package net.javaguides.orderservice;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service 
public class MessageProducer {
	
    //private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;
	@Autowired
    private KafkaTemplate<String,smsStatus> kafkaTemplate2;

//    public void sendMessage(String topicName, String message) {
//    	kafkaTemplate.send(topicName, message) ;
//     
//        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);
//        future.whenComplete((result, ex) -> {
//            if (ex == null) {
//                System.out.println("Sent message=[" + message + 
//                    "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            } else {
//                System.out.println("Unable to send message=[" + 
//                    message + "] due to : " + ex.getMessage());
//            }
//        });
//    }
  public void sendMessage(String topicName,Order order) {
	//kafkaTemplate.send(topicName,order) ;
	Message<Order> message = MessageBuilder
			.withPayload(order)
			.setHeader(KafkaHeaders.TOPIC,topicName)
			.build();
	kafkaTemplate.send(message);
			
	
	//return "send message success";
	
  }
  public void sendSMS(String topicName,smsStatus sms) {
	//kafkaTemplate.send(topicName,order) ;
	Message<smsStatus> message = MessageBuilder
			.withPayload(sms)
			.setHeader(KafkaHeaders.TOPIC,topicName)
			.build();
	kafkaTemplate2.send(message);
			
	//return "send message success";
	
  }

}