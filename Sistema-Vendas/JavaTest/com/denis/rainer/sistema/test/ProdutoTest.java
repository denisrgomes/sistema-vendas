package com.denis.rainer.sistema.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.denis.rainer.sistema.produto.Produto;
import com.denis.rainer.sistema.produto.ProdutoRN;
import com.denis.rainer.sistema.util.HibernateUtil;

public class ProdutoTest extends TestHeranca{

	@Before
	public void setup() {
		Produto p1 = new Produto(50, "Caderno", new Date(), 7.0f, "lote");
		Produto p2 = new Produto(20, "Regua", new Date(), 2.5f, "kg");
		Produto p3 = new Produto(300, "Papel", new Date(), 1.5f, "fardo");
		Produto p4 = new Produto(10, "Livro", new Date(), 30.0f, "edicao");
		Produto p5 = new Produto(90, "Caneta", new Date(), 1.5f, "caixa");
		Produto p6 = new Produto(1000, "Lapis", new Date(), 1.0f, "un");

		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.salvar(p1);
		produtoRN.salvar(p2);
		produtoRN.salvar(p3);
		produtoRN.salvar(p4);
		produtoRN.salvar(p5);
		produtoRN.salvar(p6);

	}

	@After
	public void limpaBanco() {
		ProdutoRN produtoRN = new ProdutoRN();
		java.util.List<Produto> produto = produtoRN.listar();

		for (Produto produto2 : produto) {
			produtoRN.excluir(produto2);
		}
	}

	@Test
	public void salvarProdutoTest() {

		ProdutoRN produtoRN = new ProdutoRN();
		Produto p1 = new Produto(100, "Giz", new Date(), 0.5f, "lote");

		produtoRN.salvar(p1);

		assertEquals(true, true);
	}

	/*
	 * @Test public void salvarProdutoTest(){
	 * 
	 * Produto p1 = new Produto();
	 * 
	 * p1.setDataCadastro(new Date()); p1.setDescricao("Caderno");
	 * p1.setEstoque(50); p1.setValor(7.0f); p1.setUnidade("lote");
	 * 
	 * 
	 * ProdutoRN produtoRN = new ProdutoRN();
	 * 
	 * 
	 * produtoRN.salvar(p1);
	 * 
	 * assertEquals(true, true); }
	 */

	@Test
	public void listarProdutoTest() {
		ProdutoRN produtoRN = new ProdutoRN();
		java.util.List<Produto> lista = produtoRN.listar();
		assertEquals(6, lista.size());
	}

	@Test
	public void alterarProdutoTest() {

		ProdutoRN produtoRN = new ProdutoRN();
		Produto produtoPesquisado = produtoRN.pesquisar("Cade");
		produtoPesquisado.setEstoque(100);
		produtoRN.alterar(produtoPesquisado);

		Produto produtoAlterado = produtoRN.pesquisar("Cade");

		assertEquals(100, produtoAlterado.getEstoque().longValue());
	}

	@Test
	public void excluir() {
		ProdutoRN produtoRN = new ProdutoRN();
		List<Produto> produtoExcluido = produtoRN.listar();
		produtoRN.excluir(produtoExcluido.get(0));

		produtoExcluido = produtoRN.listar();
		assertEquals(5, produtoExcluido.size());
	}
}
