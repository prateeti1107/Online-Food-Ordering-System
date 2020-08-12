package com.onlinefood.resteasy.utils;

public class URLUtils {
	public static final String baseURL = "http://localhost:8080/";

	public static class LoginURLS {
		public static final String loginURL = baseURL + "login/get-user";
		public static final String getUserByIDURL = baseURL + "login/getUserById/";
			
	}
	
	public static class DishURLS {
		public static final String getAllDishesURL = baseURL + "dish/getAllDishes";
		public static final String searchByDishNameURL = baseURL + "dish/searchByDishName/";
		public static final String searchDishesByVendor = baseURL + "/dish/searchDishesByVendor/";
		public static final String sortDishesAscURL = baseURL + "/dish/sortDishesAsc";
		public static final String sortDishesDescURL = baseURL + "/dish/sortDishesDesc";
	}
	
	public static class VendorURLS {
		public static final String getAllVendorsURL = baseURL + "vendor/getAllVendors";
	}
	
	public static class OrderURLS {
		
		public static final String placeOrderURL = baseURL + "order/order-place";
		public static final String getOrderByIDURL = baseURL + "getOrder/";
		public static final String getAllOrdersURLByAdmin = baseURL + "getAllOrders/";
		
	}
	
	
	
	
}
