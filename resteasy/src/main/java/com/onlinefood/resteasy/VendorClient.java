package com.onlinefood.resteasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.onlinefood.resteasy.utils.URLUtils;

public class VendorClient {

	public static void getAllvendors() {
		System.out.println("Below are the available vendors");
		try {
			
			URL url = new URL(URLUtils.VendorURLS.getAllVendorsURL);
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
				
			conn.disconnect();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
