package tech.matemaster9.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/7 11:29
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SpringUtil {
    @Autowired
    private ApplicationContext applicationContext;
}
