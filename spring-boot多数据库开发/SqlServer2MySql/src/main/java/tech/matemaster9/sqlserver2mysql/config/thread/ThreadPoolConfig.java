package tech.matemaster9.sqlserver2mysql.config.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 线程池配置
 * @Author: matemaster9
 * @Date: 2021/12/25 12:26
 */
@Configuration
public class ThreadPoolConfig {

    private ThreadPoolProperties properties;

    public ThreadPoolConfig(ThreadPoolProperties properties) {
        this.properties = properties;
    }

    @Bean
    public ThreadPoolExecutor executor() {
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("work-pool-%d").build();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                properties.getCorePoolSize(),
                properties.getMaxPoolSize(),
                properties.getKeepAliveSecond(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(properties.getQueueSize()),
                factory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
