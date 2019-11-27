package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {

		int id;
		String navn;
		String dato;
		String tekst;
		String url;
		
		Blogg innleggTab = new Blogg();
		
		try {	
		Scanner leser = new Scanner(filnavn);
		
		int antInnlegg = Integer.parseInt(leser.nextLine());
		innleggTab = new Blogg(antInnlegg);
		
		for (int pos = 0; pos < antInnlegg; pos++) {
			if (leser.nextLine().contains(TEKST)) {
				id = leser.nextInt();
				navn = leser.nextLine();
				dato = leser.nextLine();
				tekst = leser.nextLine();
				
				Tekst txtInnlegg = new Tekst(id, navn, dato, tekst);
				innleggTab.leggTil(txtInnlegg);
				
			} if (leser.nextLine().contains(BILDE)) {
				id = leser.nextInt();
				navn = leser.nextLine();
				dato = leser.nextLine();
				tekst = leser.nextLine();
				url = leser.nextLine();
				
				Bilde urlInnlegg = new Bilde(id, navn, dato, tekst, url);
				innleggTab.leggTil(urlInnlegg);
			}
			
		}
		
		
		} catch (NumberFormatException e) {
			System.out.println("Ugyldig tallverdi");
		}
		return innleggTab;
		}

}

