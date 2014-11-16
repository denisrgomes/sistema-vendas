package com.denis.rainer.sistema.produto;

import org.hibernate.Session;

public class ProdutoDAOHibernate implements ProdutoDAO {

	private Session session;
	
	@Override
	public void salvar(Produto produto) {
		session.save(produto);

	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
}
