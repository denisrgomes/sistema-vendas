package com.denis.rainer.sistema.venda;

import com.denis.rainer.sistema.util.DAOFactory;

public class VendaRN {

	private VendaDAO vendaDAO;
	
	public VendaRN(){
		this.vendaDAO = DAOFactory.criarVendaDAO();
	}
	
	public void salvar(Venda venda){
		this.vendaDAO.salvar(venda);
	}
}
