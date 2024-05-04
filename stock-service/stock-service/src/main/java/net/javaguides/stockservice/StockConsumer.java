package net.javaguides.stockservice;

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
public class StockConsumer {
	//@Autowired

	@Autowired
    private StockRepo repository;
   // private ConcurrentKafkaListenerContainerFactory<String, Order>concurrentKafkaListenerContainerFactory;
	int i=1;
	
	
	//private MovieRepository repository ;
	public StockConsumer() {}
	
//	public FoodConsumer(MovieRepository repository) {
//		this.repository = repository;
//	}

	@KafkaListener(topics="STOCK", groupId="my-group-id",containerFactory
            = "StockListener")
	
	public void  consume(Stock stock) {
		System.out.println("message request item from>>>"+stock.getItemId());
		if(stock.getId()==0) {
			System.out.println("message request item from food service");
		}
		else if(stock.getId()==1) {
			System.out.println("message request item from drink service");
		}
		else if(stock.getId()==2) {
			System.out.println("message request item from dessert service");
		}
		int q=stock.getQuantity();
		Stock stock1 =repository.findByItemId(stock.getItemId());
		System.out.println("request raw material from stock   name>>>"+stock1.itemName+"\n request Quantity >>"+q);
		int myStock=stock1.getQuantity();
		System.out.println("\n My stock have: "+stock1.getQuantity());
		if(q <= myStock) {
		stock1.setQuantity(myStock-q);
		System.out.println("update my stock quantity : "+stock1.getQuantity());
		repository.save(stock1);
		}
		else {
		System.out.println("out of stock!!");
		}

	}


}