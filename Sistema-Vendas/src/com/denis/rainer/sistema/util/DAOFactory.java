package com.denis.rainer.sistema.util;

import com.denis.rainer.sistema.cliente.ClienteDAO;
import com.denis.rainer.sistema.cliente.ClienteDAOHibernate;
import com.denis.rainer.sistema.produto.ProdutoDAO;
import com.denis.rainer.sistema.produto.ProdutoDAOHibernate;
import com.denis.rainer.sistema.venda.HibernateUtil;

public class DAOFactory {
	
	public static ClienteDAO criarClienteDAO(){
		
		ClienteDAOHibernate clienteDAOHibernate = new ClienteDAOHibernate();
		clienteDAOHibernate.setSession(HibernateUtil.getSession().getCurrentSession());
		
		return clienteDAOHibernate;
	}

	public static ProdutoDAO criarProdutoDAO(){
		
		ProdutoDAOHibernate produtoDAOHibernate = new ProdutoDAOHibernate();
		produtoDAOHibernate.setSession(HibernateUtil.getSession().getCurrentSession());
		
		return produtoDAOHibernate;
	}
}
