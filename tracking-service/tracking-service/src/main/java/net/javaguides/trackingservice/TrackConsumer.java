package net.javaguides.trackingservice;

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
public class TrackConsumer {

	@Autowired
	private statusRepo repository ;
	@Autowired
    private trackMessage trackMessageProducer;
	//@Autowired
   // private ConcurrentKafkaListenerContainerFactory<String, Order>concurrentKafkaListenerContainerFactory;
	
	//private MovieRepository repository ;
	public TrackConsumer() {}
	
//	public FoodConsumer(MovieRepository repository) {
//		this.repository = repository;
//	}

	@KafkaListener(topics="TRACKER", groupId="my-group-id",containerFactory
            = "TrackingListener")
	
	public void  consume(smsStatus sms) {
		System.out.println("sms from order >>>"+sms.getOrder().toString());
		System.out.println("\n status>>>"+sms.getStatus());
		Order order=sms.getOrder();
		Status status =new Status(order.getId(),order.getOrdernumber(),order.getTablenumber(),sms.getStatus());
		repository.save(status);
		System.out.println("save order status success!!");
		if(sms.getStatus().equals("finish")) {
			trackMessageProducer.sendServe("SERVE", order);
			System.out.println("send order to serve service success!!");
		}
		else if(sms.getStatus().equals("Served")) {
			repository.deleteById(order.getId());
			System.out.println("deleted order status !!");
		}
		
		

	}
}