package com.denis.rainer.sistema.cliente;

import java.util.List;

import org.hibernate.Criteria;
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listar() {
		Criteria lista = session.createCriteria(Cliente.class);
		return lista.list();
	}

}
