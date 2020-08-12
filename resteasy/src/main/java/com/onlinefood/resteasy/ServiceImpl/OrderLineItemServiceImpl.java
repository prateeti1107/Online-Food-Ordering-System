/**
 * 
 */
package com.onlinefood.resteasy.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefood.resteasy.Repository.OrderLineItemRepository;
import com.onlinefood.resteasy.Service.OrderLineItemService;
import com.onlinefood.resteasy.models.OrderLineItem;

/**
 * @author prateetidebchaudhuri
 *
 */
@Service("OrderLineItemService")
public class OrderLineItemServiceImpl implements OrderLineItemService{

	@Autowired
	OrderLineItemRepository orderLineItemRepository;
	
	@Override
	public OrderLineItem addOrderLineItem(OrderLineItem orderLineItem) {
		// TODO Auto-generated method stub
		return orderLineItemRepository.save(orderLineItem);
	}

}
