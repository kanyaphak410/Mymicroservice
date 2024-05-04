package net.javaguides.drinkservice;


import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import net.javaguides.orderservice.smsStatus;
import net.javaguides.stockservice.Stock;

@Service 
public class DrinkMessage {
	
    //private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
    private KafkaTemplate<String,smsStatus> kafkaTemplateSD;

	@Autowired
    private KafkaTemplate<String,Stock> kafkaTemplateDR;


//  public void sendMessage(String topicName,Order order) {
//	//kafkaTemplate.send(topicName,order) ;
//	Message<Order> message = MessageBuilder
//			.withPayload(order)
//			.setHeader(KafkaHeaders.TOPIC,topicName)
//			.build();
//	kafkaTemplate.send(message);
//			
//	
//	//return "send message success";
//	
//  }
  public void sendSMS(String topicName,smsStatus sms) {
	//kafkaTemplate.send(topicName,order) ;
	Message<smsStatus> message = MessageBuilder
			.withPayload(sms)
			.setHeader(KafkaHeaders.TOPIC,topicName)
			.build();
	kafkaTemplateSD.send(message);
			
	//return "send message success";
	
  }
  public void sendRequest(String topicName,Stock stock) {
	//kafkaTemplate.send(topicName,order) ;
	Message<Stock> message = MessageBuilder
			.withPayload(stock)
			.setHeader(KafkaHeaders.TOPIC,topicName)
			.build();
	kafkaTemplateDR.send(message);
			
	//return "send message success";
	
  }


}
