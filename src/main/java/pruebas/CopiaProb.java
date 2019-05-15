package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopiaProb {
	public static void main(String[] args) {
		// El 200 creo que sobra
//		problemaE(new ArrayList<>(Arrays.asList("2", "100", "3", "100 1000", "50 300", "50 5000", "200", "3",
//				"100 1000", "60 300", "50 300"))).toArray();

		// Problema quitando el 200 que sobra
		problemaE(new ArrayList<>(
				Arrays.asList("2", "100", "3", "100 1000", "50 300", "50 5000", "3", "100 1000", "60 300", "50 300")))
						.toArray();
	}

	public static List<String> problemaE(List<String> entrada) {
		// Muy cutre pero no se me ocurre nada mas de momento
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		if (!entrada.isEmpty() && (comprobarProbE(entrada))) {
			int totalCasos = Integer.parseInt(entrada.get(0));
			int casoActual = 1; // Lo dejo como 0 o como 1? Si lo pongo como 1 en el while sera <=
			int oxigenoMin = Integer.parseInt(entrada.get(1));
			int datoActual = 2;

			while (casoActual <= totalCasos) {
				int totalNaves = Integer.parseInt(entrada.get(datoActual));
				datoActual++;
				int oxiPes[][] = new int[totalNaves][2];

				List<String> aux = new ArrayList<String>();

				for (int i = 0; i < totalNaves; i++) {
					// System.out.println(i + "-" + totalNaves);
					// System.out.println(entrada.get(datoActual));
					String c[] = entrada.get(datoActual).split(" ");
					for (int j = 0; j < c.length; j++) {
						aux.add(c[j]);
					}
					// System.out.println(entrada.get(datoActual));
					datoActual++;
				}

				for (int i = 0, x = 0; i < oxiPes.length; i++) {
					for (int j = 0; j < oxiPes[i].length; j++) {
						oxiPes[i][j] = Integer.parseInt(aux.get(x));
						x++;
					}
				}
				// Esta el vector cargado con el peso de las naves y el oxigeno, falta comprobar
				// cual es mejor y ordenarlos
				comprobarNaves(oxigenoMin, oxiPes);

				casoActual++;
			}
		}
		System.out.println(salida);
		return salida;
	}

	private static void comprobarNaves(int oxigenoMin, int[][] oxiPes) {
		// Dos listas: una para oxigeno y otra para peso? Cuando una nave sea peor o
		// mejor que otra por lo que sea, movere el numero que este en la posicion x de
		// cada lista, para que siga siendo la misma nave
		List<Integer> oxigenoPeso = new ArrayList<Integer>();
		for (int i = 0; i < oxiPes.length; i++) {
			for (int j = 0; j < oxiPes[i].length; j++) {
				oxigenoPeso.add(oxiPes[i][j]);
			}
		}
		for (int i = 0; i < oxigenoPeso.size(); i++) {
			if (oxigenoPeso.get(i) == oxigenoMin && (i % 2 == 0)) {
				// Si i%2!=0 significa que es un numero par, posicion del oxigeno, mientras
				// que los numeros impares es donde va el peso
				System.out.println("oxigeno minimo");
			}
		}

		// Comprobar que elemento coincide con la cantidad de oxigenoMin

	}

	private static boolean comprobarProbE(List<String> entrada) {
		// TODO Auto-generated method stub
		return true;
	}

}
