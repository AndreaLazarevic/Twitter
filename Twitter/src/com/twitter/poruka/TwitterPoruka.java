package com.twitter.poruka;

/**
 * Klasa koja predstavlja twitter poruku
 * @author Andrea Lazarevic
 *
 */
public class TwitterPoruka {
	/**
	 * nickname twitter korisnika
	 */
	private String korisnik;
	
	/**
	 * sadrzaj poruke koju salje korisnik
	 */
	private String poruka; 
	
	/**
	 * Vraca vrednost atributa korisnik.
	 * @return korisnik kao String
	 */
	public String getKorisnik() { 
		return korisnik; 
	} 
	
	/**
	 * Postavlja novu vrednost za atribut korisnik.
	 * @param korisnik novi nickname korisnika
	 * @throws java.lang.RuntimeException ako je uneo nickname korisnika:
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) { 
		if(korisnik	== null || korisnik.isEmpty()) 
			throw new RuntimeException("Ime korisnika mora biti uneto"); 
		this.korisnik =	korisnik; 
	} 
	
	/**
	 * Vraca vrednost atributa poruka.
	 * @return poruka kao String
	 */
	public String getPoruka() { 
		return poruka; 
	} 
	
	/**
	 * Postavlja novu vrednost za atribut poruka.
	 * @param poruka novi sadrzaj poruke za slanje
	 * @throws java.lang.RuntimeException ako je uneo poruku:
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * <li>poruka duza od 140 karaktera</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) { 
		if(poruka == null || poruka == "" || poruka.length()>140) 
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova"); 
		this.poruka = poruka; 
	} 
	
	/**
	 * Vraca String sa svim podacima twitter poruke.
	 * @return Nickname korisnika i sadrzaj poruke koja se salje.
	 */
	public String toString(){ 
		return "KORISNIK:" + korisnik +	" PORUKA:" + poruka; 
	}
	
}
