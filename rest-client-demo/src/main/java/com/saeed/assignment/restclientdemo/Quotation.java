package com.saeed.assignment.restclientdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Component;

@Component("Quotation")
public class Quotation {

	public static void main(String[] args) {
		try {
			// your REST url
			String urlStr = "http://localhost:8080/books";
			String jsonStr = getBooksJSON(urlStr);
			System.out.println(jsonStr);
			
			// your REST url
			urlStr = "http://localhost:8080/book/4";
			jsonStr = getBooksJSON(urlStr);
			System.out.println(jsonStr);
	
		} catch (Exception e) {
			System.out.println("Exception in Quatation: " + e);
		}
	}

	
	public static String getBooksJSON(String urlStr) {
		String output = null;
		try {
		
			URL url = new URL(urlStr);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			output = br.readLine();
			conn.disconnect();

		} catch (Exception e) {
			System.out.println("Exception in getBooksJSON: " + e);
		}
		return output;
	}

}