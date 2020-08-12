/**
 * 
 */
package com.onlinefood.resteasy.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefood.resteasy.Repository.LoginRepository;
import com.onlinefood.resteasy.Service.LoginService;
import com.onlinefood.resteasy.models.User;

/**
 * @author prateetidebchaudhuri
 *
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public User authenticateUser(String username, String password) {
		// TODO Auto-generated method stub
		return loginRepository.authenticateUser(username, password);
	}

	@Override
	public User getUserByUserId(int userId) {
		// TODO Auto-generated method stub
		return loginRepository.getUserById(userId);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return loginRepository.getUserByUsername(username);
	}

}
