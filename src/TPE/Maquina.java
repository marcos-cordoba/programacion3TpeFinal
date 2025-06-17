package TPE;

public class Maquina implements Comparable<Maquina> {
	private String nombre;
	private int pieza;
	
	public Maquina(String nombre, int pieza) {
		this.nombre = nombre;
		this.pieza = pieza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPieza() {
		return pieza;
	}

	public void setPieza(int pieza) {
		this.pieza = pieza;
	}

	@Override
	public String toString() {
		return this.nombre + "," + this.pieza;
	}
	
	public int compareTo(Maquina otra) {
        return Integer.compare(otra.pieza, this.pieza ); // Orden por pieza ascendente
    }
	
}
