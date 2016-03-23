package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Musiteca {

	private ArrayList<Album> albuns;
	private ArrayList<Album> favoritos;
	private HashMap<String, Playlist> playlists;

	/**
	 * Construtor de Musiteca
	 */
	public Musiteca() {
		this.albuns = new ArrayList<Album>();
		this.favoritos = new ArrayList<Album>();
		this.playlists = new HashMap<String, Playlist>();
	}

	/**
	 * Adiciona um album na lista
	 * @param album
	 * @throws Exception 
	 */
	public boolean adicionaAlbum(Album album) throws Exception {
		if(album == null){
			throw new Exception("Nao pode adicionar album nulo");
		}
		this.albuns.add(album);
		return true;
	}
	
	
	public boolean removeAlbum(Album album) throws Exception{
		if(album == null){
			throw new Exception("Nao pode remover album nulo");
		}
		for (Album outroAlbum : albuns) {
			if(outroAlbum.equals(album)){
				this.albuns.remove(album);
				setFavoritos();
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifica se o album existe na lista de albuns
	 * 
	 * @param albumProcurado
	 * @return true se o album exite, false caso contrario
	 * @throws Exception 
	 */
	public boolean contemAlbum(Album albumProcurado) throws Exception {
		if(albumProcurado == null){
			throw new Exception("Nao pode procurar album nulo");
		}
		for (Album album : albuns) {
			if (album.equals(albumProcurado)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adiciona um album aos favoritos
	 * @throws Exception 
	 */
	public void adicionaFavorito(Album album) throws Exception {
		if(album == null){
			throw new Exception("Nao pode adicionar album nulo aos favoritos");
		}
		album.setFavorito(true);
		setFavoritos();
	}

	/**
	 * Adiciona uma musica em uma playlist
	 * 
	 * @param nomePlaylist
	 *            Nome da playlist que a musica sera adicionada
	 * @param nomeAlbum
	 *            O album que contem a musica
	 * @param faixa
	 *            O numero da musica no album
	 * @throws Exception
	 *             Se o album nao pertencer ao perfil Se a faixa for menor do
	 *             que 1 ou maior do que o tamanho da quantidade de faixas do
	 *             album
	 */
	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum,
			int faixa) throws Exception {
		Playlist atualPlaylist;
		Album atualAlbum;
		Musica atualFaixa;

		if (faixa < 1)
			throw new Exception("Posicao da musica nao e valida");

		if (this.playlists.containsKey(nomePlaylist))
			atualPlaylist = this.playlists.get(nomePlaylist);
		else
			atualPlaylist = new Playlist();

		atualAlbum = procuraAlbum(nomeAlbum);

		if (atualAlbum == null)
			throw new Exception("Album nao pertence ao perfil especificado.");
		else {
			if (faixa > atualAlbum.quantidadeFaixas())
				throw new Exception(
						"Posicao maior do que a quantidade de faixas");

			atualFaixa = atualAlbum.getFaixas().get(faixa - 1);

			atualPlaylist.adicionaMusica(atualFaixa);
			this.playlists.put(nomePlaylist, atualPlaylist);
			return true;
		}

	}

	/**
	 * Procura um album na lista de albuns atraves do seu nome
	 * 
	 * @param nome
	 *            O nome do album a ser procurado
	 * @return O album procurado se o album for encontrado, null se o album nao
	 *         for encontrado
	 */
	public Album procuraAlbum(String nome) {
		for (Album album : this.albuns) {
			if (album.getNome().equals(nome))
				return album;
		}

		return null;
	}

	public ArrayList<Album> getAlbuns() {
		return albuns;
	}

	public ArrayList<Album> getFavoritos() {
		setFavoritos();
		return this.favoritos;
	}

	private void setFavoritos() {
		this.favoritos = new ArrayList<Album>();
		for (Album album : albuns) {
			if(album.isFavorito()){
				this.favoritos.add(album);
			}
		}
	}

	public HashMap<String, Playlist> getPlaylists() {
		return playlists;
	}

	/**
	 * Ordena a lista de albuns por ano usando o compareTo de album
	 */
	public void ordenaAlbunsPorAno() {
		Collections.sort(this.albuns);
		setFavoritos();
		Collections.sort(this.favoritos);
	}

	/**
	 * Ordena a lista de albuns por duracao total usando comparator
	 */
	public void ordenaAlbunsPorDuracao() {
		Collections.sort(this.albuns, new Comparator<Album>() {

			@Override
			public int compare(Album album1, Album album2) {
				if (album1.getDuracaoTotal() > album2.getDuracaoTotal()) {
					return 1;
				} else if (album1.getDuracaoTotal() == album2.getDuracaoTotal()) {
					return 0;
				} else {
					return -1;
				}
			}
		});

	}

	/**
	 * Ordena a lista de albuns por quantidade de musicas usando comparator
	 */
	public void ordenaAlbunsPorQuantidade() {
		Collections.sort(this.albuns, new Comparator<Album>() {

			@Override
			public int compare(Album album1, Album album2) {
				if (album1.getFaixas().size() > album2.getFaixas().size()) {
					return 1;
				} else if (album1.getFaixas().size() == album2.getFaixas()
						.size()) {
					return 0;
				} else {
					return -1;
				}
			}
		});

	}
}