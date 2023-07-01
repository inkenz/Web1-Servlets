package br.ufscar.dc.dsw.domain;

public class Site{
	private String email;
	private String senha;
	private String URL;
	private String nome;
	private String telefone;
	
	public Site(String email, String senha, String endereco, String nome, String telefone){
		this.email = email;
		this.senha = senha;
		this.URL = endereco;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getURL() {
		return URL;
	}
	
	public void setURL(String uRL) {
		URL = uRL;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}