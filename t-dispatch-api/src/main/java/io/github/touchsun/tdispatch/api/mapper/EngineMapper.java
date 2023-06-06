package io.github.touchsun.tdispatch.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.touchsun.tdispatch.api.model.Engine;
import org.apache.ibatis.annotations.Mapper;

/**
 * 执行引擎数据访问层
 *
 * @author lee
 * @since 2023/6/2 8:51
 */
@Mapper
public interface EngineMapper extends BaseMapper<Engine> {
    
}
