/**
 * 
 */
package com.onlinefood.resteasy.Service;

import java.util.List;

import com.onlinefood.resteasy.models.FoodOrder;

/**
 * @author prateetidebchaudhuri
 *
 */
public interface FoodOrderService {

	FoodOrder placeOrder(FoodOrder foodOrder);
	
	FoodOrder getOrderById(int orderId);
	
	List<FoodOrder> getAllOrders();
}
