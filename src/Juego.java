import java.util.Random;
import java.util.Scanner;

public class Juego {

	// El "JEFE" (Main) solo coordina, no hace el trabajo sucio
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int puntaje = 0;
		int totalRondas = 5;
		
		imprimirEncabezado(); // El Jefe manda a imprimir el título
		
		for (int i = 1; i <= totalRondas; i++) {
			
			System.out.println("\nRONDA " + i + ":");
			
			// 1. El Jefe pide números a los ayudantes
			int numero1 = generarNumeroAleatorio();
			int numero2 = generarNumeroAleatorio();
			int sumaCorrecta = numero1 + numero2;
			
			// 2. Interacción
			System.out.println("¿Cuánto es " + numero1 + " + " + numero2 + "?");
			System.out.print("Tu respuesta: ");
			int respuestaUsuario = entrada.nextInt();
			
			// 3. El Jefe pregunta al juez si ganó
			boolean gano = evaluarRespuesta(respuestaUsuario, sumaCorrecta);
			
			if (gano) {
				puntaje++;
			}
		}
		
		mostrarResultadoFinal(puntaje, totalRondas);
		entrada.close();
	}
	
	// --- AQUI ESTÁN LOS AYUDANTES (MÉTODOS) ---
	
	// Ayudante 1: Solo sabe imprimir cosas bonitas
	public static void imprimirEncabezado() {
		System.out.println("*********************************************");
		System.out.println("* SISTEMA DE ENTRENAMIENTO DE HÉROES v2.0 *");
		System.out.println("*********************************************");
	}
	
	// Ayudante 2: Solo sabe generar un número del 1 al 10
	public static int generarNumeroAleatorio() {
		Random generador = new Random();
		return generador.nextInt(10) + 1;
	}
	
	// Ayudante 3: El Juez. Decide si está bien o mal y avisa.
	public static boolean evaluarRespuesta(int usuario, int correcta) {
		if (usuario == correcta) {
			System.out.println(">>> ¡CORRECTO! Enemigo derrotado.");
			return true; // Devuelve VERDADERO (ganó punto)
		} else {
			System.out.println(">>> FALLASTE. La respuesta era " + correcta);
			return false; // Devuelve FALSO (no ganó punto)
		}
	}
	
	// Ayudante 4: Da el veredicto final
	public static void mostrarResultadoFinal(int puntaje, int total) {
		System.out.println("---------------------------------------------");
		System.out.println("Puntaje Final: " + puntaje + " de " + total);
		if (puntaje == total) System.out.println("RANGO: LEGENDARIO 🌟");
		else if (puntaje >= total/2) System.out.println("RANGO: Héroe en entrenamiento.");
		else System.out.println("RANGO: Necesitas practicar más.");
	}
}