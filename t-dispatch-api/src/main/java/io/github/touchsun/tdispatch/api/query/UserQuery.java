package io.github.touchsun.tdispatch.api.query;

import io.github.touchsun.tdispatch.core.base.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户查询
 *
 * @author lee
 * @since 2023/6/2 22:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserQuery extends BaseQuery {

    private String keyword;

    private String role;

    private String status;
}
