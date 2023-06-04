package io.github.touchsun.tdispatch.admin;

import io.github.touchsun.tdispatch.core.support.TaskThreadPoolResolver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * t-dispatch 调度中心程序启动入口
 *
 * @author lee
 * @since 2023/6/1 21:28
 */
@SpringBootApplication(scanBasePackages = "io.github.touchsun.tdispatch")
@MapperScan(basePackages = "io.github.touchsun.tdispatch.db.mapper")
public class TDispatchAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(TDispatchAdminApplication.class, args);
    }
}
