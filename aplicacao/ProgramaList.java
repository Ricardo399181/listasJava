package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Empregado;

public class ProgramaList {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos funcionarios serao cadastrados ? ");
		int n = sc.nextInt();

		List<Empregado> listaEmpregados = new ArrayList<>(n);

		
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println("empregado #" + (i + 1));

			System.out.print("id: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			
			while (qualId(listaEmpregados, id)) {
				
				System.out.println("id de usuario ja existe, tente novamente: ");

				System.out.print("id: ");
				id = sc.nextInt();
				sc.nextLine();
			}
			
			System.out.print("nome: ");
			String nome = sc.nextLine();

			System.out.print("salario : ");
			Double salario = sc.nextDouble();
			System.out.println();

			Empregado empregado = new Empregado(id, nome, salario);
			listaEmpregados.add(empregado);

		}

		System.out.print("entre com o id do empregado que queira aumentar o salario: ");
		int numeroId = sc.nextInt();

		Empregado empregado = listaEmpregados.stream().filter(x -> x.getId() == numeroId).findFirst().orElse(null);

		if (empregado == null) {

			System.out.println("este ID de usuario nao existe! ");

		}

		else {
			System.out.print("Digite a porcentagem: ");
			double porcentagem = sc.nextDouble();
			empregado.aumentoSalario(porcentagem);
		}

		System.out.println("Lista de empregados: ");
		
		for(Empregado emp : listaEmpregados) {
			System.out.println(emp);
		}
		
		
		

		sc.close();
	}

	public static boolean qualId(List<Empregado> listaEmpregados, int numeroId) {
		
		Empregado empregado = listaEmpregados.stream().filter(x -> x.getId() == numeroId).findFirst().orElse(null);
		return empregado != null;
	}
	
		
	}

