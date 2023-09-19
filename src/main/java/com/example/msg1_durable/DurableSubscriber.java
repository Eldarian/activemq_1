package com.example.msg1_durable;

import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;
import org.apache.activemq.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class DurableSubscriber {
    private static final Logger logger = LoggerFactory.getLogger(DurableSubscriber.class);

    @JmsListener(destination = "InterestingTopic", containerFactory = "durableSubscriberFactory")
    public void receiveMessage(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        logger.info("Received message: " + textMessage.getText() + " on topic " + message.getJMSDestination().toString());
    }

}
