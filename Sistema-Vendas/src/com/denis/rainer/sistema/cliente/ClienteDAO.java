package com.denis.rainer.sistema.cliente;

import java.util.List;

public interface ClienteDAO {

	public void salvar(Cliente cliente);

	public List<Cliente> listar();

	public void excluir(Cliente cliente);
}
