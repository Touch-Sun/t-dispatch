package io.github.touchsun.tdispatch.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.touchsun.tdispatch.core.model.Engine;
import io.github.touchsun.tdispatch.query.EngineQuery;

/**
 * 执行引擎服务接口
 *
 * @author lee
 * @since 2023/6/2 22:31
 */
public interface EngineService extends IService<Engine> {

    /**
     * 分页查询
     *
     * @param engineQuery 查询参数
     * @return 分页数据
     */
    Page<Engine> pageList(EngineQuery engineQuery);
}
