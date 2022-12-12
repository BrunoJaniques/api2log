package com.best2log.crm.dto;

public class CredenciaisLoginDTO {
	private String email;
	private String senha;

	public CredenciaisLoginDTO() {
	}

	public CredenciaisLoginDTO(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setPassword(String senha) {
		this.senha = senha;
	}
}