import java.util.Random;
import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		imprimirEncabezado();

		// 1. Crear al Héroe
		System.out.print("Nombre de tu Héroe: ");
		String nombre = entrada.next();
		Heroe jugador = new Heroe(nombre);

		// 2. Crear al Jefe Final (Un Orco con mucha vida)
		Enemigo jefe = new Enemigo("Orco Matemático", 150, 25);

		// POLIMORFISMO EN ACCIÓN:
		// Llamamos al MISMO método (.presentarse), pero actúan diferente.
		System.out.println("\n--- PRESENTACIÓN ---");
		jugador.presentarse();
		jefe.presentarse();
		System.out.println("--------------------\n");

		System.out.println("¡CUIDADO! Un " + jefe.getNombre() + " salvaje ha aparecido.");
		System.out.println("Tiene " + jefe.getSalud() + " de vida y " + jefe.fuerza + " de ataque.");

		// 3. EL BUCLE DE COMBATE (While)
		// "Mientras el jugador viva Y el jefe viva... pelean"
		while (jugador.estaVivo() && jefe.estaVivo()) {

			System.out.println("\n--- ESTADO DE BATALLA ---");
			System.out.println(jugador.getNombre() + " HP: " + jugador.getSalud() + "  VS  " + jefe.getNombre()
					+ " HP: " + jefe.getSalud());

			int numero1 = generarNumeroAleatorio();
			int numero2 = generarNumeroAleatorio();
			int sumaCorrecta = numero1 + numero2;

			System.out.println("Para atacar, resuelve: " + numero1 + " + " + numero2);
			System.out.print("Respuesta: ");
			int respuestaUsuario = entrada.nextInt();

			if (evaluarRespuesta(respuestaUsuario, sumaCorrecta)) {
				// Si aciertas, TÚ atacas al Jefe
				System.out.println("¡ZAS! Le pegas al monstruo.");
				jefe.recibirDanio(30); // Le quitamos 30 de vida
			} else {
				// Si fallas, el Jefe interactúa contigo y te baja vida
				System.out.println("¡Fallaste! Quedaste expuesto.");
				jefe.atacar(jugador); // <--- INTERACCIÓN DE OBJETOS
			}
		}

		// 4. RESULTADO FINAL
		System.out.println("\n---------------------------------------------");
		if (jugador.estaVivo()) {
			System.out.println("¡VICTORIA LEGENDARIA! Has derrotado al " + jefe.getNombre());
		} else {
			System.out.println("GAME OVER... El " + jefe.getNombre() + " te ha aplastado.");
		}

		entrada.close();
	}

	// --- AYUDANTES ACTUALIZADOS ---

	public static void imprimirEncabezado() {
		System.out.println("*********************************************");
		System.out.println("* RPG MATH: JAVA EDITION       *");
		System.out.println("*********************************************");
	}

	public static int generarNumeroAleatorio() {
		Random generador = new Random();
		return generador.nextInt(20) + 1;
	}

	public static boolean evaluarRespuesta(int usuario, int correcta) {
		if (usuario == correcta) {
			System.out.println(">>> ¡GOLPE CRÍTICO AL ENEMIGO!");
			return true;
		} else {
			System.out.println(">>> FALLASTE. El enemigo contraataca.");
			return false;
		}
	}

	// Fíjate que aquí ahora recibimos un objeto de tipo 'Heroe'
	public static void mostrarResultadoFinal(int puntaje, int total, Heroe heroe) {
		System.out.println("---------------------------------------------");

		if (heroe.estaVivo()) {
			System.out.println("¡VICTORIA! " + heroe.getNombre() + " ha sobrevivido.");
			System.out.println("Salud restante: " + heroe.getSalud());
			System.out.println("Enemigos derrotados: " + puntaje);
		} else {
			System.out.println("GAME OVER.");
			System.out.println(heroe.getNombre() + " ha caído en batalla valientemente.");
		}
	}
}