package com.github.edgar615.spring.ds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by Edgar on 2018/8/22.
 *
 * @author Edgar  Date 2018/8/22
 */
@SpringBootApplication(scanBasePackages = {"com.github.edgar615.**"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println(context.getBeansOfType(DataSource.class));
    }

    @Bean
    @Primary
    @ConfigurationProperties("dynamic-datasource.first")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("dynamic-datasource.first")
    public DataSource firstDataSource() {
        return firstDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("dynamic-datasource.second")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "secondDataSource")
    @Qualifier("secondDataSource")
    @ConfigurationProperties("dynamic-datasource.second")
    public DataSource secondDataSource() {
        return secondDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @Qualifier("dynamicDataSource")
    public CustomerRoutingDataSource routingDataSource(
            @Autowired DataSource firstDataSource,
            @Autowired @Qualifier("secondDataSource") DataSource secondDataSource) {
        CustomerRoutingDataSource dataSource = new CustomerRoutingDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(CustomerType.first, firstDataSource);
        dataSourceMap.put(CustomerType.second, secondDataSource);
        dataSource.setTargetDataSources(dataSourceMap);
        dataSource.setDefaultTargetDataSource(secondDataSource);
        return dataSource;
    }
}
