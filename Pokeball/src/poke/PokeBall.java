package poke;

import java.util.Hashtable;

public class PokeBall {
	public static void main(String[] args) throws Exception {
		Hashtable<Integer, Pokemon> pt = new Hashtable<Integer, Pokemon>();
		
		HttpURLConnectionExample http = new HttpURLConnectionExample();
		String startingUrl = "http://pokeapi.co/api/v2/pokemon/";
		
		for(int i = 1; i < 152; i++){
		pt.put(i, http.sendGet(startingUrl + i));
		}
		System.out.println(pt.get(1).name);
	}
}
