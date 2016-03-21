package poke;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpURLConnectionExample http = new HttpURLConnectionExample();
		String startingUrl = "http://pokeapi.co/api/v2/pokemon/";
		System.out.println("Testing 1 - Send Http GET request");
		for(int i = 1; i < 152; i++){
		System.out.println("Dex No: " + i);
		http.sendGet(startingUrl + i);
		}
		
		//System.out.println("\nTesting 2 - Send Http POST request");
		//http.sendPost();

	}

	// HTTP GET request
	public Pokemon sendGet(String startingUrl) throws Exception {

		String url = startingUrl;
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		//int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		//StringBuffer response = new StringBuffer();
		
		String cvsSplitBy = ",";
		String mons[] = null;
		while ((inputLine = in.readLine()) != null) {
			mons = inputLine.split(cvsSplitBy);
			
		}
		in.close();
		String name = mons[1].substring(7);
		String spriteUrl = "";
		for(int i=0; i<mons.length; i++){
			
			if(mons[i].substring(1, 6).equals("front")){
				if(mons[i].substring(7, 14).equals("default")){
				spriteUrl = mons[i].substring(16);
				}
			}
			
		}
		int length = mons.length - 2;
		String type1 = mons[length].substring(15);
		String type2 = mons[length - 3].substring(15);
		
		//BufferedImage sprite = null;
		//try{
			//sprite = ImageIO.read(new URL(mons[length - 28]))
		//}
				
		String n = name.replace("\"", ""); 
		String t1 = type1.replace("\"", "");
		String t2 = type2.replace("\"", "");
		String sUrl = spriteUrl.replace("\"", "");
		String hp = "hp";
		

		//System.out.println(n);
		//System.out.println(t1);
		if(t2.equals(hp)) t2 = "none";
		//System.out.println(t2);
		//System.out.println(sUrl);
		
		Pokemon mon = new Pokemon(n, t1, t2, sUrl);
		return mon;
	

	}


}