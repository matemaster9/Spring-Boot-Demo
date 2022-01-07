package tech.matemaster9.config.db;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.google.common.collect.Maps;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import tech.matemaster9.config.ds.RoutingDataSource;
import tech.matemaster9.entity.enums.DataSourceEnum;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description: 动态数据源配置
 * @Author: matemaster9
 * @Date: 2022/1/4 20:32
 */
@Configuration
@MapperScan(basePackages = "tech.matemaster9.mapper")
public class DruidDataSourceConfig {

    @Bean("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource masterDS(DruidProperties properties) {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return properties.druidDS(dataSource);
    }

    @Bean("slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    public DataSource slaveDS(DruidProperties properties) {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return properties.druidDS(dataSource);
    }

    @Bean("dynamicDataSource")
    @Primary
    public RoutingDataSource dynamicDS(@Qualifier("masterDataSource") DataSource master,
                                       @Qualifier("slaveDataSource") DataSource slave) {
        Map<Object, Object> targetDataSources = Maps.newHashMap();
        targetDataSources.put(DataSourceEnum.MASTER.name(), master);
        targetDataSources.put(DataSourceEnum.SLAVE.name(), slave);
        return new RoutingDataSource(master, targetDataSources);
    }
}
