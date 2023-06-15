package io.github.touchsun.tdispatch.core.task.api;

import io.github.touchsun.tdispatch.core.http.Result;
import io.github.touchsun.tdispatch.core.task.dto.TriggerParam;

/**
 * t-dispatch 执行引擎运行组件
 *
 * @author lee
 * @since 2023/6/15 8:03
 */
public interface EngineRunner {

    /**
     * 执行任务
     * 
     * @param triggerParam 触发参数
     * @return 执行结果
     */
    Result<String> run(TriggerParam triggerParam);
}
