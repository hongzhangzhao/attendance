package edu.zygxy.common;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by guofumei on 2019/11/1.
 */
@Configuration
public class MyBatisConfig {
    @Resource
    private Environment env;

    @Bean
    public DataSource getDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("spring.datasource.driver-class-name"));
        props.put("url", env.getProperty("spring.datasource.url"));
        props.put("username", env.getProperty("spring.datasource.username"));
        props.put("password", env.getProperty("spring.datasource.password"));
        props.put("maxActive", env.getProperty("mybatis.maxActive"));
        props.put("minIdle", env.getProperty("mybatis.minIdle"));
        props.put("minEvictableIdleTimeMillis", env.getProperty("mybatis.minEvictableIdleTimeMillis"));
        props.put("testOnBorrow", env.getProperty("mybatis.testOnBorrow"));
        props.put("testWhileIdle", env.getProperty("mybatis.testWhileIdle"));
        props.put("testOnReturn", env.getProperty("mybatis.testOnReturn"));
        props.put("timeBetweenEvictionRunsMillis", env.getProperty("mybatis.timeBetweenEvictionRunsMillis"));
        props.put("validationQuery", env.getProperty("mybatis.validationQuery"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        fb.setDataSource(ds);
        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
        fb.setConfiguration(configuration);
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));
        return fb.getObject();
    }

}
