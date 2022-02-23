package cs.matemaster.mq;

import lombok.Data;
import lombok.ToString;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/23 21:20
 */
@Data
@ToString
public class RabbitMQProperties {
    /**
     * rabbitmq-server地址
     */
    private String host;
    /**
     * broker的virtualHost
     */
    private String virtualHost;
    /**
     * rabbitmq-server用户名 密码 端口
     */
    private String username;
    private String password;
    private int port;
}
