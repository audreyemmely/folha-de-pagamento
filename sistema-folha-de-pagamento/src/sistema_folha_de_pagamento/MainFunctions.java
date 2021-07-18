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
			System.out.println("No momento não há empregados cadastrados no sistema!\n");
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
			System.out.println("O empregado com ID " + empId + " foi removido do sistema!\n");
		}else {
			System.out.println("O empregado com ID " + empId + " não existe no sistema.\n");
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
				System.out.println("O empregado com ID " + empId + "não é horista.\n");
			}
		}else {
			System.out.println("O empregado com ID " + empId + " não existe no sistema.\n");
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
				System.out.println("O empregado com ID " + empId + " não é comissionado.\n");
			}
		}else {
			System.out.println("O empregado com ID " + empId + " não existe no sistema.\n");
		}
	}
	
	public void addServiceCharge() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o ID do empregado ao qual deve ser lançada uma taxa de serviço: ");
		printEmployeesList();
		int empId = input.nextInt();
		int index = -1;
		index = searchEmployeeId(employeesList, empId);
		
		if(index != -1) {
			if(employeesList.get(index).getUnionEmployee() == true) {
				employeesList.get(index).setOthersFee();
			}else {
				System.out.println("O empregado com ID " + empId + " não faz parte do sindicato.\n");
			}
		}else {
			System.out.println("O empregado com ID " + empId + " não existe no sistema.\n");
		}
	}
	
	public void changeEmployeeData() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o ID do empregado que você deseja alterar os dados:");
		printEmployeesList();
		int empId = input.nextInt();
		int index = -1;
		index = searchEmployeeId(employeesList, empId);
		
		if(index != -1) {
			System.out.println("Qual dado você deseja alterar?\n[1] - Nome\n[2] - Endereço\n"+
								"[3] - Tipo do empregado\n[4] - Método de pagamento\n[5] - Situação sindical\n"+
								"[6] - Identificação no sindicato\n[7] - Taxa sindical\n");
			
			int choice = input.nextInt();
			
			if(choice == 1) {
				employeesList.get(index).setName();
				System.out.println("Nome alterado com sucesso!");
			}else if(choice == 2) {
				employeesList.get(index).setAddress();
				System.out.println("Endereço alterado com sucesso!");
			}else if(choice == 3) {
				System.out.println("O funcionário escolhido é do tipo " + employeesList.get(index).getEmployeeType());
				int empType = 0;
				if(employeesList.get(index).equals("ASSALARIADO")) {
					System.out.println("Informe o novo tipo de empregado:\n[2] - COMISSIONADO\n[3] - HORISTA");
					empType = input.nextInt();
					if(empType == 2) {
						employeesList.get(index).setMonthlySalary();
						employeesList.get(index).setEmployeeType("COMISSIONADO");
						employeesList.get(index).setScheduleType("BI-SEMANAL");
						employeesList.get(index).setPaymentDayWeekly(4);
						employeesList.get(index).setPaymentDate(-1);
						((Commissioned) employeesList.get(index)).setSalesResult();
					}else if(empType == 3) {
						((Hourly) employeesList.get(index)).setHourlyWage();
						employeesList.get(index).setEmployeeType("HORISTA");
						employeesList.get(index).setScheduleType("SEMANAL");
						employeesList.get(index).setPaymentDayWeekly(4);
						employeesList.get(index).setPaymentDate(-1);
					}else {
						System.out.println("Tipo de empregado não encontrado.");
					}
				}else if(employeesList.get(index).equals("COMISSIONADO")) {
					System.out.println("Informe o novo tipo de empregado:\n[1] - ASSALARIADO\n[3] - HORISTA");
					empType = input.nextInt();
					if(empType == 1) {
						employeesList.get(index).setEmployeeLiquidSalary();
						employeesList.get(index).setEmployeeType("ASSALARIADO");
						employeesList.get(index).setScheduleType("MENSAL");
						employeesList.get(index).setPaymentDayWeekly(-1);
						employeesList.get(index).setPaymentDate(27);
					}else if(empType == 3) {
						((Hourly) employeesList.get(index)).setHourlyWage();
						employeesList.get(index).setEmployeeType("HORISTA");
						employeesList.get(index).setScheduleType("SEMANAL");
						employeesList.get(index).setPaymentDayWeekly(4);
						employeesList.get(index).setPaymentDate(-1);
					}else {
						System.out.println("Tipo de empregado não encontrado.");
					}
				}else if(employeesList.get(index).equals("HORISTA")) {
					System.out.println("Informe o novo tipo de empregado:\n[1] - ASSALARIADO\n[3] - COMISSIONADO");
					empType = input.nextInt();	
					if(empType == 1) {
						employeesList.get(index).setEmployeeLiquidSalary();
						employeesList.get(index).setEmployeeType("ASSALARIADO");
						employeesList.get(index).setScheduleType("MENSAL");
						employeesList.get(index).setPaymentDayWeekly(-1);
						employeesList.get(index).setPaymentDate(27);
					}else if(empType == 3) {
						employeesList.get(index).setMonthlySalary();
						employeesList.get(index).setEmployeeType("COMISSIONADO");
						employeesList.get(index).setScheduleType("BI-SEMANAL");
						employeesList.get(index).setPaymentDayWeekly(4);
						employeesList.get(index).setPaymentDate(-1);
						((Commissioned) employeesList.get(index)).setSalesResult();
					}else {
						System.out.println("Tipo de empregado não encontrado.");
					}
				}
			}else if(choice == 4) {
				System.out.println("O funcionário recebe da seguinte forma: " + employeesList.get(index).getPaymentMethod());
				int paymentType;
				if(employeesList.get(index).equals("CORREIOS")) {
					System.out.println("Informe o novo tipo de pagamento:\n[1] - DEPOSITO\n[2] - EM MAOS");
					paymentType = input.nextInt();
					if(paymentType == 1) {
						employeesList.get(index).setPaymentMethod("DEPOSITO");
					}else if(paymentType == 2) {
						employeesList.get(index).setPaymentMethod("EM MAOS");
					}else {
						System.out.println("O tipo de pagamento informado não é válido.");
					}
				}else if(employeesList.get(index).equals("EM MAOS")) {
					System.out.println("Informe o novo tipo de pagamento:\n[1] - DEPOSITO\n[3] - CORREIOS");
					paymentType = input.nextInt();
					if(paymentType == 1) {
						employeesList.get(index).setPaymentMethod("DEPOSITO");
					}else if(paymentType == 3) {
						employeesList.get(index).setPaymentMethod("CORREIOS");
					}else {
						System.out.println("O tipo de pagamento informado não é válido.");
					}
				}else if(employeesList.get(index).equals("DEPOSITO")) {
					System.out.println("Informe o novo tipo de pagamento:\n[2] - EM MAOS\n[3] - CORREIOS");
					paymentType = input.nextInt();
					if(paymentType == 2) {
						employeesList.get(index).setPaymentMethod("EM MAOS");
					}else if(paymentType == 3) {
						employeesList.get(index).setPaymentMethod("CORREIOS");
					}else {
						System.out.println("O tipo de pagamento informado não é válido.");
					}
				}
			}else if(choice == 5) {
				//continuar com coisas do sindicato e etc
			}
		}
	}
}