package sistema_folha_de_pagamento;

import java.util.Scanner;

public class Main {
	private static PrincipaisFuncoes sistemaFolhaDePagamento = new PrincipaisFuncoes(true);

	public static void menuSistema() {
		System.out.println("Bem-vindo/a ao Sistema de Folha de Pagamento!\nInforme a operação que deseja realizar no momento.");
		System.out.println("[0] Sair do Sistema\n[1] Adicionar empregado\n[2] Remover empregado\n[3] Lançar um cartão de ponto\n[4] Lançar um resultado da venda\n[5] Lançar uma taxa de serviço");
		System.out.println("[6] Alterar detalhes de um empregado\n[7] Rodar folha de pagamento do dia\n[8] Undo/Redo\n[9] Agenda de pagamento\n[10] Criar novas agendas de pagamentos\n");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcao;
		boolean varAux = true; //variavel criada para auxiliar se o sistema deve encerrar ou nao
		
		while(varAux) {
			menuSistema();
			opcao = input.nextInt();
			
			if(opcao == 0) {
				System.out.println("Obrigada por usar o nosso sistema! Volte sempre! :)");
				varAux = false;
			}else if(opcao == 1) {
				System.out.println("==== Função adição de um empregado ====");
				sistemaFolhaDePagamento.adcEmpregado();
				varAux = true;
			}else if(opcao == 2) {
				System.out.println("==== Função remoção de um empregado ====");
				sistemaFolhaDePagamento.removerEmpregado();
				varAux = true;
			}else if(opcao == 3) {
				System.out.println("==== Função lançar um cartão de ponto ====");
				sistemaFolhaDePagamento.lancarCartaoPonto();
				varAux = true;
			}else if(opcao == 4) {
				System.out.println("==== Função lançar um resultado da venda ====");
				sistemaFolhaDePagamento.adcResultadoVendas();
				varAux = true;
			}else if(opcao == 5) {
				System.out.println("==== Função lançar uma taxa de serviço ====\nEm andamento...");
				//a fazer
			}else if(opcao == 6) {
				System.out.println("==== Função alterar detalhes de um empregado ====\nNão iniciado.");
				//a fazer
			}else if(opcao == 7) {
				System.out.println("==== Função rodar a folha de pagamento para hoje ====\nNão iniciado.");
				//a fazer
			}else if(opcao == 8) {
				System.out.println("==== Função undo/redo ====\nNão iniciado.");
				//a fazer
			}else if(opcao == 9) {
				System.out.println("==== Função agenda de pagamento ====\nNão iniciado.");
				//a fazer
			}else if(opcao == 10) {
				System.out.println("==== Função criação de novas agendas de pagamento ====\nNão iniciado.");
				//a fazer
			}else {
				varAux = false;
			}					
		}
	}
	
}