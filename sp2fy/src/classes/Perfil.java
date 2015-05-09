package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Perfil {

	private String nome;
	private ArrayList<Album> albuns;
	private ArrayList<Album> favoritos;
	private HashMap<String, HashSet<Musica>> playlists;

	/**
	 * Construtor de perfil
	 * 
	 * @param nome
	 *            O nome do perfil
	 * @throws Exception
	 *             Se o nome for vazio
	 */
	public Perfil(String nome) throws Exception {
		if (nome.equals("")) {
			throw new Exception("Nome do perfil nao pode ser vazio.");
		}
		this.nome = nome;
		this.albuns = new ArrayList<Album>();
		this.favoritos = new ArrayList<Album>();
		this.playlists = new HashMap<String, HashSet<Musica>>();
	}

	/**
	 * Adiciona um album na lista de albuns do perfil
	 * 
	 * @param album
	 *            O album a ser adicionado
	 */
	public void adicionaAlbum(Album album) {
		this.albuns.add(album);
	}

	/**
	 * Verifica se um album pertence ao perfil para adiciona-lo aos favoritos
	 * 
	 * @param album
	 *            O album a ser adicionado aos favoritos
	 */
	public void adicionaAosFavoritos(Album album) {
		if (this.albuns.contains(album)) {
			this.favoritos.add(album);
		}
	}

	/**
	 * Procura um album na lista de albuns recebendo um nome
	 * 
	 * @param nome
	 *            O nome do album a ser procurado
	 * @return albumProcurado se o album for encontrado, null se o album nao for
	 *         encontrado
	 */
	public Album procuraAlbum(String nome) {
		for (Album album: albuns){
			if (album.getNome().equals(nome)){
				return album;
			}
		}
		return null;
	}

	/**
	 * Adiciona uma musica em uma playlist
	 * 
	 * @param nomePlaylist
	 *            A playlist
	 * @param nomeAlbum
	 *            O album que contem a musica
	 * @param faixa
	 *            O numero da musica no album
	 * @throws Exception
	 *             Se o album nao pertencer ao perfil
	 */
	public void adicionaPlaylist(String nomePlaylist, String nomeAlbum,
			int faixa) throws Exception {
		HashSet<Musica> atualPlaylist;
		Album atualAlbum;
		Musica atualFaixa;

		if (this.playlists.containsKey(nomePlaylist)) {
			atualPlaylist = this.playlists.get(nomePlaylist);

		} else {
			atualPlaylist = new HashSet<Musica>();
		}

		atualAlbum = procuraAlbum(nomeAlbum);

		if (atualAlbum == null) {
			throw new Exception("Album nao pertence ao perfil especificado.");

		} else {
			atualFaixa = atualAlbum.getFaixas().get(faixa - 1);

			atualPlaylist.add(atualFaixa);
			playlists.put(nomePlaylist, atualPlaylist);
		}
	}

	/**
	 * Ordena a lista de albuns por ano usando o compareTo de album
	 */
	public void ordenaAlbunsPorAno() {
		Collections.sort(albuns);
	}

	/**
	 * Ordena a lista de albuns por duracao total usando comparator
	 */
	public void ordenaAlbunsPorDuracao() {
		Collections.sort(albuns, new Comparator<Album>() {

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
		Collections.sort(albuns, new Comparator<Album>() {

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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(ArrayList<Album> albuns) {
		this.albuns = albuns;
	}

	public ArrayList<Album> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(ArrayList<Album> favoritos) {
		this.favoritos = favoritos;
	}

	public Map<String, HashSet<Musica>> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(HashMap<String, HashSet<Musica>> playlists) {
		this.playlists = playlists;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

}
