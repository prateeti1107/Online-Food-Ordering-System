/**
 * 
 */
package com.onlinefood.resteasy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinefood.resteasy.models.Vendor;

/**
 * @author prateetidebchaudhuri
 *
 */

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Integer>{
	
	@Query(nativeQuery = true, value = "select * from vendor v")
	List<Vendor> findAllVendors();

}
