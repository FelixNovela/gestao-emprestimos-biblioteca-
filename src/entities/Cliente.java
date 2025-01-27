package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.StatusEmprestimo;

public class Cliente {

	private int id;
	private String nome;
	private String numeroDeIdentificacao;
	private String contato;

	private List<Emprestimo> emprestimosAtivos = new ArrayList<>();

	public Cliente() {

	}

	public Cliente(int id, String nome, String numeroDeIdentificacao, String contato) {
		this.id = id;
		this.nome = nome;
		this.numeroDeIdentificacao = numeroDeIdentificacao;
		this.contato = contato;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getnumeroDeIdentificacao() {
		return numeroDeIdentificacao;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public List<Emprestimo> getEmprestimosAtivos() {
		return emprestimosAtivos;
	}

	public void adicionarEmprestimo(Emprestimo emprestimo) {
		emprestimosAtivos.add(emprestimo);
	}

	public void removerEmprestimo(Emprestimo emprestimo) {
		emprestimo.setStatusEmprestimo(StatusEmprestimo.DEVOLVIDO);
		emprestimo.getLivrosEmprestados().get(0).aumentarEstoque(1);
	}

	public String listarEmprestimos() {
		StringBuilder sb = new StringBuilder();
		for (Emprestimo emprestimo : emprestimosAtivos) {
			sb.append(emprestimo.toString()).append("\n");
		}
		return sb.toString();
	}

	public int verificarQuantidadeDeLivros() {
		int totalLivros = 0;
		for (Emprestimo emp : emprestimosAtivos) {
			totalLivros += emp.getLivrosEmprestados().size();
		}
		return totalLivros;
	}

	@Override
	public String toString() {
		int totalLivros = 0;
		for (Emprestimo emp : emprestimosAtivos) {
			totalLivros += emp.getLivrosEmprestados().size();
		}
		return "Cliente: " + nome + " | ID: " + numeroDeIdentificacao + " | Contato: " + contato
				+ " | Empréstimos ativos: " + totalLivros;
	}
}
