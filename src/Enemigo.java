public class Enemigo {

	// Atributos
	String nombre;
	int salud;
	int fuerza;

	// Constructor
	public Enemigo(String nombre, int salud, int fuerza) {
		this.nombre = nombre;
		this.salud = salud;
		this.fuerza = fuerza;
	}

	// Método para recibir daño (igual que el héroe)
	public void recibirDanio(int danio) {
		this.salud = this.salud - danio;
		if (this.salud < 0)
			this.salud = 0;
	}

	// --- AQUÍ ESTÁ LA MAGIA DE LA INTERACCIÓN ---
	// Este método recibe un OBJETO Heroe completo como parámetro.
	// El enemigo "lee" al héroe y modifica su salud.
	public void atacar(Heroe victima) {
		System.out.println(
				">>> El " + this.nombre + " ataca a " + victima.nombre + " con " + this.fuerza + " de fuerza.");
		victima.recibirDanio(this.fuerza);
	}

	public boolean estaVivo() {
		return this.salud > 0;
	}
}