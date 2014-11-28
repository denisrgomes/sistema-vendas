package com.denis.rainer.sistema.venda;

import java.util.List;

import com.denis.rainer.sistema.cliente.Cliente;
import com.denis.rainer.sistema.produto.Produto;
import com.denis.rainer.sistema.util.DAOFactory;

public class VendaRN {

	public VendaDAO vendaDAO;
	
	public VendaRN() {
		this.vendaDAO = DAOFactory.criarVendaDAO();
	}
	public void registrarVenda(Cliente cliente, Produto produto) {
	
		
	}

	public void registrarVenda(Venda venda) {
		this.vendaDAO.registrarVenda(venda);
		
	}

	public List<Venda> listar() {
		return this.vendaDAO.listar();
	}
	public void excluir(Venda venda) {
		this.vendaDAO.excluir(venda);
		
	}

}
