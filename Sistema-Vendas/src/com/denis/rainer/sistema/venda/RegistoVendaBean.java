package com.denis.rainer.sistema.venda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.denis.rainer.sistema.cliente.Cliente;
import com.denis.rainer.sistema.cliente.ClienteRN;
import com.denis.rainer.sistema.produto.Produto;
import com.denis.rainer.sistema.produto.ProdutoRN;

@ManagedBean(name = "registroVendas")
@ViewScoped
public class RegistoVendaBean {
	private Cliente clienteSelecionado;
	private Produto produtoSelecionado = new Produto();
	private List<SelectItem> clienteSelect;
	// private List<SelectItem> produtoSelect;
	private List<Produto> carrinhoCompras = new ArrayList<Produto>();

	private float valorTotal;

	public void buscarProduto() {
		ProdutoRN produtoRN = new ProdutoRN();
		Produto produtoPesquisado = new Produto();

		if (this.produtoSelecionado.getDescricao() != null
				&& !this.produtoSelecionado.getDescricao().equals("")) {
			produtoPesquisado = produtoRN.pesquisar(this.produtoSelecionado
					.getDescricao());

			this.carrinhoCompras.add(produtoPesquisado);
			calcularTotal();
		}

	}

	public void excluirProdutoCarrinho() {
		if (this.carrinhoCompras != null && !this.carrinhoCompras.isEmpty()) {
			if (this.produtoSelecionado != null) {
				this.carrinhoCompras.remove(this.produtoSelecionado);
				calcularTotal();
			}
		}

	}

	private void calcularTotal() {
		valorTotal = 0;
		if (!this.carrinhoCompras.isEmpty()) {
			for (Produto p : this.carrinhoCompras) {
				valorTotal += p.getValor();
			}
		}

	}

	public void finalizarVenda() {
		if (!this.carrinhoCompras.isEmpty()) {
			ArrayList<Venda> vendas = new ArrayList<Venda>();
			for (Produto p : this.carrinhoCompras) {
				if (this.clienteSelecionado != null) {
					vendas.add(new Venda(p, this.clienteSelecionado));
				}
			}
			for (Venda venda : vendas) {
				venda.setDataVenda(new Date());
				VendaRN vendaRN = new VendaRN();
				vendaRN.registrarVenda(venda);
			}
		}
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public List<Produto> getCarrinhoCompras() {
		return carrinhoCompras;
	}

	public void setCarrinhoCompras(List<Produto> carrinhoCompras) {
		this.carrinhoCompras = carrinhoCompras;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<SelectItem> getClienteSelect() {
		if (clienteSelect == null) {
			clienteSelect = new ArrayList<SelectItem>();

			ClienteRN clienteRN = new ClienteRN();
			List<Cliente> listaClientes = clienteRN.listar();

			if (listaClientes != null && !listaClientes.isEmpty()) {
				SelectItem item;
				for (Cliente clienteLista : listaClientes) {
					item = new SelectItem(clienteLista, clienteLista.getNome());
					clienteSelect.add(item);

				}
			}

		}

		return clienteSelect;
	}

	public void setClienteSelect(List<SelectItem> clienteSelect) {
		this.clienteSelect = clienteSelect;
	}

}
