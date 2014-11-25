package br.com.drogaria.domain;

public class Produto {

	private long codigo;
	private String descricao;
	private long quantidade;
	private double preco;
	private Fabricante fabricante_codigo;

	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Fabricante getFabricante_codigo() {
		return fabricante_codigo;
	}
	public void setFabricante_codigo(Fabricante fabricante_codigo) {
		this.fabricante_codigo = fabricante_codigo;
	}

}
