package com.onlinefood.resteasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.onlinefood.resteasy.utils.URLUtils;

public class Dishes {


	public static void sortDishesByPriceInAsc() {
		try {
			
			URL url = new URL(URLUtils.DishURLS.sortDishesAscURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");

			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			} 
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
		
			String output;
				System.out.println("Below are the details of the requested Dish .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
				
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void sortDishesByPriceInDesc() {
		try {
			
			URL url = new URL(URLUtils.DishURLS.sortDishesDescURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");

			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			} 
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
		
			String output;
				System.out.println("Below are the details of the requested Dish .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void viewDishesInVendor(int vendorId) {
		try {
			
			
			URL url = new URL(URLUtils.DishURLS.searchDishesByVendor+vendorId);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");

			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			} 
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
		
			String output;
				System.out.println("Below are the details of the requested Dish .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void searchByDishName(String dishName) {
		try {
		URL url = new URL(URLUtils.DishURLS.searchByDishNameURL+dishName);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json");

		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		} 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
	
		String output;
			System.out.println("Below are the details of the requested Dish .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void showAllDishes(String username) {
		System.out.println("Below are the available dishes");
		
		try {
			
			URL url = new URL(URLUtils.DishURLS.getAllDishesURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			} 
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			
			
			
			String output;
			String json = "";
				//System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					json  += output;
					System.out.println(output);
				}
			
			System.out.println("\n1. Choose a dish "
					+ "\n2. Exit");
			
			Scanner sc = new Scanner(System.in);
			boolean choice = true;
			switch(sc.nextInt()) {
				case 1: 
					OrderPlace.prepareOrder();
					break;
			      case 2:
			    	System.exit(0);
			        break;
			      default:
			        System.err.println ( "Unrecognized option" );
			        break;
			}
				

				conn.disconnect();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
