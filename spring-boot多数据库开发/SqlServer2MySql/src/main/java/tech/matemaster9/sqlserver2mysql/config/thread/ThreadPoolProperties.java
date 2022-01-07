package tech.matemaster9.sqlserver2mysql.config.thread;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 线程池的核心参数
 * @Author: matemaster9
 * @Date: 2021/12/25 12:19
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "thread.pool")
public class ThreadPoolProperties {
    private int corePoolSize;
    private int maxPoolSize;
    private int keepAliveSecond;
    private int queueSize;
}
