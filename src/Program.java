import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Emprestimo;
import entities.Livro;

public class Program {

	public static void main(String[] args) {
		List<Livro> livros = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();

		// Criar livros
		livros.add(new Livro(110, "Naruto", "Naruto", LocalDate.parse("2000-02-20"), 3));
		livros.add(new Livro(111, "Boruto", "Boruto", LocalDate.parse("2000-02-20"), 4));
		livros.add(new Livro(112, "Bleach", "Ichigo", LocalDate.parse("2000-02-20"), 6));

		// Criar clientes
		Cliente cliente1 = new Cliente("Paulo", "129389", "872910923");
		Cliente cliente2 = new Cliente("Kira", "019208", "822910923");
		Cliente cliente3 = new Cliente("Lira", "018602", "820910923");
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);

		System.out.println("LISTA DE LIVROS");
		for (Livro lista : livros) {
			System.out.println(lista);
		}

		System.out.println();
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");

		// Realizar empréstimos
		try {
			System.out.println("REALIZAR EMPRESTIMOS");
			System.out.println();
			new Emprestimo(1, cliente1, LocalDate.parse("2025-01-15"), LocalDate.parse("2025-01-16"))
					.realizarEmprestimo(new Livro[] { livros.get(1), livros.get(2) });
			new Emprestimo(2, cliente1, LocalDate.parse("2025-01-22"), LocalDate.parse("2025-01-22").plusDays(7))
					.realizarEmprestimo(new Livro[] { livros.get(0) });
			new Emprestimo(3, cliente2, LocalDate.parse("2025-01-15"), LocalDate.parse("2025-01-16"))
					.realizarEmprestimo(new Livro[] { livros.get(2), livros.get(0) });

			new Emprestimo(4, cliente3, LocalDate.now(), LocalDate.now().plusDays(9))
					.realizarEmprestimo(new Livro[] { livros.get(0), livros.get(1) });
			;

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");
		// Listar clientes e seus empréstimos
		System.out.println("LISTA DE CLIENTES:");
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("LISTA DE EMPRESTIMOS:");
		for (Cliente cliente : clientes) {

			System.out.println(cliente.listarEmprestimos());
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");
		System.out.println("LISTA DE LIVROS");
		for (Livro lista : livros) {
			System.out.println(lista);
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");
		System.out.println("FINALIZAR EMPRESTIMO");
		cliente2.getEmprestimosAtivos().get(0).finalizarEmprestimo();
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");
		System.out.println("LISTA DE LIVROS");
		for (Livro lista : livros) {
			System.out.println(lista);
		}
		System.out.println();
		System.out.println("LISTA DE EMPRESTIMOS:");
		for (Cliente cliente : clientes) {

			System.out.println(cliente.listarEmprestimos());
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------");
		System.out.println("AUMENTAR ESTOQUE DE LIVROS");
		livros.get(0).aumentarEstoque(2);
		livros.get(1).aumentarEstoque(2);
		livros.get(2).aumentarEstoque(2);
		System.out.println("LISTA DE LIVROS");
		for (Livro lista : livros) {
			System.out.println(lista);
		}

	}

}
