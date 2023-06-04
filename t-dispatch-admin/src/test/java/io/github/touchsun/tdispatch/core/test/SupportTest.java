package io.github.touchsun.tdispatch.core.test;

import io.github.touchsun.tdispatch.admin.TDispatchAdminApplication;
import io.github.touchsun.tdispatch.core.support.TaskThreadPoolResolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * t-dispatch
 *
 * @author lee
 * @since 2023/6/4 17:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TDispatchAdminApplication.class)
public class SupportTest {
    
    @Test
    public void testPool() throws InterruptedException {
        TaskThreadPoolResolver.readyStart();
        Thread.sleep(2000);
        TaskThreadPoolResolver.readyStop();
    }
}
