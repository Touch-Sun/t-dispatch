package io.github.touchsun.tdispatch.admin.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.touchsun.tdispatch.core.http.Result;
import io.github.touchsun.tdispatch.core.model.User;
import io.github.touchsun.tdispatch.core.util.CrudUtil;
import io.github.touchsun.tdispatch.query.UserQuery;
import io.github.touchsun.tdispatch.service.UserService;
import org.springframework.web.bind.annotation.*;

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
        return Result.success(userService.pageList(query));
    }

    @GetMapping("/{id}")
    public Result<User> info(@PathVariable Integer id) {
        return Result.success(userService.getById(id));
    }
    
    @PostMapping
    public Result<Boolean> insert(@RequestBody User user) {
        return Result.success(userService.save(CrudUtil.addPrepare(User.class, user)));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody User user) {
        return Result.success(userService.updateById(CrudUtil.updatePrepare(User.class, user)));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(userService.removeById(id));
    }
}
