public class Personaje {

	// Atributos compartidos
	String nombre;
	int salud;
	
	// Constructor Genérico
	public Personaje(String nombre, int salud) {
		this.nombre = nombre;
		this.salud = salud;
	}
	
	// Métodos compartidos
	public void recibirDanio(int danio) {
		this.salud = this.salud - danio;
		if (this.salud < 0) this.salud = 0;
	}
	
	public boolean estaVivo() {
		return this.salud > 0;
	}
}