package sistema_folha_de_pagamento;

public class Assalariado extends Empregados {
	
	public Assalariado(int idEmp) {
		super.definirNome();
		super.definirEndereco();
		super.definirSalarioMensal();
		super.definirIdEmpregado(idEmp);
		super.definirTipoEmpregado("ASSALARIADO");
		super.definirMetodoPagamento("DEPOSITO");
		super.definirTipoAgenda("MENSAL");
		super.definirDiaSemanaPagamento(-1);
		super.definirDataPagamento(27);
		this.empregadoSindicalista = false;
	}
	
	@Override
	public double definirSalarioLiquidoEmpregado() {
		return this.salarioLiquido += this.salarioMensal - pegarTaxaSindicato() - pegarOutrasTaxas();
	}

}