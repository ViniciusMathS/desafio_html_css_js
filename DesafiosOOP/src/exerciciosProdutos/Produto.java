package exerciciosProdutos;

public class Produto {
	
	
	private double preco;
	private String descricao;
	private int estoque;
	private int id;
	
	public Produto(double preco, String descricao, int estoque, int id) {
		
		this.preco=preco;
		this.descricao=descricao;
		this.estoque=estoque;
		this.id=id;
	}
	
	
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public double getPreco() {
		return preco;
	}




	public void setPreco(double preco) {
		this.preco = preco;
	}




	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public int getEstoque() {
		return estoque;
	}




	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}




	public String toString() {
		
		return  id+" | "+descricao+" | "+preco+" | "+estoque;
	}

}
