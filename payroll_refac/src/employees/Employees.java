package employees;

import java.lang.String;
import java.util.Scanner;

public abstract class Employees {

	private int employeeId = 0;
	private String name;
	private String address;
	private String employeeType;
	
	private String paymentMethod;
	private String scheduleType;
	private int paymentDate;
	private int paymentWeeklyDay;
	protected double monthlySalary;
	protected double grossSalary = 0;
	protected double liquidSalary = 0;
	
	protected boolean unionEmployee = false;
	private int unionId = -1;
	private double unionFee = 0;
	private double othersFee = 0;
	
	//Infos about employee
	public void setName() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o nome completo do empregado:");
		this.name = input.nextLine();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAddress() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o endereço do empregado:");
		this.address = input.nextLine();
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public boolean getUnionEmployee() {
		return this.unionEmployee;
	}
	
	//Payment
	public void setPaymentMethod(String empPaymentMethod) {
		this.paymentMethod = empPaymentMethod;
	}
	
	public String getPaymentMethod() {
		return this.paymentMethod;
	}
	
	//Employee id
	public void setEmployeeId(int empId) {
		this.employeeId = empId;
	}
	
	public int getEmployeeId() {
		return this.employeeId;
	} 
	
	//Employee type
	public void setEmployeeType(String empType) {
		this.employeeType = empType;
	}
	
	public String getEmployeeType() {
		return this.employeeType;
	}
	
	//Schedule type
	public void setScheduleType(String empScheduleType) {
		this.scheduleType = empScheduleType;
	}
	
	public String getScheduleType() {
		return this.scheduleType;
	}
	
	//Payment date
	public void setPaymentDate(int empPaymentDate) {
		this.paymentDate = empPaymentDate;
	}
	
	public int getPaymentDate() {
		return this.paymentDate;
	}
	
	//Payment day weekly
	public void setPaymentWeeklyDay(int empPaymentWeeklyDay) {
		 this.paymentWeeklyDay = empPaymentWeeklyDay;
	}
	
	public int getPaymentWeeklyDay() {
		return this.paymentWeeklyDay;
	}
	
	//Monthly salary
	public void setMonthlySalary() {
		double empMonthlySalary;
		Scanner input = new Scanner(System.in);
		System.out.print("Informe o salário mensal:\nR$ ");
		empMonthlySalary = input.nextDouble();
		if(empMonthlySalary < 0) {
			System.out.println("Salário inválido! Informe um valor maior que 0, por favor.");
		} else {
			this.monthlySalary = empMonthlySalary;
		}
	}
	
	public double getMonthlySalary() {
		return this.monthlySalary;
	}
	
	//Syndicate
	public boolean unionEmployee() {
		return this.unionEmployee;
	}
	
	public void setUnionId(int empId) {
		empId = this.employeeId*10;
		this.unionId = empId;
	}
	
	public void setUnionId() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o novo ID do empregado referente ao sindicato: ");
		int newUnionId = input.nextInt();
		this.unionId = newUnionId;
	}
	
	public int getUnionId() {
		return this.unionId;
	}
	
	public void setUnionFee(int empId) {
		double fee;
		Scanner input = new Scanner(System.in);
		System.out.println("Informe a taxa do sindicato: ");
		fee = input.nextDouble();
		if(fee < 0) {
			System.out.println("Por favor, insira um valor maior que 0.");
		}else {
			this.unionFee = fee;
		}
	}
	
	public double getUnionFee() {
		return this.unionFee;
	}
	
	public void setOthersFee() {
		double empOthersFee;
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o valor total das outras taxas a serem cobradas: ");
		empOthersFee = input.nextDouble();
		if(empOthersFee < 0) {
			System.out.println("Por favor, insira um valor maior que 0.");
		}else {
			this.othersFee = empOthersFee;
		}
	}
	
	public double getOthersFee() {
		return this.othersFee;
	}
	
	public void setUnionMembership(int empId) {
		Scanner input = new Scanner(System.in);
		
		if(this.unionEmployee == true) {
			System.out.println("EMPREGADO FILIADO AO SINDICATO");
			this.unionEmployee = false;
			this.unionId = -1;
			this.unionFee = 0;
			this.othersFee = 0;
			System.out.println("SITUAÇÃO ALTERADA: EMPREGADO NÃO FILIADO AO SINDICATO");
		}else {
			System.out.println("EMPREGADO NÃO FILIADO AO SINDICATO");
			this.unionEmployee = true;
			setUnionId(empId);
			setUnionFee(empId);
			setOthersFee();
			System.out.println("SITUAÇÃO ALTERADA: EMPREGADO FILIADO AO SINDICATO");
		}
	}

	//Employee salary
	public double setEmployeeLiquidSalary(double empLiquidSalary) {
		return this.liquidSalary = empLiquidSalary;
	}
	
	public abstract double setEmployeeLiquidSalary();
	
	@Override
	public String toString() {
		return "ID: " + getEmployeeId() + " ---- " + "Nome: " + getName() + " ---- Tipo: " + getEmployeeType() + 
				" ---- ID sindicato: " + getUnionId() + "\n";
	}

}