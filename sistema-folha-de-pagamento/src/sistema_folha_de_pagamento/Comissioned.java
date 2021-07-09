package sistema_folha_de_pagamento;

import java.util.Scanner;

public class Comissioned extends Employees {

	private double salesComission;
	private double salesResult;
	
	public Comissioned(int empId) {
		super.setName();
		super.setAddress();
		super.setMonthlySalary();
		setEmployeeId(empId);
		super.setEmployeeType("COMISSIONADO");
		super.setPaymentMethod("DEPOSITO");
		super.setScheduleType("BI-SEMANAL");
		super.setPaymentDayWeekly(4);
		super.setPaymentDate(-1);
		setSalesComission();
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
	
	public void setSalesComission() {
		double empSalesComission;
		Scanner input = new Scanner(System.in);
		System.out.println("Informe a comissão do empregado (o valor será considerado como porcentagem):");
		empSalesComission = input.nextDouble();
		if(empSalesComission < 0) {
			System.out.println("Por favor, informe um valor maior que 0.");
		}else {
			this.salesComission = empSalesComission/100;
		}
	}
	
	public double getSalesComission() {
		return this.salesComission;
	}
	
	@Override
	public double setEmployeeLiquidSalary() {
		return this.liquidSalary += this.monthlySalary/2;
	}
	
}