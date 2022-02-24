package cs.matemaster.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import cs.matemaster.mq.util.MQUtils;
import cs.matemaster.mq.util.YmlUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/23 20:59
 */
public class MQPublisher {
    private static final RabbitMQProperties properties = YmlUtils.load();
    private static final String QUEUE_NAME = "Hello";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(properties.getHost());
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String msg = "Hello rabbitmq";
            channel.basicPublish("", msg, null, msg.getBytes(StandardCharsets.UTF_8));
            System.out.println("send" + msg);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            MQUtils.autoClose(channel);
            MQUtils.autoClose(connection);
        }
    }
}
