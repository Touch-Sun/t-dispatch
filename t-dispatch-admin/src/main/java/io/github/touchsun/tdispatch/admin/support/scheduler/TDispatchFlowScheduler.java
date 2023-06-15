package io.github.touchsun.tdispatch.admin.support.scheduler;

import io.github.touchsun.tdispatch.core.task.api.EngineRunner;
import io.github.touchsun.tdispatch.core.util.EmptyUtil;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * t-dispatch 执行流程调度组件
 *
 * @author lee
 * @since 2023/6/15 8:08
 */
public class TDispatchFlowScheduler {

    /**
     * 线程安全的执行引擎运行组件缓存
     * - key => 执行引擎地址
     * - value => 执行引擎运行组件
     */
    public static ConcurrentMap<String, EngineRunner> engineRunnerSafeCache = new ConcurrentHashMap<>(16);

    /**
     * 根据执行引擎地址获取执行引擎执行组件
     * - 缓存中有直接取缓存中的值, 没有则创建并加入缓存
     * 
     * @param address 执行引擎地址
     * @return 执行引擎执行组件
     */
    public static EngineRunner getEngineRunner(String address) {
        // 参数检查
        if (EmptyUtil.isEmpty(address) || EmptyUtil.isEmpty(address.trim())) {
            return null;
        }
        
        // 从缓存读取执行引擎执行组件
        EngineRunner engineRunner = engineRunnerSafeCache.get(address.trim());
        if (EmptyUtil.isNotEmpty(engineRunner)) {
            return engineRunner;
        }
        
        //TODO 创建一个新的执行引擎执行组件
        engineRunner = null;
        
        return null;
    }
}




















