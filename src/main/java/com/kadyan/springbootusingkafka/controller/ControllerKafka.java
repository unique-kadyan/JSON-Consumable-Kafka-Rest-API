package com.kadyan.springbootusingkafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadyan.springbootusingkafka.DTO.JsonDTO;
import com.kadyan.springbootusingkafka.JsonProducer.JsonKafkaProducer;

@RestController
@RequestMapping("/v1/api/kafka")
public class ControllerKafka {
    private Logger logger = LoggerFactory.getLogger(ControllerKafka.class);
    private JsonKafkaProducer kafkaProducer;

    public ControllerKafka(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> awakeKafkaMessageProducer(@RequestBody JsonDTO entity) {
        logger.info("Entered into the controller :: awakeKafkaMessageProducer()");
        kafkaProducer.sendMessage(entity);
        return  ResponseEntity.ok("Message produced by the kafka producer ");
    }

}
