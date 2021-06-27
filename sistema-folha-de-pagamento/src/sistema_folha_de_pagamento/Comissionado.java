package sistema_folha_de_pagamento;

import java.util.Scanner;

public class Comissionado extends Empregados {

	private double comissaoVendas;
	private double resultadoVendas;
	
	public Comissionado(int idEmp) {
		super.definirNome();
		super.definirEndereco();
		super.definirSalarioMensal();
		definirIdEmpregado(idEmp);
		super.definirTipoEmpregado("COMISSIONADO");
		super.definirMetodoPagamento("DEPOSITO");
		super.definirTipoAgenda("BI-SEMANAL");
		super.definirDiaSemanaPagamento(4);
		super.definirDataPagamento(-1);
		definirComissaoVendas();
		this.empregadoSindicalista = false;
	}
	
	public void definirResultadoVendas() {
		double resultadoVendasEmp;
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o resultado das vendas:");
		resultadoVendasEmp = input.nextDouble();
		input.close();
		if(resultadoVendasEmp < 0) {
			System.out.println("Por favor, informe um valor maior que 0.");
		}else {
			this.resultadoVendas = resultadoVendasEmp;
		}
	}
	
	public double pegarResultadoVendas() {
		return this.resultadoVendas;
	}
	
	public void definirComissaoVendas() {
		double comissaoVendasEmp;
		Scanner input = new Scanner(System.in);
		System.out.println("Informe a comissão do empregado (o valor será considerado como porcentagem):");
		comissaoVendasEmp = input.nextDouble();
		input.close();
		if(comissaoVendasEmp < 0) {
			System.out.println("Por favor, informe um valor maior que 0.");
		}else {
			this.comissaoVendas = comissaoVendasEmp/100;
		}
	}
	
	public double pegarComissaoVendas() {
		return this.comissaoVendas;
	}
	
	@Override
	public double definirSalarioLiquidoEmpregado() {
		return this.salarioLiquido += this.salarioMensal/2;
	}
	
}