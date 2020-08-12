/**
 * 
 */
package com.onlinefood.resteasy.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefood.resteasy.Service.DishService;
import com.onlinefood.resteasy.Service.FoodOrderService;
import com.onlinefood.resteasy.Service.LoginService;
import com.onlinefood.resteasy.Service.OrderLineItemService;
import com.onlinefood.resteasy.models.Dish;
import com.onlinefood.resteasy.models.FoodOrder;
import com.onlinefood.resteasy.models.OrderDTO;
import com.onlinefood.resteasy.models.OrderLineItem;
import com.onlinefood.resteasy.models.User;

/**
 * @author prateetidebchaudhuri
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	FoodOrderService foodOrderService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	DishService dishService;
	
	@Autowired
	OrderLineItemService orderLineItemService;
	
	private OrderLineItem getOrderLineItem(OrderDTO inputObject) {
		User user = loginService.getUserByUsername(inputObject.getUsername());		
		
		Dish dish = dishService.searchByDishName(inputObject.getInputDish());
		
		OrderLineItem orderLineItem = new OrderLineItem();
		orderLineItem.setDish(dish);
		orderLineItem.setQuantity(inputObject.getQuantity());
		orderLineItem.setUser(user);
		orderLineItem.setVendor(dish.getVendorId());
		
		orderLineItemService.addOrderLineItem(orderLineItem);
		
		return orderLineItem;
	}
	
	@RequestMapping(value = "/order-place", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	public @ResponseBody FoodOrder placeOrder(@RequestBody List<OrderDTO> inputObjects,
			HttpServletResponse response, HttpServletRequest  request) {
		
		List<OrderLineItem> listofOrders = new ArrayList<OrderLineItem>();
		FoodOrder foodOrder = new FoodOrder();
		
		Date currentUtilDate = new Date(System.currentTimeMillis());
		OrderLineItem orderLineItem = null;
		for(OrderDTO inputObject: inputObjects) {
			orderLineItem = getOrderLineItem(inputObject);
			listofOrders.add(orderLineItem);
		}

		
		double totalPrice = 0.0;
		
		for(OrderLineItem orderItem: listofOrders) {
			totalPrice += orderItem.getQuantity()*orderItem.getDish().getDishPrice();
		}
		
		
		foodOrder.setTotalPrice(totalPrice);
		foodOrder.setOrderDate(currentUtilDate);
		foodOrder.setOrderLineItem(listofOrders);
		
		return foodOrderService.placeOrder(foodOrder);
	}
	
	
	@RequestMapping(value = "/getOrder/{orderId}", method = RequestMethod.GET, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody FoodOrder getOrderById(@PathVariable int orderId){
		
		return foodOrderService.getOrderById(orderId);
		
	}
	
	@RequestMapping(value = "/getAllOrders/{adminId}", method = RequestMethod.GET, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody List<FoodOrder> getAllOrdersForAdmin(@PathVariable int adminId){
		
		List<FoodOrder> listOfOrders = new ArrayList<>();
		User user = loginService.getUserByUserId(adminId);
		String role = user.getUserType().getUserType();
		if (role.equalsIgnoreCase("Admin")) {
			listOfOrders= foodOrderService.getAllOrders();
		} 
		return listOfOrders;
		
	}
	
}
