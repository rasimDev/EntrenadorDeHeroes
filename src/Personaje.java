public class Personaje {

	// CAMBIO 1: Usamos 'protected' (Candado de seguridad)
	protected String nombre;
	protected int salud;
	
	public Personaje(String nombre, int salud) {
		this.nombre = nombre;
		this.salud = salud;
	}
	
	// CAMBIO 2: Creamos "Getters" (Ventanas para mirar)
	// Permitimos que el juego LEA el nombre, pero no que lo cambie.
	public String getNombre() {
		return this.nombre;
	}
	
	public int getSalud() {
		return this.salud;
	}
	
	// ... (Tus métodos recibirDanio y estaVivo siguen igual) ...
    public void recibirDanio(int danio) {
		this.salud = this.salud - danio;
		if (this.salud < 0) this.salud = 0;
	}
	
	public boolean estaVivo() {
		return this.salud > 0;
	}
}