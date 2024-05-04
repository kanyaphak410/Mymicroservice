package net.javaguides.drinkservice;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.orderservice.MenuRepo;
import net.javaguides.orderservice.MessageProducer;
import net.javaguides.orderservice.Order;
import net.javaguides.orderservice.smsStatus;
import net.javaguides.stockservice.Stock;

@RestController
public class DrinkController {
	
	@Autowired
    private DrinkRepo repository;
	
	@Autowired
    private DrinkMessage messageProducer;
	
	@GetMapping("/update")
    public String greeting(@RequestParam("Id") Integer Id) {
		Optional<Drink> drink =repository.findById(Id);
		Order order= new Order(drink.get().getOrderId(),drink.get().getOrdernumber(),drink.get().getMenuid(),drink.get().getQuantity(),drink.get().getTablenumber());
		smsStatus sms= new smsStatus(order,"finish");
		messageProducer.sendSMS("TRACKER",sms);
        return "send sms to tracking service success!!" ;
    }
	
	@GetMapping("/requisition")
    public String greeting(@RequestParam("itemId") String itemId,@RequestParam("quantity") Integer quantity) {

		Stock stock1= new Stock(1,itemId,quantity);
		messageProducer.sendRequest("STOCK",stock1);
		return "send sms to Stock service success !! with itemId>>" +itemId+"\n quantity = "+quantity;
		
    }
	

}
