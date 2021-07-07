package sistema_folha_de_pagamento;

import java.lang.String;
import java.util.Scanner;

public abstract class Empregados {

	private int idEmpregado = 0;
	private String nome;
	private String endereco;
	private String tipoEmpregado;
	
	private String metodoPagamento;
	private String tipoAgenda;
	private int dataPagamento;
	private int diaSemanaPagamento;
	protected double salarioMensal;
	protected double salarioLiquido = 0;
	
	protected boolean empregadoSindicalista = false;
	private int idSindicato = -1;
	private double taxaSindicato = 0;
	private double outrasTaxas = 0;
	
	//Infos principais do empregado
	public void definirNome() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o nome completo do empregado:");
		this.nome = input.nextLine();
	}
	
	public String pegarNome() {
		return this.nome;
	}
	
	public void definirEndereco() {
		Scanner input = new Scanner(System.in);
		this.endereco = input.nextLine();
	}
	
	public String pegarEndereco() {
		return this.endereco;
	}
	
	public boolean pegarEmpregadoSindicalista() {
		return this.empregadoSindicalista;
	}
	
	//Pagamento
	public void definirMetodoPagamento(String metodoPagamentoEmp) {
		this.metodoPagamento = metodoPagamentoEmp;
	}
	
	public String pegarMetodoPagamento() {
		return this.metodoPagamento;
	}
	
	//Id empregado
	public void definirIdEmpregado(int idEmp) {
		this.idEmpregado = idEmp;
	}
	
	public int pegarIdEmpregado() {
		return this.idEmpregado;
	} 
	
	//Tipo de empregado
	public void definirTipoEmpregado(String tipoEmp) {
		this.tipoEmpregado = tipoEmp;
	}
	
	public String pegarTipoEmpregado() {
		return this.tipoEmpregado;
	}
	
	//Tipo de agenda
	public void definirTipoAgenda(String tipoAgendaEmp) {
		this.tipoAgenda = tipoAgendaEmp;
	}
	
	public String pegarTipoAgenda() {
		return this.tipoAgenda;
	}
	
	//Data pagamento
	public void definirDataPagamento(int dataPagEmp) {
		this.dataPagamento = dataPagEmp;
	}
	
	public int pegarDataPagamento() {
		return this.dataPagamento;
	}
	
	//Dia da semana do pagamento
	public void definirDiaSemanaPagamento(int diaSemanaPagamento) {
		 this.diaSemanaPagamento = diaSemanaPagamento;
	}
	
	public int pegarDiaSemanaPagamento() {
		return this.diaSemanaPagamento;
	}
	
	//Salário mensal
	public void definirSalarioMensal() {
		double salarioMensalEmp;
		Scanner input = new Scanner(System.in);
		System.out.print("Informe o salário mensal:\nR$ ");
		salarioMensalEmp = input.nextDouble();
		if(salarioMensalEmp < 0) {
			System.out.println("Salário inválido! Informe um valor maior que 0, por favor.");
		} else {
			this.salarioMensal = salarioMensalEmp;
		}
	}
	
	public double pegarSalarioMensal() {
		return this.salarioMensal;
	}
	
	//Sindicato
	public boolean empregadoSindicalista() {
		return this.empregadoSindicalista;
	}
	
	public void definirIdSindicato(int idEmp) {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o ID do empregado referente ao sindicato: ");
		int novoIdSindicato = input.nextInt();
		this.idSindicato = novoIdSindicato;
	}
	
	public int pegarIdSindicato() {
		return this.idSindicato;
	}
	
	public void definirTaxaSindicato(int idEmp) {
		double taxa;
		Scanner input = new Scanner(System.in);
		System.out.println("Informe a taxa do sindicato: ");
		taxa = input.nextDouble();
		if(taxa < 0) {
			System.out.println("Por favor, insira um valor maior que 0.");
		}else {
			this.taxaSindicato = taxa;
		}
	}
	
	public double pegarTaxaSindicato() {
		return this.taxaSindicato;
	}
	
	public void definirOutrasTaxas() {
		double outrasTaxasEmp;
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o valor total das outras taxas a serem cobradas: ");
		outrasTaxasEmp = input.nextDouble();
		if(outrasTaxasEmp < 0) {
			System.out.println("Por favor, insira um valor maior que 0.");
		}else {
			this.outrasTaxas = outrasTaxasEmp;
		}
	}
	
	public double pegarOutrasTaxas() {
		return this.outrasTaxas;
	}
	
	public void definirFiliacaoSindicato(int idEmp) {
		Scanner input = new Scanner(System.in);
		
		if(this.empregadoSindicalista == true) {
			System.out.println("EMPREGADO FILIADO AO SINDICATO");
			this.empregadoSindicalista = false;
			this.idSindicato = -1;
			this.taxaSindicato = 0;
			this.outrasTaxas = 0;
			System.out.println("SITUAÇÃO ALTERADA: EMPREGADO NÃO FILIADO AO SINDICATO");
		}else {
			System.out.println("EMPREGADO NÃO FILIADO AO SINDICATO");
			this.empregadoSindicalista = true;
			definirIdSindicato(idEmp);
			definirTaxaSindicato(idEmp);
			definirOutrasTaxas();
			System.out.println("SITUAÇÃO ALTERADA: EMPREGADO FILIADO AO SINDICATO");
		}
	}

	//Salário total do empregado
	public double definirSalarioLiquidoEmpregado(double salarioLiquidoEmp) {
		return this.salarioLiquido = salarioLiquidoEmp;
	}
	
	public abstract double definirSalarioLiquidoEmpregado();
	
	@Override
	public String toString() {
		return "ID: " + pegarIdEmpregado() + " ---- " + "Nome: " + pegarNome() + " ---- Tipo: " + pegarTipoEmpregado() + 
				" ---- ID sindicato: " + pegarIdSindicato() + "\n";
	}

}
