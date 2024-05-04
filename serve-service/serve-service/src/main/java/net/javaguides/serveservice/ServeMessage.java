package net.javaguides.serveservice;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import net.javaguides.orderservice.smsStatus;

@Service 
public class ServeMessage {
	
    //private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
    private KafkaTemplate<String,smsStatus> kafkaTemplateS;


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
	kafkaTemplateS.send(message);
			
	//return "send message success";
	
  }

}