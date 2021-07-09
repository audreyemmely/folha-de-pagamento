package sistema_folha_de_pagamento;

public class Salaried extends Employees {
	//Constructor
	public Salaried(int empId) {
		super.setName();
		super.setAddress();
		super.setMonthlySalary();
		super.setEmployeeId(empId);
		super.setEmployeeType("ASSALARIADO");
		super.setPaymentMethod("DEPOSITO");
		super.setScheduleType("MENSAL");
		super.setPaymentDayWeekly(-1);
		super.setPaymentDate(27);
		this.unionEmployee = false;
	}
	
	@Override
	public double setEmployeeLiquidSalary() {
		return this.liquidSalary += this.monthlySalary - getUnionFee() - getOthersFee();
	}

}