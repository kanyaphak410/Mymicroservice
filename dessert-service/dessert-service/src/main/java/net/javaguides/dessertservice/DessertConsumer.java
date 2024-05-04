package net.javaguides.dessertservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import net.javaguides.orderservice.Order;
@Service
public class DessertConsumer {
	
	int i=1;
	@Autowired
    private DessertRepo repository;

	public DessertConsumer() {}
	

	@KafkaListener(topics="DESSERT", groupId="my-group-id",containerFactory
            = "DessertListener")
	
	public void  consume(Order order) {
		System.out.println("message from order service >>>"+order.toString());
		Dessert dessert= new Dessert(i++,order.getId(),order.getOrdernumber(),order.getMenuid(),order.getQuantity(),order.getTablenumber());
		repository.save(dessert);
		System.out.println("saved dessert order!!");
	}
}