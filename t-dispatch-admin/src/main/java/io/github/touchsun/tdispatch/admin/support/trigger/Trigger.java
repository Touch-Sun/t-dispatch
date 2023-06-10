package io.github.touchsun.tdispatch.admin.support.trigger;

import io.github.touchsun.tdispatch.admin.config.TDispatchConfig;
import io.github.touchsun.tdispatch.api.enums.RegisterType;
import io.github.touchsun.tdispatch.api.model.Engine;
import io.github.touchsun.tdispatch.api.model.Task;
import io.github.touchsun.tdispatch.core.constant.ConstantNumber;
import io.github.touchsun.tdispatch.core.constant.ConstantSymbol;
import io.github.touchsun.tdispatch.core.router.StrategyEnum;
import io.github.touchsun.tdispatch.core.util.EmptyUtil;
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
     * 任务触发预处理
     *
     * @param taskId         任务ID
     * @param type           类型 {@link TriggerTypeEnum}
     * @param failRetryCount 失败重试次数,若该值>=0就用这个参数否则在使用task配置的重试次数,
     *                       这么做的好处是更灵活的配置重试次数,而不是硬依赖任务配置的重试次数
     * @param shardingParam  分片参数 0/1、1/2...
     *                       分片执行参数的组成格式为x/y的格式,
     *                       其中y表示一个大任务被拆分为了多少个小任务,
     *                       x则表示当前触发这个小任务是x个小任务中的第几个
     * @param executorParam  执行参数
     * @param addressList    执行引擎地址列表 127.0.0.1,127.0.0.2...
     */
    public static void triggerPreProcessing(final int taskId, final TriggerTypeEnum type, final int failRetryCount,
                                            final String shardingParam, final String executorParam, final String addressList) {
        TDispatchConfig config = TDispatchConfig.getInstance();

        // 查询任务信息
        Task task = config.getTaskService().getById(taskId);
        if (EmptyUtil.isEmpty(task)) {
            log.warn("触发任务失败, 可能由于任务已经不存在");
            return;
        }
        // 设置执行参数
        if (EmptyUtil.isNotEmpty(executorParam)) {
            task.setExecutorParam(executorParam);
        }
        // 设置任务的重试次数
        int taskFailRetryCount = failRetryCount >= 0 ? failRetryCount : task.getExecutorFailRetryCount();
        // 查询该任务的执行引擎
        Engine engine = config.getEngineService().getById(task.getEngineId());
        if (EmptyUtil.isEmpty(engine)) {
            log.warn("触发任务失败, 可能由于任务的执行引擎不存在");
            return;
        }
        // 覆盖执行引擎的机器地址
        if (EmptyUtil.isNotEmpty(addressList) && EmptyUtil.isNotEmpty(addressList.trim())) {
            // 引擎的注册类型为手动注册
            engine.setType(RegisterType.MANUAL.getCode());
            engine.setAddressList(addressList.trim());
        }
        // 设置分片参数
        int[] realShardingParam = null;
        if (EmptyUtil.isNotEmpty(shardingParam)) {
            // 校验并设置
            String[] shardingInfo = shardingParam.split(ConstantSymbol.SLASH);
            if (shardingInfo.length == ConstantNumber.TWO && NumberUtil.isNumeric(shardingInfo)) {
                realShardingParam = new int[2];
                realShardingParam[0] = Integer.parseInt(shardingInfo[0]);
                realShardingParam[1] = Integer.parseInt(shardingInfo[1]);
            }
        }
        // 判断是否是全部执行引擎一起执行(分片广播策略)
        StrategyEnum strategyEnum = StrategyEnum.parse(task.getExecutorRouteStrategy(), null);
        // 确保执行引擎的注册表不空, 保证有引擎可用, 并且在分片参数未指定的情况下(通知所有实例执行)
        if (strategyEnum == StrategyEnum.SHARDING_BROADCAST
                && EmptyUtil.isNotEmpty(engine.listOfAddressList())
                && EmptyUtil.isEmpty(realShardingParam)) {
            // 以0为起始分片索引, (假设此时注册实例为10个) 那么分片形式 -> 0/10, 1/10, 2/10, ... 9/10
            // 分片总数
            int total = engine.listOfAddressList().size();
            for (int index = 0; index < engine.listOfAddressList().size(); index++) {
                // 实际触发任务
                justDoIt(engine, task, taskFailRetryCount, strategyEnum, index, total);
            }
        } else {
            // 不是分片广播策略
            if (EmptyUtil.isEmpty(realShardingParam)) {
                // 也得给一个默认的分片参数 0/1
                realShardingParam = new int[]{0, 1};
            }
            // 实际触发任务
            justDoIt(engine, task, taskFailRetryCount, strategyEnum, realShardingParam[0], realShardingParam[1]);
        }
    }

    /**
     * 只管去做!
     * - 实际任务触发
     * 
     * @param engine 引擎
     * @param task 任务
     * @param failRetryCount 重试次数(计算出最终的任务重试次数)
     * @param strategyEnum 策略类型
     * @param index 分片索引
     * @param total 分片总数
     */
    public static void justDoIt(Engine engine, Task task, int failRetryCount, 
                                StrategyEnum strategyEnum, int index, int total) {
        
    }
}

















