package sistema_folha_de_pagamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Extra_funs {
	private ArrayList<Empregados> listaEmpregados;
	private int idEmpregado = 0;
	
	public ArrayList<Empregados> pegarListaEmpregados() {
		return this.listaEmpregados;
	}
	
	public Extra_funs(boolean activate) {
		listaEmpregados = new ArrayList<Empregados>();
	}
	
	public int procurarIdEmpregado(ArrayList<Empregados> emp, int idEmp) {
		int index = -1;
		if(emp == null) {
			index = -1;
		}else {
			for(int i = 0; i < emp.size(); ++i) {
				if(emp.get(i).pegarIdEmpregado()==idEmp) {
					index = i;
				}
			}
		}
		return index;
	}
	
	public void printListaEmpregados() {
		if (listaEmpregados.size() == 0) {
			System.out.println("No momento não há empregados cadastrados no sistema!");
		}else {
			for(int i = 0; i < listaEmpregados.size(); ++i) {
				System.out.println(listaEmpregados.get(i).toString());
			}
		}
	}
	
	public void adcEmpregado() {
		Scanner input = new Scanner(System.in);
		Empregados aux = null;
		int tipoEmp;
		
		System.out.println("Informe o tipo de empregado:\n1 - ASSALARIADO\n2 - COMISSIONADO\n3 - HORISTA");
		tipoEmp = input.nextInt();
		
		if(tipoEmp == 1) {
			idEmpregado++;
			aux = new Assalariado(idEmpregado);
			listaEmpregados.add(aux);
			System.out.println("Empregado assalariado adicionado ao sistema com sucesso!");
		}else if(tipoEmp == 2) {
			idEmpregado++;
			aux = new Comissionado(idEmpregado);
			listaEmpregados.add(aux);
			System.out.println("Empregado comissionado adicionado ao sistema com sucesso!");
		}else if(tipoEmp == 3) {
			idEmpregado++;
			aux = new Horista(idEmpregado);
			listaEmpregados.add(aux);
			System.out.println("Empregado horista adicionado ao sistema com sucesso!");
		}else {
			System.out.println("Por favor, informe um tipo de empregado válido.\n");
		}
	}
	
	public void removerEmpregado() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o ID do empregado a ser removido: ");
		printListaEmpregados();
		int idEmp = input.nextInt();
		int index = -1;
		index = procurarIdEmpregado(listaEmpregados, idEmp);
		
		if(index != -1) {
			listaEmpregados.remove(index);
			System.out.println("O empregado com ID " + idEmp + " foi removido do sistema!");
		}else {
			System.out.println("O empregado com ID " + idEmp + " não existe.");
		}
	}
	
	public void lancarCartaoPonto() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o ID do empregado para lançar o cartão de ponto: ");
		printListaEmpregados();
		int idEmp = input.nextInt();
		int index = -1;
		index = procurarIdEmpregado(listaEmpregados, idEmp);
		
		if (index != -1) {
			if(listaEmpregados.get(index).pegarTipoEmpregado().equals("HORISTA")) {
				CartaoPonto.definirCartaoPonto((Horista) listaEmpregados.get(index));	
			}else {
				System.out.println("O empregado com ID " + idEmp + "não é horista.");
			}
		}else {
			System.out.println("O empregado com ID " + idEmp + " não existe.");
		}
	}
	
	public void adcResultadoVendas() {
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o ID do empregado para lançar o resultado das vendas: ");
		printListaEmpregados();
		int idEmp = input.nextInt();
		int index = -1;
		index = procurarIdEmpregado(listaEmpregados, idEmp);
		
		// falta fazer o if para essa situação
	}
	
}