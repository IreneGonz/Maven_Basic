package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopiaProb {
	public static void main(String[] args) {
		// Este caso no tiene que devolver nada porque estan mal pasados los casos de
		// prueba
		// problemaD(new ArrayList<>(
		// Arrays.asList("7", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "1
		// 2", "3 2", "2,3")))
		// .toArray();

		// Este caso de prueba no puede funcionar porque se pasa de los casos de prueba
		// problemaD(new ArrayList<>(Arrays.asList("101", "1", "1", "2 3",
		// "4"))).toArray();

		// Este se pasa de habitaciones
		// problemaD(new ArrayList<>(Arrays.asList("1", "41", "1", "2 3",
		// "4"))).toArray();

		// Demasiadas conexiones (mas conexiones que habitaciones)
		// problemaD(new ArrayList<>(Arrays.asList("1", "2", "1", "2 3",
		// "4"))).toArray();

		problemaD(new ArrayList<>(Arrays.asList("1", "2", "1", "1 2", "2"))).toArray();
	}

	public static List<String> problemaD(List<String> entrada) {
		// Muy cutre pero no se me ocurre nada mas de momento
		boolean over = false, lost = false;
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		if (!entrada.isEmpty() && (comprobarProbD(entrada))) { // !entrada.isEmpty() && datosCorrectos??
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

				// Hay que comprobar que los datos esten correctos ANTES siquiera de empezar a
				// asignar variables
				// Aka este if sobrara cuando este comprobado
				if (datosCorrectos(totalCasos, habitaciones, conexionesEntreHabitaciones)) {
					// Comprobar si GAME OVER, PERDIDO, VICTORIA
					// Muy cutre pero de momento no tengo mas ideas
					if (comprobarGameOver(habitacionesConectadas, pasos, salida) == 1) {
						over = true;
					}
					if (!over) {
						if (comprobarPerdidoVictoria(habitaciones, pasos, salida) == 1) {
							lost = true;
						}
					}
					System.out
							.println("Habitaciones: " + habitaciones + " Num conexiones: " + conexionesEntreHabitaciones
									+ " Habitaciones conectadas: " + habsConec + " Pasos: " + pasos);

					// casoActual++; // Cambiamos de caso cuando cogemos todos los datos
					over = false;
					lost = false;
				}
				casoActual++;
			}
		}
		System.out.println(salida);
		return salida;
	}

	private static boolean comprobarProbD(List<String> entrada) {
		int totalCasos = Integer.parseInt(entrada.get(0));
		int condiciones = 0;
		if ((totalCasos >= 1 && totalCasos <= 100) && (entrada.size() >= (totalCasos * 4) + 1)) {
			// Comprobar num casos de prueba y que sea posible que pueda estar bien los
			// casos, si no, fuera
			int datoActual = 1;
			condiciones++;
			if (Integer.parseInt(entrada.get(datoActual)) >= 2 && Integer.parseInt(entrada.get(datoActual)) <= 40) {
				// Habitaciones comprobadas
				int habs = Integer.parseInt(entrada.get(datoActual));
				datoActual++;
				condiciones++;
				if (Integer.parseInt(entrada.get(datoActual)) >= 1 && Integer.parseInt(entrada.get(datoActual)) <= 20
						&& Integer.parseInt(entrada.get(datoActual)) >= habs - 1) {
					// conexiones comprobadas
					condiciones++;

					for (int i = 0; i < Integer.parseInt(entrada.get(datoActual - 1)); i++) {
						// System.out.println(i);
						datoActual++;
						if (entrada.get(datoActual).contains(" ")
								&& comprobarConexHabs(entrada.get(datoActual), habs)) {
							// Si contiene " " y la habitacion dentro del rango de habitaciones que tenemos
							condiciones++;
							// Comprobar que cada sala que aparece dentro de las conexiones esta dentro del
							// numero de habitaciones que tenemos
						}
					}
					datoActual++;
					// Solo quedan los pasos
					if (entrada.get(datoActual) != null && comprobarPasos(entrada.get(datoActual), habs)) {
						condiciones++;
						// Pasos comprobados
					}
					// System.out.println(condiciones);
				}
			}
		}
		if (condiciones == entrada.size()) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean comprobarPasos(String string, int habs) {
		// Dos posibilidades: que se pueda hacer split con "," o no. En ambos casos
		// habra que comprobar que el numero este en habs, como en comprobarConexHabs
		String aux[] = string.split(",");
		int aux2[] = new int[aux.length];
		int coincide = 0;

		for (int i = 0; i < aux.length; i++) {
			aux2[i] = Integer.parseInt(aux[i]);
			for (int j = 1; j <= habs; j++) {
				if (aux2[i] == j) {
					coincide++;
				}
			}
		}
		if (coincide == aux.length) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean comprobarConexHabs(String string, int habs) {
		// Comprobar que si hay 3 habitaciones no haya una conexion hab 2 5 por ejemplo
		// System.out.println(string);
		int coincide = 0;
		String aux[] = string.split(" ");
		int aux2[] = new int[aux.length];
		for (int i = 0; i < aux.length; i++) {
			aux2[i] = Integer.parseInt(aux[i]);
			for (int j = 1; j <= habs; j++) {
				if (aux2[i] == j) {
					coincide++;
				}
			}
		}
		if (coincide == string.length() - 1) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean datosCorrectos(int totalCasos, int habitaciones, int conexionesEntreHabitaciones) {
		// Esto sobrara cuando el metodo de arriba este bien hecho
		if ((totalCasos >= 1 && totalCasos <= 100) && (habitaciones >= 2 && habitaciones <= 40)
				&& (conexionesEntreHabitaciones >= 1 && conexionesEntreHabitaciones <= 20)) {
			System.out.println("datos correctos TRUE");
			return true;
		} else {
			System.out.println("datos incorrectos FALSE");
			return false;
		}
	}

	private static int comprobarPerdidoVictoria(int habitacionesTotal, List<Integer> pasos, ArrayList salida) {
		int ultimaHab = 0;
		for (int i = 0; i < pasos.size(); i++) {
			if (pasos.get(i) > ultimaHab) {
				ultimaHab = pasos.get(i);
			}
		}
		if (ultimaHab == habitacionesTotal) {
			salida.add("VICTORIA");
		} else {
			salida.add("PERDIDO");
		}
		return 0;
	}

	public static int comprobarGameOver(int[][] habitacionesConectadas, List<Integer> pasos, ArrayList salida) {
		int hayConexion = 0;
		// Pierdes si pasas entre 2 habs que no estan conectadas
		int habitacionesPasadas[] = new int[pasos.size()];
		// Hago tantos int n1, n2 y asi como pasos.size(), y cargo cada n1 n2 con el
		// contenido de pasos.size().get(elQueSea)
		for (int i = 0; i < pasos.size(); i++) {
			habitacionesPasadas[i] = pasos.get(i);
		}

		if (habitacionesPasadas.length - 1 == 0) { // Si solo hay 1 paso
			int hab1 = 1;
			int hab2 = habitacionesPasadas[0];
			for (int j = 0; j < habitacionesConectadas.length; j++) {
				if ((habitacionesConectadas[j][0] == hab1 && habitacionesConectadas[j][1] == hab2)
						|| (habitacionesConectadas[j][1] == hab1 && habitacionesConectadas[j][0] == hab2)) {
					hayConexion++;
				}
			}
		} else if (habitacionesPasadas.length - 1 > 0) {
			// Si hay más de 1 paso (hago comprobacion de que no esta vacio)
			for (int i = 0; i < habitacionesPasadas.length; i++) {
				if (i == 0) {
					int hab1 = 1;
					int hab2 = habitacionesPasadas[i];
					for (int j = 0; j < habitacionesConectadas.length; j++) {
						// System.out.println(habitacionesConectadas[j][0] + "-" +
						// habitacionesConectadas[j][1]);
						// System.out.println("H1-" + hab1 + " H2-" + hab2);
						if ((habitacionesConectadas[j][0] == hab1 && habitacionesConectadas[j][1] == hab2)
								|| (habitacionesConectadas[j][1] == hab1 && habitacionesConectadas[j][0] == hab2)) {
							hayConexion++;
						}
					}
				} else {
					int hab1 = habitacionesPasadas[i - 1];
					int hab2 = habitacionesPasadas[i];
					for (int j = 0; j < habitacionesConectadas.length; j++) {
						// System.out.println(habitacionesConectadas[i][0] + "-" +
						// habitacionesConectadas[i][1]);
						// System.out.println(hab1 + "-" + hab2);
						if ((habitacionesConectadas[j][0] == hab1 && habitacionesConectadas[j][1] == hab2)
								|| (habitacionesConectadas[j][1] == hab1 && habitacionesConectadas[j][0] == hab2)) {
							hayConexion++;
						}
					}
				}
			}
		}
		if (hayConexion == habitacionesPasadas.length) {
			// Si hay tatnas conexiones como habitaciones por las que he pasado->no he
			// perdido
			return 0;
		} else {
			salida.add("GAMEOVER");
			return 1;
		}
	}
}
