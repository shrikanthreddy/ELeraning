package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ProductData")
public class ProductData 
{
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	
	
	
public String getName() 
	{
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getUniversalnumber() {
		return universalnumber;
	}
	public void setUniversalnumber(String universalnumber) {
		this.universalnumber = universalnumber;
	}
	
	@Column
	private int productId;
	@Column
private String name;
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Column
private String universalnumber;
}
