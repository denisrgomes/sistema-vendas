package com.denis.rainer.sistema.venda;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.denis.rainer.sistema.cliente.Cliente;
import com.denis.rainer.sistema.produto.Produto;
import com.denis.rainer.sistema.produto.ProdutoRN;

@ManagedBean(name = "registroVendas")
@ViewScoped
public class RegistoVendaBean {
	private Cliente clienteSelecionado;
	private Produto produtoSelecionado;
	private List<Produto> carrinhoCompras = new ArrayList<Produto>();

	private float valorTotal;

	
	public void getBuscaProduto(){
		ProdutoRN produtoRN = new ProdutoRN();
		Produto produtoPesquisado = new Produto();
		
		if(this.produtoSelecionado.getDescricao()!=null && !this.produtoSelecionado.getDescricao().equals("")){
			produtoPesquisado = produtoRN.pesquisar(this.produtoSelecionado.getDescricao());
			
			this.carrinhoCompras.add(produtoPesquisado);
			calcularTotal();
		}
	
		
	}
	private void calcularTotal() {
		if(!this.carrinhoCompras.isEmpty()){
			for (Produto p : this.carrinhoCompras) {
				valorTotal += p.getValor();
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

}
