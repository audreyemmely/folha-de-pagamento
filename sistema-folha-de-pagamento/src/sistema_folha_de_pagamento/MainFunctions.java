package sistema_folha_de_pagamento;

import java.util.ArrayList;
import java.util.Scanner;

public class MainFunctions {
	private ArrayList<Employees> employeesList;
	private ArrayList<String> newSchedule;
	private int employeeId = 0;
	
	public ArrayList<Employees> getEmployeesList() {
		return this.employeesList;
	}
	
	//Constructor
	public MainFunctions(boolean start) {
		employeesList = new ArrayList<Employees>();
		newSchedule = new ArrayList<String>();
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
			System.out.println("Empregado assalariado adicionado ao sistema com sucesso!\n");
		}else if(empType == 2) {
			employeeId++;
			aux = new Commissioned(employeeId);
			employeesList.add(aux);
			System.out.println("Empregado comissionado adicionado ao sistema com sucesso!\n");
		}else if(empType == 3) {
			employeeId++;
			aux = new Hourly(employeeId);
			employeesList.add(aux);
			System.out.println("Empregado horista adicionado ao sistema com sucesso!\n");
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
				System.out.println("O empregado com ID " + empId + " não é horista.\n");
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
		System.out.println("Informe o ID do empregado ao qual deve ser lançada uma taxa de servico: ");
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
				System.out.println("O empregado escolhido é do tipo " + employeesList.get(index).getEmployeeType());
				int empType = 0;
				if(employeesList.get(index).getEmployeeType().equals("ASSALARIADO")) {
					System.out.println("Informe o novo tipo de empregado:\n[2] - COMISSIONADO\n[3] - HORISTA");
					empType = input.nextInt();
					if(empType == 2) {
						employeesList.get(index).setMonthlySalary();
						employeesList.get(index).setEmployeeType("COMISSIONADO");
						employeesList.get(index).setScheduleType("BI-SEMANAL");
						employeesList.get(index).setPaymentWeeklyDay(4);
						employeesList.get(index).setPaymentDate(-1);
						((Commissioned) employeesList.get(index)).setSalesResult();
						System.out.println("Tipo de empregado alterado com sucesso.");
					}else if(empType == 3) {
						((Hourly) employeesList.get(index)).setHourlyWage();
						employeesList.get(index).setEmployeeType("HORISTA");
						employeesList.get(index).setScheduleType("SEMANAL");
						employeesList.get(index).setPaymentWeeklyDay(4);
						employeesList.get(index).setPaymentDate(-1);
						System.out.println("Tipo de empregado alterado com sucesso.");
					}else {
						System.out.println("Tipo de empregado não encontrado.");
					}
				}else if(employeesList.get(index).getEmployeeType().equals("COMISSIONADO")) {
					System.out.println("Informe o novo tipo de empregado:\n[1] - ASSALARIADO\n[3] - HORISTA");
					empType = input.nextInt();
					if(empType == 1) {
						employeesList.get(index).setEmployeeLiquidSalary();
						employeesList.get(index).setEmployeeType("ASSALARIADO");
						employeesList.get(index).setScheduleType("MENSAL");
						employeesList.get(index).setPaymentWeeklyDay(-1);
						employeesList.get(index).setPaymentDate(27);
						System.out.println("Tipo de empregado alterado com sucesso.");
					}else if(empType == 3) {
						((Hourly) employeesList.get(index)).setHourlyWage();
						employeesList.get(index).setEmployeeType("HORISTA");
						employeesList.get(index).setScheduleType("SEMANAL");
						employeesList.get(index).setPaymentWeeklyDay(4);
						employeesList.get(index).setPaymentDate(-1);
						System.out.println("Tipo de empregado alterado com sucesso.");
					}else {
						System.out.println("Tipo de empregado não encontrado.");
					}
				}else if(employeesList.get(index).getEmployeeType().equals("HORISTA")) {
					System.out.println("Informe o novo tipo de empregado:\n[1] - ASSALARIADO\n[2] - COMISSIONADO");
					empType = input.nextInt();	
					if(empType == 1) {
						employeesList.get(index).setEmployeeLiquidSalary();
						employeesList.get(index).setEmployeeType("ASSALARIADO");
						employeesList.get(index).setScheduleType("MENSAL");
						employeesList.get(index).setPaymentWeeklyDay(-1);
						employeesList.get(index).setPaymentDate(27);
						System.out.println("Tipo de empregado alterado com sucesso.");
					}else if(empType == 2) {
						employeesList.get(index).setMonthlySalary();
						employeesList.get(index).setEmployeeType("COMISSIONADO");
						employeesList.get(index).setScheduleType("BI-SEMANAL");
						employeesList.get(index).setPaymentWeeklyDay(4);
						employeesList.get(index).setPaymentDate(-1);
						((Commissioned) employeesList.get(index)).setSalesResult();
						System.out.println("Tipo de empregado alterado com sucesso.");
					}else {
						System.out.println("Tipo de empregado não encontrado.");
					}
				}
			}else if(choice == 4) {
				System.out.println("O empregado recebe da seguinte forma: " + employeesList.get(index).getPaymentMethod());
				int paymentType;
				if(employeesList.get(index).getPaymentMethod().equals("CORREIOS")) {
					System.out.println("Informe o novo tipo de pagamento:\n[1] - DEPOSITO\n[2] - EM MAOS");
					paymentType = input.nextInt();
					if(paymentType == 1) {
						employeesList.get(index).setPaymentMethod("DEPOSITO");
						System.out.println("Tipo de pagamento alterado com sucesso.");
					}else if(paymentType == 2) {
						employeesList.get(index).setPaymentMethod("EM MAOS");
						System.out.println("Tipo de pagamento alterado com sucesso.");
					}else {
						System.out.println("O tipo de pagamento informado não é válido.");
					}
				}else if(employeesList.get(index).getPaymentMethod().equals("EM MAOS")) {
					System.out.println("Informe o novo tipo de pagamento:\n[1] - DEPOSITO\n[3] - CORREIOS");
					paymentType = input.nextInt();
					if(paymentType == 1) {
						employeesList.get(index).setPaymentMethod("DEPOSITO");
						System.out.println("Tipo de pagamento alterado com sucesso.");
					}else if(paymentType == 3) {
						employeesList.get(index).setPaymentMethod("CORREIOS");
						System.out.println("Tipo de pagamento alterado com sucesso.");
					}else {
						System.out.println("O tipo de pagamento informado não é valido.");
					}
				}else if(employeesList.get(index).getPaymentMethod().equals("DEPOSITO")) {
					System.out.println("Informe o novo tipo de pagamento:\n[2] - EM MAOS\n[3] - CORREIOS");
					paymentType = input.nextInt();
					if(paymentType == 2) {
						employeesList.get(index).setPaymentMethod("EM MAOS");
						System.out.println("Tipo de pagamento alterado com sucesso.");
					}else if(paymentType == 3) {
						employeesList.get(index).setPaymentMethod("CORREIOS");
						System.out.println("Tipo de pagamento alterado com sucesso.");
					}else {
						System.out.println("O tipo de pagamento informado não é valido.");
					}
				}
			}else if(choice == 5) {
				employeesList.get(index).setUnionMembership(employeesList.get(index).getEmployeeId());
				System.out.println("Situacao sindical alterada com sucesso!");
			}else if(choice == 6) {
				if(employeesList.get(index).getUnionEmployee() == true) {
					employeesList.get(index).setUnionId();
					System.out.println("A identificação sindical do empregado foi alterada.");
				}else {
					System.out.println("O empregado informado nao faz parte do sindicato.");
				}
			}else if(choice == 7) {
				if(employeesList.get(index).getUnionEmployee() == true) {
					employeesList.get(index).setUnionFee(employeesList.get(index).getEmployeeId());
					System.out.println("A taxa sindical do empregado foi alterada.");
				}else {
					System.out.println("O empregado informado não faz parte do sindicato.");
				}
			}
		}else {
			System.out.println("O empregado com ID " + empId + " não existe no sistema.\n");
		}
	}
	
	public void runCurrentPayroll() {
		Scanner input = new Scanner(System.in);
		int paymentDay;
		System.out.println("Informe o ano: ");
		int year = input.nextInt();
		System.out.println("Informe o mês: ");
		int month = input.nextInt();
		System.out.println("Informe o dia referente ao mês: ");
		int dayMonth = input.nextInt();
		System.out.println("Informe o dia referente à semana:\n[1] - SEGUNDA\n[2] - TERÇA\n[3] - QUARTA\n[4] - QUINTA\n[5] - SEXTA");
		int weekDay = input.nextInt();
		
		boolean checkLastDay = Calendar.lastDayMonth(year, month, dayMonth);
		
		if(checkLastDay == true) {
			paymentDay = 28;
		}else {
			paymentDay = dayMonth;
			if(dayMonth > 23 && dayMonth < 29) {
				SchedulePayment.monthlyPayment(employeesList, paymentDay - 1);
			}
		}
		SchedulePayment.weeklyPayment(employeesList, weekDay - 1);
		
		if((dayMonth > 7 && dayMonth < 15) || (dayMonth > 21 && dayMonth < 29)) {
			SchedulePayment.biweeklyPayment(employeesList, weekDay - 1);
		}
	}
	
	public void undoRedo() {
		System.out.println("Indisponível no momento.");
	}
	
	public void printNewSchedulesList() {
		if(newSchedule.size() == 0) {
			System.out.println("Não há novas agendas.\n");
		}else {
			for(int i = 0; i < newSchedule.size(); ++i) {
				int index = i;
				index++;
				System.out.println("Agenda " + index + ": " + newSchedule.get(i));
			}
		}
	}
	
	public void changeSchedulePayment() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o ID do empregado que deseja alterar a agenda: ");
		printEmployeesList();
		int empId = input.nextInt();
		int index = -1;
		index = searchEmployeeId(employeesList, empId);
		
		if(index != -1) {
			System.out.println("Qual o tipo de agenda que o empregado fará parte agora?\n[1] - SEMANAL\n[2] - BI-SEMANAL\n[3] - MENSAL");
			int option = input.nextInt();
			if(option == 1) {
				if(employeesList.get(index).getScheduleType().equals("SEMANAL")) {
					System.out.println("O empregado já está cadastrado na agenda semanal.");
				}else {
					employeesList.get(index).setScheduleType("SEMANAL");
					employeesList.get(index).setPaymentWeeklyDay(4);
					employeesList.get(index).setPaymentDate(-1);
					System.out.println("Tipo de agenda alterada com sucesso.");
				}
			} else if(option == 2) {
				if(employeesList.get(index).getScheduleType().equals("BI-SEMANAL")) {
					System.out.println("O empregado já está cadastrado na agenda bi-semanal.");
				}else {
					employeesList.get(index).setScheduleType("BI-SEMANAL");
					employeesList.get(index).setPaymentWeeklyDay(4);
					employeesList.get(index).setPaymentDate(-1);
					System.out.println("Tipo de agenda alterada com sucesso.");
				}
			} else if(option == 3) {
				if(employeesList.get(index).getScheduleType().equals("MENSAL")) {
					System.out.println("O empregado já está cadastrado na agenda mensal.");
				}else {
					employeesList.get(index).setScheduleType("MENSAL");
					employeesList.get(index).setPaymentWeeklyDay(-1);
					employeesList.get(index).setPaymentDate(27);
					System.out.println("Tipo de agenda alterada com sucesso.");
				}
			}else {
				System.out.println("O tipo de agenda informada não existe.");
			}
		}else {
			System.out.println("O empregado informado não existe.");
		}
	}
	
	public void createNewSchedulePayment() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o tipo de agenda a ser criada:  (exeplo: mensal 1 / mensal $ / semanal 1 segunda / semanal 2 segunda)");
		String newSchedulePayment = input.nextLine();
		int dayMonthPayment = 0;
		int weeklyPayment = 0;
		String[] aux;
		aux = newSchedulePayment.split(" ");
		
		if(aux.length == 2) {
			if(aux[0].equals("mensal")) {
				if(aux[1].equals("$")) {
					newSchedule.add(newSchedulePayment);
				}else {
					dayMonthPayment = Integer.parseInt(aux[1]);
					if(dayMonthPayment >= 1 && dayMonthPayment <= 27) {
						newSchedule.add(newSchedulePayment);
					}else {
						System.out.println("Data de pagamento inválida.");
					}
				}
			}else {
				System.out.println("Tipo de agenda inválido.");
			}
		}else if(aux.length == 3) {
			if(aux[0].equals("semanal")) {
				weeklyPayment = Integer.parseInt(aux[1]);
				if(weeklyPayment >= 1 && weeklyPayment <= 4) {
					if(aux[2].equals("segunda") || aux[2].equals("terça") || aux[2].equals("quarta") || aux[2].equals("quinta") || aux[2].equals("sexta")) {
						newSchedule.add(newSchedulePayment);
					}else {
						System.out.println("O dia informado é inválido.");
					}
				}else {
					System.out.println("O número da semana informado é inválido.");
				}
			}else {
				System.out.println("Tipo de agenda inválido.");
			}
		}
		printNewSchedulesList();
	}
	
}