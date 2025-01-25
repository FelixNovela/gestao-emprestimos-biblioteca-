package entities;

import java.util.ArrayList;
import java.util.List;

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
		emprestimosAtivos.remove(emprestimo);
	}

	/*public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"Nome: " + nome + " Numero de identificacao: " + numeroDeIdentificacao + " Contato: " + contato + "\n");
		for (Emprestimo emprestimos : emprestimosAtivos) {
			sb.append(emprestimos.getLivro().getTitulo() + " " + emprestimos.getLivro().getAutor() + " "
					+ emprestimos.getDataRetirada() + " " + emprestimos.getDataDevolucaoPrevista());
		}
		
		return sb.toString();
	}*/
}
