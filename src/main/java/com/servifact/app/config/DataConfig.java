
package com.servifact.app.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DataConfig {

    private static final Logger log = LoggerFactory.getLogger(DataConfig.class);
    @Autowired
    private SessionFactory sessionFactory ;

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    @Configuration
//    @Profile("production")
    @Import(PropertyPlaceholderConfig.class)
    static class Production {

        @Value("${hibernate.show_sql}")
        protected String hibernateShowSql;
        @Value("${hibernate.dialect}")
        protected String hibernateDialect;
        @Value("${hibernate.hbm2ddl.auto}")
        protected String hibernateHbm2DDL;
        @Value("${hibernate.cache.use_second_level_cache}")
        protected String hibernateSecondLevelCache;
        @Value("${hibernate.cache.provider_class}")
        protected String hibernateCacheClass;
        @Value("${hibernate.default_schema}")
        protected String hibernateSchema;
        @Value("${jdbc.driverClassName}")
        protected String jdbcDriver;
        @Value("${jdbc.username}")
        protected String jdbcUsername;
        @Value("${jdbc.password}")
        protected String jdbcPassword;
        @Value("${jdbc.url}")
        protected String jdbcUrl;

        @Bean
        public SessionFactory sessionFactory() {

            LocalSessionFactoryBean factoryBean;
            try {
                factoryBean = new LocalSessionFactoryBean();
                Properties pp = new Properties();
                pp.setProperty("hibernate.show_sql", hibernateShowSql);
                pp.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2DDL);
                pp.setProperty("hibernate.cache.use_second_level_cache", hibernateSecondLevelCache);
                pp.setProperty("hibernate.cache.provider_class", hibernateCacheClass);
                pp.setProperty("hibernate.default_schema", hibernateSchema);
                 pp.setProperty("hibernate.dialect", hibernateDialect);
                factoryBean.setDataSource(dataSource());
                factoryBean.setPackagesToScan("com.legadofact.modelo");
                factoryBean.setHibernateProperties(pp);
                factoryBean.afterPropertiesSet();
                return factoryBean.getObject();
            } catch (Exception e) {
                log.error("Couldn't configure the sessionFactory bean", e);
            }
            throw new RuntimeException("Couldn't configure the sessionFactory bean");
        }

        @Bean
        public DataSource dataSource() {
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName(jdbcDriver);
            ds.setUsername(jdbcUsername);
            ds.setPassword(jdbcPassword);
            ds.setUrl(jdbcUrl);
            
            ds.setInitialSize(5);
            ds.setMaxActive(10);
            ds.setRemoveAbandoned(true);
            ds.setLogAbandoned(true);
            ds.setValidationQuery("SELECT 1");
            return ds;
        }
    }

//    @Configuration
//    @Profile("tests")
//    @Import(PropertyPlaceholderConfig.class)
//    static class Tests {
//
//        @Value("${test.hibernate.show_sql}")
//        protected String testHibernateShowSql;
//        @Value("${test.hibernate.hbm2ddl.auto}")
//        protected String testHibernateHbm2DDL;
//        @Value("${test.hibernate.cache.use_second_level_cache}")
//        protected String testHibernateSecondLevelCache;
//        @Value("${test.hibernate.cache.provider_class}")
//        protected String testHibernateCacheClass;
//        @Value("${test.hibernate.default_schema}")
//        protected String testHibernateSchema;
//        @Value("${test.jdbc.driverClassName}")
//        protected String testJdbcDriver;
//        @Value("${test.jdbc.username}")
//        protected String testJdbcUsername;
//        @Value("${test.jdbc.password}")
//        protected String testJdbcPassword;
//        @Value("${test.jdbc.url}")
//        protected String testJdbcUrl;
//
//        @Bean
//        public SessionFactory sessionFactory() {
//            LocalSessionFactoryBean factoryBean;
//            try {
//                factoryBean = new LocalSessionFactoryBean();
//                Properties pp = new Properties();
//                pp.setProperty("hibernate.show_sql", testHibernateShowSql);
//                pp.setProperty("hibernate.hbm2ddl.auto", testHibernateHbm2DDL);
//                pp.setProperty("hibernate.cache.use_second_level_cache", testHibernateSecondLevelCache);
//                pp.setProperty("hibernate.cache.provider_class", testHibernateCacheClass);
//                pp.setProperty("hibernate.default_schema", testHibernateSchema);
//
//                factoryBean.setDataSource(dataSource());
//                factoryBean.setPackagesToScan("com.legadofact.modelo");
//                factoryBean.setHibernateProperties(pp);
//                factoryBean.afterPropertiesSet();
//                return factoryBean.getObject();
//            } catch (Exception e) {
//                log.error("Couldn't configure the sessionFactory bean", e);
//            }
//            throw new RuntimeException("Couldn't configure the sessionFactory bean");
//        }
//
//        @Bean
//        public DataSource dataSource() {
//            DriverManagerDataSource ds = new DriverManagerDataSource();
//            ds.setDriverClassName(testJdbcDriver);
//            ds.setUsername(testJdbcUsername);
//            ds.setPassword(testJdbcPassword);
//            ds.setUrl(testJdbcUrl);
//            return ds;
//        }
//    }
}
