/**
 * 
 */
package com.onlinefood.resteasy.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefood.resteasy.Repository.DishRepository;
import com.onlinefood.resteasy.Service.DishService;
import com.onlinefood.resteasy.models.Dish;

/**
 * @author prateetidebchaudhuri
 *
 */
@Service("DishService")
public class DishServiceImpl implements DishService{

	@Autowired
	DishRepository dishRepository;
	
	@Override
	public List<Dish> getAllDishes() {
		// TODO Auto-generated method stub
		return dishRepository.findAllDishes();
	}

	@Override
	public Dish searchByDishName(String dishName) {
		// TODO Auto-generated method stub
		return dishRepository.searchByDishName(dishName);
	}

	@Override
	public List<Dish> searchDishByVendor(int vendorId) {
		// TODO Auto-generated method stub
		return dishRepository.searchDishByVendor(vendorId);
	}

	@Override
	public List<Dish> viewDishesASC() {
		// TODO Auto-generated method stub
		return dishRepository.viewDishesASC();
	}

	@Override
	public List<Dish> viewDishesDESC() {
		// TODO Auto-generated method stub
		return dishRepository.viewDishesDESC();
	}

}
