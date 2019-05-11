package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programame2 {

	public static void main(String[] args) {
		// Aqui esta arreglado el caso de prueba porque estaba mal, pero no sale el
		// ultimo PERDIDO
		problemaD2(new ArrayList<>(
				Arrays.asList("3", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "1 2", "3 2", "2,3")));
		// Da VICTORIA, GAMEOVER, PERDIDO

		// Peta y el caso de prueba esta mal, tendre que conseguir que esto NO devuelva
		// nada
		// problemaD2(new ArrayList<>(
		// Arrays.asList("3", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "1
		// 2", "3 2", "2,3")));

		// problemaD2(new ArrayList<>(Arrays.asList("2", "2", "1", "1 2", "2", "3", "1",
		// "1 2", "2,3")));
		// Da VICTORIA y GAMEOVER (con problemaD funciona, con problemaD2 no)

		// problemaD2(new ArrayList<>(Arrays.asList("1", "2", "1", "1 2", "2"))); //
		// Tiene que dar VICTORIA

		// problemaD2(new ArrayList<>(Arrays.asList("1", "5", "2", "1 2", "3 2",
		// "2,3")));
		// Deberia dar PERDIDO

		// problemaD2(new ArrayList<>(Arrays.asList("1", "5", "2", "1 2", "3 2",
		// "1,5")));
		// Creo que deberia dar GAMEOVER

		// problemaD2(new ArrayList<>(Arrays.asList("1", "2", "1", "1 2", "2")));
		// Esto deberia dar VICTORIA

		// problemaD(new ArrayList<>(
		// Arrays.asList("3", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "1
		// 2", "3 2", "2,3")));

		// problemaD(new ArrayList<>(Arrays.asList("1", "2", "1", "1 2", "2")));
	}

	public static List<String> problemaD2(List<String> entrada) { // Otra prueba más
		// Muy cutre pero no se me ocurre nada mas de momento
		boolean over = false, lost = false;
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

					casoActual++; // Cambiamos de caso cuando cogemos todos los datos
					over = false;
					lost = false;
				}
			}
		}

		System.out.println(salida);
		return salida;
	}

	private static boolean datosCorrectos(int totalCasos, int habitaciones, int conexionesEntreHabitaciones) {
		// TODO Auto-generated method stub
		if ((totalCasos >= 1 && totalCasos <= 100) && (habitaciones >= 2 && habitaciones <= 40)
				&& (conexionesEntreHabitaciones >= 1 && conexionesEntreHabitaciones <= 20)) {
			return true;
		} else {
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
									|| (habitacionesConectadas[j][1] == hab1
										&& habitacionesConectadas[j][0] == hab2)) {
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
									|| (habitacionesConectadas[j][1] == hab1
										&& habitacionesConectadas[j][0] == hab2)) {
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

	// Original que no va del todo bien (el bucle se lo pasa bastante por el forro)
	public static void comprobarGameOverOrig(int[][] habitacionesConectadas, List<Integer> pasos, ArrayList salida) {
		boolean pierdes = false;
		// Pierdes si pasas entre 2 habs que no estan conectadas
		int habitacionesPasadas[] = new int[pasos.size()];
		// Hago tantos int n1, n2 y asi como pasos.size(), y cargo cada n1 n2 con el
		// contenido de pasos.size().get(elQueSea)
		for (int i = 0; i < pasos.size(); i++) {
			habitacionesPasadas[i] = pasos.get(i);
		}
		// Tengo que comparar la habitacion actual con la siguiente para saber de que
		// habitacion a cual va, teniendo en cuenta que empieza desde la habitacion 1
		// aunque pasos NO tiene la habitacion 1
		System.out.println("habitacionesPasadas " + habitacionesPasadas.length);
		for (int i = 0; i < habitacionesPasadas.length; i++) { // habitacionesPasadas.length-1
			// if(!pierdes)?
			if (i == 0) {
				System.out.println("i == 0");
				int hab1 = 1;
				int hab2 = habitacionesPasadas[i];
				for (int a = 0; a < habitacionesConectadas.length; a++) {
					// System.out.println(habitacionesConectadas[i][0] + "-" +
					// habitacionesConectadas[i][1]);
					// System.out.println(hab1 + "-" + hab2);
					if (!((habitacionesConectadas[a][0] == hab1 && habitacionesConectadas[a][1] == hab2)
							|| (habitacionesConectadas[a][1] == hab1 && habitacionesConectadas[a][0] == hab2))) {
						salida.add("GAMEOVER");
						// pierdes=false; ?
						break;
					}
				}
			} else {
				System.out.println("i != 0");
				int hab1 = habitacionesPasadas[i];
				int hab2 = habitacionesPasadas[i + 1];
				for (int a = 0; a < habitacionesConectadas.length; a++) {
					System.out.println("b");
					// System.out.println(habitacionesConectadas[i][0] + "-" +
					// habitacionesConectadas[i][1]);
					// System.out.println(hab1 + "-" + hab2);
					if (!((habitacionesConectadas[a][0] == hab1 && habitacionesConectadas[a][1] == hab2)
							|| (habitacionesConectadas[a][1] == hab1 && habitacionesConectadas[a][0] == hab2))) {
						salida.add("GAMEOVER");
						break;
					}
				}
			}
			i++;
			System.out.println(i);
		}
		// for (int i = 0; i < habitacionesConectadas.length; i++) {
		// for (int j = 0; j < habitacionesConectadas[i].length; j++) {
		// }
		// }
	}

	public static List<String> problemaD(List<String> entrada) { // Original
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		if (!entrada.isEmpty()) {
			int totalCasos = Integer.parseInt(entrada.get(0));
			int casoActual = 0; // Lo dejo como 0 o como 1? Si lo pongo como 1 en el while sera <=
			int datoActual = 1;
			while (casoActual < totalCasos) {
				// Solo hay 1 linea con habitaciones
				int habitaciones = Integer.parseInt(entrada.get(datoActual));
				datoActual++;
				// Linea con el numero de conexiones que hay entre habitaciones
				int conexHab = Integer.parseInt(entrada.get(datoActual));

				// String habitacionesConectadas[] = new String[conexHab * 2];
				// List<String> habitacionesConectadas = new ArrayList<String>();

				// String conexionesString[] = new String[conexHab * 2];
				List<String> conexionesString = new ArrayList();
				// int conexionesInt[] = new int[conexHab * 2];
				List<Integer> conexionesInt = new ArrayList();
				// Es *2 porque siempre va a ser par
				// System.out.println(conexiones2.length);
				datoActual++;
				// System.out.println(entrada.get(datoActual));
				// System.out.println("Conexiones String/2: " + conexHab / 2);
				for (int i = 0; i < conexHab; i++) {
					String[] aux = entrada.get(datoActual).split(" ");
					conexionesInt.add(Integer.parseInt(aux[0]));
					conexionesInt.add(Integer.parseInt(aux[1]));
					// System.out.println(aux[0] + "-" + aux[1]);
					// datoActual++;
					// Esto de arriba no estaría del todo bien, llegaría un punto en el que te
					// quedarías sin datos
					// Igual se podria hacer que si se puede hacer split(" ") que sume datoActual,
					// y si no no?
					// Esto de abajo no serviria porque si no hay espacios no se hara el split, se
					// guardará el string tal cual
					// if (entrada.get(datoActual).split(" ") != null)
					// Así funciona bien (o por lo menos mejor)
					if (entrada.get(datoActual + 1).contains(" ")) { // Y si comparo con datoActual+1?
						datoActual++;
					}
				}
				// Ahora tocan los pasos que se realizan, que pueden ir separados por comas o
				// ser un unico numero
				ArrayList<Integer> pasos = new ArrayList<Integer>(); // Los metere ya como int para que sea mas facil
				datoActual++;
				String aux[] = entrada.get(datoActual).split(",");
				// En el ultimo caso el 1 2 o 12 llega hasta aquí y NO DEBERIA
				// Coge 12 como que es un paso pero es parte de las conexiones entre
				// habitaciones, estará mal en el paso anterior
				// System.out.println(casoActual + "-" + conexionesList.size());

				// System.out.println(casoActual + "-" + conexionesList);
				// System.out.println(datoActual + "-" + aux[0]);

				for (int i = 0; i < aux.length; i++) {
					pasos.add(Integer.parseInt(aux[i]));
				}
				// Aquí tenemos que calcular si es VICTORIA, GAME OVER o PERDIDO (en orden
				// contrario pero es la idea)
				// System.out.println(pasos.size());
				for (int i = 0; i < pasos.size(); i++) {
					if (pasos.size() == 1) {
						int num1 = pasos.get(0);
						if (conexionesInt.contains(num1) && pasos.contains(habitaciones)) {
							salida.add("VICTORIA");
							break;
						} else {
							salida.add("GAME OVER");
							break;
						}

					} else {
						int num1 = pasos.get(0);
						int num2 = pasos.get(1);

						if (conexionesInt.contains(num1) && conexionesInt.contains(num2)) {
							salida.add("VICTORIA");
							break;
						}
						if (pasos.contains(habitaciones)) {
							salida.add("GAME OVER");
							break;
						}
					}
				}

				System.out.println("Habitaciones: " + habitaciones + " Num conexiones: " + conexHab
						+ " Habitaciones conectadas: " + conexionesInt + " Pasos: " + pasos);

				datoActual++;
				casoActual++; // Cambiamos de caso cuando cogemos todos los datos
			}
		}

		System.out.println(salida);
		return salida;
	}

}
