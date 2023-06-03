package io.github.touchsun.tdispatch.core.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.touchsun.tdispatch.core.constant.ConstantNumber;
import lombok.Data;

import java.util.Date;

/**
 * 基础查询对象
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@Data
public class BaseQuery {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 当前页
     */
    private Integer current = ConstantNumber.ONE;

    /**
     * 页大小
     */
    private Integer size = ConstantNumber.MAX_PAGE;

    /**
     * 排序字段
     */
    private String orderField;

    /**
     * 排序方式
     */
    private String orderType;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 操作用户id
     */
    private Integer userId;


    public <T> Page<T> outPage() {
        return new Page<>(current, size);
    }
}
