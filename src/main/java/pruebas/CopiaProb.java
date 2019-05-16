package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CopiaProb {
	public static void main(String[] args) {
		// El 200 es el oxigeno necesario en el segundo caso
		problemaE(new ArrayList<>(Arrays.asList("2", "100", "3", "100 1000", "50 300", "50 5000", "200", "3",
				"100 1000", "60 300", "50 300"))).toArray();

	}

	public static List<String> problemaE(List<String> entrada) {
		// Muy cutre pero no se me ocurre nada mas de momento
		ArrayList salida = new ArrayList();
		System.out.println(entrada);
		System.out.println();

		if (!entrada.isEmpty() && (comprobarProbE(entrada))) {
			int totalCasos = Integer.parseInt(entrada.get(0));
			int casoActual = 1; // Lo dejo como 0 o como 1? Si lo pongo como 1 en el while sera <=
			int datoActual = 1;

			while (casoActual <= totalCasos) {
				int oxigenoMin = Integer.parseInt(entrada.get(datoActual));
				datoActual++;
				int totalNaves = Integer.parseInt(entrada.get(datoActual));
				datoActual++;
				// int oxiPes[][] = new int[totalNaves][2];

				List<String> datosNaves = new ArrayList<String>();

				for (int i = 0; i < totalNaves; i++) {
					datosNaves.add(entrada.get(datoActual));
//					String c[] = entrada.get(datoActual).split(" ");
//					for (int j = 0; j < c.length; j++) {
//						datosNaves.add(c[j]);
//					}
					datoActual++;
				}

//				for (int i = 0, x = 0; i < oxiPes.length; i++) {
//					for (int j = 0; j < oxiPes[i].length; j++) {
//						oxiPes[i][j] = Integer.parseInt(datosNaves.get(x));
//						x++;
//					}
//				}
				System.out.println("Caso actual: " + casoActual + " Oxigeno necesario: " + oxigenoMin + " Nº naves: "
						+ totalNaves + " Oxigeno-Peso: " + datosNaves);
				// Esta el vector cargado con el peso de las naves y el oxigeno, falta comprobar
				// cual es mejor y ordenarlos
				comprobarNaves(oxigenoMin, datosNaves, casoActual, salida);
				System.out.println();

				casoActual++;
			}
		}
		System.out.println(salida);
		return salida;
	}

	private static void comprobarNaves(int oxigenoMin, List<String> datosNaves, int casoActual, ArrayList salida) {
		// List definitiva = new ArrayList();
		salida.add("Caso " + casoActual + ":");

		System.out.println("Antes " + datosNaves);
		// Ordena las naves de mayor a menor?
		// No tengo ni idea de como funcionaba esto, tenia mas logica antes
		Collections.sort(datosNaves);
		System.out.println("Despues " + datosNaves);
		String aux[][] = new String[datosNaves.size()][2];
		int oxiPeso[][] = new int[datosNaves.size()][2];

		for (int i = 0; i < datosNaves.size(); i++) {
			aux[i] = datosNaves.get(i).split(" ");
//			if (aux[i][0].equals(String.valueOf(oxigenoMin))) {
//				System.out.println("Aqui hay oxigeno suficiente");
//			}
		}
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[i].length; j++) {
				oxiPeso[i][j] = Integer.parseInt(aux[i][j]);
			}
		}
		int datosBlanco = 0;
		// while (datosBlanco < datosNaves.size()) { //Hace falta esto?
		int posMax = 0;
		for (int i = 0; i < aux.length; i++) {
			if (oxiPeso[i][0] >= oxigenoMin && (oxiPeso[i][0] >= oxiPeso[posMax][0]
					|| (oxiPeso[i][0] == oxiPeso[posMax][0] && oxiPeso[i][1] < oxiPeso[posMax][1]))) {
				// Si alcanza o supera el oxigenoMinimo y tiene mas oxigeno que la entrada en
				// posicion posMax o si tienen la misma cantidad de osxigeno pero la primera
				// nave pesa menos que la otra->entra
				salida.add(aux[i][0] + " " + aux[i][1]);
				// A la lista definitiva hay que meterle los numeros separados por espacios
				oxiPeso[i][0] = 0;
				oxiPeso[i][1] = 0;
				posMax = i; // Creo que esto tiene que estar
				datosBlanco++;
				// Falta otro else if? que tenga en cuenta si alcanza el O2 necesario pero no es
				// mejor que la mejor entrada en la lista definitiva
			} else if (oxiPeso[i][0] < oxigenoMin) { // Si no alcanza el oxigeno minimo
				System.out.println(oxiPeso[i][0] + "-" + oxiPeso[i][1]);
			}
		}
		// }

		// Una posibilidad era usar TreeMap pero no se puede repetir nunca el primer
		// numero
		// HashMap<Integer, Integer> map = new HashMap<>();
		// map.put(oxiPeso[i][0], oxiPeso[i][1]);
		// TreeMap<Integer, Integer> treeMap = new TreeMap<>(map);
	}

	private static boolean comprobarProbE(List<String> entrada) {
		// TODO Auto-generated method stub
		return true;
	}

}
