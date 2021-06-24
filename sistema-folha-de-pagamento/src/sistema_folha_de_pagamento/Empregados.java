package sistema_folha_de_pagamento;

import java.lang.String;
import java.util.Scanner;

public class Empregados {
	//organizar melhor esses dados depois
	private int idEmpregado = 0;
	private String nome;
	private String endereco;
	private String tipoEmpregado;
	private String metodoPagamento;
	private String tipoAgenda;
	private int dataPagamento;
	private int diaSemanaPagamento;
	protected double salarioMensal;
	protected double salarioLiquido;
	protected boolean empregadoSindicalista = false;
	private int idSindicato = -1;
	private double taxaSindicato = 0;
	private double outrasTaxas = 0;
	
	//Infos principais do empregado
	public void definirNome() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome completo do empregado:");
		this.nome = input.nextLine();
		input.close();
	}
	
	public String pegarNome() {
		return nome;
	}

	
	public void definirEndereco() {
		Scanner input = new Scanner(System.in);
		this.endereco = input.nextLine();
		input.close();
	}
	
	public String pegarEndereco() {
		return endereco;
	}
	

	
	public boolean pegarEmpregadoSindicalista() {
		return empregadoSindicalista;
	}
	
	//Pagamento
	public void definirMetodoPagamento(String metodoPagamentoEmp) {
		this.metodoPagamento = metodoPagamentoEmp;
	}
	
	public String pegarMetodoPagamento() {
		return metodoPagamento;
	}
	
	//Id empregado
	public void definirIdEmpregado(int idEmpregado) {
		this.idEmpregado = idEmpregado;
	}
	
	public int pegarIdEmpregado() {
		return this.idEmpregado;
	} 
	
	//Tipo de empregado
	public void definirTipoEmpregado(String tipoEmp) {
		this.tipoEmpregado = tipoEmp;
	}
	
	public String pegarTipoEmpregado() {
		return tipoEmpregado;
	}
	
	//Tipo de agenda
	public void definirTipoAgenda(String tipoAgendaEmp) {
		this.tipoAgenda = tipoAgendaEmp;
	}
	
	public String pegarTipoAgenda() {
		return tipoAgenda;
	}
	
	//Data pagamento
	public void definirDataPagamento(int dataPagEmp) {
		this.dataPagamento = dataPagEmp;
	}
	
	public int pegarDataPagamento() {
		return dataPagamento;
	}
	
	//Dia da semana do pagamento
	
	//cansei, depois termino

}