package io.github.touchsun.tdispatch.core.support.init;

import io.github.touchsun.tdispatch.core.support.thread.TaskThreadPoolResolver;
import lombok.extern.slf4j.Slf4j;

/**
 * t-dispatch 核心启动
 *
 * @author lee
 * @since 2023/6/5 8:11
 */
@Slf4j
public class Bootstrap {

    /**
     * 初始化
     */
    public void initialize() {
        // 启动任务触发线程池
        TaskThreadPoolResolver.readyStart();
    }

    /**
     * 销毁
     */
    public void destroy() {
        // 关闭任务触发线程池
        TaskThreadPoolResolver.readyStop();
    }
}























