/**
 * 
 */
package com.onlinefood.resteasy.Service;

import com.onlinefood.resteasy.models.User;

/**
 * @author prateetidebchaudhuri
 *
 */
public interface LoginService {

	User authenticateUser(String username, String password);
	
	User getUserByUserId(int userId);
	
	User getUserByUsername(String username);
}
