package net.javaguides.serveservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import net.javaguides.orderservice.Order;
import net.javaguides.orderservice.orderRepo;
import net.javaguides.orderservice.smsStatus;

@Service
public class ServeConsumer {

	@Autowired
	private ServeRepo repository ;
	//@Autowired
   // private ConcurrentKafkaListenerContainerFactory<String, Order>concurrentKafkaListenerContainerFactory;
	
	//private MovieRepository repository ;
	public ServeConsumer() {}
	
//	public FoodConsumer(MovieRepository repository) {
//		this.repository = repository;
//	}

	@KafkaListener(topics="SERVE", groupId="my-group-id",containerFactory
            = "TrackingListener")
	
	public void  consume(Order order) {
		System.out.println("sms from order >>>"+order.toString());
		Serve serve =new Serve(order.getId(),order.getOrdernumber(),order.getMenuid(),order.getQuantity(),order.getTablenumber());
		repository.save(serve);
		System.out.println("saved serve order!!");
		
	}
}
