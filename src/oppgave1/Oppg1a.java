package oppgave1;

import java.util.*;
import static java.lang.Integer.*;

public class Oppg1a {

	public static void main(String[] args) {
		
		List<String> listen = Arrays.asList("10","1","20","110","21","12");
		
		Collections.sort(listen, (a,b) -> compare(parseInt(a), parseInt(b)));
		System.out.println(listen);
	}

}
