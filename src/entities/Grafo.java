package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Grafo {
	private static Map<String, Map<String, Set<String>>> locais = new HashMap<String, Map<String, Set<String>>>();
	private static Map<Integer, Integer> histograma = new HashMap<Integer, Integer>();
	
	public static Map<String, Map<String, Set<String>>> getLocais() {
		return locais;
	}
	
	public static void mapear_locais_e_pessoas(String arquivo) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(arquivo));
			bf.readLine(); //legendas
			String linha = bf.readLine();			
			int i = 1;
			
			while(linha != null) {
				String[] dados = linha.split(",");
				
				adicionar_pessoa_no_local(dados[2], dados[3], dados[43]); //Domicilíos
				adicionar_pessoa_no_local(dados[57], dados[58], dados[43]); //Escolas
				adicionar_pessoa_no_local(dados[62], dados[63], dados[43]); //Trabalho1
				adicionar_pessoa_no_local(dados[71], dados[72], dados[43]); //Trabalho2
				adicionar_pessoa_no_local(dados[84], dados[85], dados[43]); //Origem
				adicionar_pessoa_no_local(dados[88], dados[89], dados[43]); //Destino
				adicionar_pessoa_no_local(dados[92], dados[93], dados[43]); //Transferência1
				adicionar_pessoa_no_local(dados[96], dados[97], dados[43]); //Transferência2
				adicionar_pessoa_no_local(dados[100], dados[101], dados[43]); //Transferência3
				
				System.out.println("Linha " + i + " lida...");
				i++;
				
				linha = bf.readLine();
			}
			bf.close();
		}catch(IOException e) {
			e.getMessage();			
		}
	}

	public static void gerar_dados_do_histograma(String saida) {
		for(Map.Entry<String, Map<String, Set<String>>> entryX : locais.entrySet()) {
			for(Map.Entry<String, Set<String>> entryY : entryX.getValue().entrySet()){
				adicionar_local_no_histograma(entryY.getValue());
			}			
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(saida));
			bw.write("Classe do local, Frequência");
			for(Map.Entry<Integer, Integer> entry : histograma.entrySet()) {
				bw.newLine();
				bw.write(entry.getKey() + ", " + entry.getValue());
			}
			bw.close();
		}catch(IOException e) {
			e.getMessage();			
		}
	}
	
	private static void adicionar_pessoa_no_local(String x, String y, String id) {
		if(x.equals("0") && y.equals("0")) return;
		Map<String, Set<String>> coordenadaX = locais.get(x);
		if(coordenadaX == null) coordenadaX = new HashMap<String, Set<String>>();
		Set<String> coordenadaY = coordenadaX.get(y);
		if(coordenadaY == null) coordenadaY = new HashSet<String>();
		coordenadaY.add(id);
		coordenadaX.put(y, coordenadaY);
		locais.put(x, coordenadaX);
	}
	
	private static void adicionar_local_no_histograma(Set<String> frequentadores) {
		int tamanho = frequentadores.size();
		int quantidadeDeLocais;
		if(histograma.get(tamanho) == null) quantidadeDeLocais = 0;
		else quantidadeDeLocais = histograma.get(tamanho);
		quantidadeDeLocais += 1;
		histograma.put(tamanho, quantidadeDeLocais);
	}
}
