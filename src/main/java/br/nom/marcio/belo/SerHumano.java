package br.nom.marcio.belo;

public class SerHumano {
	private String nome;
	
	protected SerHumano(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
