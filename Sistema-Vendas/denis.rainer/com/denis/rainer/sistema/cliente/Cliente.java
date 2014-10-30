package com.denis.rainer.sistema.cliente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue
	private Integer id;
	private String cpf;
	private String email;
	private String endereco;
	@Column(name="data_cadastro")
	private Date dataCadastro;
	private String nome;
	private float renda;
}
