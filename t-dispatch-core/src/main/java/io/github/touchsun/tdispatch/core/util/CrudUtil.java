package io.github.touchsun.tdispatch.core.util;

import io.github.touchsun.tdispatch.core.base.BaseModel;
import io.github.touchsun.tdispatch.core.sso.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * 增删改查预处理
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@Slf4j
public class CrudUtil {

    /**
     * 新增前预处理
     *
     * @param entity 实体类的类对象
     * @param dto    前端表单信息
     * @return 实体对象
     */
    public static <T> T addPrepare(Class<T> entity, Object dto) {
        try {
            // 实例化Entity
            T result = entity.newInstance();
            // 得到基础用户操作信息
            BaseModel baseModel = BaseModel.newInstance(UserHolder.get(), false);
            // 先拷贝前端表单信息
            BeanUtils.copyProperties(dto, result);
            // 再拷贝用户操作信息
            BeanUtils.copyProperties(baseModel, result);
            // 返回
            return result;
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("新增前预处理异常", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 修改前预处理
     *
     * @param entity 实体类的类对象
     * @param dto    前端表单信息
     * @return 实体对象
     */
    public static <T> T updatePrepare(Class<T> entity, Object dto) {
        try {
            // 实例化Entity
            T result = entity.newInstance();
            // 得到基础用户操作信息
            BaseModel baseModel = BaseModel.newInstance(UserHolder.get(), true);
            // 先拷贝用户操作信息
            BeanUtils.copyProperties(baseModel, result);
            // 在拷贝前端表单信息
            BeanUtils.copyProperties(dto, result);
            // 返回
            return result;
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("修改前预处理异常", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 新增前预处理
     *
     * @param entity 实体类的类对象
     * @return 实体对象
     */
    public static <T> T addPrepare(Class<T> entity) {
        return singlePrepare(entity, false);
    }

    /**
     * 修改前预处理
     *
     * @param entity 实体类的类对象
     * @return 实体对象
     */
    public static <T> T updatePrepare(Class<T> entity) {
        return singlePrepare(entity, true);
    }


    public static <T> T singlePrepare(Class<T> entity, boolean update) {
        try {
            // 实例化Entity
            T result = entity.newInstance();
            // 得到基础用户操作信息
            BaseModel baseModel = BaseModel.newInstance(UserHolder.get(), update);
            // 拷贝用户操作信息
            BeanUtils.copyProperties(baseModel, result);
            // 返回
            return result;
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("修改前预处理异常", e);
            throw new RuntimeException(e);
        }
    }

}
