package br.com.drogaria.domain;

public class Fabricante {

	private long id;
	private String descricao;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		String saida = id + "-" + descricao;
		return saida;
	}
}
