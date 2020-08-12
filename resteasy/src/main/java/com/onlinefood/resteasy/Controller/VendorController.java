/**
 * 
 */
package com.onlinefood.resteasy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.onlinefood.resteasy.Service.VendorService;
import com.onlinefood.resteasy.models.Dish;
import com.onlinefood.resteasy.models.Vendor;

/**
 * @author prateetidebchaudhuri
 *
 */
@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	VendorService vendorService;
	
	@RequestMapping(value = "/getAllVendors", method = RequestMethod.GET, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody List<Vendor> getAllVendors() throws JsonProcessingException{
		
		return vendorService.getAllVendorsO();
		
	}
		
}
