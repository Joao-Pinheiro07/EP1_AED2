package entities;

import java.util.HashSet;
import java.util.Set;

public class Location {
	
	int cX;
	int cY;
	private Set<Frequentador> frequentadores = new HashSet<Frequentador>();
	
	public Location(int cX, int cY) {		
		this.cX = cX;
		this.cY = cY;		
	}

	public int getcX() {
		return cX;
	}

	public int getcY() {
		return cY;
	}

	public Set<Frequentador> getFrequentadores() {
		return frequentadores;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cX;
		result = prime * result + cY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (cX != other.cX)
			return false;
		if (cY != other.cY)
			return false;
		return true;
	}
	
	public void adicionarFrequentador(Frequentador frequentador) {
		frequentadores.add(frequentador);
	}
	
	public void exibirFrequentadores() {
		for(Frequentador f : frequentadores) {
			System.out.print(f.getId() + " ");
		}
	}
	
	public int quantidadeDeFrequentadores() {
		return frequentadores.size();
	}

}
