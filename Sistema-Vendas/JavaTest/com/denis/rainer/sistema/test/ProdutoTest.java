package com.denis.rainer.sistema.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.denis.rainer.sistema.produto.Produto;
import com.denis.rainer.sistema.venda.HibernateUtil;

public class ProdutoTest {

	static Session session;
	static org.hibernate.Transaction transaction;
	
	@BeforeClass
	public static void openSession(){
		session = HibernateUtil.getSession().getCurrentSession();
		transaction = session.beginTransaction();

	}
	
	@AfterClass
	public static void closeSession(){
			try {
				transaction.commit();
				
			}catch (Exception e) {
				System.out.println("Problema no commit: " + e.getMessage());;
			
			}finally{
				try {
					if(session.isOpen()){
						session.close();
						}
				
				}catch (Exception e) {
					System.out.println("Problema no fechamento da conexao: " + e.getMessage());
					
				}
			}
			
	}
	
	@Before
	public void setup(){
		Produto p1 = new Produto(50, "Caderno", new Date(), 7.0f, "lote");
		Produto p2 = new Produto(20, "Regua", new Date(), 2.5f, "kg");
		Produto p3 = new Produto(300, "Papel", new Date(), 1.5f, "fardo");
		Produto p4 = new Produto(10, "Livro", new Date(), 30.0f, "edicao");
		Produto p5 = new Produto(90, "Caneta", new Date(), 1.5f, "caixa");
		Produto p6 = new Produto(1000, "Lapis", new Date(), 1.0f, "un");
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		session.save(p5);
		session.save(p6);
	}
	
	
	@Test
	public void salvarProdutoTest(){
		 String sql = "from Produto p where p.descricao like :descricao";
		 Query consulta = session.createQuery(sql);
		 consulta.setString("descricao", "%Li%");
		 Produto produtoConsultado = (Produto) consulta.uniqueResult();
		 
		 assertEquals("edicao", produtoConsultado.getUnidade());
	}
}