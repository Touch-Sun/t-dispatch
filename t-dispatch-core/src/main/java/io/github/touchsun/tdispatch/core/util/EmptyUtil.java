package io.github.touchsun.tdispatch.core.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * 空值判断工具
 *
 * @author lee
 * @since 2023/6/9 8:44
 */
public class EmptyUtil {

    /**
     * 判断对象是否为空
     *
     * @param obj 需要判断的对象
     * @return boolean 空返回true，非空返回false
     */
    public static boolean isEmpty(Object obj) {
        return Optional.ofNullable(obj)
                .map(o -> {
                    if (o instanceof String) {
                        return ((String) o).trim().length() == 0;
                    } else if (o instanceof Collection) {
                        return ((Collection<?>) o).isEmpty();
                    } else if (o.getClass().isArray()) {
                        return Array.getLength(o) == 0;
                    } else if (o instanceof Map) {
                        return ((Map<?, ?>) o).isEmpty();
                    } else if (o instanceof Number) {
                        return ((Number) o).doubleValue() == 0.0d;
                    } else if (o instanceof Boolean) {
                        return !(Boolean) o;
                    } else {
                        return false;
                    }
                })
                .orElse(true);
    }

    /**
     * 判断对象是否不为空
     *
     * @param obj 需要判断的对象
     * @return boolean 空返回true，非空返回false
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}
