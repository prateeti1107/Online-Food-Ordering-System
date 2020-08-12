/**
 * 
 */
package com.onlinefood.resteasy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.onlinefood.resteasy.Service.DishService;
import com.onlinefood.resteasy.models.Dish;

/**
 * @author prateetidebchaudhuri
 *
 */
@RestController
@RequestMapping("/dish")
public class DishController {

	@Autowired
	DishService dishService;
	
	
	@RequestMapping(value = "/getAllDishes", method = RequestMethod.GET, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Dish> getAllDishes() throws JsonProcessingException{
		
		return dishService.getAllDishes();
		
	}
	
	@RequestMapping(value = "/searchByDishName/{dishName}", method = RequestMethod.GET, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody Dish searchByDishName(@PathVariable String dishName) throws JsonProcessingException{
		
		
		return dishService.searchByDishName(dishName);
		
	}
	
	@RequestMapping(value = "/searchDishesByVendor/{vendorId}", method = RequestMethod.GET, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Dish> searchDishByVendor(@PathVariable int vendorId) throws JsonProcessingException{
		
		
		return dishService.searchDishByVendor(vendorId);
		
	}
	
	@RequestMapping(value = "/sortDishesAsc", method = RequestMethod.GET, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Dish> sortDishesinAsc() throws JsonProcessingException{
		
		
		return dishService.viewDishesASC();
		
	}
	
	@RequestMapping(value = "/sortDishesDesc", method = RequestMethod.GET, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Dish> sortDishesinDesc() throws JsonProcessingException{
		
		
		return dishService.viewDishesDESC();
		
	}
}
