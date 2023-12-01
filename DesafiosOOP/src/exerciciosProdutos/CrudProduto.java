package exerciciosProdutos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CrudProduto {

	private ArrayList<Produto> lista = new ArrayList<>();

	public ArrayList<Produto> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Produto> lista) {
		this.lista = lista;
	}

	public void inserir(double preco, String descricao, int estoque, int id) {
		Produto p = new Produto(preco, descricao, estoque, id);
		getLista().add(p);
		System.out.println("O produto " + p.getDescricao() + " foi adicionado com sucesso.");
	}

	public void alterar(double preco, String descricao, int estoque, int id) {
		for (Produto p : getLista()) {
			if (p.getId() == id) {
				p.setDescricao(descricao);
				p.setPreco(preco);
				p.setEstoque(estoque);
				System.out.println("Produto alterado!");
				return;
			}
		}
		System.out.println("O Id informado não existe.");
	}

	public void excluirUm(int id) {
		for (Produto p : getLista()) {
			if (p.getId() == id) {
				getLista().remove(p);
				System.out.println("Produto excluido!");
				return;
			}
		}
	}

	public void mostrarTodos() {
		for (Produto p : getLista()) {
			System.out.println(p + "\n");
		}
	}

	public void mostrarUm(int d) {
		for (Produto p : getLista()) {
			if (p.getId() == d) {
				System.out.println(p);
				return;
			}
		}
	}

	public void excluirTodods() {
		getLista().clear();
		System.out.println("Todos os produtos foram esxcluidos.");
	}

	public void escreverLista(ArrayList<Produto> lista) throws IOException {
		FileWriter writer = new FileWriter("listaProdutos.txt");
		for (int i = 0; i < lista.size(); i++) {
			String texto = String.valueOf(lista.get(i));
			try {
				writer.write(texto + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		writer.close();
	}

	public int gerarId(ArrayList<Produto> lista) {
		int maiorId = 0;
		if (lista.size() != 0) {
			for (Produto p : lista) {
				if (p.getId() > maiorId) {
					maiorId = p.getId();
				}
			}
		}
		return maiorId;
	}

	public void lerArquivo() throws FileNotFoundException { 
		File file = new File("listaProdutos.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			String linha = reader.nextLine();
			String[] array = linha.split(" | ");
			int id = Integer.parseInt(array[0]);
			String desc = array[2];
			double prec = Double.parseDouble(array[4]);
			int estq = Integer.parseInt(array[6]);
			inserir(prec, desc, estq, id);
		}
		reader.close();
	}
}
