package com.study.board.config;



import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * PrimaryDbConfig
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = PrimaryDbConfig.BASE_PACKAGES
        , sqlSessionTemplateRef = "primarySqlSessionTemplate")
public class PrimaryDbConfig {

    /**
     * BASE_PACKAGES
     */
    public static final String BASE_PACKAGES = "com.study.board.mybatis.mapper";

    /**
     * MAPPER_XML_PATH
     */
    public static final String MAPPER_XML_PATH ="classpath*:mapper/*.xml";;

    /**
     * dataSource
     * @return dataSource
     */
    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    //https://mybatis.org/spring/transactions.html

    /**
     * transactionManager
     *
     * @return DataSourceTransactionManager
     */
    @Primary
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * sqlSessionFactory
     *
     * @param primaryDataSource primaryDataSource
     * @return SqlSessionFactory
     * @throws Exception Exception
     */
    @Primary
    @Bean(name = "primarySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("primaryDataSource") DataSource primaryDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(primaryDataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_PATH));
        return bean.getObject();
    }

    /**
     * sqlSessionTemplate
     *
     * @param sqlSessionFactory sqlSessionFactory
     * @return SqlSessionTemplate
     * @throws Exception Exception
     */
    @Bean(name = "primarySqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("primarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}