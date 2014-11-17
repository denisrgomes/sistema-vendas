package com.denis.rainer.sistema.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.denis.rainer.sistema.cliente.Cliente;
import com.denis.rainer.sistema.venda.Venda;
import com.denis.rainer.sistema.venda.VendaRN;

public class VendaTest {

	@Test
	public void salvarVendaTest() {
		
		Venda v1 = new Venda();
		
		VendaRN vendaRN = new VendaRN();
		vendaRN.salvar(v1);
	}

}
