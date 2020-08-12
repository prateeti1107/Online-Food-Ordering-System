/**
 * 
 */
package com.onlinefood.resteasy.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefood.resteasy.Repository.FoodOrderRepository;
import com.onlinefood.resteasy.Repository.OrderLineItemRepository;
import com.onlinefood.resteasy.Service.FoodOrderService;
import com.onlinefood.resteasy.models.FoodOrder;
import com.onlinefood.resteasy.models.OrderLineItem;

/**
 * @author prateetidebchaudhuri
 *
 */
@Service("FoodOrderService")
public class FoodOrderServiceImpl implements FoodOrderService {

	@Autowired
	FoodOrderRepository foodOrderRepository;
	
	@Autowired
	OrderLineItemRepository orderLineItemRepository;
	
	@Override
	public FoodOrder placeOrder(FoodOrder foodOrder) {
		// TODO Auto-generated method stub
		List<OrderLineItem> orderLineitems = foodOrder.getOrderLineItem();
		FoodOrder order = foodOrderRepository.save(foodOrder);
		
		for(OrderLineItem orderLineItem: orderLineitems) {
			orderLineItem.setOrderId(order.getOrderId());
			orderLineItemRepository.save(orderLineItem);
		}
		
		return order;
	}

	@Override
	public FoodOrder getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return foodOrderRepository.getOrderById(orderId);
	}

	@Override
	public List<FoodOrder> getAllOrders() {
		// TODO Auto-generated method stub
		return foodOrderRepository.getAllOrders();
	}

}
