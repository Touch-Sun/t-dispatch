package io.github.touchsun.tdispatch.admin.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.touchsun.tdispatch.core.http.Result;
import io.github.touchsun.tdispatch.api.model.Dict;
import io.github.touchsun.tdispatch.core.util.CrudUtil;
import io.github.touchsun.tdispatch.api.query.DictQuery;
import io.github.touchsun.tdispatch.admin.service.DictService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 字典控制器
 *
 * @author lee
 * @since 2023/6/2 22:15
 */
@RestController
@RequestMapping("/dict")
public class DictController {
    
    @Resource
    private DictService dictService;
    
    @GetMapping
    public Result<Page<Dict>> selectAll(DictQuery query) {
        return Result.success(this.dictService.pageList(query));
    }

    @GetMapping("/{id}")
    public Result<Dict> info(@PathVariable Integer id) {
        return Result.success(dictService.getById(id));
    }

    @PostMapping
    public Result<Boolean> insert(@RequestBody Dict user) {
        return Result.success(dictService.save(CrudUtil.addPrepare(Dict.class, user)));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody Dict user) {
        return Result.success(dictService.updateById(CrudUtil.updatePrepare(Dict.class, user)));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(dictService.removeById(id));
    }
}
