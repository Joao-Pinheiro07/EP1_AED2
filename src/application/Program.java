package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Histograma;
import entities.Location;

public class Program {
	
	 public static List <Location> locais = new ArrayList<>();
	 public static List <Histograma> hists = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		
		Locale.setDefault(Locale.US);		
		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Digite o caminho do arquivo a ser lido: ");
		String arquivo = input.readLine();
		
		try {			
			BufferedReader bf = new BufferedReader(new FileReader(arquivo));
			
			bf.readLine(); //legendas;
			String linha = bf.readLine();
			int i = 1;
			
			while(linha != null) {
				String[] dados = linha.split(",");				
				
				novoLocal(dados[2], dados[3]); //domicilios
				novoLocal(dados[57], dados[58]); //escolas
				novoLocal(dados[62], dados[63]); //trabalho1
				novoLocal(dados[71], dados[72]); //trabalho2
				novoLocal(dados[84], dados[85]); //origem
				novoLocal(dados[88], dados[89]); //destino
				novoLocal(dados[92], dados[93]); //transferencia1
				novoLocal(dados[96], dados[97]); //transferencia2
				novoLocal(dados[100], dados[101]); //transferencia3	
				
				System.out.println("Linha " + i + " lida...");
				i = i + 1;
				
				linha = bf.readLine();				
			}
			
			bf.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Erro na abertura do arquivo: " + e.getMessage());
			
		}	
		
		for(Location loc : locais) {
			novoHistograma(loc.getFrequentadores());
		}
		
		try {
			System.out.println();
			System.out.print("Digite o caminho do arquivo de saída: ");
			arquivo = input.readLine();
			input.close();
			BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
			
			bw.write("Frequentadores, Quantidade de locais");
			
			for(Histograma h : hists) {
				bw.newLine();
				bw.write(h.getFrequentadoresLocal() + ", " + h.getLocs());				
			}
			bw.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		}
		
		
	}
	
	public static void novoLocal(String x, String y){

		
		if(x.equals("0") && y.equals("0")) return;
		
		int cX = Integer.parseInt(x);
		int cY = Integer.parseInt(y);
		Location novoLocal = new Location(cX, cY);
		
		if(locais.contains(novoLocal)) {
			for(Location local : locais) {
				if(novoLocal.equals(local)) {
					local.increment();
					break;
				}
			}
		}
		else {
			locais.add(novoLocal);
		}		
					
	}	
	
	public static void novoHistograma(int frequentadores) {
		Histograma novoHistograma = new Histograma(frequentadores);
		if(hists.contains(novoHistograma)) {
			for(Histograma h : hists) {
				if(novoHistograma.equals(h)) {
					h.increment();
					break;
				}
			}
		}
		else {
			hists.add(novoHistograma);
		}
	}
}
