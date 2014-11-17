package com.denis.rainer.sistema.produto;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="produtoBean")
@RequestScoped
public class ProdutoBean {

	private Produto produtoSelecionado = new Produto();
	
	public void salvar(){
		
		ProdutoRN produtoRN = new ProdutoRN();
		produtoSelecionado.setDataCadastro(new Date());
		
			produtoRN.salvar(produtoSelecionado);
			
			FacesMessage fmessage = new FacesMessage("Produto cadastrado com sucesso!!");
			FacesContext fcontext = FacesContext.getCurrentInstance();
			fcontext.addMessage(null, fmessage);
			
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	
}
