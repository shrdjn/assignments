/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
* Copyright (c) 2019 FedEx Services, Inc. All Rights Reserved.* * * * * * * * * * * * * *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*/
package com.infogain.ordermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.ordermanagement.ItemRepository;
import com.infogain.ordermanagement.OrderRepository;
import com.infogain.ordermanagement.beans.CustOrder;
import com.infogain.ordermanagement.beans.Item;

/** This class is used for 
 * @author Sharad.Jain
 *
 */

@Service
public class RestaurantService {

	@Autowired  
	private OrderRepository orderRepository;  
	
	@Autowired  
	private ItemRepository itemRepository;  
	
	
	    public List<Item> showMenu(){  
	        List<Item> records = new ArrayList<>();  
	        itemRepository.findAll().forEach(records::add);  
	        return records;  
	    }  
	    
	    public int addItem(Item item){  
	        itemRepository.save(item);  
	        return item.getItemId();  
	    }  
	    
	    public int takeOrder(CustOrder order) {
	    	  
	        orderRepository.save(order);  
	        return order.getOrderId();
	    }

	
	
}
