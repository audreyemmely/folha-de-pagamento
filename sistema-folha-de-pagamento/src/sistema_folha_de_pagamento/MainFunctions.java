package sistema_folha_de_pagamento;

import java.util.ArrayList;
import java.util.Scanner;

public class MainFunctions {
	private ArrayList<Employees> employeesList;
	private int employeeId = 0;
	
	public ArrayList<Employees> getEmployeesList() {
		return this.employeesList;
	}
	
	//Constructor
	public MainFunctions(boolean start) {
		employeesList = new ArrayList<Employees>();
	}
	
	public int searchEmployeeId(ArrayList<Employees> emp, int empId) {
		int index = -1;
		if(emp == null) {
			index = -1;
		}else {
			for(int i = 0; i < emp.size(); ++i) {
				if(emp.get(i).getEmployeeId()==empId) {
					index = i;
				}
			}
		}
		return index;
	}
	
	public void printEmployeesList() {
		if (employeesList.size() == 0) {
			System.out.println("No momento não há empregados cadastrados no sistema!");
		}else {
			for(int i = 0; i < employeesList.size(); ++i) {
				System.out.println(employeesList.get(i).toString());
			}
		}
	}
	
	public void addEmployee() {
		Scanner input = new Scanner(System.in);
		Employees aux = null;
		int empType;
		
		System.out.println("Informe o tipo de empregado:\n1 - ASSALARIADO\n2 - COMISSIONADO\n3 - HORISTA");
		empType = input.nextInt();
		
		if(empType == 1) {
			employeeId++;
			aux = new Salaried(employeeId);
			employeesList.add(aux);
			System.out.println("Empregado assalariado adicionado ao sistema com sucesso!");
		}else if(empType == 2) {
			employeeId++;
			aux = new Commissioned(employeeId);
			employeesList.add(aux);
			System.out.println("Empregado comissionado adicionado ao sistema com sucesso!");
		}else if(empType == 3) {
			employeeId++;
			aux = new Hourly(employeeId);
			employeesList.add(aux);
			System.out.println("Empregado horista adicionado ao sistema com sucesso!");
		}else {
			System.out.println("Por favor, informe um tipo de empregado válido.\n");
		}
	}
	
	public void deleteEmployee() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o ID do empregado a ser removido: ");
		printEmployeesList();
		int empId = input.nextInt();
		int index = -1;
		index = searchEmployeeId(employeesList, empId);
		
		if(index != -1) {
			employeesList.remove(index);
			System.out.println("O empregado com ID " + empId + " foi removido do sistema!");
		}else {
			System.out.println("O empregado com ID " + empId + " não existe.");
		}
	}
	
	public void launchTimecard() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o ID do empregado para lançar o cartão de ponto: ");
		printEmployeesList();
		int empId = input.nextInt();
		int index = -1;
		index = searchEmployeeId(employeesList, empId);
		
		if (index != -1) {
			if(employeesList.get(index).getEmployeeType().equals("HORISTA")) {
				Timecard.setTimecard((Hourly) employeesList.get(index));	
			}else {
				System.out.println("O empregado com ID " + empId + "não é horista.");
			}
		}else {
			System.out.println("O empregado com ID " + empId + " não existe.");
		}
	}
	
	public void addSalesResult() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o ID do empregado para lançar o resultado das vendas: ");
		printEmployeesList();
		int empId = input.nextInt();
		int index = -1;
		index = searchEmployeeId(employeesList, empId);
		
		if(index != -1) {
			if(employeesList.get(index).getEmployeeType().equals("COMISSIONADO")) {
				((Commissioned) employeesList.get(index)).setSalesResult();
			}else {
				System.out.println("O empregado com ID " + empId + " não é comissionado.");
			}
		}else {
			System.out.println("O empregado com ID " + empId + " não existe.");
		}
	}
	
}