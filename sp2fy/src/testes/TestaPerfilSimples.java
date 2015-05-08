package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.*;

public class TestaPerfilSimples {
	
	private Perfil gabriela;
	private Album x;
	private Album dontKillTheMagic;
	private Album badBlood;
	
	@Before
	public void setUp(){
		try {
			gabriela = new Perfil("Gabriela");
			x = new Album("X", "Ed Sheeran", 2014);
			dontKillTheMagic = new Album("Don't Kill The Magic", "Magic!", 2014);
			badBlood = new Album("Bad Blood", "Bastille", 2013);
			
		} catch (Exception e) {
			Assert.fail();
		}

	}

	@Test
	public void testPerfil() {
		try {
			Perfil gabriela = new Perfil("Gabriela");
			Assert.assertEquals("Gabriela", gabriela.getNome());
			Assert.assertEquals("Perfil: Gabriela", gabriela.toString());
			Assert.assertEquals(0, gabriela.getAlbuns().size());
			Assert.assertEquals(0, gabriela.getFavoritos().size());

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testPerfilInvalido() {
		try {
			Perfil nomeInvalido = new Perfil("");
			Assert.fail("Esperava excecao de nome vazio");

		} catch (Exception e) {
			Assert.assertEquals("Nome do perfil nao pode ser vazio.",
					e.getMessage());
		}
	}

	@Test
	public void testAdicionaAlbum() {
		try {
			gabriela.adicionaAlbum(dontKillTheMagic);
			gabriela.adicionaAlbum(x);

			Assert.assertEquals(2, gabriela.getAlbuns().size());
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testAdicionaAosFavoritos() {
		try {
			gabriela.adicionaAlbum(dontKillTheMagic);

			gabriela.adicionaAosFavoritos(dontKillTheMagic);
			gabriela.adicionaAosFavoritos(badBlood);
			Assert.assertEquals(1, gabriela.getFavoritos().size());

		} catch (Exception e) {
			Assert.fail();
		}
	}

}
