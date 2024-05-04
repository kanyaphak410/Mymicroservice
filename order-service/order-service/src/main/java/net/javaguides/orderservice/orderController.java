package net.javaguides.orderservice;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class orderController {
	@Autowired
	private orderRepo repository ;
	@Autowired
	private MenuRepo Mrepository ;
	@Autowired
    private MessageProducer messageProducer;
	public orderController() {}
	int j=1;
	
	public orderController(orderRepo repository,MenuRepo Mrepository) {
		this.repository = repository;
		this.Mrepository=Mrepository;
	}
  //  private MessageProducer messageProducer;

	@GetMapping("/greeting")
    public String greeting() {
        return "Greeting" ;
    }
	
	@GetMapping("/order")
	  public  String addOrder (@RequestParam("ordernum") Integer ordernum ,@RequestParam("menuId") String menuId,@RequestParam("Quantity") Integer Quantity,@RequestParam("tableId") String tableId) {
		    // @ResponseBody means the returned String is the response, not a view name@RequestParam("ordernum") Integer ordernum ,
		    // @RequestParam means it is a parameter from the GET or POST request@RequestParam Integer ordernum , @RequestParam String menu

//		Order n = new Order();
//		    n.setOrdernumber(1);
//		    n.setMenuid("jl52");
//		    n.setQuantity(5);
//		    n.setTablenumber("jk12");
//		    repository.save(n);
//		    return "Saved";
//		//return"---------Hello Spring Boot App------------";
		
		Order order= new Order(j++,ordernum,menuId,Quantity,tableId);
		repository.save(order);
		
		smsStatus sms= new smsStatus(order,"pending");
		messageProducer.sendSMS("TRACKER",sms);
		
		
		System.out.println("order from consumer = "+ menuId);
		Menu menu= Mrepository.findByMenuid(menuId);
		System.out.println("menuName = "+ menu.getMenuName());
	    System.out.println("catagory= "+menu.getCatagory());
	    if(menu.getCatagory().equals("food")) {
	    messageProducer.sendMessage("POS5WMS",order);
	    System.out.println( "send message to food service success");
	    }
	    else if(menu.getCatagory().equals("drink")) {
	    messageProducer.sendMessage("POS6WMS",order);
	    System.out.println( "send message to drink  service success");
	    }
	    else if(menu.getCatagory().equals("dessert")) {
	    messageProducer.sendMessage("DESSERT",order);
	    System.out.println( "send message to dessert service success");
	    }
//		
		return "saved: "+menuId+"\n orderNum: "+ordernum+"\n Quantity:"+Quantity+"\n tableId:"+tableId;
	}
	
//    @GetMapping("/send")
//    public ResponseEntity<?> sendMessage(@RequestParam("message") String message) {
//        messageProducer.sendMessage("POS3WMS", message);
//        return ResponseEntity.ok("Message sent: " + message);
//    }return repository.save(customer);

}

