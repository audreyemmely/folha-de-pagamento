package sistema_folha_de_pagamento;

import java.util.Scanner;

public class Commissioned extends Employees {

	private double salesCommission;
	private double salesResult;
	
	public Commissioned(int empId) {
		super.setName();
		super.setAddress();
		super.setMonthlySalary();
		setEmployeeId(empId);
		super.setEmployeeType("COMISSIONADO");
		super.setPaymentMethod("DEPOSITO");
		super.setScheduleType("BI-SEMANAL");
		super.setPaymentWeeklyDay(4);
		super.setPaymentDate(-1);
		setSalesCommission();
		this.unionEmployee = false;
	}
	
	public void setSalesResult() {
		double empSalesResult;
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o resultado das vendas:");
		empSalesResult = input.nextDouble();
		if(empSalesResult < 0) {
			System.out.println("Por favor, informe um valor maior que 0.");
		}else {
			this.salesResult = empSalesResult;
		}
	}
	
	public double getSalesResult() {
		return this.salesResult;
	}
	
	public void setSalesCommission() {
		double empSalesCommission;
		Scanner input = new Scanner(System.in);
		System.out.println("Informe a comissão do empregado (o valor será considerado como porcentagem):");
		empSalesCommission = input.nextDouble();
		if(empSalesCommission < 0) {
			System.out.println("Por favor, informe um valor maior que 0.");
		}else {
			this.salesCommission = empSalesCommission/100;
		}
	}
	
	public double getSalesCommission() {
		return this.salesCommission;
	}
	
	@Override
	public double setEmployeeLiquidSalary() {
		return this.liquidSalary += this.monthlySalary/2 + getSalesCommission()*getSalesResult() - getUnionFee()/2 - getOthersFee()/2;
	}
	
}