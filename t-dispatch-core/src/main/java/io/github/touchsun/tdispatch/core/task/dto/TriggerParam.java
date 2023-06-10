package io.github.touchsun.tdispatch.core.task.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 任务触发参数
 *
 * @author lee
 * @since 2023/6/7 8:43
 */
@Data
@Builder
public class TriggerParam implements Serializable {

    private static final long serialVersionUID = 2631620028609316218L;

    /**
     * 任务 ID
     */
    private int taskId;

    /**
     * 执行引擎处理器
     */
    private String executorHandler;

    /**
     * 执行引擎参数
     */
    private String executorParams;

    /**
     * 执行引擎阻塞策略
     */
    private String executorBlockStrategy;

    /**
     * 执行引擎超时时间
     */
    private int executorTimeout;

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
     * 分片参数：分片索引
     */
    private int broadcastIndex;

    /**
     * 分片参数：分片总数
     */
    private int broadcastTotal;
}
