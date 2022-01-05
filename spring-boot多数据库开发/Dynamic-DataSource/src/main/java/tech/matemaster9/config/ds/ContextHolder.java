package tech.matemaster9.config.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/4 21:56
 */
public class ContextHolder {
    public static final Logger log = LoggerFactory.getLogger("DynamicDataSourceLog");

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDataSourceType(String dataSource) {
        log.info("切换到数据源: " + dataSource);
        CONTEXT_HOLDER.set(dataSource);
    }

    public static String getDataSource() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSource() {
        CONTEXT_HOLDER.remove();
    }
}
