package net.javaguides.trackingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import net.javaguides.orderservice.Order;
import net.javaguides.orderservice.smsStatus;

@RestController
public class TrackController {
	@Autowired
    private statusRepo repository;
	
	@Autowired
    private trackMessage messageProducer;
	
//	@GetMapping("/update")
//    public String greeting(@RequestParam("orderId") Integer orderId) {
//		Food food =repository.findByOrderId(orderId);
//		Order order= new Order(food.getOrderId(),food.getOrdernumber(),food.getMenuid(),food.getQuantity(),food.getTablenumber());
//		smsStatus sms= new smsStatus(order,"finish");
//		messageProducer.sendServe("SERVE",order);
//        return "send sms to tracking service success!!" ;
//    }

}
