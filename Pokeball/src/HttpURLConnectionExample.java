import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpURLConnectionExample http = new HttpURLConnectionExample();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
		
		//System.out.println("\nTesting 2 - Send Http POST request");
		//http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://pokeapi.co/api/v2/pokemon/1";
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		String cvsSplitBy = ",";

		while ((inputLine = in.readLine()) != null) {
			String[] mons = inputLine.split(cvsSplitBy);
			System.out.println(mons[1]);
		}
		in.close();

		
	

	}


}