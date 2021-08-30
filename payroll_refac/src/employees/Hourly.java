package employees;

import java.util.Scanner;

public class Hourly extends Employees {
	private double hourlyWage;
	private double daySalary;
	
	public Hourly(int empId) {
		super.setName();
		super.setAddress();
		super.setEmployeeId(empId);
		setHourlyWage();
		super.setEmployeeType("HORISTA");
		super.setPaymentMethod("DEPOSITO");
		super.setScheduleType("SEMANAL");
		super.setPaymentWeeklyDay(4);
		super.setPaymentDate(-1);
		this.unionEmployee = false;
	}
	
	public void setHourlyWage() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o salário por hora:");
		double salary = input.nextDouble();
		if(salary < 0) {
			System.out.println("Por favor, informe um valor maior que 0.");
		}else {
			this.hourlyWage = salary;
		}
	}
	
	public double getHourlyWage() {
		return this.hourlyWage;
	}
	
	public void setDaySalary() {
		double empDaySalary = 0.0;
		this.grossSalary = empDaySalary;
	}
	
	public void getDaySalary(double workedHours) {
		if(workedHours <= 8) {
			this.grossSalary = workedHours * this.hourlyWage;
		}else {
			this.grossSalary = 8 * this.hourlyWage + (workedHours - 8) * (1.5 * this.hourlyWage);
		}
		System.out.println("Salário do dia: " + this.grossSalary);
	}
	
	public double getDaySalary() {
		return this.grossSalary;
	}
	
	@Override
	public double setEmployeeLiquidSalary() {
		return this.liquidSalary += this.grossSalary - getUnionFee()/4 - getOthersFee()/4;
	}

}