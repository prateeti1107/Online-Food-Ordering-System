package com.onlinefood.resteasy;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinefood.resteasy.models.User;
import com.onlinefood.resteasy.utils.URLUtils;

public class LoginPage {

	public void login() {
		try {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter Username::");
		
		String username = scanner.nextLine();
		System.out.println("\nEnter password");
		String password = scanner.nextLine();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		URL url = new URL(URLUtils.LoginURLS.loginURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		

		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		String input = mapper.writeValueAsString(user);
		
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		
		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		} else {
			System.out.println("\nSuccessfully logged in User :" + username);
			System.out.println("\nChoose from below menu::");
			System.out.println("\n\n 1. View List of Available Foods "
					+ "\n 2. Search by a particular dish \n 3. View List of Vendors"
					+ "\n 4. View dishes according to Sorted Price(ascending)"
					+ "\n 5. View dishes according to Sorted Price(descending)"
					+ "\n 6. Exit");
			
			switch ( scanner.nextInt() ) {
		      case 1:		    
		        Dishes dishes = new Dishes();
		        dishes.showAllDishes(username);
		        
		        break;
		      case 2:
		    	boolean choice = true;
		    	while(choice) {
			    	Scanner sc = new Scanner(System.in);
			    	System.out.println("Enter dish name to search the details");
			    	String dishName = sc.nextLine();
			    	Dishes.searchByDishName(dishName);
			    	System.out.println("Search for another dish?(Yes/No");
					
					String option = sc.nextLine();
					
					if(option.equalsIgnoreCase("no")){
						choice = false;
					} 
		    	}
		        break;
		      case 3:
		    	VendorClient.getAllvendors();
		    	Scanner sc = new Scanner(System.in);
				System.out.println("\n\nSee available dishes in the vendor?(Yes/No");
				String opt = sc.nextLine();
				boolean vendorChosen = true;
				if(opt.equalsIgnoreCase("yes")) {
					while(vendorChosen) {
						Scanner sc2 = new Scanner(System.in);
							System.out.println("\nChoose a vendor");
							int vendorId = sc.nextInt();
							Dishes.viewDishesInVendor(vendorId);
							
							System.out.println("\nChoose dish from this vendor?(Yes/No)");
							String op =sc2.nextLine();
							if(op.equalsIgnoreCase("yes")) {
								vendorChosen = false;
							}
								
						}
					OrderPlace.prepareOrder();
					}
				
		        break;
		      case 4:
		    	  Dishes.sortDishesByPriceInAsc();
		    	  break;
		      case 5:
		    	  Dishes.sortDishesByPriceInDesc();
		    	  break;
		      default:
		        System.err.println ( "Unrecognized option" );
		        break;
		    }
		}
		
		conn.disconnect();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
