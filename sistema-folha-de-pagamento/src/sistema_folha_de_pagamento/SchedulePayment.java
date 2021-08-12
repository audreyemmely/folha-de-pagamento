package sistema_folha_de_pagamento;

import java.util.ArrayList;

public class SchedulePayment {
	
	public static void weeklyPayment(ArrayList<Employees> employees, int weeklyDay) {
		for (int i = 0; i < employees.size(); ++i) {
			if(employees.get(i).getScheduleType().equals("SEMANAL") && employees.get(i).getPaymentWeeklyDay() == weeklyDay) {
				System.out.println("ID: " + employees.get(i).getEmployeeId() +
									"\nNome: " + employees.get(i).getName() +
									"\nSal�rio: R$ " + ((Hourly )employees.get(i)).setEmployeeLiquidSalary() +
									"\nM�todo de pagamento: " + employees.get(i).getPaymentMethod() + "\n");
				((Hourly )employees.get(i)).setDaySalary();
				employees.get(i).setEmployeeLiquidSalary(0);
			}
		}
	}
	
	public static void biweeklyPayment(ArrayList<Employees> employees, int weeklyDay) {
		for(int i = 0; i < employees.size(); ++i) {
			if(employees.get(i).getScheduleType().equals("BI-SEMANAL") && employees.get(i).getPaymentWeeklyDay() == weeklyDay) {
				System.out.println("ID: " + employees.get(i).getEmployeeId() + "\nNome: " + employees.get(i).getName() +
									"\nSal�rio: R$ " + ((Commissioned )employees.get(i)).setEmployeeLiquidSalary() +
									"\nM�todo de pagamento: " + employees.get(i).getPaymentMethod() + "\n");
				employees.get(i).setEmployeeLiquidSalary(0);
			}
		}
	}
	
	public static void monthlyPayment(ArrayList<Employees> employees, int paymentDate) {
		for(int i = 0; i < employees.size(); ++i) {
			if(employees.get(i).getScheduleType().equals("MENSAL") && employees.get(i).getPaymentDate() == paymentDate) {
                System.out.println("ID: " + employees.get(i).getEmployeeId() + "\nNome: " + employees.get(i).getName() +
                					"\nSal�rio: R$ " +((Salaried )employees.get(i)).setEmployeeLiquidSalary() + 
                					"\nM�todo de pagamento: " + employees.get(i).getPaymentMethod() + "\n");
                employees.get(i).setEmployeeLiquidSalary(0);
			}
		}
	}
	
}