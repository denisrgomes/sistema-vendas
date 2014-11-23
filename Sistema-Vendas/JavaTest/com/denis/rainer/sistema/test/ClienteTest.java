package com.denis.rainer.sistema.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.denis.rainer.sistema.cliente.Cliente;
import com.denis.rainer.sistema.cliente.ClienteRN;
import com.denis.rainer.sistema.util.HibernateUtil;
import com.sun.org.apache.xpath.internal.operations.Equals;

public class ClienteTest {

	static Session session;
	static Transaction transaction;

	@BeforeClass
	public static void openSession() {
		session = HibernateUtil.getSession().getCurrentSession();
		transaction = session.beginTransaction();
	}

	@AfterClass
	public static void closeSession() {
		try {
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Problema no commit: " + e.getMessage());
		} finally {
			try {
				if (session.isOpen()) {
					session.close();
				}
			} catch (Exception e) {
				System.out.println("Problema no fechamento da conexao: "
						+ e.getMessage());
			}
		}
	}

	@Before
	public void setup() {
		ClienteRN clienteRN = new ClienteRN();

		Cliente c1 = new Cliente("26655387337", "cliente1@email.com",
				"Rua Cliente 1", new Date(), "Cliente 1", 1000);
		Cliente c2 = new Cliente("26655387338", "cliente2@email.com",
				"Rua Cliente 1", new Date(), "Cliente 2", 1000);
		Cliente c3 = new Cliente("26565387339", "cliente3@email.com",
				"Rua Cliente 1", new Date(), "Cliente 3", 1000);

		clienteRN.salvar(c1);
		clienteRN.salvar(c2);
		clienteRN.salvar(c3);
	}

	//@After
	public void limpaBanco() {
		ClienteRN clienteRN = new ClienteRN();
		@SuppressWarnings("unchecked")
		List<Cliente> cliente = clienteRN.listar();

		for (Cliente cliente2 : cliente) {
			clienteRN.excluir(cliente2);
		}
	}

	@Test
	public void salvarTest() {
		Cliente c1 = new Cliente();

		c1.setCpf("123456789");
		c1.setDataCadastro(new Date());
		c1.setEmail("denis@gmail.com");
		c1.setEndereco("Rua");
		c1.setNome("Denis");
		c1.setRenda(900f);

		/*
		 * Regras de negocio do cliente
		 */
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.salvar(c1);

		assertEquals(true, true);
	}

	@Test
	public void listarClienteTest() {

		ClienteRN clienteRN = new ClienteRN();
		List<Cliente> clienteListado = clienteRN.listar();

		assertEquals(3, clienteListado.size());
	}

	@Test
	public void excluir() {
		ClienteRN clienteRN = new ClienteRN();

		List<Cliente> lista = clienteRN.listar();

		Cliente clienteExcluido = lista.get(0);

		clienteRN.excluir(clienteExcluido);

		lista = clienteRN.listar();

		assertEquals(6, lista.size());

	}
	
	@Test
	public void pesquisarTest(){
		ClienteRN clienteRN  = new ClienteRN();
		Cliente clientePesquisado = clienteRN.pesquisar("te 1");
		
		assertEquals("26655387337",clientePesquisado.getCpf());
	}
	
	@Test
	public void alterarTest(){
		ClienteRN clienteRN  = new ClienteRN();
		Cliente clientePesquisado = clienteRN.pesquisar("te 1");
		
		assertEquals("26655387337",clientePesquisado.getCpf());
		
		clientePesquisado.setEndereco("Novo Endereco");
		
		clienteRN.alterar(clientePesquisado);
		
		Cliente clienteAlterado = clienteRN.pesquisar("te 1");
		
		assertEquals("Novo Endereco", clienteAlterado.getEndereco());
	
	}
}
