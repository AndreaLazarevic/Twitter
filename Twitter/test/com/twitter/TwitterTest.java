/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruka.TwitterPoruka;

/**
 * @author Korisnik
 *
 */
public class TwitterTest {
	private Twitter t;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		TwitterPoruka tp = new TwitterPoruka();
		
		tp.setKorisnik("raspevana");
		tp.setPoruka("Pomaze Raspy.");
		
		t.unesi(tp.getKorisnik(), tp.getPoruka());;
				
		assertEquals("raspevana", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Pomaze Raspy.", t.vratiSvePoruke().getLast().getPoruka());
		
		
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		TwitterPoruka tp = new TwitterPoruka();
		
		tp.setKorisnik("raspevana");
		tp.setPoruka("Pomaze Raspy");
		
		t.unesi(tp.getKorisnik(), tp.getPoruka());;
				
		assertEquals("raspevana", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Pomaze Raspy", t.vratiSvePoruke().getLast().getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		TwitterPoruka tp = new TwitterPoruka();
		
		tp.setKorisnik("raspevana");
		tp.setPoruka("Pomaze Raspy");
		
		t.unesi(tp.getKorisnik(), tp.getPoruka());
		
		assertEquals(tp,t.vratiPoruke(1, "Raspy")[0]);	
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		t.vratiPoruke(100, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanTag() {
		t.vratiPoruke(100, "");
	}
	
	@Test
	public void testVratiPorukeMaxBrNula() {
		assertEquals(t.vratiPoruke(0, "por").length, 100);
		
	}
	
	@Test
	public void testVratiPorukePrekoracenMaxBr() {
		TwitterPoruka tp1 = new TwitterPoruka();
	 	tp1.setKorisnik("raspevana");
	 	tp1.setPoruka("Cao cao");
		 	
	 	TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("disfunkcionalna");
	 	tp2.setPoruka("Cao");
		 	
	 	t.unesi(tp1.getKorisnik(), tp1.getPoruka());
	 	t.unesi(tp2.getKorisnik(), tp2.getPoruka());
		 	
	 	assertEquals(tp1, t.vratiPoruke(1, "Cao")[0]);
	}
}
