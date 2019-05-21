package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Programame {

	public static List<String> problemaA(List<String> entrada) {
		ArrayList salida = new ArrayList<>();
		System.out.println(entrada);

		int entradaActual = 1;
		// Compruebo que la lista no este vacia y tenga tantos casos de prueba como se
		// indican en la entrada, asi como si los numeros que se pasan estan dentro del
		// rango correcto
		if ((!entrada.isEmpty() && entrada.size() - 1 == Integer.parseInt(entrada.get(0))
				&& comprobarProbA(entrada, entradaActual))) {
			// Recorro la entrada tantas veces como casos de prueba haya
			while (entradaActual <= Integer.parseInt(entrada.get(0))) {
				String actual[] = entrada.get(entradaActual).split(" ");
				// Una vez hecho el split los numeros estan en la posicion 0 y 2, mientras que
				// el signo esta en la posicion 1
				int n1 = Integer.parseInt(actual[0]);
				int n2 = Integer.parseInt(actual[2]);
				switch (actual[1]) {
				case "+":
					salida.add(String.valueOf(n1 + n2));
					break;
				case "-":
					salida.add(String.valueOf(n1 - n2));
					break;
				case "/":
					if (n2 != 0) {
						salida.add(String.valueOf(n1 / 2));
					} else {
						salida.add("ERROR");
					}
					break;
				case "*":
					salida.add(String.valueOf(n1 * n2));
					break;
				}
				entradaActual++;
			}
		}
		return salida;
	}

	private static boolean comprobarProbA(List<String> entrada, int entradaActual) {
		int espacios = 0;
		int n1 = 0, n2 = 0;
		boolean numAdecuado = false;
		String actual[] = entrada.get(entradaActual).split(" ");
		// El dato tiene que tener una longitud de 3 una vez se haya hecho el split,
		// porque hay 2 numeros y un signo
		if (actual.length == 3) {
			n1 = Integer.parseInt(actual[0]);
			n2 = Integer.parseInt(actual[2]);
		}
		if ((n1 >= -10000 && n1 <= 10000) && (n2 >= -10000 && n2 <= 1000)) {
			numAdecuado = true;
		}
		// Compruebo que no falten o sobren espacios
		for (int i = 0; i < entrada.size(); i++) {
			if (entrada.get(i).contains(" ")) {
				espacios++;
			}
		}
		// Si no sobran ni faltan espacios y los numeros estan dentro del rango
		// requerido, el caso esta bien, se puede ejecutar el resto del codigo
		if ((entrada.size() - 1 == espacios) && numAdecuado) {
			return true;
		}
		return false;
	}

	public static List<String> problemaB(List<String> entrada) {
		ArrayList salida = new ArrayList<>();
		System.out.println(entrada);

		// Si la entrada no esta vacia y los datos se han pasado de forma correcta se
		// ejecuta el codigo
		if (!entrada.isEmpty() && comprobarProbB(entrada)) {
			// Recorro la lista de entrada
			for (int j = 1; j < entrada.size(); j++) {
				// if(no es un numero??
				String palabraActual = entrada.get(j);
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
			System.out.println(salida);
			return salida;
		} else {
			return salida;
		}

	}

	private static boolean comprobarProbB(List<String> entrada) {
		int totalCasos = Integer.parseInt(entrada.get(0));
		int palabraBien = 0;
		// Compruebo si el numero de casos esta bien pasado y el tamaño de la entrada
		// coincide con ese numero total de casos
		if ((totalCasos >= 1 && totalCasos <= 10000) && (entrada.size() - 1 == totalCasos)) {
			for (int i = 1; i < entrada.size(); i++) {
				// Compruebo palabra por palabra si cumple con unos requisitos
				if (palabraCorrecta(entrada.get(i))) {
					palabraBien++;
				}
			}
		}
		// Se comprueba si hay tantas palabras bien pasadas como casos de prueba
		if (palabraBien == entrada.size() - 1) {
			return true;
		}

		return false;
	}

	private static boolean palabraCorrecta(String palabra) {
		// Si la palabra no es un numero, no tiene unicamente vocales y su tamaño esta
		// dentro del rango adecuado, la palabra esta bien
		if (!palabra.matches(".*\\d.*") && !soloVocales(palabra) && palabra.length() <= 1000) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean soloVocales(String palabra) {
		// Primero paso la palabra a minusculas porque luego es mas sencillo
		palabra = palabra.toLowerCase();
		int voc = 0;
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == 'a' || palabra.charAt(i) == 'e' || palabra.charAt(i) == 'i'
					|| palabra.charAt(i) == 'o' || palabra.charAt(i) == 'u') {
				// Recorro la palabra, y si se encuentra una vocal, sumo 1 a la cantidad de
				// vocales que tiene la palabra
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
		// Compruebo si hay letras repetidas dentro de una misma palabra
		int cantidad = 0;
		for (int i = 0, x = 1; i < palabra.length() - 1; i++, x++) {
			// Recorro la palabra comparando el char en una posicion i con la posicion
			// siguiente, y si coinciden, la letra se repite
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

		if (!entrada.isEmpty() && comprobarProbC(entrada)) {
			for (int i = 1; i < entrada.size(); i++) {
				int num = Integer.parseInt(entrada.get(i));
				int numero = 3;
				int primos = 0;

				// Voy desde el numero 3 (porque el 1 no cuenta y el 2 no es primo) hasta llegar
				// al numero con el que estoy trabajando
				while (numero <= num) {
					if (numPrimo(numero) && empiezaUno(numero)) {
						// Si ese numero es primo y ademas empieza en uno, el numero actual con el que
						// se esta trabajando tiene x numeros primos +1
						primos++;
					}
					numero++;
				}
				salida.add(String.valueOf(primos));
				primos = 0;
			}
		}
		System.out.println(salida);
		return salida;
	}

	private static boolean comprobarProbC(List<String> entrada) {
		System.out.println(entrada);
		int totalCasosPrueba = Integer.parseInt(entrada.get(0));
		int numeros = 0;

		// Compruebo que tanto el numero total de casos de prueba como los numeros que
		// se pasan en la entrada entren dentro del rango
		if ((totalCasosPrueba >= 1 && totalCasosPrueba <= 100) && (totalCasosPrueba == entrada.size() - 1)) {
			for (int i = 0; i < totalCasosPrueba; i++) {
				if (Integer.parseInt(entrada.get(i)) >= 1 && Integer.parseInt(entrada.get(i)) <= 2000000) {
					numeros++;
				}
			}
		}
		// Si coinciden la cantidad de numeros que estan bien con el numero total de
		// casos de prueba, la entrada es correcta
		if (totalCasosPrueba == numeros) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean empiezaUno(int numero) {
		// Si el rango de posiciones 0 a 1 dentro del numero es 1, ese numero empieza
		// por 1
		if (Integer.parseInt(Integer.toString(numero).substring(0, 1)) == 1) {
			return true;
		}
		return false;
	}

	private static boolean numPrimo(int numero) {
		int cont = 0;
		// Comienzo en 1 hasta llegar al numero que quiero, cada vez que al dividir el
		// numero original por i da 0, se suma uno a un contador
		for (int i = 1; i <= numero; i++) {
			if (numero % i == 0) {
				cont++;
			}
		}
		// Si el numero solo se podia dividir por si mismo y por 1, el numero es primo,
		// si no, no lo es
		if (cont == 2) {
			return true;
		} else {
			return false;
		}
	}

	public static List<String> problemaD(List<String> entrada) {
		boolean over = false;
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		if (!entrada.isEmpty() && (comprobarProbD(entrada))) {
			int totalCasos = Integer.parseInt(entrada.get(0));
			int casoActual = 0;
			int datoActual = 1;
			while (casoActual < totalCasos) {
				// Guardo el numero de habitaciones que hay y el numero de conexiones que hay
				// entrae habitaciones
				int habitaciones = Integer.parseInt(entrada.get(datoActual));
				datoActual++;
				int conexionesEntreHabitaciones = Integer.parseInt(entrada.get(datoActual));
				datoActual++;

				// Meto en una lista las habitaciones que hay conectadas, separandolas por el
				// espacio
				List<String> aux = new ArrayList<String>();
				for (int i = 0; i < conexionesEntreHabitaciones; i++) {
					String c[] = entrada.get(datoActual).split(" ");
					for (int j = 0; j < c.length; j++) {
						aux.add(c[j]);
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
				// Esto es solo para imprimirmelo por pantalla
				List<Integer> habsConec = new ArrayList<Integer>();
				for (int i = 0; i < habitacionesConectadas.length; i++) {
					for (int j = 0; j < habitacionesConectadas[i].length; j++) {
						habsConec.add(habitacionesConectadas[i][j]);
					}
				}

				// Aquí compruebo que se guardan bien las habitaciones conectadas asi:
				// 1 2 La habitacion 1 esta conectada con la 2
				// 3 4 La habitacion 3 esta conectada con la 4
				for (int i = 0; i < habitacionesConectadas.length; i++) {
					for (int j = 0; j < habitacionesConectadas[i].length; j++) {
					}
				}
				// Los pasos pueden ir sueltos o separados por comas
				String pAux[] = entrada.get(datoActual).split(",");
				List<Integer> pasos = new ArrayList<Integer>();
				for (int i = 0; i < pAux.length; i++) {
					pasos.add(Integer.parseInt(pAux[i]));
				}
				datoActual++;

				// Compruebo si has perdido
				if (comprobarGameOver(habitacionesConectadas, pasos, salida) == 1) {
					over = true;
				}
				// Si no has perdido es que o te has perdido o has ganado
				if (!over) {
					comprobarPerdidoVictoria(habitaciones, pasos, salida);
				}
				System.out.println("Habitaciones: " + habitaciones + " Num conexiones: " + conexionesEntreHabitaciones
						+ " Habitaciones conectadas: " + habsConec + " Pasos: " + pasos);

				over = false;
				casoActual++;
			}
		}
		System.out.println(salida);
		return salida;
	}

	private static boolean comprobarProbD(List<String> entrada) {
		int totalCasos = Integer.parseInt(entrada.get(0));
		int condiciones = 0;

		// Compruebo el numero total de casos y la longitud minima de la entrada
		if ((totalCasos >= 1 && totalCasos <= 100) && (entrada.size() >= (totalCasos * 4) + 1)) {
			int datoActual = 1;
			condiciones++;

			// Compruebo las habitaciones
			if (Integer.parseInt(entrada.get(datoActual)) >= 2 && Integer.parseInt(entrada.get(datoActual)) <= 40) {
				int habs = Integer.parseInt(entrada.get(datoActual));
				datoActual++;
				condiciones++;

				// Compruebo el numero de conexiones entre habitaciones
				if (Integer.parseInt(entrada.get(datoActual)) >= 1 && Integer.parseInt(entrada.get(datoActual)) <= 20
						&& Integer.parseInt(entrada.get(datoActual)) >= habs - 1) {
					condiciones++;

					for (int i = 0; i < Integer.parseInt(entrada.get(datoActual - 1)); i++) {
						datoActual++;
						if (entrada.get(datoActual).contains(" ")
								&& comprobarConexHabs(entrada.get(datoActual), habs)) {
							// Si contiene " " y la habitacion dentro del rango de habitaciones que tenemos
							condiciones++;
						}
					}
					datoActual++;
					// Comprobamos los pasos
					if (entrada.get(datoActual) != null && comprobarPasos(entrada.get(datoActual), habs)) {
						condiciones++;
					}
				}
			}
		}
		// Si todos los datos son correctos, la entrada esta bien
		if (condiciones == 5) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean comprobarPasos(String string, int habs) {
		// Los pasos van separados por , o no
		String aux[] = string.split(",");
		int aux2[] = new int[aux.length];
		int coincide = 0;

		// Compruebo que no se de un paso a una habitacion que ni siquiera existe
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
		int coincide = 0;
		// Separo las conexiones entre habitaciones por espacios
		String aux[] = string.split(" ");
		int aux2[] = new int[aux.length];
		// Recorro el vector con las conexiones entre habitaciones y compruebo que los
		// numeros que aparecen ahi coincidan con habitaciones que existan
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

	private static void comprobarPerdidoVictoria(int habitacionesTotal, List<Integer> pasos, ArrayList salida) {
		int ultimaHab = 0;
		for (int i = 0; i < pasos.size(); i++) {
			if (pasos.get(i) > ultimaHab) {
				ultimaHab = pasos.get(i);
			}
		}
		// Si la ultima habitacion que pisas coincide con el numero total de
		// habitaciones que hay, ganas, si no, ha perdido
		if (ultimaHab == habitacionesTotal) {
			salida.add("VICTORIA");
		} else {
			salida.add("PERDIDO");
		}
	}

	public static int comprobarGameOver(int[][] habitacionesConectadas, List<Integer> pasos, ArrayList salida) {
		int hayConexion = 0;
		// Pierdes si pasas entre 2 habs que no estan conectadas
		int habitacionesPasadas[] = new int[pasos.size()];
		// Hago tantos int n1, n2 y asi como pasos.size(), y cargo cada n1 n2 con el
		// contenido de pasos.size().get(el que sea)
		for (int i = 0; i < pasos.size(); i++) {
			habitacionesPasadas[i] = pasos.get(i);
		}

		if (habitacionesPasadas.length - 1 == 0) { // Si solo hay 1 paso
			int hab1 = 1;
			int hab2 = habitacionesPasadas[0];
			// Recorro las habitaciones que hay conectadas y compruebo que los pasos que doy
			// coinciden con dos habitaciones que esten conectadas, si coincide es que hay
			// conexion
			for (int j = 0; j < habitacionesConectadas.length; j++) {
				if ((habitacionesConectadas[j][0] == hab1 && habitacionesConectadas[j][1] == hab2)
						|| (habitacionesConectadas[j][1] == hab1 && habitacionesConectadas[j][0] == hab2)) {
					hayConexion++;
				}
			}
		} else if (habitacionesPasadas.length - 1 > 0) {
			// Si hay más de 1 paso
			// Lo mismo de antes pero en un for con tantas iteraciones como pasos
			// habitaciones por las que hayas pasado
			for (int i = 0; i < habitacionesPasadas.length; i++) {
				if (i == 0) {
					int hab1 = 1;
					int hab2 = habitacionesPasadas[i];
					for (int j = 0; j < habitacionesConectadas.length; j++) {
						if ((habitacionesConectadas[j][0] == hab1 && habitacionesConectadas[j][1] == hab2)
								|| (habitacionesConectadas[j][1] == hab1 && habitacionesConectadas[j][0] == hab2)) {
							hayConexion++;
						}
					}
				} else {
					int hab1 = habitacionesPasadas[i - 1];
					int hab2 = habitacionesPasadas[i];
					for (int j = 0; j < habitacionesConectadas.length; j++) {
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

	public static List<String> problemaE(List<String> entrada) {
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		if (!entrada.isEmpty() && (comprobarProbE(entrada))) {
			int totalCasos = Integer.parseInt(entrada.get(0));
			int casoActual = 1;
			int datoActual = 1;

			// Recorro todos los casos que hay
			while (casoActual <= totalCasos) {
				int oxigenoMin = Integer.parseInt(entrada.get(datoActual));
				datoActual++;
				int totalNaves = Integer.parseInt(entrada.get(datoActual));
				datoActual++;

				List<String> datosNaves = new ArrayList<String>();

				// En la lista de datosNaves meto el oxigeno-peso de cada nave
				for (int i = 0; i < totalNaves; i++) {
					datosNaves.add(entrada.get(datoActual));
					datoActual++;
				}

				System.out.println("Caso actual: " + casoActual + " Oxigeno necesario: " + oxigenoMin + " N� naves: "
						+ totalNaves + " Oxigeno-Peso: " + datosNaves);
				// Aqui compruebo que nave va antes que otra y la ordeno
				comprobarNaves(oxigenoMin, datosNaves, casoActual, salida);

				casoActual++;
			}
		}
		System.out.println(salida);
		return salida;
	}

	private static void comprobarNaves(int oxigenoMin, List<String> datosNaves, int casoActual, ArrayList salida) {
		salida.add("Caso " + casoActual + ":");

		// Ordeno la lista de naves segun oxigeno y peso
		Collections.sort(datosNaves, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// Voy comparando naves de dos en dos
				// oxi1 y peso1 = oxigeno y peso de la primera nave
				// oxi2 y peso2 = oxigeno y peso de la segunda nave
				int oxi1 = Integer.valueOf(o1.split(" ")[0]);
				int peso1 = Integer.valueOf(o1.split(" ")[1]);
				int oxi2 = Integer.valueOf(o2.split(" ")[0]);
				int peso2 = Integer.valueOf(o2.split(" ")[1]);

				if (oxi1 >= oxigenoMin && oxi2 >= oxigenoMin) {
					if (oxi1 > oxi2) {
						return -1;
					} else if (oxi1 < oxi2) {
						return 1;
					} else if (oxi1 == oxi2) {
						if (peso1 < peso2) {
							return -1;
						} else if (peso1 > peso2) {
							return 1;
						} else if (peso1 == peso2) {
							return 0;
						}
					}
				} else if (oxi1 < oxigenoMin || oxi2 < oxigenoMin) {
					if (oxi1 >= oxigenoMin) {
						return -1;
					} else if (oxi2 >= oxigenoMin) {
						return 1;
					} else if (oxi1 < oxigenoMin && oxi2 < oxigenoMin) {
						if (peso1 > peso2) {
							return 1;
						} else if (peso1 == peso2) {
							if (oxi1 > oxi2) {
								return -1;
							} else {
								return 1;
							}
						} else {
							return -1;
						}
					} else if (oxi1 == oxi2) {
						if (peso1 > peso2) {
							return 1;
						} else if (peso1 < peso2) {
							return -1;
						} else if (peso1 == peso2) {
							if (oxi1 > oxi2) {
								return -1;
							} else if (oxi1 < oxi2) {
								return 1;
							}
						}
					}
				}
				return 0;
			}
		});
		// Una vez los datos de las naves estan ordenados, los añado a la lista de
		// salida
		for (int i = 0; i < datosNaves.size(); i++) {
			salida.add(datosNaves.get(i));
		}
	}

	private static boolean comprobarProbE(List<String> entrada) {
		int totalCasos = Integer.parseInt(entrada.get(0));
		int condiciones = 0;
		int numNaves = 0;
		int casoActual = 0;
		int datoActual = 1;

		// Compruebo el numero total de casos
		if ((totalCasos >= 1 && totalCasos <= 3) && (entrada.size() >= (totalCasos * 2) + 1)) {
			while (casoActual < totalCasos) {
				condiciones++;

				// Compruebo el oxigeno minimo que necesita cada nave
				if (Integer.parseInt(entrada.get(datoActual)) >= 1
						&& Integer.parseInt(entrada.get(datoActual)) <= 100000) {
					datoActual++;
					condiciones++;

					// Comprobar el numero de naves
					if (Integer.parseInt(entrada.get(datoActual)) >= 1
							&& Integer.parseInt(entrada.get(datoActual)) <= 50000) {
						condiciones++;
						numNaves = Integer.parseInt(entrada.get(datoActual));

						// Por cada nave compruebo que los datos son correctos
						for (int i = 0; i < numNaves; i++) {
							datoActual++;
							if (entrada.get(datoActual).contains(" ") && comprobarNaves(entrada.get(datoActual))) {
								// Si contiene " " y las naves tienen bien los datos de oxigeno y peso
								condiciones++;
							}
						}
					} else {
						break;
					}
				} else {
					break;
				}
				casoActual++;
				datoActual++;
			}
			if (condiciones == entrada.size() + totalCasos - 1) {
				return true;
			}
		}
		return false;
	}

	private static boolean comprobarNaves(String string) {
		// Separando por espacios, compruebo que los datos de oxigeno y peso estan
		// dentro de los rangos
		String aux[] = string.split(" ");
		if ((Integer.parseInt(aux[0]) >= 1 && Integer.parseInt(aux[0]) <= 100000)
				&& (Integer.parseInt(aux[1]) >= 1 && Integer.parseInt(aux[1]) <= 100000)) {
			return true;
		}
		return false;
	}

}
