package com.denis.rainer.sistema.venda;

import java.util.List;

public interface VendaDAO {

	public void registrarVenda(Venda venda);

	public List<Venda> listar();

	public void excluir(Venda venda);
}
