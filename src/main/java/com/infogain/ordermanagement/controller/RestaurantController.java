/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
* Copyright (c) 2019 FedEx Services, Inc. All Rights Reserved.* * * * * * * * * * * * * *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*/
package com.infogain.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.ordermanagement.beans.CustOrder;
import com.infogain.ordermanagement.beans.Item;
import com.infogain.ordermanagement.service.RestaurantService;

/** This class is used for 
 * @author Sharad.Jain
 *
 */

@RestController
@RequestMapping("/order-management")
public class RestaurantController {
	
	
	@Autowired  
    private RestaurantService restaurantService; 
 
	@RequestMapping(value = "/addItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int addItem(@RequestBody Item item) {
        System.out.println("Entering RestaurantController...Adding Item");
    	return restaurantService.addItem(item);
    }
	
    @RequestMapping(value = "/showMenu", method = RequestMethod.GET)
    public List<Item> showMenu() {
        System.out.println("Entering RestaurantController");
    	return restaurantService.showMenu();
    }
          
    
    
    @RequestMapping(value = "/takeOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int takeOrder(@RequestBody CustOrder order) {
        System.out.println("Taking Order");
        return restaurantService.takeOrder(order);
        
		/*
		 * Date date = new Date(); CustOrder order = new CustOrder(1,date,"Not Ready");
		 * return restaurantService.takeOrder(order);
		 */ 
    }
    
	/*
	 * @RequestMapping(value = "/checkStatus", method = RequestMethod.GET) public
	 * void checkStatus(@PathVariable String orderId) {
	 * 
	 * 
	 * return restaurantService.checkStatus(); }
	 */

}
