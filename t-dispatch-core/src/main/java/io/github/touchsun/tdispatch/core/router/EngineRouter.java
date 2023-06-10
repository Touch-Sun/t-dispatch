package io.github.touchsun.tdispatch.core.router;

import io.github.touchsun.tdispatch.core.task.dto.TriggerParam;
import io.github.touchsun.tdispatch.core.http.Result;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 执行引擎路由器
 * - 由于执行引擎采用分布式部署, 所以任务触发需要选择一个最合适的执行引擎
 * - 该类作用即为任务选择出一个最优的执行引擎实例
 *
 * @author lee
 * @since 2023/6/6 9:05
 */
@Slf4j
public abstract class EngineRouter {

    /**
     * 根据执行引擎地址列表, 任务触发参数选择一个最优的执行引擎地址
     * 
     * @param triggerParam 任务触发参数
     * @param addressList 执行引擎地址列表
     * @return 最优执行引擎地址列表
     */
    public abstract Result<String> route(TriggerParam triggerParam, List<String> addressList);
}
