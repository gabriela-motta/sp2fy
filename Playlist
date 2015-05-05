package classes;

import java.util.HashSet;

public class Playlist {

	// atributos
	private String nome;
	private HashSet<Musica> musicas;

	public Playlist(String nome) throws Exception {
		if (nome.equals("")) {
			throw new Exception("Nome da playlist nao pode ser vazio.");
		}
		this.nome = nome;
		this.musicas = new HashSet<Musica>();
	}

	@Override
	public String toString() {
		return "Playlist: " + this.nome;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Playlist) {
			Playlist outraPlaylist = (Playlist) obj;
			return this.getNome().equals(outraPlaylist.getNome());
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HashSet<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(HashSet<Musica> musicas) {
		this.musicas = musicas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

}
