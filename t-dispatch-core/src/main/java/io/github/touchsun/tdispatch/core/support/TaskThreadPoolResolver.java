package io.github.touchsun.tdispatch.core.support;

import io.github.touchsun.tdispatch.core.config.TDispatchConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 任务触发线程池处理
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
        log.info("TDispatch🌤️高速触发线程池, 启动成功...");
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
        log.info("TDispatch🌩️低速触发线程池, 启动成功...");
    }

    /**
     * 停止
     */
    public void stop() {
        FAST_TRIGGER_POOL.shutdownNow();
        log.info("TDispatch🌤️高速触发线程池" + " 停止成功...");
        SLOW_TRIGGER_POOL.shutdownNow();
        log.info("TDispatch🌩️️低速触发线程池" + " 停止成功...");
    }

}
























