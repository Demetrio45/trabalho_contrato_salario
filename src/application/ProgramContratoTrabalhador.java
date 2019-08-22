package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class ProgramContratoTrabalhador {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Informe o nome do departamento: ");
		String nomeDepartamento = leia.nextLine();
		System.out.println("Informe os dados do trabalhador:");
		System.out.print("Nome do trabalhador: ");
		String nomeTrabalhador = leia.nextLine();
		System.out.print("Nível: ");
		String nivelTrabalhador = leia.nextLine();
		System.out.print("Salario Base: ");
		double salarioBase = leia.nextDouble();
		
		Trabalhador trabalhador  = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase, new Departamento(nomeDepartamento));

		System.out.print("Quantos contratos o trabalhador possui? ");
		int n = leia.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Contrato #" + i + " data:");
			System.out.print("Data (DD/MM/YYYY): ");
			Date contratoData = sdf.parse(leia.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = leia.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = leia.nextInt();
			ContratoHora contrato = new ContratoHora(contratoData, valorPorHora, horas);
			trabalhador.addContrato(contrato);
			
		}

		System.out.println();
		System.out.print("Informe o mês e ano que deseja verificar o rendimento (MM/YYYY): ");
		String mesEano = leia.next();
		int mes = Integer.parseInt(mesEano.substring(0, 2));
		int ano = Integer.parseInt(mesEano.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda do  " + mesEano + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));

		leia.close();
	}
}