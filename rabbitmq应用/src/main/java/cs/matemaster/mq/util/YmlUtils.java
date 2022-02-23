package cs.matemaster.mq.util;

import cs.matemaster.mq.RabbitMQProperties;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/23 21:12
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class YmlUtils {
    private static InputStream RABBITMQ_CONFIG = null;

    public static RabbitMQProperties load() {
        Yaml yaml = new Yaml();
        RabbitMQProperties rabbitMQProperties = yaml.loadAs(RABBITMQ_CONFIG, RabbitMQProperties.class);
        return rabbitMQProperties;
    }

    static {
        RABBITMQ_CONFIG = YmlUtils.class.getClassLoader().getResourceAsStream("rabbitmq.yml");
    }

    public static void main(String[] args) {
        System.out.println(RABBITMQ_CONFIG);
        System.out.println(load());
    }
}
