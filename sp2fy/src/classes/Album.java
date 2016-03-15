package classes;

import java.util.ArrayList;

public class Album implements Comparable<Album> {

	private String nome;
	private String artista;
	private int anoLancamento;
	private ArrayList<Musica> faixas;
	private boolean isFavorito;

	/**
	 * Construtor de album
	 * 
	 * @param nome
	 *            O titulo do album
	 * @param artista
	 *            O artista do album
	 * @param anoLancamento
	 *            O ano de lancamento do album
	 * @throws Exception
	 *             Se o nome ou o artista forem vazios, ou se o ano de
	 *             lancamento for negativo
	 */
	public Album(String nome, String artista, int anoLancamento)
			throws Exception {

		if (nome == null || nome.trim().equals("")) 
			throw new Exception("Titulo do album nao pode ser nulo ou vazio.");
		

		if (artista == null || artista.trim().equals("")) 
			throw new Exception("Nome do artista do album nao pode ser nulo ou vazio.");
		

		if (anoLancamento <= 1900) 
			throw new Exception("Ano de lancamento do album nao pode ser anterior a 1900.");

		this.nome = nome;
		this.artista = artista;
		this.anoLancamento = anoLancamento;
		this.faixas = new ArrayList<Musica>();
		this.isFavorito = false;
	}

	/**
	 * Adiciona uma musica no album, e aumenta a duracao total do album
	 * 
	 * @param musica
	 *            A musica a ser adicionada
	 * @throws Exception 
	 * 			Se a musica ja estiver no album
	 */
	public void adicionaMusica(Musica musica) throws Exception {
		if(musica == null){
			throw new Exception("Nao pode adicionar musica nula.");
		}
		if (faixas.contains(musica))
			throw new Exception(musica.getTitulo() + " ja esta no album.");
		
		faixas.add(musica);
	}

	/**
	 * Remove uma faixa do album pela posicao que ela se encontra, e diminui a duracao total do album
	 * 
	 * @param numero
	 *            O numero da faixa a ser removida
	 * @throws Exception 
	 * 				Se a posicao da musica for menor do que 1
	 */
	public void removeFaixa(int numero) throws Exception {
		if (numero < 1) 
			throw new Exception("Posicao da musica nao e valida");
		
		if (faixas.isEmpty())
			throw new Exception("Album esta vazio");
		
		if (numero > faixas.size())
			throw new Exception("Posicao maior do que a quantidade de faixas");
		
		int posicao = numero - 1;
		faixas.remove(posicao);
	}
	
	/**
	 * Pesquisa uma musica pelo nome
	 * 
	 * @param nome
	 * 			Nome da musica
	 * @return
	 * 			Se achar a musica retorna 'true', caso contrario retorna 'false'
	 */
	public boolean pesquisarMusica(String nome){
		for (Musica musica : faixas){
			if (musica.getTitulo().equals(nome))
				return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return
	 * 			A quantidade de faixas cadastradas no album
	 */
	public int quantidadeFaixas(){
		return faixas.size();
	}

	/**
	 * Verifica se dois albuns sao iguais comparando o nome e o artista
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Album) {
			Album outroAlbum = (Album) obj;
			
			return this.getArtista().equals(outroAlbum.getArtista())
					&& this.getNome().equals(outroAlbum.getNome());
		}
		
		return false;
	}

	/**
	 * Compara o ano de lancamento de dois albuns para ver qual o maior durante
	 * uma ordenacao
	 */
	public int compareTo(Album outroAlbum) {
		if (this.getAnoLancamento() > outroAlbum.getAnoLancamento()) {
			return 1;
		} else if (this.getAnoLancamento() == outroAlbum.getAnoLancamento()) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * Retorna uma String que representa o album
	 */
	@Override
	public String toString() {
		return "Album: " + this.nome + ", " + this.artista + ", lancado em "
				+ this.anoLancamento;
	}

	public String getNome() {
		return nome;
	}

	public String getArtista() {
		return artista;
	}

	public int getDuracaoTotal() {
		int duracao = 0;
		for (Musica musica : faixas) {
			duracao = duracao + musica.getDuracao();
		}
		return duracao;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public ArrayList<Musica> getFaixas() {
		return faixas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

}
