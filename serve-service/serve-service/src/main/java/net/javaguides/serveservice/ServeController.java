package net.javaguides.serveservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import net.javaguides.orderservice.Order;
import net.javaguides.orderservice.smsStatus;

@RestController
public class ServeController {
	
	@Autowired
    private ServeRepo repository;
	
	@Autowired
    private ServeMessage messageProducer;
	
	@GetMapping("/update")
    public String greeting(@RequestParam("orderId") Integer orderId) {
		Optional<Serve> serve =repository.findById(orderId);
		Order order= new Order(serve.get().getId(),serve.get().getOrdernumber(),serve.get().getMenuid(),serve.get().getQuantity(),serve.get().getTablenumber());
		smsStatus sms= new smsStatus(order,"Served");
		messageProducer.sendSMS("TRACKER",sms);
        return "send Served sms to tracking service success!!" ;
    }

}
