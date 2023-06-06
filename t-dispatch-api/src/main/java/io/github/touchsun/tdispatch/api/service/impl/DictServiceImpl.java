package io.github.touchsun.tdispatch.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.touchsun.tdispatch.api.model.Dict;
import io.github.touchsun.tdispatch.api.mapper.DictMapper;
import io.github.touchsun.tdispatch.api.query.DictQuery;
import io.github.touchsun.tdispatch.api.service.DictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 字典服务接口实现
 *
 * @author lee
 * @since 2023/6/2 22:35
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    
    @Resource
    private DictMapper dictMapper;

    @Override
    public Page<Dict> pageList(DictQuery dictQuery) {
        return dictMapper.selectPage(dictQuery.outPage(), new QueryWrapper<Dict>().lambda()
                .eq(StringUtils.isNotBlank(dictQuery.getType()), Dict::getType, dictQuery.getType())
                .orderByDesc(Dict::getCreateTime)
        );
    }
}
