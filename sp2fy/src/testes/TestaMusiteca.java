package testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.*;

public class TestaMusiteca {

	private Album bad;
	private Album nightVisions;
	private Album uptownSpecial;
	private Album bad25Anniversary;

	private Musica demons;
	private Musica radioactive;
	private Musica badM;
	private Musica uptownFunk;
	private Musica manInTheMirror;
	private Musica smoothCriminal;
	private Musiteca musiteca;

	@Before
	public void setUp() {
		try {
			bad = new Album("Bad", "Michael Jackson", 1987);
			nightVisions = new Album("Night Visions", "Imagine Dragons", 2012);
			uptownSpecial = new Album("Uptown Special", "Mark Ronson", 2015);
			bad25Anniversary = new Album("Bad", "Michael Jackson", 2012);

			demons = new Musica("Demons", 4, "Indie");
			radioactive = new Musica("Radioactive", 5, "Rock Alternativo");
			uptownFunk = new Musica("Uptown Funk", 4, "Funk");
			manInTheMirror = new Musica("Man In The Mirror", 3, "Pop");
			smoothCriminal = new Musica("Smooth Criminal", 3, "Pop");
			badM = new Musica("Bad", 2, "Pop");

			musiteca = new Musiteca();

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testAdicionaFavorito() {
		try {
			musiteca.adicionaAlbum(bad);
			assertEquals(false, bad.isFavorito());

			musiteca.adicionaFavorito(bad);
			assertEquals(true, bad.isFavorito());

		} catch (Exception e) {
			fail();
		}

		try {
			musiteca.adicionaFavorito(null);
			fail();
		} catch (Exception e) {
			assertEquals("Nao pode adicionar album nulo aos favoritos",
					e.getMessage());
		}

	}

	@Test
	public void testadicionaAlbum() {
		try {
			assertEquals(true, musiteca.adicionaAlbum(bad25Anniversary));
		} catch (Exception e) {
			fail();
		}

		try {
			musiteca.adicionaAlbum(null);
		} catch (Exception e) {
			assertEquals("Nao pode adicionar album nulo", e.getMessage());
		}
	}

	@Test
	public void testContemAlbum() {
		try {
			assertEquals(false, musiteca.contemAlbum(uptownSpecial));
			musiteca.adicionaAlbum(uptownSpecial);
			assertEquals(true, musiteca.contemAlbum(uptownSpecial));
		} catch (Exception e) {
			fail();
		}

		try {
			musiteca.contemAlbum(null);
		} catch (Exception e) {
			assertEquals("Nao pode procurar album nulo", e.getMessage());
		}
	}

	@Test
	public void testRemoveAlbum() {
		try {
			assertEquals(false, musiteca.removeAlbum(bad));
			musiteca.adicionaAlbum(bad);
			assertEquals(true, musiteca.removeAlbum(bad));
		} catch (Exception e) {
			fail();
		}

		try {
			musiteca.removeAlbum(null);
		} catch (Exception e) {
			assertEquals("Nao pode remover album nulo", e.getMessage());
		}
	}

	@Test
	public void testAdicionaPlaylist() {
		try {
			nightVisions.adicionaMusica(demons);
			musiteca.adicionaAlbum(nightVisions);

			assertEquals(true, musiteca.adicionaPlaylist("Fazendo lab",
					"Night Visions", 1));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testOrdenaAlbuns() {
		try {
			bad.adicionaMusica(badM);
			nightVisions.adicionaMusica(demons);
			bad.adicionaMusica(manInTheMirror);
			bad.adicionaMusica(smoothCriminal);
			uptownSpecial.adicionaMusica(uptownFunk);
			nightVisions.adicionaMusica(radioactive);

			musiteca.adicionaAlbum(uptownSpecial);
			musiteca.adicionaAlbum(nightVisions);
			musiteca.adicionaAlbum(bad);

			musiteca.ordenaAlbunsPorAno();

			Assert.assertEquals(bad, musiteca.getAlbuns().get(0));
			Assert.assertEquals(nightVisions, musiteca.getAlbuns().get(1));
			Assert.assertEquals(uptownSpecial, musiteca.getAlbuns().get(2));

			musiteca.ordenaAlbunsPorDuracao();

			Assert.assertEquals(uptownSpecial, musiteca.getAlbuns().get(0));
			Assert.assertEquals(bad, musiteca.getAlbuns().get(1));
			Assert.assertEquals(nightVisions, musiteca.getAlbuns().get(2));

			musiteca.ordenaAlbunsPorQuantidade();

			Assert.assertEquals(uptownSpecial, musiteca.getAlbuns().get(0));
			Assert.assertEquals(nightVisions, musiteca.getAlbuns().get(1));
			Assert.assertEquals(bad, musiteca.getAlbuns().get(2));

		} catch (Exception e) {
			Assert.fail();
		}

	}
}