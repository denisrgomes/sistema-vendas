package com.denis.rainer.sistema.produto;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "produtoBean")
@RequestScoped
public class ProdutoBean {

	private Produto produtoSelecionado = new Produto();
	List<Produto> lista = null;

	public void salvar() {

		ProdutoRN produtoRN = new ProdutoRN();
		produtoSelecionado.setDataCadastro(new Date());

		if (this.produtoSelecionado.getId() != null
				&& this.produtoSelecionado.getId() != 0) {
			produtoRN.alterar(this.produtoSelecionado);
			FacesMessage fmessage = new FacesMessage(
					"Produto alterado com sucesso!!");
			FacesContext fcontext = FacesContext.getCurrentInstance();
			fcontext.addMessage(null, fmessage);
		} else {

			produtoRN.salvar(this.produtoSelecionado);
			FacesMessage fmessage = new FacesMessage(
					"Produto cadastrado com sucesso!!");
			FacesContext fcontext = FacesContext.getCurrentInstance();
			fcontext.addMessage(null, fmessage);
		}

		this.lista = null;
	}

	public void excluir() {
		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.excluir(produtoSelecionado);
		this.lista = null;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public List<Produto> getLista() {
		ProdutoRN produtoRN = new ProdutoRN();
		if (lista == null) {
			lista = produtoRN.listar();
		}
		return lista;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public void novo() {
		this.produtoSelecionado = new Produto();
	}
}
