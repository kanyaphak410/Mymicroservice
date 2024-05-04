package net.javaguides.stockservice;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name="Stock")
public class Stock {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id ;
	String itemId;
	String itemName;
	Integer quantity;
	
	
	public Stock() {
		
	}
	public Stock(Integer id,String item,Integer quantity) {
		super();
		this.id=id;
		this.itemId=item;
		this.quantity = quantity;

	}
	public Stock(Integer id,String item,String itemName,Integer quantity) {
		super();
		this.id = id;
		this.itemId=item;
		this.itemName=itemName;
		this.quantity = quantity;

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
