package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enums.StatusEmprestimo;

public class Emprestimo {
	private int id;
	private Cliente cliente;

	private List<Livro> livrosEmprestados = new ArrayList<>();
	private LocalDate dataRetirada;
	private LocalDate dataDevolucaoPrevista;
	private StatusEmprestimo statusEmprestimo;

	public Emprestimo() {

	}

	public Emprestimo(int id, Cliente cliente, Livro livro, LocalDate dataRetirada, LocalDate dataDevolucaoPrevista) {

		this.id = id;
		this.cliente = cliente;
		this.dataRetirada = dataRetirada;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		this.statusEmprestimo = statusEmprestimo.ATIVO;
		this.realizarEmprestimo(livro);

	}

	public int getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Livro> getLivrosEmprestados() {
		return livrosEmprestados;
	}

	public LocalDate getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public LocalDate getDataDevolucaoPrevista() {

		return this.dataDevolucaoPrevista;
	}

	public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}

	public StatusEmprestimo getStatusEmprestimo() {
		if (this.verificarAtraso()) {

			this.statusEmprestimo = statusEmprestimo.ATRASADO;
		}
		return this.statusEmprestimo;
	}


	public boolean verificarAtraso() {
		Duration duration = Duration.between(dataDevolucaoPrevista.atStartOfDay(), LocalDate.now().atStartOfDay());
		int dias = (int) duration.toDays();

		return dias >= 1;
	}

	public void realizarEmprestimo(Livro livro) {
		try {
			if (cliente.podeRealizarEmprestimo()) {
				if (!livro.diminuirEstoque()) {
					this.livrosEmprestados.add(livro);
					this.statusEmprestimo = statusEmprestimo.ATIVO;

					// Adiciona este empréstimo à lista de empréstimos ativos do cliente
					this.cliente.adicionarEmprestimo(this);
				}

			} else {
				throw new IllegalArgumentException(
						cliente.getNome() + " já tem 3 empréstimos ativos. Operação não permitida.");
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Empréstimo do cliente: " + cliente.getNome() + "\n");
		sb.append("Data de Retirada: " + dataRetirada + "\n");
		sb.append("Data Prevista de Devolução: " + getDataDevolucaoPrevista() + "\n");
		sb.append("Status: " + getStatusEmprestimo() + "\n");
		sb.append("Livros emprestados:\n");
		for (Livro livro : livrosEmprestados) {
			sb.append(" - Título: " + livro.getTitulo() + " | Autor: " + livro.getAutor() + "\n");
		}
		return sb.toString();
	}

}
