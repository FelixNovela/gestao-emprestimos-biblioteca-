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

	public Emprestimo(int id, Cliente cliente, LocalDate dataRetirada, LocalDate dataDevolucaoPrevista) {
		this.id = id;
		this.cliente = cliente;
		this.dataRetirada = dataRetirada;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
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
		return dataDevolucaoPrevista;
	}

	public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}

	public StatusEmprestimo getStatusEmprestimo() {
		return statusEmprestimo;
	}

	public void setStatusEmprestimo(StatusEmprestimo statusEmprestimo) {
		this.statusEmprestimo = statusEmprestimo;
	}

	public int verificarAtraso() {
		Duration duration = Duration.between(dataDevolucaoPrevista.atStartOfDay(), LocalDate.now().atStartOfDay());
		int dias = (int) duration.toDays();
		boolean atraso = false;
		if (dias >= 1) {
			atraso = true;
		}
		return dias;
	}

	public void realizarEmprestimo(Livro livro) {
		livrosEmprestados.add(livro);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome do cliente: " + cliente.getNome() + " | Numero de identificacao: "
				+ cliente.getnumeroDeIdentificacao() + " | Contato: " + cliente.getContato() + "\n\n");
		for (Livro emprestimos : livrosEmprestados) {
			sb.append("Titulo do livro: " + emprestimos.getTitulo() + " | ");
			sb.append("Autor do livro: " + emprestimos.getAutor() + " | ");
			sb.append("Data de retirada: " + getDataRetirada() + " | ");
			sb.append("Data da devolucao: " + this.getDataDevolucaoPrevista() + " |\n");
		}

		return sb.toString();
	}
}
