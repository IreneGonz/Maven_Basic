package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programame2 {

	public static void main(String[] args) {
//		 problemaD(new ArrayList<>(
//		 Arrays.asList("3", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "1
//		 2", "3 2", "2,3")));

		// problemaD(new ArrayList<>(
		// Arrays.asList("2", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3")));

		// Lo de arriba tiene que dar VICTORIA y GAME OVER
		// problemaD(new ArrayList<>(Arrays.asList("1", "2", "1", "1 2", "2"))); //
		// Tiene que dar VICTORIA

		// problemaD2(new ArrayList<>(
		// Arrays.asList("3", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "1
		// 2", "3 2", "2,3")));

		problemaD3(new ArrayList<>(Arrays.asList("1", "2", "1", "1 2", "2")));
	}

	public static List<String> problemaD(List<String> entrada) {
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		if (!entrada.isEmpty()) {
			// Si no esta vacia y la forma de poner los datos es correcta, aka no
			// faltan/sobran datos
			int casoActual = 0;

			// Hay 3 casos de prueba pero hay mas de 3 entradas dentro de un caso de prueba
			while (casoActual < Integer.parseInt(entrada.get(0))) {
				// Recorrer lo que seria 1 caso de prueba (min son 4 entradas más pero pueden
				// ser más)
				// for (int i = 0; i < 4; i++) {
				int entradaActual = 1;
				int numHabitaciones = Integer.parseInt(entrada.get(entradaActual));
				entradaActual++;
				int cConexionesEntreHabitaciones = Integer.parseInt(entrada.get(entradaActual));
				entradaActual++;
				// Hay tantas lineas de conexiones entre habitaciones como posibilidades se
				// hayan indicado antes
				int conexiones[][] = new int[cConexionesEntreHabitaciones][2];

				for (int k = 0; k < conexiones.length; k++) {
					for (int j = 0; j < conexiones[k].length; j++) {
						String aux[] = entrada.get(entradaActual).split(" ");
						conexiones[k][0] = Integer.parseInt(aux[0]);
						conexiones[k][1] = Integer.parseInt(aux[1]);
						System.out.println(conexiones[k][0] + "-" + conexiones[k][1]);
					}
					entradaActual++;
				}
				// Comprobar el tema de pasos
				// El tema de conexiones y pasos se podria hacer con una lista? en plan si
				// conexiones.contains(pasos) o algo asi (pasos puede ir separado por , o no
				// !!!)
				int pasos = Integer.parseInt(entrada.get(entradaActual));

				for (int i = 0; i < conexiones.length; i++) {
					for (int j = 0; j < conexiones[i].length; j++) {
						if (conexiones[i][j] == pasos) {
							System.out.println("coincide");
						}
					}
				}
				// }
				salida.add("Resultado");
				casoActual++;
			}
		}

		System.out.println(salida);
		return salida;
	}

	public static List<String> problemaD2(List<String> entrada) {
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		// Primero compruebo que la entrada no sea una lista vacia
		if (!entrada.isEmpty()) {
			// Todo esto se realizara x veces, tantas como casos de prueba haya
			int casosPrueba = Integer.parseInt(entrada.get(0));
			int numHabitaciones = Integer.parseInt(entrada.get(1));
			String posiblesConexiones[] = entrada.get(2).split(" ");
			// No siempre sera entrada.get(3) !!!! variara segun la longitud de
			// posiblesConexiones!!!
			String conexionesHabitaciones[] = entrada.get(3).split(" ");
			String pasos[] = entrada.get(4).split(",");
			System.out.println("Casos de prueba: " + casosPrueba);
			System.out.println("Numero de habitaciones: " + numHabitaciones);
			for (int i = 0; i < posiblesConexiones.length; i++) {
				System.out.println("Conexiones: " + posiblesConexiones[i]);
			}
			// Lo mismo de antes, esto no funciona asi
			System.out.println(
					"Conexiones entre habitaciones: " + conexionesHabitaciones[0] + "-" + conexionesHabitaciones[1]);
			System.out.println("Pasos a realizar: " + pasos[0]);
		}

		System.out.println(salida);
		return salida;
	}
	
	public static List<String> problemaD3(List<String> entrada) {
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		if (!entrada.isEmpty()) {
			int totalCasos = Integer.parseInt(entrada.get(0));
			int casoActual = 0;
			int datoActual = 1;
			while (casoActual < totalCasos) {
				// Solo hay 1 linea con habitaciones
				int habitaciones = Integer.parseInt(entrada.get(datoActual));
				datoActual++;
				// Linea con el numero de conexiones que hay entre habitaciones
				int conexHab = Integer.parseInt(entrada.get(datoActual));
				// foreach recorriendo tantas lineas de conexiones entre habitaciones como
				// conexHab haya
				// Filas - Columnas
				String habitacionesConectadas[] = new String[conexHab * 2];
				System.out.println(habitacionesConectadas.length);
				for (int i = 0; i < conexHab; i++) {
					habitacionesConectadas = entrada.get(datoActual).split(" ");
				}
				casoActual++;
			}
		}

		System.out.println(salida);
		return salida;
	}
}
