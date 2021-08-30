package employees;

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
		super.setPaymentWeeklyDay(-1);
		super.setPaymentDate(27);
		this.unionEmployee = false;
	}
	
	public double getGrossSalary() {
		return this.grossSalary = this.monthlySalary;
	}
	
	@Override
	public double setEmployeeLiquidSalary() {
		return this.liquidSalary += getGrossSalary() - getUnionFee() - getOthersFee();
	}

}