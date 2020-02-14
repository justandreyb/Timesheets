package com.justandreyb.timesheets.server.database.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.justandreyb.timesheets.server.database.config.pool.HikariCPConfiguration;
import com.justandreyb.timesheets.server.database.config.pool.WithoutPoolConfiguration;
import com.justandreyb.timesheets.server.database.config.source.H2Configuration;
import com.justandreyb.timesheets.server.database.config.source.MySqlConfiguration;

@Configuration
@Import({
    // Datasource configurations
    H2Configuration.class,
    MySqlConfiguration.class,
    // Connections pool configurations
    HikariCPConfiguration.class,
    WithoutPoolConfiguration.class,
})
@EnableTransactionManagement
public class DatabaseConfiguration {

    private final Environment environment;

    public DatabaseConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.justandreyb.timesheets.server.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory.getObject());
        return transactionManager;
    }

    @Bean
    public HibernateTemplate hibernateTemplate(LocalSessionFactoryBean sessionFactory) {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory.getObject());
        return hibernateTemplate;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("database.hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("database.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("database.hibernate.showSql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("database.hibernate.formatSql"));
        properties.put("hibernate.generate_statistic", environment.getRequiredProperty("database.hibernate.generateStatistic"));
        return properties;
    }

}
