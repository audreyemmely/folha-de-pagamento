package sistema_folha_de_pagamento;

import java.lang.String;

public class Empregados {
	
	private int id;
	private String nome;
	private String endereco;
	private String metodoPagamento;
	
	public String pegarNome() {
		return nome;
	}
	
	public void definirNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public String pegarEndereco() {
		return endereco;
	}
	
	public void definirEndereco(String novoEndereco) {
		this.endereco = novoEndereco;
	}
	
	public String pegarMetodoPagamento() {
		return metodoPagamento;
	}
	
	public int pegarId() {
		return id;
	} 
	
	public Empregados(int id, String nome, String endereco, String metodo) {
		this.id = id;
		this.definirNome(nome);
		this.definirEndereco(endereco);
		this.metodoPagamento = metodo;
	}
}