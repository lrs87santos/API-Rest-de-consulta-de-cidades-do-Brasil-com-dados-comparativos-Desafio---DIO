package com.santos.leonardo.CitiesAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;

public class MyClass {
	public static void main(String[] args) throws Exception {
		try {
			URL url = new URL("https://parseapi.back4app.com/classes/City?count=1&limit=0");
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestProperty("X-Parse-Application-Id", "QiGq93pW2KO3xAHlLNFoJjg1kM3qYMhiLEtTPwYq"); // Este é o ID do aplicativo falso
			urlConnection.setRequestProperty("X-Parse-Master-Key", "gv6cOhHXeNwNWzDsObRXEe67BwpVhddUIVwVPR5C"); // Esta é a chave mestra somente leitura do aplicativo
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				StringBuilder stringBuilder = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					stringBuilder.append(line);
				}
				JSONObject data = new JSONObject(stringBuilder.toString()); // Aqui você tem os dados de que precisa
				System.out.println(data.toString(2));
			} finally {
				urlConnection.disconnect();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
}

