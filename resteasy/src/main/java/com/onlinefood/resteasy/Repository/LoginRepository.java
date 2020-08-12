/**
 * 
 */
package com.onlinefood.resteasy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinefood.resteasy.models.User;

/**
 * @author prateetidebchaudhuri
 *
 */
@Repository
public interface LoginRepository extends JpaRepository<User, Integer>{
	
	@Query(nativeQuery = true, value = "select * from user u where u.username =:username and u.password =:password")
	User authenticateUser(@Param("username") String username, @Param("password") String password);

	@Query(nativeQuery = true, value = "select * from user u where u.user_id =:userId")
	User getUserById(@Param("userId") int userId);
	
	@Query(nativeQuery = true, value = "select * from user u where u.username =:username")
	User getUserByUsername(@Param("username") String username);
}
