package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public class Perfil {

	// atributos
	private String nome;
	private ArrayList<Album> albuns;
	private ArrayList<Album> favoritos;
	private Map<String, Playlist> playlists;

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

	public void adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {
		Playlist atualPlaylist;
		Album atualAlbum;
		Musica atualFaixa;
		
		if (this.playlists.containsKey(nomePlaylist)){
			atualPlaylist = this.playlists.get(nomePlaylist);
			
		}else {
			Playlist vazia = new Playlist(nomePlaylist);
			playlists.put(nomePlaylist, vazia);
		}
		
		if (this.albuns.contains(nomeAlbum)){
			
			
		} else{
			throw new Exception("Album nao pertence ao perfil especificado.");
		}
	}

	public void ordenaAlbunsPorAno() {
		Collections.sort(albuns);
	}

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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Perfil) {
			Perfil outroPerfil = (Perfil) obj;
			return this.getNome().equals(outroPerfil.getNome());
		}
		return false;
	}

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

	public Map<String, Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Map<String, Playlist> playlists) {
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
