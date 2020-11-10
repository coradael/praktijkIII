//package com.praktijk3.model;
//
//import java.util.Locale;
//
//public class countryListDemo {
//
//	public static void main(String[] args) {
//
//		// Using Locale class static method getISOCountries()
//		// we extract a list of all 2-letter country codes 
//		// defined in ISO 3166. Can be used to create Locales.
//		
//		String[] countries = Locale.getISOCountries();
//		
//		// Loop each country 
//		for(int i = 0; i < countries.length; i++) { 
//			
//			String country = countries[i];
//			Locale locale = new Locale("en", country);
//         
//			// Get the country name by calling getDisplayCountry()
//			String countryName = locale.getDisplayCountry();
//         
//			// Printing the country name on the console
//         System.out.println(i+1 + " : " + countryName);
//			
//		}		
//				
//	}
//
//}
