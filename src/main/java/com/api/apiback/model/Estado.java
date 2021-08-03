package com.api.apiback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	@Column
	private String sigla;
	@Column
	private String nome;
	
	public Estado () {
		
	}
	
	public Estado(Long codigo, String sigla, String nome) {
		this.codigo = codigo;
		this.sigla = sigla;
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Estado [codigo=" + codigo + ", sigla=" + sigla + ", nome=" + nome + ", getCodigo()=" + getCodigo()
				+ ", getSigla()=" + getSigla() + ", getNome()=" + getNome() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + "]";
	}

}
