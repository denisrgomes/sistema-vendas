package com.denis.rainer.sistema.cliente;

import java.util.List;

import com.denis.rainer.sistema.util.DAOFactory;

public class ClienteRN {

	/*
	 * Interface do Cliente
	 */
	private ClienteDAO clienteDAO;

	public ClienteRN() {
		this.clienteDAO = DAOFactory.criarClienteDAO();
	}

	public void salvar(Cliente c1) {
		this.clienteDAO.salvar(c1);
	}

	public List<Cliente> listar() {

		return clienteDAO.listar();
	}

	public void excluir(Cliente cliente) {
		this.clienteDAO.excluir(cliente);

	}

	public Cliente pesquisar(String string) {
		return this.clienteDAO.pesquisar(string);
	}

	public void alterar(Cliente cliente) {
		this.clienteDAO.alterar(cliente);
		
	}

	public Cliente pesquisarPorCodigo(Integer codigo) {
		
		return this.clienteDAO.pesquisarPorCodigo(codigo);
	}

}
