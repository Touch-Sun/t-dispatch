package io.github.touchsun.tdispatch.admin.web.controller;

import io.github.touchsun.tdispatch.core.http.Result;
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
}
