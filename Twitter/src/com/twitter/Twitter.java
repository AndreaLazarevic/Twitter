package com.twitter;
import java.util.LinkedList; 

import com.twitter.poruka.TwitterPoruka;

/**
 * Klasa Twitter u kojoj su implementirane metode za rad sa twitter porukama
 * @author Andrea Lazarevic
 *
 */
public class Twitter { 
	/**
	 * lista objekata klase TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>(); 
	
	/**
	 * Vraca sve poruke koje se nalaze u listi.
	 * @return listu poruke
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * Unosi poruku na kraj liste
	 * @param korisnik nickname twitter korisnika
	 * @param poruka sadrzaj poruke koju salje korisnik
	 */
	public void unesi(String korisnik, String poruka) { 
		//Pravi se nova poruka i puni podacima
		TwitterPoruka tp = new TwitterPoruka(); 

		tp.setKorisnik(korisnik); 
		tp.setPoruka(poruka); 
		
		//Poruka se unosi u listu na kraj 
		poruke.addLast(tp); 
	} 
	
	/**
	 * Pronalazi i vraca poruke koje sadrze zadati tag u vidu niza objekata TwitterPoruka
	 * @param maxBroj maksimalan broj poruka koji se moze upisati u niz
	 * @param tag zadati tag
	 * 
	 * @throws java.lang.RuntimeException ako je unet tag koji je: 
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 * 
	 * @return rezultat u vidu niza objekata TwitterPoruka
	 * 
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) { 
		if(tag == null || tag.isEmpty()) 
			throw new RuntimeException("Morate uneti tag");
		
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka 
		if(maxBroj <= 0) maxBroj = 100;
		
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka 
		int brojac = 0; 

		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj]; 

		//Pretrazuju se poruke i traze se one koje sadrze tag. 
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj, pretraga
		//se prekida. 
		for(int i = 0; i < poruke.size(); i++) 
			if(poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if(brojac < maxBroj){ 
					rezultat[brojac]=poruke.get(i);
					brojac++; 
				} 
				else
					break; 
		return rezultat;
	} 
} 

