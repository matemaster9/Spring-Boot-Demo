package cs.matemaster.mq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/24 9:26
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MQUtils {

    /**
     * 自动关闭 Connection
     *
     * @param connection
     */
    public static void autoClose(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 自动关闭 Channel
     *
     * @param channel
     */
    public static void autoClose(Channel channel) {
        if (channel != null) {
            try {
                channel.close();
            } catch (TimeoutException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
