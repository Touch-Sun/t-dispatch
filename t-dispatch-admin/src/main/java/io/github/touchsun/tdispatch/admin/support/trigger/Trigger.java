package io.github.touchsun.tdispatch.admin.support.trigger;

import io.github.touchsun.tdispatch.admin.config.TDispatchConfig;
import io.github.touchsun.tdispatch.api.enums.RegisterType;
import io.github.touchsun.tdispatch.api.model.Engine;
import io.github.touchsun.tdispatch.api.model.Task;
import io.github.touchsun.tdispatch.core.constant.ConstantNumber;
import io.github.touchsun.tdispatch.core.constant.ConstantSymbol;
import io.github.touchsun.tdispatch.core.util.NumberUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 触发器
 *
 * @author lee
 * @since 2023/6/5 20:22
 */
@Slf4j
public class Trigger {

    /**
     * 静态任务触发触发
     *
     * @param taskId 任务ID
     * @param type 类型 {@link TriggerTypeEnum}
     * @param failRetryCount 失败重试次数,若该值>=0就用这个参数否则在使用task配置的重试次数,
     *                       这么做的好处是更灵活的配置重试次数,而不是硬依赖任务配置的重试次数
     * @param shardingParam 分片参数 0/1、1/2... 
     *                      分片执行参数的组成格式为x/y的格式,
     *                      其中x表示一个大任务被拆分为了多少个小任务, 
     *                      y则表示当前触发这个小任务是x个小任务中的第几个
     * @param executorParam 执行参数
     * @param addressList 执行引擎地址列表 127.0.0.1,127.0.0.2...
     */
    public static void trigger(final int taskId, final TriggerTypeEnum type, final int failRetryCount,
                               final String shardingParam, final String executorParam, final String addressList) {
        TDispatchConfig config = TDispatchConfig.getInstance();
        
        // 查询任务信息
        Task task = config.getTaskService().getById(taskId);
        if (task == null) {
            log.warn("触发任务失败, 可能由于任务已经不存在");
            return;
        }
        // 设置执行参数
        if (executorParam != null) {
            task.setExecutorParam(executorParam);
        }
        // 设置任务的重试次数
        int taskFailRetryCount = failRetryCount >= 0 ? failRetryCount : task.getExecutorFailRetryCount();
        // 查询该任务的执行引擎
        Engine engine = config.getEngineService().getById(task.getEngineId());
        if (engine == null) {
            log.warn("触发任务失败, 可能由于任务的执行引擎不存在");
            return;
        }
        // 覆盖执行引擎的机器地址
        if (addressList != null && addressList.trim().length() > 0) {
            // 引擎的注册类型为手动注册
            engine.setType(RegisterType.MANUAL.getCode());
            engine.setAddressList(addressList.trim());
        }
        // 设置分片参数
        int[] realShardingParam = null;
        if (shardingParam != null) {
            // 校验并设置
            String[] shardingInfo = shardingParam.split(ConstantSymbol.SLASH);
            if (shardingInfo.length == ConstantNumber.TWO && NumberUtil.isNumeric(shardingInfo)) {
                realShardingParam = new int[2];
                realShardingParam[0] = Integer.parseInt(shardingInfo[0]);
                realShardingParam[1] = Integer.parseInt(shardingInfo[1]);
            }
        }
        // 执行引擎选择策略(分片广播策略)
        
    }
}

















