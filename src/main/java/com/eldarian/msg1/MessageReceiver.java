package com.eldarian.msg1;

import org.springframework.jms.annotation.JmsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiver {

    private static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);
    @JmsListener(destination = "myQueue")
    public void receiveMessage(String message) {
        logger.info("Received message: " + message);
    }
}
