package com.earthadmin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class DruidConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

//    @Bean
//    public YamlPropertiesFactoryBean configProperties() throws Exception{
//        YamlPropertiesFactoryBean propertiesFactoryBean = new YamlPropertiesFactoryBean();
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        propertiesFactoryBean.setResources(resolver.getResources("classpath*:application.yml"));
//        return propertiesFactoryBean;
//    }

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(30);
        dataSource.setInitialSize(10);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }


    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }

//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory() throws Exception{
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
////        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
////        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*Mapper.xml;classpath*:com/gitee/sunchenbin/mybatis/actable/mapping/*/*.xml"));
//        sqlSessionFactoryBean.setMapperLocations(resolveMapperLocations());
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.earthadmin.entity.*");
//        return sqlSessionFactoryBean;
//    }
//
//    private Resource[] resolveMapperLocations() {
//        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//        List<String> mapperLocations = new ArrayList();
//        mapperLocations.add("classpath*:mapper/*Mapper.xml");
//        mapperLocations.add("classpath*:com/gitee/sunchenbin/mybatis/actable/mapping/*/*.xml");
//        List<Resource> resources =new ArrayList();
//        if(mapperLocations!=null){
//            for (String mapperLocation:mapperLocations){
//                try {
//                    Resource[] mappers = resourcePatternResolver.getResources(mapperLocation);
//                    resources.addAll(Arrays.asList(mappers));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        return resources.toArray(new Resource[resources.size()]);
//    }

}
