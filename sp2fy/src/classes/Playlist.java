package classes;

import java.util.ArrayList;

public class Playlist {

	private ArrayList<Musica> musicas;

	/**
	 * Construtor de Playlist
	 */
	public Playlist() {
		this.musicas = new ArrayList<Musica>();
	}

	/**
	 * Adiciona uma musica no agrupamento de musicas
	 * 
	 * @param musica
	 */
	public void adicionaMusica(Musica musica) {
		this.musicas.add(musica);

	}

	/**
	 * Verifica se o agrupamento contem uma musica
	 * 
	 * @param musicaProcurada
	 * @return true se o agrupamento tiver a musica, false caso contrario
	 */
	public boolean contains(Musica musicaProcurada) {
		for (Musica musica : musicas) {
			if (musica.equals(musicaProcurada)) {
				return true;
			}
		}
		return false;
	}

}
