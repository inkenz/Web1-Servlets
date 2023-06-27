package br.ufscar.dc.dsw.domain;

public class Usuario {

	private String email;
	private String senha;
	private String papel;


	public Usuario(String email, String senha, String papel) {
		this.email = email;
		this.senha = senha;
		this.papel = papel;
	}


	public String getEmail() {
		return this.email;
	}

	public void setLogin(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String password) {
		this.senha = password;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
}
