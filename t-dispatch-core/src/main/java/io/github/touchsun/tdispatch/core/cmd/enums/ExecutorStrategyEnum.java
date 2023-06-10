package io.github.touchsun.tdispatch.core.cmd.enums;

import lombok.Getter;

/**
 * 执行引擎执行任务的阻塞策略类型
 *
 * @author lee
 * @since 2023/6/10 13:47
 */
public enum ExecutorStrategyEnum {

    /**
     * 执行引擎执行任务时按照任务的提交顺序依次执行, 
     * 当一个任务执行完毕后才能之后才能继续执行后续的任务
     */
    SERIAL_EXECUTION("串行执行"),

    /**
     * 执行引擎可同时执行多个任务, 
     * 不需要等待上一个任务执行完在执行下一个任务
     */
    CONCURRENT_EXECUTION("并行执行"),

    /**
     * 执行引擎此刻正在执行一个任务未完成, 
     * 那么此时新提交上来一个任务会被直接丢弃掉
     */
    DISCARD_LATER("后续任务丢弃"),

    /**
     * 执行引擎此刻正在执行一个任务未完成,
     * 那么此时新提交上来一个任务会直接杀死当前任务,
     * 新任务会直接启动执行
     */
    COVER_EARLY("新任务覆盖旧任务");
    
    
    @Getter
    private final String title;

    ExecutorStrategyEnum(String title) {
        this.title = title;
    }
}
