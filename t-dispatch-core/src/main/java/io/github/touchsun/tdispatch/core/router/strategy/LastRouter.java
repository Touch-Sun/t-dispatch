package io.github.touchsun.tdispatch.core.router.strategy;

import io.github.touchsun.tdispatch.core.constant.ConstantNumber;
import io.github.touchsun.tdispatch.core.task.dto.TriggerParam;
import io.github.touchsun.tdispatch.core.http.Result;
import io.github.touchsun.tdispatch.core.router.EngineRouter;

import java.util.List;

/**
 * 优先选择最后一个引擎
 *
 * @author lee
 * @since 2023/6/7 9:07
 */
public class LastRouter extends EngineRouter {
    
    @Override
    public Result<String> route(TriggerParam triggerParam, List<String> addressList) {
        return Result.success(addressList.get(addressList.size() - ConstantNumber.ONE));
    }
}
