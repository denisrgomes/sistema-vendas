package com.denis.rainer.sistema.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean {

	private Cliente clienteSelecionado = new Cliente();
	
	List<Cliente> lista = null;
	
	
	public void salvar(){
		ClienteRN clienteRN = new ClienteRN();
		clienteSelecionado.setDataCadastro(new Date());
		clienteRN.salvar(clienteSelecionado);
		
		FacesMessage fmessage = new FacesMessage("Cliente cadastrado com sucesso!");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, fmessage);
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public List<Cliente> getLista() {
	
		ClienteRN clienteRN = new ClienteRN();
		
		//if(lista != null){
			lista = clienteRN.listar();
		//}
		
		return lista;
	}
	
	
	
}
