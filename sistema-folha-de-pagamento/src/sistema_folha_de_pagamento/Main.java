package sistema_folha_de_pagamento;

import java.util.Scanner;

public class Main {
	private static Extra_funs sistemaFolhaDePagamento = new Extra_funs(true);
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int opcao;
		boolean varAux = true;
		
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
			}else{
				varAux = false;
			}
					
		}
	}
	
	public static void menuSistema() {
		System.out.println("Bem-vindo/a ao Sistema de Folha de Pagamento!");
		System.out.println("0 - Sair do Sistema");
		System.out.println("1 - Adicionar empregado");
	}
}