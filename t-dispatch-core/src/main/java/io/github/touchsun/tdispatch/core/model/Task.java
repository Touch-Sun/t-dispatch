package io.github.touchsun.tdispatch.core.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.touchsun.tdispatch.core.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "task")
public class Task extends BaseModel implements Serializable {
    
    private static final long serialVersionUID = 6965382205666603974L;

    /**
     * 执行引擎主键ID
     */
    private Integer engineId;
    /**
     * 描述
     */
    private String desc;
    /**
     * 报警邮件
     */
    private String alarmEmail;
    /**
     * 调度类型
     */
    private String scheduleType;
    /**
     * 调度配置，值含义取决于调度类型
     */
    private String scheduleConf;
    /**
     * 调度过期策略
     */
    private String misfireStrategy;
    /**
     * 执行器路由策略
     */
    private String executorRouteStrategy;
    /**
     * 执行器任务handler
     */
    private String executorHandler;
    /**
     * 执行器任务参数
     */
    private String executorParam;
    /**
     * 阻塞处理策略
     */
    private String executorBlockStrategy;
    /**
     * 任务执行超时时间，单位秒
     */
    private Integer executorTimeout;
    /**
     * 失败重试次数
     */
    private Integer executorFailRetryCount;
    /**
     * GLUE类型
     */
    private String glueType;
    /**
     * GLUE源代码
     */
    private String glueSource;
    /**
     * GLUE备注
     */
    private String glueRemark;
    /**
     * GLUE更新时间
     */
    private Date glueUpdateTime;
    /**
     * 子任务ID，多个逗号分隔
     */
    private String childTaskId;
    /**
     * 调度状态：0-停止，1-运行
     */
    private Integer triggerStatus;
    /**
     * 上次调度时间
     */
    private Long triggerLastTime;
    /**
     * 下次调度时间
     */
    private Long triggerNextTime;
}
