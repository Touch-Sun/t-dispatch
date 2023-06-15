package io.github.touchsun.tdispatch.core.task.api.impl.client;

import io.github.touchsun.tdispatch.core.http.Result;
import io.github.touchsun.tdispatch.core.task.api.EngineRunner;
import io.github.touchsun.tdispatch.core.task.dto.TriggerParam;

/**
 * t-dispatch 客户端实现
 * - 主要通过请求调度中心的执行接口完成执行引擎的一些逻辑, 本身不做任何逻辑
 *
 * @author lee
 * @since 2023/6/15 8:22
 */
public class EngineRunnerClientImpl implements EngineRunner {
    
    @Override
    public Result<String> run(TriggerParam triggerParam) {
        return null;
    }
}
