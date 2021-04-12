package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter department's name");
		String department = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.print("Worker Leevel:");
		String level = sc.nextLine();
		System.out.print("Base Salary:");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));
		
		// A instanciacao NEW cria os objetos na memoria com os valores passados, neste
		// caso, um objeto associado ao outro

		System.out.print("How many contracts will this employee have?");
		// Agora vai ser montado o contrato com os seus dados e depois será necessário
		// associar ele ao trabalhador
		
		int numberContracts = sc.nextInt();
		for (int i = 0; i <= numberContracts -1; i++) {
			System.out.println("Enter contract number " + i + ":");
			System.out.print("Date(DD/MM/YYYY)");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Enter contract duration: ");
			int duration = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, duration);
			// Contrato criado, com os valores passados, é necessário vinculá-lo ao
			// trabalhador
			// Estes contratos vão estar dentro de uma lista e o addContract faz a adição
			// dos dados na lista, que estão dentro do for
			worker.addContract(contract);
		}
		System.out.println("-----------");
		System.out.println("Enter month and year to calculate income - MM/yyyy");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2)); // Captura caracteres de 0 a 2 da variável
																	// convertendo para Integer
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName()); // Não entendi direito isso
		System.out.println("Income for: " + monthAndYear + " is " + String.format("%.2f",worker.income(year, month)));
		sc.close();
	}

}
