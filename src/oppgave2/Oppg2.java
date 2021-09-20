package oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {
	
	public static void main(String[] args) {

		List<Ansatt> ansatte = Arrays.asList(
			new Ansatt("Charles", "Dickens", Kjonn.MANN, "Janitor", 350000),
			new Ansatt("Lewis", "Carroll", Kjonn.MANN, "Engineer", 750000),
			new Ansatt("Thomas", "Carlyle", Kjonn.MANN, "Stylist", 400000),
			new Ansatt("Charlotte", "Bronte", Kjonn.DAME, "Lawyer", 1000000),
			new Ansatt("Matthew", "Arnold", Kjonn.MANN, "Proffesional friend", 600000));
		
		//Definerer variabler for prosent og kronetillegg
		int kroneTillegg = 15000;
		double prosentTillegg = 1.10; //Gitt ved prosentfaktor
		int lavLonn = 400000; //Antar at lav lønn er <400k
		
		//i
		System.out.println("------Et fast kronetillegg------");
		Function<Ansatt, Integer> fastKrone = (a -> a.getAarslonn() + kroneTillegg);
		lonnsOppgjor(ansatte, fastKrone);
		
		skrivUtAlle(ansatte);
		System.out.println("\n");
		
		//ii
		System.out.println("------Et fast prosenttillegg------");
		Function<Ansatt, Integer> fastProsent = (a -> ((int)(a.getAarslonn() * prosentTillegg)));
		lonnsOppgjor(ansatte, fastProsent);
		
		skrivUtAlle(ansatte);
		System.out.println("\n");
		
		//iii
		System.out.println("------Et fast kronetillegg hvis du har lav lønn------");
		Function<Ansatt, Integer> fastKroneFattig = (a -> {
			if(a.getAarslonn() <= lavLonn) {
				return (a.getAarslonn() + kroneTillegg);
			}
			else {
				return a.getAarslonn();
			}
		});
		lonnsOppgjor(ansatte, fastKroneFattig);
		
		skrivUtAlle(ansatte);
		System.out.println("\n");
		
		//iv
		System.out.println("------Et fast prosenttillegg hvis du er mann------");
		Function<Ansatt, Integer> fastProsentMann = (a -> {
			if(a.getKjonn() == Kjonn.MANN) {
				return ((int)(a.getAarslonn() * prosentTillegg));
			}
			else {
				return a.getAarslonn();
			}
		});
		lonnsOppgjor(ansatte, fastProsentMann);
		
		skrivUtAlle(ansatte);
		
		
	}
	
	//lonnsoppgjor(...) skal beregne lønnsøkning til de ansatte 
	private static void lonnsOppgjor(List<Ansatt> ansatte, Function <Ansatt, Integer> funksjon) {
		ansatte.forEach(a -> a.setAarslonn(funksjon.apply(a)));
	}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		ansatte.forEach(a -> System.out.println(a.toString()));
	}

}
