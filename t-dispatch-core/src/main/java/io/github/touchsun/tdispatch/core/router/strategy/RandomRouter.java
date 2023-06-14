package io.github.touchsun.tdispatch.core.router.strategy;

import io.github.touchsun.tdispatch.core.constant.ConstantNumber;
import io.github.touchsun.tdispatch.core.http.Result;
import io.github.touchsun.tdispatch.core.router.EngineRouter;
import io.github.touchsun.tdispatch.core.task.dto.TriggerParam;

import java.util.List;
import java.util.Random;

/**
 * 随机选择一个引擎
 * @author eisuto
 */
public class RandomRouter extends EngineRouter {

    private static final Random LOCAL_RANDOM = new Random();


    @Override
    public Result<String> route(TriggerParam triggerParam, List<String> addressList) {
        String address = addressList.get(LOCAL_RANDOM.nextInt(addressList.size()));
        return Result.success(address);
    }
}
