package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	
	protected Innlegg innleggstabell[];
	protected int nesteledige;
	

	public Blogg() {
		
		this.innleggstabell = new Innlegg[20];
		this.nesteledige = 0;
		
	}

	public Blogg(int lengde) {
		
		this.innleggstabell = new Innlegg[lengde];
		this.nesteledige = 0;
		
	}

	public int getAntall() {
		
		return nesteledige;
		
	}
	
	public Innlegg[] getSamling() {
		
		return innleggstabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) { //evt skriv om

		int finnes = -1;
		int pos = 0;
		
		while (pos < nesteledige && finnes == -1) {
			
			if (innleggstabell[pos].erLik(innlegg)) {
				finnes = pos;
			}
		
			pos++;	
		}
		return finnes;
		

	}

	public boolean finnes(Innlegg innlegg) {
		
		boolean finnes = false;
		
		int pos = 0;
		while (pos < nesteledige && !finnes) {
			if (innleggstabell[pos].erLik(innlegg)) {
				finnes = true;
			}
			pos++;	
		}
		return finnes;
		
	}

	public boolean ledigPlass() {
		
		boolean ledig = false;
		
		if (nesteledige < innleggstabell.length) {
			ledig = true;
		}
		return ledig;

	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		boolean lagtTil = false;
		
		if (!finnes(innlegg)) {
			innleggstabell[nesteledige] = innlegg;
			nesteledige++;
			lagtTil = true;
		}
		
		return lagtTil;

	}
	
	public String toString() {
		
		String bloggString = nesteledige + "\n";
		
		for (int pos = 0; pos < nesteledige; pos++) {
			bloggString += innleggstabell[pos].toString();
		}
		
		return bloggString;
		
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		Innlegg[] dobbelTabell = new Innlegg[innleggstabell.length*2];
		
		for (int pos = 0; pos < nesteledige; pos++) {
			dobbelTabell[pos] = innleggstabell[pos];
		}
		
		innleggstabell = dobbelTabell;
		
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		
		
		if (!leggTil(innlegg)) {
			utvid();
		}
		
		leggTil(innlegg);
		
		return true;
		
	}

	
	public boolean slett(Innlegg innlegg) {
		
		int pos = finnInnlegg(innlegg);
		if (pos >= 0) {
			nesteledige--;
			innleggstabell[pos] = innleggstabell[nesteledige];
			innleggstabell[nesteledige] = null;
			return true;
		} else {
			return false;
		}
		
	}
	
	public int[] search(String keyword) {
		
		int[] idMedOrd = new int[nesteledige];
		int idPos = 0;
		
		for (int pos = 0; pos < nesteledige; pos++) {
			if (innleggstabell[pos].toString().contains(keyword));
				idMedOrd[idPos] = innleggstabell[pos].getId();
				idPos++;
		}
		return idMedOrd;
	}
}