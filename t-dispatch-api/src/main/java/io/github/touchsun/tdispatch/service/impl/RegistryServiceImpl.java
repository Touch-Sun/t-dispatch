package io.github.touchsun.tdispatch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.touchsun.tdispatch.core.model.Registry;
import io.github.touchsun.tdispatch.db.mapper.RegistryMapper;
import io.github.touchsun.tdispatch.service.RegistryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 注册表服务接口实现
 *
 * @author lee
 * @since 2023/6/2 22:35
 */
@Service
public class RegistryServiceImpl extends ServiceImpl<RegistryMapper, Registry> implements RegistryService {
    
    @Resource
    private RegistryMapper registryMapper;
    
}
