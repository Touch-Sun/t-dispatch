package io.github.touchsun.tdispatch.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.touchsun.tdispatch.api.model.Registry;
import org.apache.ibatis.annotations.Mapper;

/**
 * 注册表数据访问层
 *
 * @author lee
 * @since 2023/6/2 8:51
 */
@Mapper
public interface RegistryMapper extends BaseMapper<Registry> {
    
}
