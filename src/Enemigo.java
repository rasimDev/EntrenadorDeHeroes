public class Enemigo extends Personaje {

	// Este atributo es exclusivo del Enemigo
	int fuerza;
	
	public Enemigo(String nombre, int salud, int fuerza) {
		// Pasamos nombre y salud al Padre
		super(nombre, salud);
		// Nos encargamos de la fuerza nosotros mismos
		this.fuerza = fuerza;
	}
	
	// Método exclusivo del Enemigo
	public void atacar(Heroe victima) {
		System.out.println(">>> El " + this.nombre + " ataca a " + victima.nombre + " con " + this.fuerza + " de fuerza.");
		victima.recibirDanio(this.fuerza);
	}
}