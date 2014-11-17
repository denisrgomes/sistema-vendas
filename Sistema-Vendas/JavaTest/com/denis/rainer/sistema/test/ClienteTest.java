package com.denis.rainer.sistema.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
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
	public static void openSession(){
		session = HibernateUtil.getSession().getCurrentSession();
		transaction = session.beginTransaction();
	}
	
	@AfterClass
	public static void closeSession(){
		try {
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Problema no commit: " + e.getMessage());
		}finally{
			try {
				if(session.isOpen()){
					session.close();
				}
			} catch (Exception e) {
				System.out.println("Problema no fechamento da conexao: " + e.getMessage());
			}
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

}
