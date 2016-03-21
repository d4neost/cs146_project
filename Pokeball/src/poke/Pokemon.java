package poke;

public class Pokemon {
	public int dexNo;
	public String name;
	public String type1;
	public String type2;
	public String spriteUrl;
	
	Pokemon(String name, String type1, String type2, String spriteUrl){
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.spriteUrl = spriteUrl;
	}
}
