package com.earthadmin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*"})
@AutoConfigureAfter(DruidConfig.class)
@MapperScan({"com.earthadmin.mapper","com.gitee.sunchenbin.mybatis.actable.dao.*"})
public class MybatisMapperScanConfig {

//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() throws Exception{
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.gitee.sunchenbin.mybatis.actable.dao.*");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        return mapperScannerConfigurer;
//    }

}
