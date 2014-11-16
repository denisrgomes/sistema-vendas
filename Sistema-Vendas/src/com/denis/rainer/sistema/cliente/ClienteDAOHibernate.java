package com.denis.rainer.sistema.cliente;

import org.hibernate.Session;

public class ClienteDAOHibernate implements ClienteDAO {

	private Session session;
	
	@Override
	public void salvar(Cliente cliente) {
		session.save(cliente);

	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}

}
