package com.denis.rainer.sistema.util;

import org.hibernate.Session;

import com.denis.rainer.sistema.venda.Venda;
import com.denis.rainer.sistema.venda.VendaDAO;

public class VendaDAOHibernate implements VendaDAO {

	private Session session;
	
	@Override
	public void salvar(Venda venda) {
		session.save(venda);
	}

	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
}
