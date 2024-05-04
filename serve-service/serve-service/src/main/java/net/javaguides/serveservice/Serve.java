package net.javaguides.serveservice;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name="Serve")
public class Serve {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id ;
	Integer ordernumber ;
	String menuid ;
	Integer quantity;
	String tablenumber;
	
	public Serve() {
	}
	
	
	public Serve(Integer id, Integer orderNumber, String MenuId,Integer Quantity,String tableNumber) {
		super();
		this.id = id;
		this.ordernumber = orderNumber;
		this.menuid = MenuId;
		this.quantity=Quantity;
		this.tablenumber = tableNumber;
	}


	public String getMenuid() {
		return menuid;
	}


	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
	

}
