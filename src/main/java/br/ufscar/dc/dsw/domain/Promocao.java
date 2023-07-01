package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Promocao{
	private long id;
	private String endereco;
	private String CNPJ;
	private float preco;
	private Date inicio;
	private Date fim;
	
	public Promocao(long id, String endereco, String CNPJ, float preco, Date inicio, Date fim){
		this.id = id;
		this.endereco = endereco;
		this.CNPJ = CNPJ;
		this.preco = preco;
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCNPJ() {
		return CNPJ;
	}
	
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public Date getInicio() {
		return inicio;
	}
	
	@SuppressWarnings("deprecation")
	public void setInicio(int ano, int mes, int dia) {
		Date aux = new Date(ano, mes, dia);
		this.inicio = aux;
	}
	
	public Date getFim() {
		return fim;
	}
	
	@SuppressWarnings("deprecation")
	public void setFim(int ano, int mes, int dia) {
		Date aux = new Date(ano, mes, dia);
		this.fim = aux;
	}
	
} 