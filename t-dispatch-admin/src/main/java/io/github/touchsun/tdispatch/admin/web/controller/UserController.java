package io.github.touchsun.tdispatch.admin.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.touchsun.tdispatch.core.http.Result;
import io.github.touchsun.tdispatch.core.model.User;
import io.github.touchsun.tdispatch.query.UserQuery;
import io.github.touchsun.tdispatch.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户控制器
 *
 * @author lee
 * @since 2023/6/2 22:15
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Resource
    private UserService userService;
    
    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success(userService.hello());
    }
    
    @GetMapping
    public Result<Page<User>> selectAll(UserQuery query) {
        return Result.success(this.userService.pageList(query));
    }
}
