package com.eldarian.msg1;

import jakarta.annotation.PostConstruct;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    private final JmsTemplate jmsTemplate;

    public MessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    @PostConstruct
    public void startSending() {
        sendMessage("myQueue", "hello, world!");
    }
}
