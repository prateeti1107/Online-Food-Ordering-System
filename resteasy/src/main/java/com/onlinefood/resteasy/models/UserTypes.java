/**
 * 
 */
package com.onlinefood.resteasy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author prateetidebchaudhuri
 *
 */
@Entity
public class UserTypes {

	@Id
	@GeneratedValue
	private int userTypeId;
	
	private String userType;

	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
