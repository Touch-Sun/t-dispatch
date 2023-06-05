package io.github.touchsun.tdispatch.core.support.trigger;

import lombok.Getter;

/**
 * 任务触发类型
 *
 * @author lee
 * @since 2023/6/5 8:30
 */
public enum TriggerTypeEnum {

    /**
     * 一般为界面点击触发
     */
    MANUAL("手动触发"),
    /**
     * 任务配置的CRON表达式触发
     */
    CRON("CRON表达式触发"),
    /**
     * 界面点击重试/或者程序自动重试触发
     */
    RETRY("重试触发"),
    /**
     * 一般在父子任务触发生效
     */
    PARENT("父子任务联动触发"),
    /**
     * 提供的REST API 接口触发
     */
    API("API接口触发"),
    /**
     * 超出规定时间触发
     * - 例如订单超时未支付该触发的任务
     */
    MISFIRE("超时触发");
    
    
    @Getter
    private final String name;

    TriggerTypeEnum(String name) {
        this.name = name;
    }
}
