package io.github.touchsun.tdispatch.admin.support.trigger;

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
     * @param shardingParam 分片参数
     * @param executorParam 执行参数
     * @param addressList 执行引擎地址列表
     */
    public static void trigger(final int taskId, final TriggerTypeEnum type, final int failRetryCount,
                               final String shardingParam, final String executorParam, final String addressList) {
        
    }
}












