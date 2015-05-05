package classes;

import java.util.ArrayList;

public class Album implements Comparable<Album> {

	// atributos
	private String nome;
	private String artista;
	private int duracaoTotal;
	private int anoLancamento;
	private ArrayList<Musica> faixas;

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

		if (nome.equals("")) {
			throw new Exception("Titulo do album nao pode ser vazio.");
		}

		if (artista.equals("")) {
			throw new Exception("Nome do artista do album nao pode ser vazio.");
		}

		if (anoLancamento < 0) {
			throw new Exception(
					"Ano de lancamento do album nao pode ser negativo.");
		}

		this.nome = nome;
		this.artista = artista;
		this.anoLancamento = anoLancamento;
		this.duracaoTotal = 0;
		this.faixas = new ArrayList<Musica>();
	}

	/**
	 * Adiciona uma musica no album, e aumenta a duracao total do album
	 * 
	 * @param musica
	 *            A musica a ser adicionada
	 */
	public void adicionaMusica(Musica musica) {
		this.faixas.add(musica);
		this.duracaoTotal = this.duracaoTotal + musica.getDuracao();
	}

	/**
	 * Remove uma faixa do album, e diminui a duracao total do album
	 * 
	 * @param numero
	 *            O numero da faixa a ser removida
	 */
	public void removeFaixa(int numero) {
		int posicao = numero - 1;
		this.duracaoTotal = this.duracaoTotal
				- this.faixas.get(posicao).getDuracao();
		this.faixas.remove(posicao);
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

	public int compareTo(Album outroAlbum) {
		if (this.getAnoLancamento() > outroAlbum.getAnoLancamento()) {
			return 1;
		} else if (this.getAnoLancamento() == outroAlbum.getAnoLancamento()) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Album: " + this.nome + ", " + this.artista + ", lancado em "
				+ this.anoLancamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getDuracaoTotal() {
		return duracaoTotal;
	}

	public void setDuracaoTotal(int duracaoTotal) {
		this.duracaoTotal = duracaoTotal;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public ArrayList<Musica> getFaixas() {
		return faixas;
	}

	public void setFaixas(ArrayList<Musica> faixas) {
		this.faixas = faixas;
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
