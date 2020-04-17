package entities;

public class Histograma {	
	int locs;
	int frequentadoresLocal;
	
	public Histograma(int frequentadoresLocal) {
		this.locs = 1;
		this.frequentadoresLocal = frequentadoresLocal;
	}

	public int getLocs() {
		return locs;
	}

	public int getFrequentadoresLocal() {
		return frequentadoresLocal;
	}
	
	public void increment() {
		locs += 1;
	}
	
	public String toString() {
		return locs + "locais tem " + frequentadoresLocal + " frequentadores.";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + frequentadoresLocal;
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
		Histograma other = (Histograma) obj;
		if (frequentadoresLocal != other.frequentadoresLocal)
			return false;
		return true;
	}	
	
}
