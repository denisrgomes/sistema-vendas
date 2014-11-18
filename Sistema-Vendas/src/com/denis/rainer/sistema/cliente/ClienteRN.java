package com.denis.rainer.sistema.cliente;

import java.util.List;

import com.denis.rainer.sistema.util.DAOFactory;

public class ClienteRN {
 
	/*
	 * Interface do Cliente
	 */
	private ClienteDAO clienteDAO;
	
	public ClienteRN(){
	this.clienteDAO = DAOFactory.criarClienteDAO();
	}

	public void salvar(Cliente c1) {
		this.clienteDAO.salvar(c1);
	}

	public List<Cliente> listar() {
		
		return clienteDAO.listar();
	}

}
