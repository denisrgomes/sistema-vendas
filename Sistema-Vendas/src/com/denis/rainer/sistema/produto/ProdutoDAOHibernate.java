package com.denis.rainer.sistema.produto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	@Override
	public void alterar(Produto produto) {
		this.session.update(produto);

	}

	@Override
	public Produto pesquisar(String string) {

		Query consulta = this.session
				.createQuery("from Produto p where p.descricao like :descricao");
		consulta.setString("descricao", "%" + string + "%");
		return (Produto) consulta.uniqueResult();
	}

	@Override
	public Object pesquisarPorCodigo(Integer codigo) {
		
		return (Produto) this.session.get(Produto.class, codigo);
	}

}
