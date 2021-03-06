package com.denis.rainer.sistema.produto;

import java.util.List;

import com.denis.rainer.sistema.util.DAOFactory;

public class ProdutoRN {

	private ProdutoDAO produtoDAO;

	public ProdutoRN() {
		this.produtoDAO = DAOFactory.criarProdutoDAO();
	}

	public void salvar(Produto produto) {
		this.produtoDAO.salvar(produto);

	}

	public List<Produto> listar() {

		return this.produtoDAO.listar();
	}

	public void excluir(Produto produto) {
		this.produtoDAO.excluir(produto);

	}

	public void alterar(Produto produto) {
		this.produtoDAO.alterar(produto);

	}

	public Produto pesquisar(String string) {
		return this.produtoDAO.pesquisar(string);
	}

	public Object pesquisarPorCodigo(Integer codigo) {
		return this.produtoDAO.pesquisarPorCodigo(codigo);
	}
}
