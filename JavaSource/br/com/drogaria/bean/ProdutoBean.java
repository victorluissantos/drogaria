package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

	private ListDataModel<Produto> itens;
	private Produto produto;

	public void prepararNovo() {
		produto = new Produto();
	}

	@PostConstruct
	public void preparaPesquisa() {
		try {

			ProdutoDAO dao = new ProdutoDAO();

			ArrayList<Produto> lista = dao.listar();

			itens = new ListDataModel<Produto>(lista);

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Não foi possivel listar os fabricantes"
					+ ex.getMessage() + "\n" + ex.getErrorCode());
		}
	}

	public ListDataModel<Produto> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Produto> itens) {
		this.itens = itens;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}



}
