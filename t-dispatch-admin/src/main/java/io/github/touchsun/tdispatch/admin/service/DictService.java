package io.github.touchsun.tdispatch.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.touchsun.tdispatch.api.model.Dict;
import io.github.touchsun.tdispatch.api.query.DictQuery;

/**
 * 字典服务接口
 *
 * @author lee
 * @since 2023/6/2 22:31
 */
public interface DictService extends IService<Dict> {

    /**
     * 分页查询
     *
     * @param dictQuery 查询参数
     * @return 分页数据
     */
    Page<Dict> pageList(DictQuery dictQuery);
}
