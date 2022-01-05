package tech.matemaster9.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tech.matemaster9.annotation.DataSource;
import tech.matemaster9.config.ds.ContextHolder;

import java.util.Objects;

/**
 * @Description:
 * @Author: matemaster9
 * @Date: 2022/1/4 22:33
 */
@Aspect
@Order(1)
@Component
public class DataSourceAspect {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(tech.matemaster9.annotation.DataSource)")
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        DataSource dataSource = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if (Objects.isNull(dataSource)) {
            dataSource = AnnotationUtils.findAnnotation(signature.getDeclaringType(), DataSource.class);
        }
        ContextHolder.setDataSourceType(dataSource.value().name());

        try {
            return joinPoint.proceed();
        } finally {
            ContextHolder.clearDataSource();
        }
    }
}
