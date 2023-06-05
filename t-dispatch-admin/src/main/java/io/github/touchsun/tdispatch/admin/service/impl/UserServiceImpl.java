package io.github.touchsun.tdispatch.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.touchsun.tdispatch.api.model.User;
import io.github.touchsun.tdispatch.admin.mapper.UserMapper;
import io.github.touchsun.tdispatch.api.query.UserQuery;
import io.github.touchsun.tdispatch.admin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务接口实现
 *
 * @author lee
 * @since 2023/6/2 22:35
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    
    @Resource
    private UserMapper userMapper;

    @Override
    public String hello() {
        return "Hello TDispatch⏱️";
    }

    @Override
    public Page<User> pageList(UserQuery query) {
        Page<User> userPage = userMapper.selectPage(query.outPage(), new QueryWrapper<User>().lambda()
                .eq(StringUtils.isNotBlank(query.getStatus()), User::getStatus, query.getStatus())
                .eq(StringUtils.isNotBlank(query.getRole()), User::getType, query.getRole())
                .like(StringUtils.isNotBlank(query.getKeyword()), User::getUserName, query.getKeyword())
                .or()
                .like(StringUtils.isNotBlank(query.getKeyword()), User::getPhone, query.getKeyword())
                .or()
                .like(StringUtils.isNotBlank(query.getKeyword()), User::getEmail, query.getKeyword())
                .orderByDesc(User::getCreateTime)
        );
        userPage.getRecords().forEach(e -> e.setPassword(null));
        return userPage;
    }
}
