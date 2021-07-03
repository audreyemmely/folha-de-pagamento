package sistema_folha_de_pagamento;

import java.util.Scanner;

public class CartaoPonto {
	public static void definirCartaoPonto(Horista empHorista) {
		Scanner input = new Scanner(System.in);
		double horas, horaEntrada, horaSaida;
		System.out.println("Informe a hora de entrada (formato 24h): ");
		horaEntrada = input.nextInt();
		System.out.println("Informe a hora de saída (formato 24h): ");
		horaSaida = input.nextInt();
		if(horaEntrada > horaSaida) {
			System.out.println("Hora de entrada maior que a hora de saída!");
		}else {
			horas = horaSaida - horaEntrada;
			if(horas > 24) {
				System.out.println("Horas trabalhadas: " + horas);
				empHorista.definirSalarioDia(horas);
				System.out.println("Cartão de ponto inserido no sistema.");
			}
		}
	}
	
}