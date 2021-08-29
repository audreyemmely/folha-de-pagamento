package sistema_folha_de_pagamento;

import java.util.Scanner;

public class Main {
	private static MainFunctions payrollSystem = new MainFunctions(true);

	public static void systemMenu() {
		System.out.println("Bem-vindo/a ao Sistema de Folha de Pagamento!\nInforme a opera��o que deseja realizar no momento.");
		System.out.println("[0] Sair do Sistema\n[1] Adicionar empregado\n[2] Remover empregado\n[3] Lan�ar um cart�o de ponto\n[4] Lan�ar um resultado da venda\n[5] Lancar uma taxa de servi�o");
		System.out.println("[6] Alterar detalhes de um empregado\n[7] Rodar folha de pagamento do dia\n[8] Undo/Redo\n[9] Agenda de pagamento\n[10] Criar novas agendas de pagamentos\n");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int option;
		boolean varAux = true; //variable created to help if the system should shut down or not
		
		while(varAux) {
			systemMenu();
			option = input.nextInt();
			
			if(option == 0) {
				System.out.println("Obrigada por usar o nosso sistema! Volte sempre! :)");
				varAux = false;
			}else if(option == 1) {
				System.out.println("==== Fun��o adi��o de um funcion�rio ====");
				payrollSystem.addEmployee();
				varAux = true;
			}else if(option == 2) {
				System.out.println("==== Fun��o remo��o de um funcion�rio ====");
				payrollSystem.deleteEmployee();
				varAux = true;
			}else if(option == 3) {
				System.out.println("==== Fun��o lan�ar um cart�o de ponto ====");
				payrollSystem.launchTimecard();
				varAux = true;
			}else if(option == 4) {
				System.out.println("==== Fun��o lan�ar um resultado da venda ====");
				payrollSystem.addSalesResult();
				varAux = true;
			}else if(option == 5) {
				System.out.println("==== Fun��o lan�ar uma taxa de servi�o ====");
				payrollSystem.addServiceCharge();
				varAux = true;
			}else if(option == 6) {
				System.out.println("==== Fun��o alterar detalhes de um empregado ====\n");
				payrollSystem.changeEmployeeData();
				varAux = true;
			}else if(option == 7) {
				System.out.println("==== Fun��o rodar a folha de pagamento para hoje ====\n");
				payrollSystem.runCurrentPayroll();
				varAux = true;
			}else if(option == 8) {
				System.out.println("==== Fun��o undo/redo ====\nN�o iniciado.");
				//a fazer
			}else if(option == 9) {
				System.out.println("==== Fun��o agenda de pagamento ====\n");
				payrollSystem.changeSchedulePayment();
				varAux = true;
			}else if(option == 10) {
				System.out.println("==== Fun��o cria��o de novas agendas de pagamento ====\n");
				payrollSystem.createNewSchedulePayment();
				varAux = true;
			}else {
				varAux = false;
			}				
		}
	}
	
}