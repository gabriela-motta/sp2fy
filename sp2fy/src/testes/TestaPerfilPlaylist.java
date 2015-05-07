package testes;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.*;

public class TestaPerfilPlaylist {

	private Musica colors;
	private Musica youngAgain;
	private Musica loversOnTheSun;
	private Musica feelSoClose;
	private Musica weFoundLove;
	private Musica iNeedYourLove;

	private Album unitedWeAre;
	private Album listen;
	private Album eighteenMonths;

	private Playlist paraRelaxar;
	private Playlist nomeInvalido;

	private Perfil gabriela;

	@Before
	public void setUp() {
		try {
			gabriela = new Perfil("Gabriela");

			paraRelaxar = new Playlist("Para Relaxar");

			colors = new Musica("Colors", 4, "EDM");
			youngAgain = new Musica("Young Again", 5, "EDM");
			loversOnTheSun = new Musica("Lovers On The Sun", 3, "EDM");
			feelSoClose = new Musica("Feel So Close", 3, "Dance Pop");
			weFoundLove = new Musica("We Found Love", 3, "Dance Pop");
			iNeedYourLove = new Musica("I Need Your Love", 3, "Dance Pop");

			unitedWeAre = new Album("United We Are", "Hardwell", 2015);
			listen = new Album("Listen", "David Guetta", 2014);
			eighteenMonths = new Album("18 Months", "Calvin Harris", 2012);

		} catch (Exception e) {
			Assert.fail();
		}

	}

	@Test
	public void testPlaylist() {
		try {
			Assert.assertEquals("Para Relaxar", paraRelaxar.getNome());
			Assert.assertEquals(0, paraRelaxar.getMusicas().size());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testPlaylistInvalida() {
		try {
			nomeInvalido = new Playlist("");
			Assert.fail("Esperava excecao de nome vazio");

		} catch (Exception e) {
			Assert.assertEquals("Nome da playlist nao pode ser vazio.",
					e.getMessage());
		}
	}

	/*
	 * @Test public void testAdicionaPlaylist(){ try{
	 * unitedWeAre.adicionaMusica(youngAgain);
	 * unitedWeAre.adicionaMusica(colors);
	 * listen.adicionaMusica(loversOnTheSun);
	 * 
	 * gabriela.adicionaAlbum(listen); gabriela.adicionaAosFavoritos(listen);
	 * 
	 * gabriela.adicionaPlaylist("Tomorrowland Brasil", "United We Are", 2);
	 * Assert.assertEquals(1, gabriela.getPlaylists().size());
	 * 
	 * } catch (Exception e){ Assert.fail(); } }
	 */

	@Test
	public void testOrdenaAlbuns() {
		try {
			listen.adicionaMusica(loversOnTheSun);
			eighteenMonths.adicionaMusica(feelSoClose);
			eighteenMonths.adicionaMusica(weFoundLove);
			eighteenMonths.adicionaMusica(iNeedYourLove);
			unitedWeAre.adicionaMusica(youngAgain);
			unitedWeAre.adicionaMusica(colors);

			gabriela.adicionaAlbum(listen);
			gabriela.adicionaAlbum(eighteenMonths);
			gabriela.adicionaAlbum(unitedWeAre);

			gabriela.ordenaAlbunsPorAno();

			Assert.assertEquals(eighteenMonths, gabriela.getAlbuns().get(0));
			Assert.assertEquals(listen, gabriela.getAlbuns().get(1));
			Assert.assertEquals(unitedWeAre, gabriela.getAlbuns().get(2));

			gabriela.ordenaAlbunsPorDuracao();

			Assert.assertEquals(listen, gabriela.getAlbuns().get(0));
			Assert.assertEquals(eighteenMonths, gabriela.getAlbuns().get(1));
			Assert.assertEquals(unitedWeAre, gabriela.getAlbuns().get(2));

			gabriela.ordenaAlbunsPorQuantidade();

			Assert.assertEquals(listen, gabriela.getAlbuns().get(0));
			Assert.assertEquals(unitedWeAre, gabriela.getAlbuns().get(1));
			Assert.assertEquals(eighteenMonths, gabriela.getAlbuns().get(2));
			
		} catch (Exception e) {
			Assert.fail();
		}

	}
}
