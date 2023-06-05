package io.github.touchsun.tdispatch.admin.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.touchsun.tdispatch.core.http.Result;
import io.github.touchsun.tdispatch.core.model.Task;
import io.github.touchsun.tdispatch.core.util.CrudUtil;
import io.github.touchsun.tdispatch.query.TaskQuery;
import io.github.touchsun.tdispatch.service.TaskService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 任务控制器
 *
 * @author lee
 * @since 2023/6/2 22:15
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    
    @Resource
    private TaskService taskService;
    
    @GetMapping
    public Result<Page<Task>> selectAll(TaskQuery query) {
        return Result.success(this.taskService.pageList(query));
    }

    @GetMapping("/{id}")
    public Result<Task> info(@PathVariable Integer id) {
        return Result.success(taskService.getById(id));
    }

    @PostMapping
    public Result<Boolean> insert(@RequestBody Task user) {
        return Result.success(taskService.save(CrudUtil.addPrepare(Task.class, user)));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody Task user) {
        return Result.success(taskService.updateById(CrudUtil.updatePrepare(Task.class, user)));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(taskService.removeById(id));
    }
}
