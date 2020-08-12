/**
 * 
 */
package com.onlinefood.resteasy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefood.resteasy.models.OrderLineItem;

/**
 * @author prateetidebchaudhuri
 *
 */
@Repository
public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Integer>{
	

}
