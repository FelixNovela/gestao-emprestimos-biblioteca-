import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Emprestimo;
import entities.Livro;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Livro> list = new ArrayList<>();
		List<Cliente> clienteList = new ArrayList<>();

		Livro livro = new Livro(110, "Naruto", "Naruto", LocalDate.parse("2000-02-20"), 2);
		list.add(livro);

		Livro livro2 = new Livro(111, "Boruto", "Boruto", LocalDate.parse("2000-02-20"), 4);
		list.add(livro2);

		Livro livro3 = new Livro(112, "Bleach", "Ichigo", LocalDate.parse("2000-02-20"), 6);
		list.add(livro3);

		/*
		 * Cliente cliente = new Cliente(109, "Felix", "sh353453", "848248764"); Cliente
		 * cliente2 = new Cliente(9, "lks", "sh353453", "848248764");
		 * 
		 * Emprestimo emprest = new Emprestimo(3, cliente,
		 * LocalDate.parse("2025-01-10"), LocalDate.parse("2025-01-20")); Emprestimo
		 * emprest2 = new Emprestimo(7, cliente, LocalDate.parse("2025-01-09"),
		 * LocalDate.parse("2025-01-28"));
		 * 
		 * emprest.realizarEmprestimo(livro3); emprest.realizarEmprestimo(livro);
		 * emprest.realizarEmprestimo(livro2); cliente.adicionarEmprestimo(emprest);
		 * cliente.adicionarEmprestimo(emprest); cliente.adicionarEmprestimo(emprest);
		 * 
		 * emprest2.realizarEmprestimo(livro3); emprest2.realizarEmprestimo(livro);
		 * emprest.realizarEmprestimo(livro2); cliente2.adicionarEmprestimo(emprest);
		 * cliente2.adicionarEmprestimo(emprest2);
		 * cliente2.adicionarEmprestimo(emprest2); System.out.println("Livros"); //
		 * Adicionar Livros /* for (int i = 0; i <= 2; i++) { System.out.println("ID ");
		 * int id = sc.nextInt(); sc.nextLine();
		 * 
		 * System.out.println("Titulo "); String t = sc.nextLine();
		 * 
		 * System.out.println("Autor "); String a = sc.nextLine();
		 * 
		 * System.out.println("Estoque "); int es = sc.nextInt();
		 * 
		 * list.add(new Livro(id, t, a, LocalDate.parse("2000-02-20"), es));
		 * 
		 * }
		 */

		// Adicionar cliente
		System.out.println("Dados do cliente");
		System.out.print("Id: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Nome do cliente: ");
		String nome = sc.nextLine();

		System.out.print("Numero De Identificacao: ");
		String numeroDeIdentificacao = sc.nextLine();

		System.out.print("Contato: ");
		String contato = sc.nextLine();

		Cliente cliente = new Cliente(id, nome, numeroDeIdentificacao, contato);

		Emprestimo emprest0 = new Emprestimo(3, cliente, LocalDate.parse("2025-01-10"), LocalDate.parse("2025-01-20"));
		System.out.println();

		System.out.println("LISTA DE LIVROS DISPONIVEIS");
		for (Livro l : list) {
			int cont = 0;
			System.out.println(l);
		}
		System.out.println();

		System.out.print("Deseja emprestar quantos livros? ");
		int nLivros = sc.nextInt();
		System.out.println();

		for (int ii = 1; ii <= nLivros; ii++) {

			System.out.print("Informe o numero do livro que deseja emprestar: ");
			int li = sc.nextInt();
			emprest0.realizarEmprestimo(list.get(li));
			cliente.adicionarEmprestimo(emprest0);
			System.out.println();
		}
		System.out.println();
		System.out.println("DADOS DO EMPRESTIMO");
		System.out.println(emprest0);
	}

}
