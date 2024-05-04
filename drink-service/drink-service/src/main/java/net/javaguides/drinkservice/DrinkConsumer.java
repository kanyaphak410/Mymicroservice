package net.javaguides.drinkservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import net.javaguides.orderservice.Order;
@Service
public class DrinkConsumer {
	//@Autowired
	int i=1;
	@Autowired
    private DrinkRepo repository;
   // private ConcurrentKafkaListenerContainerFactory<String, Order>concurrentKafkaListenerContainerFactory;
	
	//private MovieRepository repository ;
	public DrinkConsumer() {}
	
//	public FoodConsumer(MovieRepository repository) {
//		this.repository = repository;
//	}

	@KafkaListener(topics="POS6WMS", groupId="my-group-id",containerFactory
            = "DrinkListener")
	
	public void  consume(Order order) {
		System.out.println("message from order >>>"+order.toString());
		Drink drink= new Drink(i++,order.getId(),order.getOrdernumber(),order.getMenuid(),order.getQuantity(),order.getTablenumber());
		repository.save(drink);
		System.out.println("saved drink order!!");
	}
}
