package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.*;

public class TestaAlbum {

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

	@Before
	public void setUp() {
		try {
			bad = new Album("Bad", "Michael Jackson", 1987);
			nightVisions = new Album("Night Visions", "Imagine Dragons", 2012);
			uptownSpecial = new Album("Uptown Special", "Mark Ronson", 2015);
			bad25Anniversary = new Album("Bad", "Michael Jackson", 2012);

			demons = new Musica("Demons", 3, "Indie");
			radioactive = new Musica("Radioactive", 3, "Rock Alternativo");
			uptownFunk = new Musica("Uptown Funk", 4, "Funk");
			manInTheMirror = new Musica("Man In The Mirror", 5, "Pop");
			smoothCriminal = new Musica("Smooth Criminal", 4, "Pop");
			badM = new Musica("Bad", 4, "Pop");

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testAlbum() {
		try {
			Assert.assertEquals("Bad", bad.getNome());
			Assert.assertEquals("Michael Jackson", bad.getArtista());
			Assert.assertEquals(1987, bad.getAnoLancamento());
			Assert.assertEquals("Album: Bad, Michael Jackson, lancado em 1987",
					bad.toString());

			Assert.assertEquals("Night Visions", nightVisions.getNome());
			Assert.assertEquals("Imagine Dragons", nightVisions.getArtista());
			Assert.assertEquals(2012, nightVisions.getAnoLancamento());
			Assert.assertEquals(
					"Album: Night Visions, Imagine Dragons, lancado em 2012",
					nightVisions.toString());

			Assert.assertEquals("Uptown Special", uptownSpecial.getNome());
			Assert.assertEquals("Mark Ronson", uptownSpecial.getArtista());
			Assert.assertEquals(2015, uptownSpecial.getAnoLancamento());
			Assert.assertEquals(
					"Album: Uptown Special, Mark Ronson, lancado em 2015",
					uptownSpecial.toString());

			Assert.assertEquals(bad, bad25Anniversary);
			Assert.assertFalse(bad.equals(uptownSpecial));

			Assert.assertEquals(0, bad25Anniversary.compareTo(nightVisions));
			Assert.assertEquals(1, uptownSpecial.compareTo(bad));
			Assert.assertEquals(-1, nightVisions.compareTo(uptownSpecial));

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testAlbumInvalido() {
		try {
			Album tituloInvalido = new Album("", "Michael Jackson", 1987);
			Assert.fail("Esperava excecao de nome vazio");
		} catch (Exception e) {
			Assert.assertEquals("Titulo do album nao pode ser vazio.",
					e.getMessage());
		}

		try {
			Album artistaInvalido = new Album("Night Visions", "", 2012);
			Assert.fail("Esperava excecao de artista vazio");
		} catch (Exception e) {
			Assert.assertEquals("Nome do artista do album nao pode ser vazio.",
					e.getMessage());
		}

		try {
			Album anoInvalido = new Album("Uptown Special", "Mark Ronson", -3);
			Assert.fail("Esperava excecao de ano de lancamento negativo");
		} catch (Exception e) {
			Assert.assertEquals(
					"Ano de lancamento do album nao pode ser negativo.",
					e.getMessage());
		}
	}

	@Test
	public void testAdicionaMusica() {
		try {
			uptownSpecial.adicionaMusica(uptownFunk);
			Assert.assertEquals(1, uptownSpecial.getFaixas().size());
			Assert.assertEquals(4, uptownSpecial.getDuracaoTotal());

			bad.adicionaMusica(smoothCriminal);
			bad.adicionaMusica(manInTheMirror);
			Assert.assertEquals(2, bad.getFaixas().size());
			Assert.assertEquals(9, bad.getDuracaoTotal());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testRemoveMusica() {
		try {
			nightVisions.adicionaMusica(radioactive);
			nightVisions.adicionaMusica(demons);
			nightVisions.adicionaMusica(badM);

			nightVisions.removeFaixa(3);
			Assert.assertEquals(6, nightVisions.getDuracaoTotal());
			Assert.assertEquals(2, nightVisions.getFaixas().size());

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
