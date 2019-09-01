package com.justandreyb.timesheets.server.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public HikariConfig dataSourceSettings() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setPoolName("ConnectionsPool");
        hikariConfig.setConnectionTestQuery("SELECT 1");
        hikariConfig.setMaximumPoolSize(3);
        hikariConfig.setJdbcUrl(env.getRequiredProperty("database.url"));
        hikariConfig.setUsername(env.getRequiredProperty("database.username"));
        hikariConfig.setPassword(env.getRequiredProperty("database.password"));
        hikariConfig.setDriverClassName(env.getRequiredProperty("database.driver"));
        return hikariConfig;
    }

    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource() {
        return new HikariDataSource(dataSourceSettings());
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.justandreyb.timesheets.server.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public HibernateTemplate hibernateTemplate() {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory().getObject());
        return hibernateTemplate;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(org.hibernate.cfg.Environment.DATASOURCE, dataSource());
        properties.put(org.hibernate.cfg.Environment.DIALECT, env.getRequiredProperty("database.hibernateDialect"));
        properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, env.getRequiredProperty("database.hibernateHBM2DDL"));
        properties.put(org.hibernate.cfg.Environment.SHOW_SQL, env.getRequiredProperty("database.showSql"));
        properties.put(org.hibernate.cfg.Environment.FORMAT_SQL, env.getRequiredProperty("database.formatSql"));
        return properties;
    }

}
