package com.kafka.kafkaconsumer.controllers;

import com.kafka.kafkaconsumer.models.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class TransactionController {

    Transaction tranFromTopic = null;
   @KafkaListener(groupId = "payments",topics = "Payments",containerFactory = "kafkaListenerContainerFactory")
    public Transaction getTransaction(Transaction message){
            tranFromTopic = message;
            return tranFromTopic;
    }

    @GetMapping("/transactions")
    public Transaction consumeMsg(){
       return tranFromTopic;

    }

}
