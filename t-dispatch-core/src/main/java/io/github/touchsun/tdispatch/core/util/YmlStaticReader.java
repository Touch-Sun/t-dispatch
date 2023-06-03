package io.github.touchsun.tdispatch.core.util;

import io.github.touchsun.tdispatch.core.exception.TDispatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 静态类中读取环境变量
 *
 * @author lee
 * @since 2023/6/2 22:07
 */
@Component
public class YmlStaticReader implements org.springframework.context.EnvironmentAware {

    private static Environment env;

    @Override
    @Autowired
    public void setEnvironment(Environment environment) {
        env = environment;
    }

    public static String getString(String key) throws TDispatchException {
        String value = env.getProperty(key);
        if (value == null) {
            throw new TDispatchException("Env Error：" + key);
        }
        return value;
    }

    public static Integer getInteger(String key) throws TDispatchException {
        return Integer.parseInt(getString(key));
    }

    public static Long getLong(String key) throws TDispatchException {
        return Long.parseLong(getString(key));
    }

    public static Float getFloat(String key) throws TDispatchException {
        return Float.parseFloat(getString(key));
    }

    public static Boolean getBoolean(String key) throws TDispatchException {
        return Boolean.parseBoolean(getString(key));
    }

    public static Double getDouble(String key) throws TDispatchException {
        return Double.parseDouble(getString(key));
    }
}
