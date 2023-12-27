package com.kadyan.springbootusingkafka.JsonProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kadyan.springbootusingkafka.DTO.JsonDTO;

@Service
public class JsonKafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, JsonDTO> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, JsonDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(JsonDTO inputDTO) {
        logger.info("Message sent -> "+inputDTO.getEmailId().toString());
        Message<JsonDTO> message = MessageBuilder.withPayload(inputDTO).setHeader(KafkaHeaders.TOPIC, "newTopic1")
                .build();

                kafkaTemplate.send(message);
    }
}
