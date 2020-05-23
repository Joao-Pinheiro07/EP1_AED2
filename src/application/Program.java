package application;

import java.util.Scanner;
import entities.Grafo;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o caminho do arquivo a ser lido: ");
		String arquivo = sc.nextLine();
		
		long start = System.currentTimeMillis();
		Grafo.mapear_locais_e_pessoas(arquivo);
		long check1 = System.currentTimeMillis();
		
		System.out.println();
		System.out.print("Digite o caminho do arquivo de saída: ");
		String saida = sc.nextLine();
		
		long check2 = System.currentTimeMillis();
		Grafo.gerar_dados_do_histograma(saida);
		long end = System.currentTimeMillis();
		
		long tempo = (check1 - start) + (end - check2);
		System.out.println("Tempo de leitura: " + tempo + " milissegundos.");
		
		sc.close();
	}
}
