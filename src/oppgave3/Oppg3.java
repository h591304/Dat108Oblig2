package oppgave3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import oppgave3.Ansatt;
import oppgave3.Kjonn;

public class Oppg3 {

	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Charles", "Dickens", Kjonn.MANN, "Janitor", 500000),
				new Ansatt("Lewis", "Carroll", Kjonn.MANN, "Engineer", 750000),
				new Ansatt("Thomas", "Carlyle", Kjonn.MANN, "Stylistboss", 450000),
				new Ansatt("Charlotte", "Bronte", Kjonn.DAME, "Lawyer", 1000000),
				new Ansatt("Matthew", "Arnold", Kjonn.MANN, "Proffesional friend", 600000),
				new Ansatt("Leah", "Smith", Kjonn.DAME, "Psychologistboss", 800000));
		
		//a) - Lager en liste som kun inneholder etternavnene til de ansatte
		List<String> etternavnTilAnsatte = ansatte.stream()
				.map(Ansatt::getEtternavn)
				.collect(Collectors.toList());
		System.out.println("Liste med etternavn: " + etternavnTilAnsatte);
		
		//b) - Antall kvinner blandt de ansatte
		long antKvinner = ansatte.stream()
				.filter(k -> k.getKjonn() == Kjonn.DAME)
				.count();
		System.out.println("Antall kvinner: " + antKvinner);
		
		//c) - Gjennomsnittslønnen til kvinnene
		double snittLonn = ansatte.stream()
				.filter(k -> k.getKjonn() == Kjonn.DAME)
				.collect(Collectors.averagingDouble(Ansatt::getAarslonn));
		System.out.println("Gjennomsnittlønnen til kvinnene: " + snittLonn + "\n");
		
		//d) - Alle sjefer får lønnsøkning på 7%
		double lonnsOkning = 1.07; //prosentøkningen aka 7%
		ansatte.stream()
			.filter(s -> s.getStilling().toLowerCase().contains("boss"))
			.forEach(s -> s.setAarslonn((s.getAarslonn() * lonnsOkning)));
		
		System.out.println("-----Sjefer med 7% lønnsøkning-----");
		System.out.println(ansatte.toString());
		System.out.println("\n");
		
		//e) - Oppgi sannshetsverdi om noen tjener mer enn 800,000kr
		boolean merEnn800000 = ansatte.stream()
				.anyMatch(a -> a.getAarslonn() > 800000);
		System.out.println(merEnn800000 + ", der er ansatte som tjener mer enn 800,000kr!");
		
		//f) - Skriver ut alle ansatte med System.out.println uten løkke
		ansatte.stream().forEach(System.out::println);
		
		//g) - Finner ansatte med lavest lønn
		//Definerer lavest lønn
		double lavestLonn = ansatte.stream()
				.min(Comparator.comparing(Ansatt::getAarslonn))
				.map(a -> a.getAarslonn())
				.orElse((double) -1);
		
		//Identifiserer de(n) ansatte med lavest lønn
		List<Ansatt> fattigAnsatt = ansatte.stream()
				.filter(a -> a.getAarslonn() == lavestLonn)
				.collect(Collectors.toList());
		
		System.out.println("Den fattigste ansatte er: " + fattigAnsatt);
		
		//h - Finner summen av alle heltall i [1, 1000> som er delelig med 3 eller 5
		System.out.println("\nTall delelig med 3: ");
		
		IntStream.range(1, 1000)
			.filter(x -> x % 3 == 0)
			.forEach(System.out::println);
		
		System.out.println("Tall delelig med 5: ");
		
		IntStream.range(1, 1000)
		.filter(x -> x % 5 == 0)
		.forEach(System.out::println);
		
	}
}
