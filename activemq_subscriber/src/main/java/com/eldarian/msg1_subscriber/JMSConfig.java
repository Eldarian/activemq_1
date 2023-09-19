package com.eldarian.msg1_subscriber;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
public class JMSConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerURL;

    @Value("${spring.activemq.user}")
    private String brokerUserName;

    @Value("${spring.activemq.password}")
    private String brokerPassword;

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerURL);
        connectionFactory.setUserName(brokerUserName);
        connectionFactory.setPassword(brokerPassword);
        return connectionFactory;
    }

    @Bean(name = "topicListenerFactory")
    public DefaultJmsListenerContainerFactory topicListenerFactory() {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory());
        jmsListenerContainerFactory.setPubSubDomain(true);
        return jmsListenerContainerFactory;
    }
}
