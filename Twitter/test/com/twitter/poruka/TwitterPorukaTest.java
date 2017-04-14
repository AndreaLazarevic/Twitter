/**
 * 
 */
package com.twitter.poruka;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Korisnik
 *
 */
public class TwitterPorukaTest {
	private TwitterPoruka tp;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		tp.setKorisnik("raspevana");
		
		assertEquals("raspevana", tp.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("");
	}
	
	

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		tp.setPoruka("Pomaze Raspy");
		
		assertEquals("Pomaze Raspy", tp.getPoruka());	
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString() {
		tp.setPoruka("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzinaVanOpsega() {
		tp.setPoruka("RecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenicaRecenica");
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		tp.setKorisnik("raspevana");
		tp.setPoruka("Pomaze Raspy");
			
		assertEquals("KORISNIK:raspevana PORUKA:Pomaze Raspy", tp.toString());	
	}

}
