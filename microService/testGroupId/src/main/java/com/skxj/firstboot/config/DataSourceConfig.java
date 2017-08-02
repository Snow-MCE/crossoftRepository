package com.skxj.firstboot.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Snow on 7/11/2017.
 */

@Configuration
@MapperScan("com.skxj.firstboot.dao")
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource(){

        return new DataSource();
    }

}
