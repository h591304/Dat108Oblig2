package oppgave1;

@FunctionalInterface
interface Funksjon{
	int funksjon(int x, int y);
}

public class Oppg1b {

	public static void main(String[] args) {
		
		int sum =  beregn(12, 13, (x,y) -> x+y);
		/**
		 * ii) alternativ for "?"
		 * for(x > y) {
		 * 		storste = x;
		 * } else {
		 * 		sorste = y;
		 * }
		 */
		int storste = beregn(-5, 3, (x,y) -> (x > y) ? x:y);
		int differanse = beregn(54, 45, (x,y) -> x-y);
		
		//i
		System.out.println("Summen av 12 og 13, er: " + sum);	
		//ii
		System.out.println("Den strøste av -5 og 3, er: " + storste);	
		//iii
		System.out.println("Avstanden mellom 54 og 45, er: " + differanse);
	}
	
	public static int beregn(int x, int y, Funksjon f) {
		return f.funksjon(x, y);
	}

}
