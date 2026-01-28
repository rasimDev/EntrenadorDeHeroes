import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {

		// PREPARACIÓN (Herramientas y Variables Iniciales)
		Scanner entrada = new Scanner(System.in);
		Random generador = new Random();
		int puntaje = 0; // Aquí guardaremos los aciertos
		int totalRondas = 5; // El juego durará 5 preguntas

		System.out.println("*********************************************");
		System.out.println("* SISTEMA DE ENTRENAMIENTO DE HÉROES     *");
		System.out.println("*********************************************");
		System.out.println("¡Bienvenido! Tienes " + totalRondas + " misiones por delante.");
		System.out.println("---------------------------------------------");

		// EL BUCLE (Aquí empieza la repetición)
		// "int i = 1" -> Empezamos en la ronda 1
		// "i <= totalRondas" -> Mientras no pasemos la ronda 5...
		// "i++" -> Al terminar una ronda, suma 1 al contador

		for (int i = 1; i <= totalRondas; i++) {

			// 1. Generar nuevos enemigos (números) en cada vuelta
			int numero1 = generador.nextInt(10) + 1;
			int numero2 = generador.nextInt(10) + 1;
			int sumaCorrecta = numero1 + numero2;

			// 2. Mostrar la pregunta actual
			System.out.println("\nRONDA " + i + ":"); // \n es un salto de línea
			System.out.println("¿Cuánto es " + numero1 + " + " + numero2 + "?");
			System.out.print("Tu respuesta: "); // print (sin ln) deja escribir al lado

			// 3. Capturar respuesta
			int respuestaUsuario = entrada.nextInt();

			// 4. Verificar (El Juez)

			if (respuestaUsuario == sumaCorrecta) {
				System.out.println(">>> ¡CORRECTO! Enemigo derrotado.");
				puntaje++; // Sumamos 1 punto al marcador
			} else {
				System.out.println(">>> FALLASTE. La respuesta era " + sumaCorrecta);
				// Aquí no sumamos puntos
			}
			// Al llegar a esta llave }, el programa sube automáticamente al inicio del
			// 'for'
		}
		// CIERRE (Resultados finales)
		System.out.println("---------------------------------------------");
		System.out.println("ENTRENAMIENTO FINALIZADO");
		System.out.println("Puntaje Final: " + puntaje + " de " + totalRondas);

		if (puntaje == 5) {
			System.out.println("RANGO: ¡SUPERHÉROE LEGENDARIO! 🌟");
		} else if (puntaje >= 3) {
			System.out.println("RANGO: Héroe en entrenamiento. ¡Bien hecho!");
		} else {
			System.out.println("RANGO: Necesitas practicar más, recluta.");
		}

		entrada.close();
	}

}
