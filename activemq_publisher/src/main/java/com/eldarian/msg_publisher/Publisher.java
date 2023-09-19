package com.eldarian.msg_publisher;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    @Autowired
    @Qualifier("pubTemplate")
    private JmsTemplate jmsTemplate;

    public void sendMessage(String destination, String message) {
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend(destination, message);
    }

    @PostConstruct
    public void startSending() {
        sendMessage("InterestingTopic", "hello, world!");
        sendMessage("InterestingTopic", "Such an interesting topic!");
    }
}
