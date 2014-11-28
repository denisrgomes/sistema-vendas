package com.denis.rainer.sistema.venda;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class VendaDAOHibernate implements VendaDAO {

	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void registrarVenda(Venda venda) {
		this.session.save(venda);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Venda> listar() {
		Criteria lista = this.session.createCriteria(Venda.class);
		return lista.list();
	}

	@Override
	public void excluir(Venda venda) {
		this.session.delete(venda);
	}

}
