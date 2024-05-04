package net.javaguides.foodservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import net.javaguides.orderservice.MessageProducer;
import net.javaguides.orderservice.Order;
@Service
public class FoodConsumer {
	//@Autowired

	@Autowired
    private FoodRepo repository;
   // private ConcurrentKafkaListenerContainerFactory<String, Order>concurrentKafkaListenerContainerFactory;
	int i=1;
	
	
	//private MovieRepository repository ;
	public FoodConsumer() {}
	
//	public FoodConsumer(MovieRepository repository) {
//		this.repository = repository;
//	}

	@KafkaListener(topics="POS5WMS", groupId="my-group-id",containerFactory
            = "foodListener")
	
	public void  consume(Order order) {
		System.out.println("message from order >>>"+order.toString());
		Food food= new Food(i++,order.getId(),order.getOrdernumber(),order.getMenuid(),order.getQuantity(),order.getTablenumber());
		repository.save(food);

	}
}