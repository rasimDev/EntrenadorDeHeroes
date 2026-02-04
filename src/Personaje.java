// CAMBIO 1: Agregamos 'abstract'
public abstract class Personaje {

	protected String nombre;
	protected int salud;
	
	public Personaje(String nombre, int salud) {
		this.nombre = nombre;
		this.salud = salud;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getSalud() {
		return this.salud;
	}
	
	public void recibirDanio(int danio) {
		this.salud = this.salud - danio;
		if (this.salud < 0) this.salud = 0;
	}
	
	public boolean estaVivo() {
		return this.salud > 0;
	}
	
	// CAMBIO 2: El método abstracto (El Contrato)
	// Esto dice: "No sé cómo lo harán, pero mis hijos DEBEN tener este método"
	public abstract void presentarse();
}