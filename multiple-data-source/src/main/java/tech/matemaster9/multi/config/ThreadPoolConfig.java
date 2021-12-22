package tech.matemaster9.multi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author matemaster9
 * @date 2021/12/22 9:47
 */
@Configuration
public class ThreadPoolConfig {
    @Bean
    public ThreadPoolExecutor executor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 12, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
