package com.onlinefood.resteasy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinefood.resteasy.models.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer>{
	@Query(nativeQuery= true, value = "select * from dish d")
	List<Dish> findAllDishes();
	
	@Query(nativeQuery=true, value = "select * from dish d where dish_name =:dishName")
	Dish searchByDishName(@Param("dishName") String dishNname);
	
	
	@Query(nativeQuery=true, value = "select * from dish d where d.vendor_id =:vendorId")
	List<Dish> searchDishByVendor(@Param("vendorId") int vendorId);
	
	@Query(nativeQuery=true, value = "select * from dish d order by dish_price")
	List<Dish> viewDishesASC();
	
	@Query(nativeQuery=true, value = "select * from dish d order by dish_price desc")
	List<Dish> viewDishesDESC();
	
}
