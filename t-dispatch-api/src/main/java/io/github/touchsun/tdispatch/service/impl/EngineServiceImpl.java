package io.github.touchsun.tdispatch.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.touchsun.tdispatch.core.model.Engine;
import io.github.touchsun.tdispatch.db.mapper.EngineMapper;
import io.github.touchsun.tdispatch.query.EngineQuery;
import io.github.touchsun.tdispatch.service.EngineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 执行引擎服务接口实现
 *
 * @author lee
 * @since 2023/6/2 22:35
 */
@Service
public class EngineServiceImpl extends ServiceImpl<EngineMapper, Engine> implements EngineService {
    
    @Resource
    private EngineMapper engineMapper;

    @Override
    public Page<Engine> pageList(EngineQuery engineQuery) {
        return engineMapper.selectPage(engineQuery.outPage(), new QueryWrapper<Engine>().lambda()
                .like(StringUtils.isNotBlank(engineQuery.getKeyword()), Engine::getAppName, engineQuery.getKeyword())
                .or()
                .like(StringUtils.isNotBlank(engineQuery.getKeyword()), Engine::getTitle, engineQuery.getKeyword())
                .orderByDesc(Engine::getCreateTime)
        );
    }
}
