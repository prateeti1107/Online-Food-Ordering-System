/**
 * 
 */
package com.onlinefood.resteasy.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinefood.resteasy.Repository.VendorRepository;
import com.onlinefood.resteasy.Service.VendorService;
import com.onlinefood.resteasy.models.Vendor;

/**
 * @author prateetidebchaudhuri
 *
 */
@Service("VendorService")
public class VendorServiceImpl implements VendorService{

	@Autowired
	VendorRepository vendorRepository;
	
	@Override
	public List<Vendor> getAllVendorsO() {
		// TODO Auto-generated method stub
		return vendorRepository.findAllVendors();
	}

}
