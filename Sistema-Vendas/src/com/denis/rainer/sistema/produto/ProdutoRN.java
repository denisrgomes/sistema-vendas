package com.denis.rainer.sistema.produto;

import com.denis.rainer.sistema.util.DAOFactory;

public class ProdutoRN {

	private ProdutoDAO produtoDAO;
	
	public ProdutoRN(){
		this.produtoDAO = DAOFactory.criarProdutoDAO();
	}
	public void salvar(Produto produto) {
		this.produtoDAO.salvar(produto);
		
	}
}
