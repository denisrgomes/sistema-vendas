package com.denis.rainer.sistema.produto;

import java.util.List;

public interface ProdutoDAO {

	public void salvar(Produto produto);

	public List<Produto> listar();

	public void excluir(Produto produto);

	public void alterar(Produto produto);

	public Produto pesquisar(String string);

	public Object pesquisarPorCodigo(Integer codigo);
}
