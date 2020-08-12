package com.onlinefood.resteasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinefood.resteasy.models.OrderDTO;
import com.onlinefood.resteasy.utils.URLUtils;

public class OrderPlace {
	
	private static OrderDTO chooseOrder() {
		Scanner scanner = new Scanner(System.in);
		OrderDTO orderDto = new OrderDTO();
		
		System.out.println("Enter dish:");
		orderDto.setInputDish(scanner.nextLine());
		
		System.out.println("Enter quantity");
		orderDto.setQuantity(scanner.nextInt());
		
		return orderDto;
		
	}
	
	public static void prepareOrder() {
		Scanner sc = new Scanner(System.in);
		boolean choice = true;
		List<OrderDTO> orderDtos = new ArrayList<OrderDTO>();
		while(choice==true) {
			Scanner scanner = new Scanner(System.in);
			
			OrderDTO orderDto = chooseOrder();
			
			orderDtos.add(orderDto);
			
			System.out.println("Choose another item?(Yes/No)");
			
			String option = scanner.nextLine();
			
			if(option.equalsIgnoreCase("No")) {
				choice = false;
				System.out.println("in here");
			} else {
				System.out.println("in here else"+option);
			}
		}
		placeOrder(orderDtos);
	}

	public static void placeOrder(List<OrderDTO> orderDtos) {
		System.out.println("Placing order...");
		
		try {
		URL url = new URL(URLUtils.OrderURLS.placeOrderURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
//		OrderDTO orderDto = new OrderDTO();
//		orderDto.setInputDish(inputDish);
//		orderDto.setQuantity(quantity);
//		orderDto.setUsername(username);
		
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		String input = mapper.writeValueAsString(orderDtos);
		
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		
		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
				
		String output;
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		
		conn.disconnect();
		//System.exit(0);
		
		}catch(Exception e) {
			
		}
	}
}
