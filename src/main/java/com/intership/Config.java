package com.intership;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

public class Config {
    @Configuration
    @EnableTransactionManagement
    @PropertySource("classpath:persistence-jndi.properties")
    @ComponentScan("org.intership")
    @EnableJpaRepositories(basePackages = "org.intership.repositories")
    public class PersistenceJNDIConfig {

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory()
                throws NamingException {
            LocalContainerEntityManagerFactoryBean em
                    = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(dataSource());

            //rest of entity manager configuration
            return em;
        }

        @Bean
        public DataSource dataSource() throws NamingException {
            return (DataSource) new JndiTemplate().lookup("jdbc/sergey");
        }

        @Bean
        public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(emf);
            return transactionManager;
        }

        //rest of persistence configuration
    }
}
