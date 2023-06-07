package io.github.touchsun.tdispatch.core.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 任务触发传输对象
 *
 * @author lee
 * @since 2023/6/7 8:43
 */
@Data
@Builder
public class TriggerDTO implements Serializable {

    private static final long serialVersionUID = 2631620028609316218L;

    /**
     * 任务 ID
     */
    private int taskId;

    /**
     * 执行引擎处理器
     */
    private String engineHandler;

    /**
     * 执行引擎参数
     */
    private String engineParams;

    /**
     * 执行引擎阻塞策略
     */
    private String engineBlockStrategy;

    /**
     * 执行引擎超时时间
     */
    private int engineTimeout;

    /**
     * 日志 ID
     */
    private long logId;

    /**
     * 日志日期时间
     */
    private long logDateTime;

    /**
     * GLUE 类型
     */
    private String glueType;

    /**
     * GLUE 源代码
     */
    private String glueSource;

    /**
     * GLUE 更新时间
     */
    private long glueUpdateTime;

    /**
     * 广播参数：广播索引
     */
    private int broadcastIndex;

    /**
     * 广播参数：广播总数
     */
    private int broadcastTotal;
}
