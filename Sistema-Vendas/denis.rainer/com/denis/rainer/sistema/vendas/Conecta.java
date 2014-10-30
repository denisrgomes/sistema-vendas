package com.denis.rainer.sistema.vendas;
import org.hibernate.Session;

public class Conecta {
	
	public static void main(String[] args) {
		Session session = null;
		
		try {
			
			session = HibernateUtil.getSession().openSession();
			System.out.println("Conectou!!");
		} finally{
			session.close();
			System.out.println("Desconectou!!");
		}
	}
}
