package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.InstGenerator;
import model.services.PayPal;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados do contrato");
		System.out.print("Numero: ");
		int contractNumber = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate contractDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Valor do contrato: ");
		double contractValue = sc.nextDouble();
		
		Contract contract = new Contract(contractNumber, contractDate, contractValue);
		
		System.out.print("Entre com o numero de parcelas: ");
		int qtdInstallment = sc.nextInt();
		
		InstGenerator ig = new InstGenerator(qtdInstallment, new PayPal());
		ig.processInstallments(contract);
		
		System.out.println("\nParcelas: ");
		for (Installment inst : contract.getContInstallments()) {
			System.out.println(inst);
		}
		
		sc.close();
	}

}
