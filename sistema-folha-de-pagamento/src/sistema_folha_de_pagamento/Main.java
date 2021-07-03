package sistema_folha_de_pagamento;

import java.util.Scanner;

public class Main {
	private static Extra_funs sistemaFolhaDePagamento = new Extra_funs(true);
	
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
			}else if(opcao == 5) {
				System.out.println("==== Função lançar uma taxa de serviço ====");
			}else if(opcao == 6) {
				System.out.println("==== Função alterar detalhes de um empregado ====");
			}else if(opcao == 7) {
				//a fazer
			}else if(opcao == 8) {
				//a fazer
			}else if(opcao == 9) {
				//a fazer
			}else if(opcao == 10) {
				//a fazer
			}else {
				varAux = false;
			}					
		}
	}
	
	public static void menuSistema() {
		System.out.println("Bem-vindo/a ao Sistema de Folha de Pagamento!");
		System.out.println("0 - Sair do Sistema");
		System.out.println("1 - Adicionar empregado");
		System.out.println("2 - Remover empregado");
		System.out.println("3 - Lançar um cartão de ponto");
		System.out.println("4 - Lançar um resultado da venda");
		System.out.println("5 - Lançar uma taxa de serviço");
		System.out.println("6 - Alterar detalhes de um empregado");
//		System.out.println("7 - Rodar folha de pagamento do dia");
//		System.out.println("8 - Undo/Redo");
//		System.out.println("9 - Agenda de pagamento");
//		System.out.println("10 - Criar novas agendas de pagamento");
	}
	
}