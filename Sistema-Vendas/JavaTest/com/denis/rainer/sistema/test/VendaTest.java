package com.denis.rainer.sistema.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.denis.rainer.sistema.cliente.Cliente;
import com.denis.rainer.sistema.cliente.ClienteRN;
import com.denis.rainer.sistema.produto.Produto;
import com.denis.rainer.sistema.produto.ProdutoRN;
import com.denis.rainer.sistema.venda.Venda;
import com.denis.rainer.sistema.venda.VendaRN;

public class VendaTest extends TestHeranca {

	Cliente c1;
	Cliente c2;
	Cliente c3;
	Produto p1;
	Produto p2;
	Produto p3;

	@Before
	public void setup() {
		ClienteRN clienteRN = new ClienteRN();

		c1 = new Cliente("64241181520", "cliente1@email.com", "Rua Cliente 1",
				new Date(), "Cliente 1", 1000);
		c2 = new Cliente("78600825431", "cliente2@email.com", "Rua Cliente 2",
				new Date(), "Cliente 2", 1000);
		c3 = new Cliente("81629676489", "cliente3@email.com", "Rua Cliente 3",
				new Date(), "Cliente 3", 1000);

		clienteRN.salvar(c1);
		clienteRN.salvar(c2);
		clienteRN.salvar(c3);

		p1 = new Produto(50, "Caderno", new Date(), 7.0f, "lote");
		p2 = new Produto(20, "Regua", new Date(), 2.5f, "kg");
		p3 = new Produto(300, "Papel", new Date(), 1.5f, "fardo");

		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.salvar(p1);
		produtoRN.salvar(p2);
		produtoRN.salvar(p3);

	}

	@After
	public void limpaBanco() {
		VendaRN vendaRN = new VendaRN();
		List<Venda> venda = vendaRN.listar();
		
		for (Venda venda2 : venda) {
			vendaRN.excluir(venda2);
		}
	}
	
	@Test
	public void registrarVendaTest() {

		VendaRN vendaRN = new VendaRN();
		Venda venda1 = new Venda();
		Venda venda2 = new Venda();
		Venda venda3 = new Venda();
		
		venda1.setCliente(c1);
		venda1.setProduto(p1);
		venda1.setDataVenda(new Date());
		
		venda2.setCliente(c2);
		venda2.setProduto(p2);
		venda2.setDataVenda(new Date());
		
		venda3.setCliente(c3);
		venda3.setProduto(p3);
		venda3.setDataVenda(new Date());
		
		vendaRN.registrarVenda(venda1);
		vendaRN.registrarVenda(venda2);
		vendaRN.registrarVenda(venda3);
		
		List<Venda> vendas = vendaRN.listar();
		
		assertEquals(3,vendas.size());
	}

}
