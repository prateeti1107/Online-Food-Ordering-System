/**
 * 
 */
package com.onlinefood.resteasy.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/**
 * @author prateetidebchaudhuri
 *
 */
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	
	private String username;
	
	private String password;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="roleId")
	private UserTypes userType;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserTypes getUserType() {
		return userType;
	}

	public void setUserType(UserTypes userType) {
		this.userType = userType;
	}
	
	

}
