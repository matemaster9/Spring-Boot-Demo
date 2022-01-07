package tech.matemaster9.annotation;

import tech.matemaster9.entity.enums.DataSourceEnum;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/4 22:31
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TargetDataSource {
    DataSourceEnum value() default DataSourceEnum.MASTER;
}
