package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopiaD {
	public static void main(String[] args) {
		// No peta pero esta mal el caso de prueba (no es 12 sino 1 2)
		problemaD2(new ArrayList<>(
				Arrays.asList("3", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "12", "3 2", "2,3")));

		// Peta pero el caso de prueba esta bien

		// problemaD(new ArrayList<>(
		// Arrays.asList("3", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "1
		// 2", "3 2", "2,3")));
	}

	public static List<String> problemaD2(List<String> entrada) { // Otra prueba más
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		if (!entrada.isEmpty()) {
			// Primero llamar a un metodo que compruebe que hay suficientes datos y que
			// todos estan correctos
			int totalCasos = Integer.parseInt(entrada.get(0));
			int casoActual = 0; // Lo dejo como 0 o como 1? Si lo pongo como 1 en el while sera <=
			int datoActual = 1;
			while (casoActual < totalCasos) {
				int habitaciones = Integer.parseInt(entrada.get(datoActual));
				datoActual++;
				int conexionesEntreHabitaciones = Integer.parseInt(entrada.get(datoActual));
				if (casoActual == 1) {
				}
				datoActual++;

				List<String> aux = new ArrayList<String>();
				for (int i = 0; i < conexionesEntreHabitaciones; i++) {
					String c[] = entrada.get(datoActual).split(" ");
					for (int j = 0; j < c.length; j++) {
						aux.add(c[j]);
					}
					if (casoActual == 1) {
						// System.out.println(entrada.get(datoActual));
					}
					datoActual++;
				}
				// Hago esto para guardar las habitaciones conectadas de esta forma:
				// 1 2 La habitacion 1 esta conectada con la 2
				// 3 4 La habitacion 3 esta conectada con la 4
				int habitacionesConectadas[][] = new int[conexionesEntreHabitaciones][2];
				for (int i = 0, x = 0; i < habitacionesConectadas.length; i++) {
					for (int j = 0; j < habitacionesConectadas[i].length; j++) {
						habitacionesConectadas[i][j] = Integer.parseInt(aux.get(x));
						x++;
					}
				}
				// Esto se puede borrar, es solo para imprimirmelo por pantalla
				List<Integer> habsConec = new ArrayList<Integer>();
				for (int i = 0; i < habitacionesConectadas.length; i++) {
					for (int j = 0; j < habitacionesConectadas[i].length; j++) {
						habsConec.add(habitacionesConectadas[i][j]);
					}
				} // Esto se puede borrar, es solo para imprimirmelo por pantalla

				// Aquí compruebo que se guardan bien las habitaciones conectadas en plan:
				// 1 2 La habitacion 1 esta conectada con la 2
				// 3 4 La habitacion 3 esta conectada con la 4
				for (int i = 0; i < habitacionesConectadas.length; i++) {
					for (int j = 0; j < habitacionesConectadas[i].length; j++) {
						// System.out.println(habitacionesConectadas[i][j] + " i: " + i + " j: " + j);
					}
				}
				// Los pasos pueden ir sueltos o separados por comas
				// (En principio no hay que poner datoActual++)
				String pAux[] = entrada.get(datoActual).split(",");
				List<Integer> pasos = new ArrayList<Integer>();
				for (int i = 0; i < pAux.length; i++) {
					pasos.add(Integer.parseInt(pAux[i]));
				}
				datoActual++;
				// Comprobar si GAME OVER, PERDIDO, VICTORIA

				comprobarGameOver(habitacionesConectadas, pasos, salida);
				System.out.println("Habitaciones: " + habitaciones + " Num conexiones: " + conexionesEntreHabitaciones
						+ " Habitaciones conectadas: " + habsConec + " Pasos: " + pasos);

				casoActual++; // Cambiamos de caso cuando cogemos todos los datos
			}
		}

		System.out.println(salida);
		return salida;
	}

	public static void comprobarGameOver(int[][] habitacionesConectadas, List<Integer> pasos, ArrayList salida) {

	}
}
