/**
 * 
 */
package com.onlinefood.resteasy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinefood.resteasy.models.FoodOrder;

/**
 * @author prateetidebchaudhuri
 *
 */
@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

	@Query(nativeQuery= true, value = "select * from food_order fo where fo.order_id =:orderId")
	FoodOrder getOrderById(@Param("orderId") int orderId);
	
	@Query(nativeQuery=true, value = "select * from food_order fo")
	List<FoodOrder> getAllOrders();
}
