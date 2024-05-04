package net.javaguides.trackingservice;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name="Status")
public class Status {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id ;
	Integer ordernumber ;
	String tablenumber;
	String status;
	
	public Status() {
	}
	
	
	public Status(Integer id, Integer orderNumber,String tableNumber,String status) {
		super();
		this.id = id;
		this.ordernumber = orderNumber;
		this.tablenumber = tableNumber;
		this.status=status;
	}
	public Integer getOrderId() {
		return id;
	}
	public void setOrderId(Integer orderId) {
		id = orderId;
	}
	public Integer getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getTablenumber() {
		return tablenumber;
	}
	public void setTablenumber(String tablenumber) {
		this.tablenumber = tablenumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
