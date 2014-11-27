package com.denis.rainer.sistema.produto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class ProdutoDAOHibernate implements ProdutoDAO {

	private Session session;

	@Override
	public void salvar(Produto produto) {
		session.save(produto);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> listar() {
		Criteria lista = this.session.createCriteria(Produto.class);
		return lista.list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void excluir(Produto produto) {
		this.session.delete(produto);
		
	}

}
