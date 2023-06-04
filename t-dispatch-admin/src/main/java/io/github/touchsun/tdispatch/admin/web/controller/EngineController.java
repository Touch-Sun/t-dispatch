package io.github.touchsun.tdispatch.admin.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.touchsun.tdispatch.core.http.Result;
import io.github.touchsun.tdispatch.core.model.Engine;
import io.github.touchsun.tdispatch.query.EngineQuery;
import io.github.touchsun.tdispatch.service.EngineService;
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
@RequestMapping("/engine")
public class EngineController {
    
    @Resource
    private EngineService engineService;
    
    @GetMapping
    public Result<Page<Engine>> selectAll(EngineQuery query) {
        return Result.success(this.engineService.pageList(query));
    }
}
