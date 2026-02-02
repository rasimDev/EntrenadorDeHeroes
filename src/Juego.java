import java.util.Random;
import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		int puntaje = 0;
		int totalRondas = 10; // ¡Aumentamos las rondas para hacerlo más difícil!
		int vidas = 3; // Empezamos con 3 corazones ❤️❤️❤️
		
		imprimirEncabezado();
		
		// El bucle ahora tiene dos condiciones de salida: acabar las rondas O morir
		for (int i = 1; i <= totalRondas; i++) {
			
			System.out.println("\n--- RONDA " + i + " --- (Vidas: " + vidas + ")");
			
			int numero1 = generarNumeroAleatorio();
			int numero2 = generarNumeroAleatorio();
			int sumaCorrecta = numero1 + numero2;
			
			System.out.println("¿Cuánto es " + numero1 + " + " + numero2 + "?");
			System.out.print("Respuesta: ");
			int respuestaUsuario = entrada.nextInt();
			
			boolean gano = evaluarRespuesta(respuestaUsuario, sumaCorrecta);
			
			if (gano) {
				puntaje++;
			} else {
				vidas--; // Restamos una vida
				System.out.println(">>> ¡CUIDADO! Te quedan " + vidas + " vidas.");
				
				if (vidas == 0) {
					System.out.println(">>> ☠️ SE TE ACABARON LAS VIDAS ☠️");
					break; // <--- ESTO ROMPE EL BUCLE INMEDIATAMENTE
				}
			}
		}
		
		mostrarResultadoFinal(puntaje, totalRondas, vidas); // Pasamos 'vidas' para saber si murió
		entrada.close();
	}
	
	// --- AYUDANTES ---
	
	public static void imprimirEncabezado() {
		System.out.println("*********************************************");
		System.out.println("* ENTRENAMIENTO DE HÉROES: SURVIVAL     *");
		System.out.println("*********************************************");
		System.out.println("Reglas: 10 Rondas. Si fallas 3 veces... GAME OVER.");
	}
	
	public static int generarNumeroAleatorio() {
		Random generador = new Random();
		return generador.nextInt(20) + 1; // Ahora números hasta el 20 (más difícil)
	}
	
	public static boolean evaluarRespuesta(int usuario, int correcta) {
		if (usuario == correcta) {
			System.out.println(">>> ¡Bien hecho!");
			return true;
		} else {
			System.out.println(">>> ¡ERROR! La respuesta era " + correcta);
			return false;
		}
	}
	
	// Hemos actualizado este método para recibir las vidas también
	public static void mostrarResultadoFinal(int puntaje, int total, int vidas) {
		System.out.println("---------------------------------------------");
		
		if (vidas == 0) {
			System.out.println("RESULTADO: Misión Fallida (Game Over)");
			System.out.println("Lograste " + puntaje + " aciertos antes de caer.");
		} else {
			System.out.println("¡MISIÓN CUMPLIDA! Sobreviviste.");
			System.out.println("Puntaje Final: " + puntaje + " de " + total);
		}
	}
}