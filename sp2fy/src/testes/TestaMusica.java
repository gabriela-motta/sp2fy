package testes;

import classes.Musica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaMusica {

	private Musica chandelier;
	private Musica elasticHeart;
	private Musica cellophane;

	@Before
	public void setUp() {
		try {
			chandelier = new Musica("Chandelier", 3, "Pop");
			elasticHeart = new Musica("Elastic Heart", 3, "Pop");
			cellophane = new Musica("Cellophane", 4, "Pop");

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testMusica() {
		try {
			Assert.assertEquals("Chandelier", chandelier.getNome());
			Assert.assertEquals(3, chandelier.getDuracao());
			Assert.assertEquals("Pop", chandelier.getGenero());
			Assert.assertEquals("Musica: Chandelier, 3 min, Pop",
					chandelier.toString());

			Assert.assertEquals("Elastic Heart", elasticHeart.getNome());
			Assert.assertEquals(3, elasticHeart.getDuracao());
			Assert.assertEquals("Pop", elasticHeart.getGenero());
			Assert.assertEquals("Musica: Elastic Heart, 3 min, Pop",
					elasticHeart.toString());

			Assert.assertEquals("Cellophane", cellophane.getNome());
			Assert.assertEquals(4, cellophane.getDuracao());
			Assert.assertEquals("Pop", cellophane.getGenero());
			Assert.assertEquals("Musica: Cellophane, 4 min, Pop",
					cellophane.toString());

			Musica chandelierRemix = new Musica("Chandelier", 3, "Eletronica");
			Assert.assertEquals(chandelier, chandelierRemix);
			Assert.assertFalse(chandelier.equals(elasticHeart));

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testMusicaInvalida() {
		try {
			Musica tituloInvalido = new Musica("", 3, "Pop");
			Assert.fail("Esperava excecao de nome vazio");
		} catch (Exception e) {
			Assert.assertEquals("Titulo da musica nao pode ser vazio.",
					e.getMessage());
		}

		try {
			Musica duracaoInvalida = new Musica("Elastic Heart", -5, "Pop");
			Assert.fail("Esperava excecao de duracao negativa");
		} catch (Exception e) {
			Assert.assertEquals("Duracao da musica nao pode ser negativa.",
					e.getMessage());
		}

		try {
			Musica tipoInvalido = new Musica("Cellophane", 4, "");
			Assert.fail("Esperava excecao de tipo vazio");
		} catch (Exception e) {
			Assert.assertEquals("Genero da musica nao pode ser vazio.",
					e.getMessage());
		}
	}
}
