package tech.matemaster9.sqlserver2mysql.config.db;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Description: SQL server数据源配置
 * @Author: matemaster9
 * @Date: 2021/12/25 11:10
 */
@Configuration
@MapperScan(basePackages = "tech.matemaster9.sqlserver2mysql.mapper.sqlserver", sqlSessionTemplateRef = "sqlserverSessionTemplate")
public class SqlServerDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.sqlserver-datasource")
    public DataSource sqlserverDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlserverSessionFactory(@Qualifier("sqlserverDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlserverSessionTemplate(@Qualifier("sqlserverSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("sqlserverTxManager")
    public PlatformTransactionManager txManager(@Qualifier("sqlserverDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sqlserverJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("sqlserverDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
