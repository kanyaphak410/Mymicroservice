package net.javaguides.orderservice;

import jakarta.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@jakarta.persistence.Table(name="menu")
public class Menu {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id ;
	String menuid;
	String menuName;
	String catagory;
	
	public Menu() {
		
	}
	public Menu(Integer id,String menuid,String menuName,String catagory) {
		super();
		this.id = id;
		this.menuid=menuid;
		this.menuName = menuName;
		this.catagory = catagory;

	}
	
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	
	


}
