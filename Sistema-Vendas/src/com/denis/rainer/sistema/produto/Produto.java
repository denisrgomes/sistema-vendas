package com.denis.rainer.sistema.produto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer estoque;
	private String descricao;
	@Column(name="data_cadastro")
	private Date dataCadastro;
	private float valor;
	private String unidade;
	
	
	public Produto(){
		
	};
	
	public Produto(Integer estoque, String descricao, Date dataCadastro,
			float valor, String unidade) {
		
		this.estoque = estoque;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.valor = valor;
		this.unidade = unidade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date data_cadastro) {
		this.dataCadastro = data_cadastro;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
}
