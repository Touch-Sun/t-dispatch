package io.github.touchsun.tdispatch.api.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.touchsun.tdispatch.core.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "log")
public class Log extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = 4943307509320804544L;

    /**
     * 执行引擎主键ID
     */
    private Integer engineId;
    /**
     * 任务，主键ID
     */
    private Integer taskId;
    /**
     * 执行引擎地址，本次执行的地址
     */
    private String engineAddress;
    /**
     * 执行引擎任务handler
     */
    private String engineHandler;
    /**
     * 执行引擎任务参数
     */
    private String engineParam;
    /**
     * 执行引擎任务分片参数，格式如 1/2
     */
    private String engineShardingParam;
    /**
     * 失败重试次数
     */
    private Integer engineFailRetryCount;
    /**
     * 调度-时间
     */
    private Date triggerTime;
    /**
     * 调度-结果
     */
    private Integer triggerCode;
    /**
     * 调度-日志
     */
    private String triggerMsg;
    /**
     * 执行-时间
     */
    private Date handleTime;
    /**
     * 执行-状态
     */
    private Integer handleCode;
    /**
     * 执行-日志
     */
    private String handleMsg;
    /**
     * 告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败
     */
    private Integer alarmStatus;
}
