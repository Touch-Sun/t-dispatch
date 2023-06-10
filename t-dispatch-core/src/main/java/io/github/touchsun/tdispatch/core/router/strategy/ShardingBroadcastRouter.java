package io.github.touchsun.tdispatch.core.router.strategy;

import io.github.touchsun.tdispatch.core.constant.ConstantNumber;
import io.github.touchsun.tdispatch.core.http.Result;
import io.github.touchsun.tdispatch.core.router.EngineRouter;
import io.github.touchsun.tdispatch.core.task.dto.TriggerParam;

import java.util.List;

/**
 * 分片广播策略
 *
 * @author lee
 * @since 2023/6/7 9:07
 */
public class ShardingBroadcastRouter extends EngineRouter {
    
    @Override
    public Result<String> route(TriggerParam triggerParam, List<String> addressList) {
        if (triggerParam.getBroadcastIndex() < addressList.size()) {
            // 当前触发分片排列在可用地址范围内, 就给出执行引擎实例地址
            return Result.success(addressList.get(triggerParam.getBroadcastIndex()));
        } else {
            // 当前触发分片排列在可用地址超出了执行引擎注册实例的总数, 直接取第一个注册实例
            return Result.success(addressList.get(ConstantNumber.ZERO));
        }
    }
}
