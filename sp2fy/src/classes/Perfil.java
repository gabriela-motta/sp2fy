package classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Perfil {

	private String nome;
	private Musiteca musiteca;

	/**
	 * Construtor de perfil
	 * 
	 * @param nome
	 *            O nome do perfil
	 * @throws Exception
	 *             Se o nome for vazio
	 */
	public Perfil(String nome) throws Exception {
		if (nome.trim().equals("") || nome == null)
			throw new Exception("Nome do perfil nao pode ser vazio.");

		this.nome = nome;
		this.musiteca = new Musiteca();
	}

	/**
	 * Adiciona um album na lista de albuns do perfil
	 * 
	 * @param album
	 *            O album a ser adicionado
	 */
	public boolean adicionaAlbum(Album album) {
		if (album != null) {
			musiteca.adicionaAlbum(album);
			return true;
		}
		return false;
	}

	/**
	 * Verifica se um album pertence ao perfil e adiciona aos favoritos
	 * 
	 * @param album
	 *            O album a ser adicionado aos favoritos
	 * @throws Exception
	 *             Se o album nao pertencer ao perfil
	 */
	public boolean adicionaAosFavoritos(Album album) throws Exception {
		if (!musiteca.contemAlbum(album)) {
			throw new Exception("Nao pode adicionar " + album.getNome()
					+ " aos favoritos pois nao pertence ao perfil.");
		}

		musiteca.adicionaFavorito(album);
		return true;
	}

	/**
	 * Procura um album na musiteca atraves do seu nome
	 */
	public Album procuraAlbum(String nome) {
		return musiteca.procuraAlbum(nome);
	}

	/**
	 * Adiciona uma musica em uma playlist da musiteca
	 */
	public void adicionaPlaylist(String nomePlaylist, String nomeAlbum,
			int faixa) throws Exception {
		musiteca.adicionaPlaylist(nomePlaylist, nomeAlbum, faixa);
	}

	/**
	 * Ordena a lista de albuns por ano usando o compareTo de album
	 */
	public void ordenaAlbunsPorAno() {
		musiteca.ordenaAlbunsPorAno();
	}

	/**
	 * Ordena a lista de albuns por duracao total usando comparator
	 */
	public void ordenaAlbunsPorDuracao() {
		musiteca.ordenaAlbunsPorDuracao();
	}

	/**
	 * Ordena a lista de albuns por quantidade de musicas usando comparator
	 */
	public void ordenaAlbunsPorQuantidade() {
		musiteca.ordenaAlbunsPorQuantidade();
	}

	/**
	 * Verifica se dois perfis sao iguais comparando o nome
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Perfil) {
			Perfil outroPerfil = (Perfil) obj;

			return this.getNome().equals(outroPerfil.getNome());
		}

		return false;
	}

	/**
	 * Retorna uma String que representa o perfil
	 */
	@Override
	public String toString() {
		return "Perfil: " + this.nome;
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Album> getAlbuns() {
		return musiteca.getAlbuns();
	}

	public ArrayList<Album> getFavoritos() {
		return musiteca.getFavoritos();
	}

	public HashMap<String, Playlist> getPlaylists() {
		return musiteca.getPlaylists();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

}
