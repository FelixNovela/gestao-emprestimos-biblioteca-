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
	public boolean podeRealizarEmprestimo() {
	    return emprestimosAtivos.size() < 3; // Retorna true se o cliente tiver menos de 3 empréstimos ativos
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

    
    public String listarEmprestimos() {
        StringBuilder sb = new StringBuilder();
        for (Emprestimo emprestimo : emprestimosAtivos) {
            sb.append(emprestimo.toString()).append("\n");
        }
        return sb.toString();
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

	@Override
	public String toString() {
	    return "Cliente: " + nome + 
	           " | ID: " + numeroDeIdentificacao + 
	           " | Contato: " + contato + 
	           " | Empréstimos ativos: " + emprestimosAtivos.size();
	}
}
