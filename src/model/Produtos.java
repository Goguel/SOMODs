package model;

public class Produtos {
	private String nome;
	private float valor;
	private int qtdRestante;
	private float valorFinal;
	private int cod;
	
	public Produtos(int cod, String nome, float valor, int qtdRestante, float valorFinal) {
		this.cod = cod;
		this.nome = nome;
		this.valor = valor;
		this.qtdRestante = qtdRestante;
		this.valorFinal = valorFinal;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return ""+valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getQtdRestante() {
		return ""+qtdRestante;
	}
	public void setQtdRestante(int qtdRestante) {
		this.qtdRestante = qtdRestante;
	}
	public String getValorFinal() {
		return ""+valorFinal;
	}
	public void setValorFinal(float valorFinal) {
		this.valorFinal = valorFinal;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
}
