/**
 * 
 */
package com.onlinefood.resteasy.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinefood.resteasy.Service.LoginService;
import com.onlinefood.resteasy.models.User;

/**
 * @author prateetidebchaudhuri
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/get-user", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	public @ResponseBody User authenticateUser(@RequestBody User user,
			HttpServletResponse response, HttpServletRequest  request) {
		
		return loginService.authenticateUser(user.getUsername(), user.getPassword());
	}
	
	@RequestMapping(value = "/getUserById/{userId}", method = RequestMethod.GET, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody User getOrderById(@PathVariable int userId){
		
		return loginService.getUserByUserId(userId);
		
	}

}
