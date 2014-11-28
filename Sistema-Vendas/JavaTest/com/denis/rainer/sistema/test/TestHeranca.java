package com.denis.rainer.sistema.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.denis.rainer.sistema.util.HibernateUtil;

public abstract class TestHeranca {

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
}
