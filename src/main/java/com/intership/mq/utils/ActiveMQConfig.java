package com.intership.mq.utils;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.naming.Context;
import java.util.Properties;


@Configuration
@EnableJms
public class ActiveMQConfig {


    @Value("${broker.url}")
    private String brokerUrl;

    @Value("${broker.username}")
    private String userName;

    @Value("${broker.password}")
    private String password;

    @Value("${broker.queue}")
    private String queueName;

    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private static final String CONNECTION_FACTORY = "java:comp/env/jms/myQueueConnectionFactory";



    @Bean
    public ConnectionFactory connectionFactory() {
        try {
            ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
            cf.setBrokerURL(brokerUrl);
            return cf;

        }  catch (Exception ex) {
            System.out.println("Error");
        }
        return null;
    }

    Properties getEnvProperties() {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        env.put(Context.PROVIDER_URL, brokerUrl);
        env.put(Context.SECURITY_PRINCIPAL, userName);
        env.put(Context.SECURITY_CREDENTIALS, password);

        return env;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

}
