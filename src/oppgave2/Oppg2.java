package oppgave2;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Beregning{
	int beregn(Ansatt a);
}

public class Oppg2 {
	
	public static void main(String[] args) {

		List<Ansatt> ansatte = Arrays.asList(
			new Ansatt("Charles", "Dickens", Kjonn.MANN, "Janitor", 500000),
			new Ansatt("Lewis", "Carroll", Kjonn.MANN, "Engineer", 7500000),
			new Ansatt("Thomas", "Carlyle", Kjonn.MANN, "Stylist", 450000),
			new Ansatt("Charlotte", "Bronte", Kjonn.DAME, "Lawyer", 1000000),
			new Ansatt("Matthew", "Arnold", Kjonn.MANN, "Proffesional friend", 600000));
		
		//Definerer variabler for prosent og kronetillegg
		int kroneTillegg = 20000;
		int prosentTillegg = 15; //Gitt ved prosentpoeng
		
		//i
		System.out.println("------Et fast kronetillegg------");
		lonnsoppgjor(ansatte, a -> a.setAarslonn(a.getAarslonn() + kroneTillegg));
		
		
		skrivUtAlle(ansatte);
		
		
		
		//ii
		System.out.println("------Et fast prosenttillegg------");
		//TODO
		
		
		skrivUtAlle(ansatte);
						
		
		
		//iii
		System.out.println("------Et fast kronetillegg hvis du har lav lønn------");
		//TODO
		
		
		skrivUtAlle(ansatte);

		
		
		//iv
		System.out.println("------Et fast prosenttillegg hvis du er mann------");
		//TODO
		
		
		skrivUtAlle(ansatte);
		
		
	}
	
	//lonnsoppgjor(...) skal beregne lønnsøkning til de ansatte 
	private static Beregning lonnsoppgjor(List<Ansatt> ansatte, Beregning b) {
		ansatte.forEach(a -> b.beregn(a));
	}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		ansatte.forEach(a -> System.out.println(a.toString()));
	}
	
//	public static int funksjon(int x, int y, Beregning b) {
//		return b.beregn(x, y);
//	}

}
