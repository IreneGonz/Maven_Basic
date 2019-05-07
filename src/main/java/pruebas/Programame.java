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
		problemaC(new ArrayList<>(Arrays.asList("3", "100", "137", "7")));
	}

	public static List<String> problemaA(List<String> entrada) {
		ArrayList salida = new ArrayList<>();
		System.out.println(entrada);

		int entradaActual = 1;

		if (!entrada.isEmpty() && entrada.size() - 1 == Integer.parseInt(entrada.get(0))) {
			while (entradaActual <= Integer.parseInt(entrada.get(0))) {
				String actual[] = entrada.get(entradaActual).split(" ");
				// System.out.println(2 + Integer.parseInt(new String("+") + 3));
				if (actual.length == 3) {
					int n1 = Integer.parseInt(actual[0]);
					int n2 = Integer.parseInt(actual[2]);

					if ((Integer.parseInt(actual[0]) >= -10000 && Integer.parseInt(actual[0]) <= 10000)
							&& (Integer.parseInt(actual[2]) >= -10000 && Integer.parseInt(actual[2]) <= 10000)) {
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
					}
				} else {
					// Excepción si no se puede realizar ninguna operación
					// try {
					// throw new Exception("No hay datos con los que operar");
					// } catch (Exception e) {
					// e.printStackTrace();
					// }
					break;
				}
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

	public List<String> problemaD(List<String> entrada) {
		ArrayList salida = null;
		return salida;
	}

	public List<String> problemaE(List<String> entrada) {
		ArrayList salida = null;
		return salida;
	}

}
