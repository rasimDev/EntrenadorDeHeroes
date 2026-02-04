// "extends Personaje" significa: Heroe ES UN Personaje + cosas extra
public class Heroe extends Personaje {

	// No necesitamos declarar nombre ni salud, ¡ya los heredó!
	
	// Constructor
	public Heroe(String nombre) {
		// super() llama al constructor del Padre (Personaje)
		// Le pasamos el nombre y 100 de vida fija
		super(nombre, 100); 
	}
	
	// Aquí solo ponemos lo que es ÚNICO del Héroe
	public void curarse() {
		this.salud += 20;
		if (this.salud > 100) this.salud = 100;
	}
}