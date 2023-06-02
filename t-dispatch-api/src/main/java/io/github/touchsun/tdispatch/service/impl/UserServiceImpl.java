package io.github.touchsun.tdispatch.service.impl;

import io.github.touchsun.tdispatch.db.mapper.UserMapper;
import io.github.touchsun.tdispatch.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务接口实现
 *
 * @author lee
 * @since 2023/6/2 22:35
 */
@Service
@Component
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserMapper userMapper;

    @Override
    public String hello() {
        return "Hello TDispatch⏱️";
    }
}
