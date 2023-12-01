package exerciciosProdutos;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		CrudProduto m = new CrudProduto();
		m.lerArquivo();

		;
		while (true) {
			System.out.println("1 - Inserir produto");
			System.out.println("2 - Alterar produto");
			System.out.println("3 - Mostrar um produto por Id");
			System.out.println("4 - Mostrar todos os produtos");
			System.out.println("5 - Excluir um produto por Id");
			System.out.println("6 - Excluir todos osprodutos");
			System.out.println("0 - Sair e salvar");
			System.out.print("Escolha uma opção: ");
			int op = new Scanner(System.in).nextInt();
			switch (op) {
			case 1:
				System.out.print("Informe o nome do produto: ");
				String desc = new Scanner(System.in).next();
				System.out.print("Informe o preço do produto: ");
				double prec = new Scanner(System.in).nextDouble();
				System.out.print("Informe a quantidade em estoque: ");
				int estq = new Scanner(System.in).nextInt();
				int id = m.gerarId(m.getLista()) + 1;
				m.inserir(prec, desc, estq, id);
				break;
			case 2:
				System.out.print("Informe o Id do pruduto que deseja alterar: ");
				int novoId = new Scanner(System.in).nextInt();
				System.out.print("Informe o nome do produto: ");
				String novoDesc = new Scanner(System.in).next();
				System.out.print("Informe o preço do produto: ");
				double novoPrec = new Scanner(System.in).nextDouble();
				System.out.print("Informe a quantidade em estoque: ");
				int novoEstq = new Scanner(System.in).nextInt();
				m.alterar(novoPrec, novoDesc, novoEstq, novoId);
				break;
			case 3:
				System.out.print("Informe o Id do pruduto que deseja mostrar: ");
				int mostrarId = new Scanner(System.in).nextInt();
				m.mostrarUm(mostrarId);
				break;
			case 4:
				m.mostrarTodos();
				break;
			case 5:
				System.out.print("Informe o Id do pruduto que deseja excluir: ");
				int excluirId = new Scanner(System.in).nextInt();
				m.excluirUm(excluirId);
				break;
			case 6:
				m.excluirTodods();
				break;
			case 0:
				try {
					m.escreverLista(m.getLista());
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Fim do programa.");
				return;
			default:
				System.out.println("Informe uma opçao valida \n");
				break;

			}

		}

	}
}
