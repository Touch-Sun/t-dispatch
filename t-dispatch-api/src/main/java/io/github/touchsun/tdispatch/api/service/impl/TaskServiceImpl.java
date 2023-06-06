package io.github.touchsun.tdispatch.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.touchsun.tdispatch.api.mapper.TaskMapper;
import io.github.touchsun.tdispatch.api.model.Task;
import io.github.touchsun.tdispatch.api.query.TaskQuery;
import io.github.touchsun.tdispatch.api.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 任务服务接口实现
 *
 * @author lee
 * @since 2023/6/2 22:35
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {
    
    @Resource
    private TaskMapper taskMapper;

    @Override
    public Page<Task> pageList(TaskQuery taskQuery) {
        return taskMapper.selectPage(taskQuery.outPage(), new QueryWrapper<Task>().lambda()
                .like(StringUtils.isNotBlank(taskQuery.getKeyword()), Task::getDesc, taskQuery.getKeyword())
                .orderByDesc(Task::getCreateTime)
        );
    }
}
