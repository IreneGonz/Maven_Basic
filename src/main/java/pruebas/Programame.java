package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programame {

	public static void main(String[] args) {
		// problemaA(new ArrayList<>(Arrays.asList("5", "5 + -13", "10 / 2", "7 * 3", "3
		// / 0", "5 - 13")));
		// problemaA(new ArrayList<>(Arrays.asList("5", "5 + -13", "10 / 2", "7 * 3", "3
		// / 0", "5 - 13")));
		// problemaA(new ArrayList<>(Arrays.asList("5", "5 + -13", "10 / 2", "7 * 3", "3
		// / 0", "5")));
		// problemaA(new ArrayList<>(Arrays.asList("5 + -13", "10 / 2", "7 * 3", "3 /
		// 0", "5 - 13")));
		// problemaB(new ArrayList<>(Arrays.asList("6", "Polonio", "TT", "RADIO",
		// "helio", "BeCeRRo", "AHA")));
		// problemaC(new ArrayList<>(Arrays.asList("3", "100", "137", "7")));
		// problemaC(new ArrayList<>(Arrays.asList("4", "100", "137", "7"))).toArray();
		// problemaA(new ArrayList<>(Arrays.asList("3", "100 + -13", "10 / 2", "3 +
		// 1")));
	}

	public static List<String> problemaA(List<String> entrada) {
		ArrayList salida = new ArrayList<>();
		System.out.println(entrada);

		int entradaActual = 1;

		if ((!entrada.isEmpty() && entrada.size() - 1 == Integer.parseInt(entrada.get(0))
				&& comprobarProbA(entrada, entradaActual))) {
			while (entradaActual <= Integer.parseInt(entrada.get(0))) {
				String actual[] = entrada.get(entradaActual).split(" ");
				// System.out.println(2 + Integer.parseInt(new String("+") + 3));
				// if (actual.length == 3) {
					int n1 = Integer.parseInt(actual[0]);
					int n2 = Integer.parseInt(actual[2]);
					// if ((Integer.parseInt(actual[0]) >= -10000 && Integer.parseInt(actual[0]) <=
					// 10000)
					// && (Integer.parseInt(actual[2]) >= -10000 && Integer.parseInt(actual[2]) <=
					// 10000)) {
				// if ((n1 >= -10000 && n1 <= 10000) && (n2 >= -10000 && n2 <= 10000)) {
						switch (actual[1]) {
						case "+":
							salida.add(String.valueOf(n1 + n2));
							// salida.add(n1 + n2);
							// System.out.println(num1 + num2);
							break;
						case "-":
							salida.add(String.valueOf(n1 - n2));
							// salida.add(n1 - n2);
							// System.out.println(num1 - num2);
							break;
						case "/":
							if (n2 != 0) {
								salida.add(String.valueOf(n1 / 2));
								// salida.add(n1 / n2);
								// System.out.println(num1 / num2);
							} else {
								salida.add("ERROR");
								// System.out.println("ERROR");
							}
							break;
						case "*":
							salida.add(String.valueOf(n1 * n2));
							// salida.add(n1 * n2);
							// System.out.println(num1 * num2);
							break;
						}
				// }
				// }
				entradaActual++;
			}
			System.out.println(salida);
			return salida;

		} else {
			// Excepción si no
			// try {
			// throw new Exception("No hay tantos datos como casos de prueba");
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			return salida;
		}
	}

	private static boolean comprobarProbA(List<String> entrada, int entradaActual) {
		int espacios = 0;
		int n1 = 0, n2 = 0;
		boolean numAdecuado = false;
		String actual[] = entrada.get(entradaActual).split(" ");
		if (actual.length == 3) {
			n1 = Integer.parseInt(actual[0]);
			n2 = Integer.parseInt(actual[2]);
		}
		if ((n1 >= -10000 && n1 <= 10000) && (n2 >= -10000 && n2 <= 1000)) {
			numAdecuado = true;
		}
		for (int i = 0; i < entrada.size(); i++) {
			if (entrada.get(i).contains(" ")) {
				espacios++;
			}
		}
		if ((entrada.size() - 1 == espacios) && numAdecuado) {
			return true;
		}
		return false;
	}

	public static List<String> problemaB(List<String> entrada) {
		ArrayList salida = new ArrayList<>();
		System.out.println(entrada);

		// for(int i=0; i<entrada.size(); i++)
		if (!entrada.isEmpty() && entrada.size() - 1 == Integer.parseInt(entrada.get(0))) {
			for (String palabraActual : entrada) { // Recorro la lista de entrada
				if (!palabraActual.matches(".*\\d.*") && !soloVocales(palabraActual)) {
					palabraActual = palabraActual.toLowerCase(); // paso la palabra a minus para comprobarlas mejor
					char[] charActual = palabraActual.toCharArray();
					for (int i = 0; i < charActual.length; i++) {
						if (charActual[i] == 'a' || charActual[i] == 'e' || charActual[i] == 'i' || charActual[i] == 'o'
								|| charActual[i] == 'u') {
							charActual[i] = ' ';
						}
					}
					String palabraSinVoc = new String(charActual);
					palabraSinVoc = palabraSinVoc.replaceAll(" ", "");
					char[] charSinVocSinEspacios = palabraSinVoc.toCharArray();
					Arrays.sort(charSinVocSinEspacios); // Char ordenado
					String palabraSinVocOrd = new String(charSinVocSinEspacios); // Palabra "original" ordenada

					if ((palabraSinVocOrd.length() == 1) || letraRepetida(palabraSinVoc)
							|| palabraSinVocOrd.equals(palabraSinVoc)) {
						salida.add("ERROR");
					} else {
						salida.add("OK");
					}
				}
			}
			System.out.println(salida);
			return salida;
		} else {
			// Excepción si no hay tantos datos como casos de prueba
			// try {
			// throw new Exception("No hay tantos datos como casos de prueba");
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			return salida;
		}

	}

	private static boolean soloVocales(String palabra) {
		int voc = 0;
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == 'a' || palabra.charAt(i) == 'e' || palabra.charAt(i) == 'i'
					|| palabra.charAt(i) == 'o' || palabra.charAt(i) == 'u') {
				voc++;
			}
		}
		if (voc == palabra.length()) {
			// Solo hay vocales
			return true;
		} else {
			// Hay al menos 1 consonante
			return false;
		}
	}

	private static boolean letraRepetida(String palabra) {
		int cantidad = 0;
		for (int i = 0, x = 1; i < palabra.length() - 1; i++, x++) {
			if (palabra.charAt(i) == palabra.charAt(x)) {
				cantidad++;
			}
		}
		if (cantidad >= 1) {
			// Si cantidad >=1 significa que se ha repetido la letra en algun momento
			return true;
		} else {
			return false;
		}
	}

	public static List<String> problemaC(List<String> entrada) {
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		int entradaActual = 1;
		for (int i = 1; i < entrada.size(); i++) {
			// for (String numeroActual : entrada) {// Trabajamos de numero en numero, uno
			// por uno
			// Comprobar que sea un numero entero y no un decimal
			int num = Integer.parseInt(entrada.get(i));
			// int num = Integer.parseInt(numeroActual);
			int numero = 2;
			int primos = 0;
			while (numero <= num) { // Tiene que ir desde 2 (el 1 no cuenta) hasta el numero que sea
				if (numPrimo(numero) && empiezaUno(numero)) {
					primos++;
				}
				numero++;
			}
			salida.add(String.valueOf(primos)); // Espera recibir un String y no un int
			// salida.add(primos);
			primos = 0;
		}
		System.out.println(salida);
		return salida;
	}

	private static boolean empiezaUno(int numero) {
		if (Integer.parseInt(Integer.toString(numero).substring(0, 1)) == 1) {
			return true;
		}
		return false;
	}

	private static boolean numPrimo(int numero) {
		int cont = 0;
		for (int i = 1; i <= numero; i++) {
			if (numero % i == 0) {
				cont++;
			}
		}
		if (cont <= 2) {
			return true;
		} else {
			return false;
		}
	}

	public static List<String> problemaD(List<String> entrada) { // Otra prueba más
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

	public List<String> problemaE(List<String> entrada) {
		ArrayList salida = null;
		return salida;
	}

}
