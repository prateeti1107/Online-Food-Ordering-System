package com.onlinefood.resteasy.Service;

import java.util.List;

import com.onlinefood.resteasy.models.Dish;

public interface DishService {
	
	List<Dish> getAllDishes();
	
	Dish searchByDishName(String dishName);
	
	List<Dish> searchDishByVendor(int vendorId);
	
	List<Dish> viewDishesASC();
	
	List<Dish> viewDishesDESC();
}
