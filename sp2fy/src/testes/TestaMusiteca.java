package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.Album;
import classes.Musica;
import classes.Musiteca;

public class TestaMusiteca {
	
	private Musica colors;
	private Musica youngAgain;
	private Musica loversOnTheSun;
	private Musica feelSoClose;
	private Musica weFoundLove;
	private Musica iNeedYourLove;

	private Album unitedWeAre;
	private Album listen;
	private Album eighteenMonths;
	
	private Musiteca musiteca;

	@Before
	public void setUp(){
		try {
			colors = new Musica("Colors", 4, "EDM");
			youngAgain = new Musica("Young Again", 5, "EDM");
			loversOnTheSun = new Musica("Lovers On The Sun", 3, "EDM");
			feelSoClose = new Musica("Feel So Close", 3, "Dance Pop");
			weFoundLove = new Musica("We Found Love", 3, "Dance Pop");
			iNeedYourLove = new Musica("I Need Your Love", 3, "Dance Pop");

			unitedWeAre = new Album("United We Are", "Hardwell", 2015);
			listen = new Album("Listen", "David Guetta", 2014);
			eighteenMonths = new Album("18 Months", "Calvin Harris", 2012);
			
			musiteca = new Musiteca();
			
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testAdicionaAlbum() {
		try {
			musiteca.adicionaAlbum(eighteenMonths);
			assertEquals(1, musiteca.getAlbuns().size());
			
			musiteca.adicionaAlbum(null);
			
		} catch (Exception e) {
			assertEquals("Nao pode adicionar album nulo", e.getMessage());
		}
	}

}
