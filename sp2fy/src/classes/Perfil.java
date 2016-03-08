package classes;

//114110443 - Gabriela Motta Oliveira - LAB 4 - Turma 3

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Perfil {

	private String nome;
	private ArrayList<Album> albuns;
	private HashSet<Album> favoritos;
	private HashMap<String, ArrayList<Musica>> playlists;

	/**
	 * Construtor de perfil
	 * 
	 * @param nome
	 *            O nome do perfil
	 * @throws Exception
	 *             Se o nome for vazio
	 */
	public Perfil(String nome) throws Exception {
		if (nome.equals("")) 
			throw new Exception("Nome do perfil nao pode ser vazio.");
		
		this.nome = nome;
		this.albuns = new ArrayList<Album>();
		this.favoritos = new HashSet<Album>();
		this.playlists = new HashMap<String, ArrayList<Musica>>();
	}

	/**
	 * Adiciona um album na lista de albuns do perfil
	 * 
	 * @param album
	 *            O album a ser adicionado
	 */
	public void adicionaAlbum(Album album) {
		if (album != null)
			albuns.add(album);
	}

	/**
	 * Verifica se um album pertence ao perfil e adiciona aos favoritos
	 * 
	 * @param album
	 *            O album a ser adicionado aos favoritos
	 * @throws Exception 
	 * 				Se o album nao pertencer ao perfil
	 */
	public void adicionaAosFavoritos(Album album) throws Exception {
		if (!albuns.contains(album)) {
			throw new Exception("Nao pode adicionar " + album.getNome() + " aos favoritos pois nao pertence ao perfil.");
		}
		
		favoritos.add(album);
	}

	/**
	 * Procura um album na lista de albuns atraves do seu nome
	 * 
	 * @param nome
	 *            O nome do album a ser procurado
	 * @return 
	 * 			O album procurado se o album for encontrado, null se o album nao for encontrado
	 */
	public Album procuraAlbum(String nome) {
		for (Album album : albuns) {
			if (album.getNome().equals(nome)) 
				return album;
		}
		
		return null;
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
	 *             Se o album nao pertencer ao perfil
	 *             Se a faixa for menor do que 1 ou maior do que o tamanho da quantidade de faixas do album
	 */
	public void adicionaPlaylist(String nomePlaylist, String nomeAlbum,
			int faixa) throws Exception {
		ArrayList<Musica> atualPlaylist;
		Album atualAlbum;
		Musica atualFaixa;
		
		if (faixa < 1) 
			throw new Exception("Posicao da musica nao e valida");

		if (playlists.containsKey(nomePlaylist)) 
			atualPlaylist = playlists.get(nomePlaylist);
		else 
			atualPlaylist = new ArrayList<Musica>();

		atualAlbum = procuraAlbum(nomeAlbum);

		if (atualAlbum == null) 
			throw new Exception("Album nao pertence ao perfil especificado.");
		else {
			if (faixa > atualAlbum.quantidadeFaixas())
				throw new Exception("Posicao maior do que a quantidade de faixas");
			
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

	public ArrayList<Album> getAlbuns() {
		return albuns;
	}

	public HashSet<Album> getFavoritos() {
		return favoritos;
	}

	public HashMap<String, ArrayList<Musica>> getPlaylists() {
		return playlists;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

}
