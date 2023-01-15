package com.messias.via_cep.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Codebeautify")
public class Codebeautify {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String cep;
	@Column
	private String logradouro;
	@Column
	private String complemento;
	@Column
	private String bairro;
	@Column
	private String localidade;
	@Column
	private String uf;
	@Column
	private String ibge;
	@Column
	private String gia;
	@Column
	private String ddd;
	@Column
	private String siafi;


	// Getter Methods

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}

	public String getIbge() {
		return ibge;
	}

	public String getGia() {
		return gia;
	}

	public String getDdd() {
		return ddd;
	}

	public String getSiafi() {
		return siafi;
	}

	// Setter Methods

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}

	public Codebeautify() {
	}
}
