package io.github.touchsun.tdispatch.core.config;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * t-dispatch 核心配置
 *
 * @author lee
 * @since 2023/6/4 17:01
 */
@Data
@Configuration
public class TDispatchConfig implements InitializingBean, DisposableBean {

    /**
     * 简单单例模式
     */
    private static TDispatchConfig tDispatchConfig = null;
    
    public static TDispatchConfig getInstance() {
        return tDispatchConfig;
    }

    @Override
    public void destroy() throws Exception {
        
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // Bean属性设置后回调, 此时将静态单例Bean指向到堆区
        tDispatchConfig = this;
    }


    @Value("${tdispatch.pool.fast.corePoolSize}")
    private Integer fastCorePoolSize;

    @Value("${tdispatch.pool.fast.maximumPoolSize}")
    private Integer fastMaximumPoolSize;

    @Value("${tdispatch.pool.fast.keepAliveTime}")
    private Long fastKeepAliveTime;

    @Value("${tdispatch.pool.slow.corePoolSize}")
    private Integer slowCorePoolSize;

    @Value("${tdispatch.pool.slow.maximumPoolSize}")
    private Integer slowMaximumPoolSize;

    @Value("${tdispatch.pool.slow.keepAliveTime}")
    private Long slowKeepAliveTime;
}