/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
* Copyright (c) 2019 FedEx Services, Inc. All Rights Reserved.* * * * * * * * * * * * * *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*/
package com.infogain.ordermanagement.beans;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** This class is used as the domain class for Item
 * @author Sharad.Jain
 *
 */

@Entity
@Table(name = "ITEM")
public class Item implements Serializable{

	public int getItemId() {
		return itemId;
	}



	public void setItemId(int itemId) {
		this.itemId = itemId;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public int getItemPrepTimeInMins() {
		return itemPrepTimeInMins;
	}



	public void setItemPrepTimeInMins(int itemPrepTimeInMins) {
		this.itemPrepTimeInMins = itemPrepTimeInMins;
	}


	/**
	 *  for deserialisation
	 */
	public Item() {
		System.out.println("Inside Item constructor...");
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;

	@Column(name = "itemName")
	private String itemName;

	@Column(name = "itemPrepTimeInMins")
	private int itemPrepTimeInMins;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	//@NotFound(action = NotFoundAction.IGNORE)
	// @Fetch(FetchMode.SELECT)
    private Set<CustOrder> custOrders;


    public Set<CustOrder> getCustOrders() {
		return custOrders;
	}



	public void setCustOrders(Set<CustOrder> custOrders) {
		this.custOrders = custOrders;
	}



	public Item(String itemName, int itemPrepTimeInMins, CustOrder...custOrders) {
    	this.itemName = itemName;
        this.itemPrepTimeInMins = itemPrepTimeInMins;
        
        this.custOrders = Stream.of(custOrders).collect(Collectors.toSet());
        this.custOrders.forEach(x -> x.setItem(this));
        
    }
	
}
