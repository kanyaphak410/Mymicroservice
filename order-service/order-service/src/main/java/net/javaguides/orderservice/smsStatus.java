package net.javaguides.orderservice;

public class smsStatus {
		
	Order order;
	String status;
	
	public smsStatus() {
	}
	
	public smsStatus(Order order,String s) {
		super();
		this.order = order;
		this.status=s;

	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
