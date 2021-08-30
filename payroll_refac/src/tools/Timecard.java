package tools;

import java.util.Scanner;

import employees.Hourly;

public class Timecard {
	public static void setTimecard(Hourly hourlyEmp) {
		Scanner input = new Scanner(System.in);
		double hours, entryTime, departureTime;
		System.out.println("Informe a hora de entrada (formato 24h): ");
		entryTime = input.nextInt();
		System.out.println("Informe a hora de saída (formato 24h): ");
		departureTime = input.nextInt();
		if(entryTime > departureTime) {
			System.out.println("Hora de entrada maior que a hora de saída!");
		}else {
			hours = departureTime - entryTime;
			if(hours > 24) {
				System.out.println("Informe o horário correto. O funcionário trabalhou mais de 24h.");
			}else {
				System.out.println("Horas trabalhadas: " + hours);
				hourlyEmp.getDaySalary(hours);
				System.out.println("Cartão de ponto inserido no sistema.");
			}
		}
	}
	
}