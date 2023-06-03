package io.github.touchsun.tdispatch.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.touchsun.tdispatch.core.model.User;
import io.github.touchsun.tdispatch.query.UserQuery;

/**
 * 用户服务接口
 *
 * @author lee
 * @since 2023/6/2 22:31
 */
public interface UserService extends IService<User> {
    
    String hello();

    /**
     * 分页查询
     *
     * @param userQuery 查询参数
     * @return 分页数据
     */
    Page<User> pageList(UserQuery userQuery);
}
