package entities;

public class Location {
	
	int cX;
	int cY;
	int frequentadores;
	
	public Location(int cX, int cY) {		
		this.cX = cX;
		this.cY = cY;
		this.frequentadores = 1;
	}

	public int getcX() {
		return cX;
	}

	public int getcY() {
		return cY;
	}

	public int getFrequentadores() {
		return frequentadores;
	}
	
	public void increment() {		
		frequentadores += 1;
		return;
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
	
	

}
