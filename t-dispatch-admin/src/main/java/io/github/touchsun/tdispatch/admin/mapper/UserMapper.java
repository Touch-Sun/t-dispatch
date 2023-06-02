package io.github.touchsun.tdispatch.admin.mapper;

import io.github.touchsun.tdispatch.admin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户数据访问层
 *
 * @author lee
 * @since 2023/6/2 8:51
 */
@Mapper
public interface UserMapper {

    List<User> pageList(@Param("offset") int offset,
                        @Param("pageSize") int pageSize,
                        @Param("username") String username,
                        @Param("role") int role);
}
