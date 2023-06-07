package io.github.touchsun.tdispatch.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.touchsun.tdispatch.api.mapper.LogMapper;
import io.github.touchsun.tdispatch.api.model.Log;
import io.github.touchsun.tdispatch.api.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 日志服务接口实现
 *
 * @author lee
 * @since 2023/6/2 22:35
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {
    
    @Resource
    private LogMapper LogMapper;
    
}
