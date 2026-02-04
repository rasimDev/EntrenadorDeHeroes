import java.util.Random;
import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		imprimirEncabezado();

		// 1. NACIMIENTO: Instanciamos el objeto
		System.out.print("Nombre de tu Héroe: ");
		String nombre = entrada.next();
		Heroe jugador = new Heroe(nombre);

		System.out.println(">>> Héroe creado: " + jugador.nombre + " (HP: " + jugador.salud + ")");

		int puntaje = 0;
		int totalRondas = 10;

		// 2. EL CICLO DE BATALLA
		for (int i = 1; i <= totalRondas; i++) {

			// Si el héroe muere en medio de la batalla, se acaba el bucle
			if (!jugador.estaVivo()) {
				break;
			}

			System.out.println("\n--- RONDA " + i + " --- (Salud actual: " + jugador.salud + ")");

			int numero1 = generarNumeroAleatorio();
			int numero2 = generarNumeroAleatorio();
			int sumaCorrecta = numero1 + numero2;

			System.out.println("Enemigo aparece: ¿Cuánto es " + numero1 + " + " + numero2 + "?");
			System.out.print("Ataque: ");
			int respuestaUsuario = entrada.nextInt();

			boolean gano = evaluarRespuesta(respuestaUsuario, sumaCorrecta);

			if (gano) {
				puntaje++;
				// Opcional: ¡Podrías curarlo si acierta!
				// jugador.curarse();
			} else {
				// AQUÍ ESTÁ LA CLAVE POO:
				// No restamos vidas manualmente. Le decimos al objeto que reciba daño.
				// 34 de daño significa que con 3 golpes (34+34+34 > 100) muere.
				jugador.recibirDanio(34);
				System.out.println(">>> ¡El héroe ha sido herido!");
			}
		}

		// 3. FINAL DEL JUEGO
		mostrarResultadoFinal(puntaje, totalRondas, jugador); // Pasamos el OBJETO entero
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
			System.out.println("¡VICTORIA! " + heroe.nombre + " ha sobrevivido.");
			System.out.println("Salud restante: " + heroe.salud);
			System.out.println("Enemigos derrotados: " + puntaje);
		} else {
			System.out.println("GAME OVER.");
			System.out.println(heroe.nombre + " ha caído en batalla valientemente.");
		}
	}
}