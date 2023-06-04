package io.github.touchsun.tdispatch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.touchsun.tdispatch.core.model.Dict;
import io.github.touchsun.tdispatch.db.mapper.DictMapper;
import io.github.touchsun.tdispatch.service.DictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务接口实现
 *
 * @author lee
 * @since 2023/6/2 22:35
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    
    @Resource
    private DictMapper dictMapper;

}
