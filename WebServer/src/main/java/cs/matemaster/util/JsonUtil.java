package cs.matemaster.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description: JSON的序列化和反序列化
 * @Author: MateMaster
 * @Date: 2022/2/19 16:33
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final ObjectMapper CAMEL_MAPPER = new ObjectMapper();

    /**
     * JSON序列化
     *
     * @param obj 被序列化对象
     * @return JSON序列化字符串
     */
    public static String serialize(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * JSON序列化 忽略null属性
     *
     * @param obj 被序列化对象
     * @return JSON序列化字符串
     */
    public static String serializeIgnoreNull(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * JSON序列化 大驼峰属性
     *
     * @param obj 被序列化对象
     * @return JSON序列化字符串
     */
    public static String serializeWithUpperCamel(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            CAMEL_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
            return CAMEL_MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    /**
     * 反序列化泛型T对象
     * @param data 反序列化内容
     * @param clazz 泛型对象
     * @param <T> 对象类型
     * @return 反序列化后的对象
     */
    public static <T> T deserialize(String data, Class<T> clazz) {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        try {
            MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return MAPPER.readValue(data, clazz);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
