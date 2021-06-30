package sistema_folha_de_pagamento;

import java.util.Scanner;

public class Horista extends Empregados {
	private double salarioPorHora;
	private double salarioDia;
	
	public Horista(int idEmp) {
		super.definirNome();
		super.definirEndereco();
		super.definirIdEmpregado(idEmp);
		definirSalarioPorHora();
		super.definirTipoEmpregado("HORISTA");
		super.definirMetodoPagamento("DEPOSITO");
		super.definirTipoAgenda("SEMANAL");
		super.definirDiaSemanaPagamento(4);
		super.definirDataPagamento(-1);
		this.empregadoSindicalista = false;
	}
	
	public void definirSalarioPorHora() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o salário por hora:");
		double salario = input.nextDouble();
		input.close();
		if(salario < 0) {
			System.out.println("Por favor, informe um valor maior que 0.");
		}else {
			this.salarioPorHora = salario;
		}
	}
	
	public double pegarSalarioPorHorario() {
		return this.salarioPorHora;
	}
	
	public void definirSalarioDia() {
		double salarioDiaEmp = 0.0;
		this.salarioDia = salarioDiaEmp;
	}
	
	public void definirSalarioDia(double horasTrabalhadas) {
		if(horasTrabalhadas <= 8) {
			this.salarioDia = horasTrabalhadas * this.salarioPorHora;
		}else {
			this.salarioDia = 8 * this.salarioPorHora + (horasTrabalhadas - 8) * (1.5 * this.salarioPorHora);
		}
		System.out.println("Salário do dia: " + this.salarioDia);
	}
	
	public double pegarSalarioDia() {
		return this.salarioDia;
	}
	
	@Override
	public double definirSalarioLiquidoEmpregado() {
		return this.salarioLiquido += this.salarioDia - pegarTaxaSindicato()/4 - pegarOutrasTaxas()/4;
	}

}