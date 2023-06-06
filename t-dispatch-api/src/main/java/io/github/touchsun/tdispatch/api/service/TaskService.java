package io.github.touchsun.tdispatch.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.touchsun.tdispatch.api.model.Task;
import io.github.touchsun.tdispatch.api.query.TaskQuery;

/**
 * 任务服务接口
 *
 * @author lee
 * @since 2023/6/2 22:31
 */
public interface TaskService extends IService<Task> {

    /**
     * 分页查询
     *
     * @param taskQuery 查询参数
     * @return 分页数据
     */
    Page<Task> pageList(TaskQuery taskQuery);
}
