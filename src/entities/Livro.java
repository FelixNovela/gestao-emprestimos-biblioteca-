package entities;

import java.time.LocalDate;

public class Livro {
	private int id;
	private String titulo;
	private String autor;
	private LocalDate DateanoPublicacao;
	private int estoque;
	private int totalEmprestado;
	public Livro() {

	}

	public Livro(int id, String titulo, String autor, LocalDate dateanoPublicacao, int estoque) {
		if (titulo.trim().isEmpty() || autor.trim().isEmpty()) {
			System.out.println("Livro com título ou autor vazio");
		} else if (estoque <= 0) {
			System.out.println("O estoque inicial deve ser maior ou igual a 1");
		} else {
			this.id = id;
			this.titulo = titulo;
			this.autor = autor;
			this.DateanoPublicacao = dateanoPublicacao;
			this.estoque = estoque;
		}

	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getDateanoPublicacao() {
		return DateanoPublicacao;
	}

	public void setDateanoPublicacao(LocalDate dateanoPublicacao) {
		DateanoPublicacao = dateanoPublicacao;
	}

	
	public int getTotalEmprestado() {
		return totalEmprestado;
	}

	public void setTotalEmprestado(int totalEmprestado) {
		this.totalEmprestado -= totalEmprestado;
	}

	public int getEstoque() {
		return estoque;
	}

	public void aumentarEstoque(int quantidade) {
		this.estoque += quantidade;
		
	}

	public boolean diminuirEstoque() {
		boolean resp = false;
		if (this.estoque <= 0 ) {
			System.out.println("Nao e possivel diminuir estoque.Quantidade disponivel " + getEstoque()+"\n");
			resp = true;
		} else {
			this.estoque -= 1;
			this.totalEmprestado += 1;
			
		}
		return resp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: "+id + " | ");
		sb.append("Titulo: "+titulo + " | ");
		sb.append("Autor: "+autor + " | ");
		sb.append("Data de Publicacao: "+DateanoPublicacao + " | ");
		sb.append("Quantidade no estoque: " +estoque + " | ");
		sb.append("Total emprestados.: " +this.getTotalEmprestado() + " | ");

		return sb.toString();
	}

}
