/**
 * 
 */
package com.onlinefood.resteasy;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.DataOutput;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.fasterxml.jackson.core.io.DataOutputAsStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinefood.resteasy.models.User;

/**
 * @author prateetidebchaudhuri
 *
 */
public class LoginRestEasy {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginPage login = new LoginPage();
		try {
			System.out.println("\n\n Welcome to RESTEASY Online Application \b\n\n");
			System.out.println("\nPlease login to continue \n");
			
			login.login();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
