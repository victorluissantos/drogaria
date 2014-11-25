package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

	private ListDataModel<Fabricante> itens;
	private Fabricante fabricante;

	public void prepararNovo() {
		fabricante = new Fabricante();
	}

	@PostConstruct
	public void preparaPesquisa() {
		try {

			FabricanteDAO dao = new FabricanteDAO();

			ArrayList<Fabricante> lista = dao.listar();

			itens = new ListDataModel<Fabricante>(lista);

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Não foi possivel listar os fabricantes"
					+ ex.getMessage() + "\n" + ex.getErrorCode());
		}
	}

	public void novo() {

		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);

			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);

			JSFUtil.adicionarMensagemSucesso("Fabricante cadastrado com sucesso !");

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Não foi Gravar o fabricante"
					+ ex.getMessage() + "\n" + ex.getErrorCode());
		}

	}

	public void prepararExcluir() {
		fabricante = itens.getRowData();
	}

	public void excluir() {

		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.excluir(fabricante);

			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);

			JSFUtil.adicionarMensagemSucesso("Fabricante Excluido com sucesso !");

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Não foi excluir o fabricante"
					+ ex.getMessage() + "\n" + ex.getErrorCode());
		}

	}

	public void editar() {

		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);

			ArrayList<Fabricante> lista = dao.listar();
			itens = new ListDataModel<Fabricante>(lista);

			JSFUtil.adicionarMensagemSucesso("Fabricante Editado com sucesso !");

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro("Não foi editar o fabricante"
					+ ex.getMessage() + "\n" + ex.getErrorCode());
		}

	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ListDataModel<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fabricante> itens) {
		this.itens = itens;
	}

}
