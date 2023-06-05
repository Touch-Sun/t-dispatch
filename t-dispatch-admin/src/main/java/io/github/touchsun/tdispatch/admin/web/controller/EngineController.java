package io.github.touchsun.tdispatch.admin.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.touchsun.tdispatch.core.http.Result;
import io.github.touchsun.tdispatch.core.model.Engine;
import io.github.touchsun.tdispatch.core.util.CrudUtil;
import io.github.touchsun.tdispatch.query.EngineQuery;
import io.github.touchsun.tdispatch.service.EngineService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 执行引擎控制器
 *
 * @author lee
 * @since 2023/6/2 22:15
 */
@RestController
@RequestMapping("/engine")
public class EngineController {
    
    @Resource
    private EngineService engineService;
    
    @GetMapping
    public Result<Page<Engine>> selectAll(EngineQuery query) {
        return Result.success(this.engineService.pageList(query));
    }

    @GetMapping("/{id}")
    public Result<Engine> info(@PathVariable Integer id) {
        return Result.success(engineService.getById(id));
    }

    @PostMapping
    public Result<Boolean> insert(@RequestBody Engine user) {
        return Result.success(engineService.save(CrudUtil.addPrepare(Engine.class, user)));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody Engine user) {
        return Result.success(engineService.updateById(CrudUtil.updatePrepare(Engine.class, user)));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(engineService.removeById(id));
    }
}
