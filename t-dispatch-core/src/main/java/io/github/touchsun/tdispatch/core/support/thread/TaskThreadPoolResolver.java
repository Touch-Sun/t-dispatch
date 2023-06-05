package io.github.touchsun.tdispatch.core.support.thread;

import io.github.touchsun.tdispatch.core.config.TDispatchConfig;
import io.github.touchsun.tdispatch.core.support.trigger.TriggerTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * t-dispatch 任务触发线程池
 *
 * @author lee
 * @since 2023/6/4 16:36
 */
@Slf4j
public class TaskThreadPoolResolver {

    /**
     * 高速触发线程池
     * - 未超过超时时间的调度任务
     */
    private ThreadPoolExecutor FAST_TRIGGER_POOL = null;

    /**
     * 低速触发线程池
     * - 超过超时时间的调度任务
     */
    private ThreadPoolExecutor SLOW_TRIGGER_POOL = null;

    /**
     * 简单单例模式
     */
    private static final TaskThreadPoolResolver RESOLVER = new TaskThreadPoolResolver();

    /**
     * 准备启动
     * - 对外部提供的静态调用
     */
    public static void readyStart() {
        RESOLVER.start();
    }

    /**
     * 准备停止
     * - 对外部提供的静态调用
     */
    public static void readyStop() {
        RESOLVER.stop();
    }

    /**
     * 启动
     */
    public void start() {
        TDispatchConfig config = TDispatchConfig.getInstance();
        FAST_TRIGGER_POOL = new ThreadPoolExecutor(
                config.getFastCorePoolSize(),
                config.getFastMaximumPoolSize(),
                config.getFastKeepAliveTime(),
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(1000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        log.info("TDispatch🌤️高速触发线程-" + r.hashCode() + " 已加入");
                        return new Thread(r, "TDispatch🌤️高速触发线程-" + r.hashCode());
                    }
                });
        log.info("TDispatch🌤️高速触发线程池, 启动成功... ...");
        SLOW_TRIGGER_POOL = new ThreadPoolExecutor(
                config.getSlowCorePoolSize(),
                config.getSlowMaximumPoolSize(),
                config.getSlowKeepAliveTime(),
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        log.info("TDispatch🌩️低速触发线程-" + r.hashCode() + " 已加入");
                        return new Thread(r, "TDispatch🌩️低速触发线程-" + r.hashCode());
                    }
                });
        log.info("TDispatch🌩️低速触发线程池, 启动成功... ...");
    }

    /**
     * 停止
     */
    public void stop() {
        FAST_TRIGGER_POOL.shutdownNow();
        log.info("TDispatch🌤️高速触发线程池, 停止成功... ...");
        SLOW_TRIGGER_POOL.shutdownNow();
        log.info("TDispatch🌩️️低速触发线程池, 停止成功... ...");
    }

    /**
     * 任务超时计数器
     * - 采用volatile修饰与ConcurrentMap存储保证了在多线程环境下, 并发调用的安全性
     * - volatile修饰后所有的线程均可见
     * - ConcurrentMap较普通Map使用分段锁控制访问, 且含有"读写分离"模式(即允许多个线程同时读取数据, 但仅允许一个线程写入数据)
     */
    private volatile ConcurrentMap<Integer, AtomicInteger> TASK_TIMEOUT_COUNT_MAP = new ConcurrentHashMap<>(16);
    
    /**
     * 提交任务
     * 
     * @param taskId 任务ID
     * @param type 类型 {@link TriggerTypeEnum}
     * @param failRetryCount 失败重试次数
     * @param shardingParam 分片参数
     * @param executorParam 执行参数
     * @param addressList 执行引擎地址列表
     */
    public void commit(final int taskId, final TriggerTypeEnum type, final int failRetryCount, 
                       final String shardingParam, final String executorParam, final String addressList) {
        // 选择触发线程池(默认高速触发池)
        ThreadPoolExecutor currentPool = FAST_TRIGGER_POOL;
        // 查看该任务的超时次数
        AtomicInteger taskTimeoutCount = TASK_TIMEOUT_COUNT_MAP.get(taskId);
        // 若任务在1min中之内超时了10次, 则选择低速触发池执行
        if (taskTimeoutCount != null && taskTimeoutCount.get() > 10) {
            currentPool = SLOW_TRIGGER_POOL;
        }
        
    }
}
























