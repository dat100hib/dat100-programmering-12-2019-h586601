package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab12.oppgave3.*;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn)  {
		
		boolean ok = false;
	
		try {
		PrintWriter skriver = new PrintWriter(MAPPE + filnavn);
				
		skriver.print(samling.toString());
				
		skriver.close();
		
		ok = true;
		
		} catch (FileNotFoundException e) {
			System.out.println("Finner ikke filen, sjekk gjerne om du har skrevet riktig");
		}
		
		return ok;
	}
}

