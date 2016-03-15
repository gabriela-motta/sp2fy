package classes;

public class Musica {

	private String nome;
	private int duracao;
	private String genero;

	/**
	 * Construtor de musica
	 * 
	 * @param nome
	 *            O titulo da musica
	 * @param duracao
	 *            A duracao em minutos da musica
	 * @param genero
	 *            O genero da musica
	 * @throws Exception
	 *             Se o nome ou o genero forem vazios, ou se a duracao for
	 *             negativa
	 */
	public Musica(String nome, int duracao, String genero) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");

		if (duracao < 0)
			throw new Exception("Duracao da musica nao pode ser negativa.");

		if (genero == null || genero.trim().equals(""))
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");

		this.nome = nome;
		this.duracao = duracao;
		this.genero = genero;
	}

	/**
	 * Verifica se duas musicas sao iguais comparando o nome e a duracao
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Musica) {
			Musica outraMusica = (Musica) obj;

			return this.getTitulo().equals(outraMusica.getTitulo())
					&& this.getDuracao() == outraMusica.getDuracao();
		}
		return false;
	}

	/**
	 * Retorna uma String que representa a musica
	 */
	@Override
	public String toString() {
		return "Musica: " + this.nome + ", " + this.duracao + " min, "
				+ this.genero;
	}

	public String getTitulo() {
		return nome;
	}

	public int getDuracao() {
		return duracao;
	}

	public String getGenero() {
		return genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

}
