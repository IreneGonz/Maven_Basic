package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopiaProb {
	public static void main(String[] args) {
		// problemaE(new ArrayList<>(Arrays.asList("2", "100", "3", "100 1000", "50
		// 300", "50 5000", "200", "3",
		// "100 1000", "60 300", "50 300"))).toArray();

		// Este caso deberia pararse en comprobarProbE(entrada) porque esta mal
		// pasado->le paso menos naves de las que le indico
		// no sale bien
		problemaE(new ArrayList<>(
				Arrays.asList("2", "100", "3", "100 1000", "50 300", "50 5000", "200", "3", "100 1000", "60 300")))
						.toArray();

		// Esto deberia hacerlo porque esta bien pasado
//		problemaE(new ArrayList<>(Arrays.asList("3", "100", "3", "100 1000", "50 300", "50 5000", "200", "3",
//				"100 1000", "60 300", "50 300", "100", "2", "100 2000", "150 500"))).toArray();

	}

	public static List<String> problemaE(List<String> entrada) {
		// Muy cutre pero no se me ocurre nada mas de momento
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		if (!entrada.isEmpty() && (comprobarProbE2(entrada))) { // Cuidado con comprobarProbE2 no E
			int totalCasos = Integer.parseInt(entrada.get(0));
			int casoActual = 1;
			int datoActual = 1;

			while (casoActual <= totalCasos) {
				int oxigenoMin = Integer.parseInt(entrada.get(datoActual));
				datoActual++;
				int totalNaves = Integer.parseInt(entrada.get(datoActual));
				datoActual++;

				List<String> datosNaves = new ArrayList<String>();

				for (int i = 0; i < totalNaves; i++) {
					datosNaves.add(entrada.get(datoActual));
					datoActual++;
				}

				System.out.println("Caso actual: " + casoActual + " Oxigeno necesario: " + oxigenoMin + " N� naves: "
						+ totalNaves + " Oxigeno-Peso: " + datosNaves);
				comprobarNaves(oxigenoMin, datosNaves, casoActual, salida);

				casoActual++;
			}
		}
		System.out.println(salida);
		return salida;
	}

	private static void comprobarNaves(int oxigenoMin, List<String> datosNaves, int casoActual, ArrayList salida) {
		salida.add("Caso " + casoActual + ":");
		Collections.sort(datosNaves, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
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
		for (int i = 0; i < datosNaves.size(); i++) {
			salida.add(datosNaves.get(i));
		}
	}

	private static boolean comprobarProbE2(List<String> entrada) {
		int totalCasos = Integer.parseInt(entrada.get(0));
		int condiciones = 0;
		int oxigenoMinimo = 0;
		int numNaves = 0;
		int casoActual = 0;
		int datoActual = 1; // Esto se que esta mal
		if ((totalCasos >= 1 && totalCasos <= 3) && (entrada.size() >= (totalCasos * 2) + 1)) {
			while (casoActual < totalCasos) {
				condiciones++;
				// System.out.println(condiciones + "-" + datoActual + "-" +
				// entrada.get(datoActual));
				// Comprobar oxigenoMinimo
				// System.out.println(condiciones + "-" + datoActual + "-" +
				// entrada.get(datoActual));
				if (Integer.parseInt(entrada.get(datoActual)) >= 1
						&& Integer.parseInt(entrada.get(datoActual)) <= 100000) {
					oxigenoMinimo = Integer.parseInt(entrada.get(datoActual));
					datoActual++;
					condiciones++;
					// Comprobar el numero de naves
					if (Integer.parseInt(entrada.get(datoActual)) >= 1
							&& Integer.parseInt(entrada.get(datoActual)) <= 50000) {
						// datoActual++;
						condiciones++;
						numNaves = Integer.parseInt(entrada.get(datoActual));

						// System.out.println("cond antes " + condiciones);
						for (int i = 0; i < numNaves; i++) {
							// System.out.println(i);
							datoActual++;
							if (entrada.get(datoActual).contains(" ") && comprobarNaves(entrada.get(datoActual))) {
								// Si contiene " " y las naves tienen bien los datos de oxigeno y peso
								condiciones++;
							}
						}
					}
				}
				casoActual++;
				datoActual++;
			}
			// System.out.println(totalCasos * 3 + "-" + (entrada.size() - 1));
			// System.out.println((totalCasos * 3) + (numNaves * 2));
			// System.out.println(totalCasos);
			// System.out.println(condiciones + "-" + (entrada.size() + totalCasos - 1));
			System.out.println(entrada.size() + 2);
			if (condiciones == entrada.size() + totalCasos - 1) {
				return true;
			}
		}
		return false;
	}

	private static boolean comprobarProbE(List<String> entrada) {
		int totalCasos = Integer.parseInt(entrada.get(0));
		int condiciones = 0;
		int oxigenoMinimo = 0;
		int numNaves = 0;
		int casoActual = 0;
		if ((totalCasos >= 1 && totalCasos <= 3) && (entrada.size() >= (totalCasos * 2) + 1)) {
			while (casoActual < totalCasos) {
				int datoActual = 1; // Esto se que esta mal
				condiciones++;
				// System.out.println(condiciones + "-" + datoActual + "-" +
				// entrada.get(datoActual));
				// Comprobar oxigenoMinimo
				System.out.println(condiciones + "-" + datoActual + "-" + entrada.get(datoActual));
				if (Integer.parseInt(entrada.get(datoActual)) >= 1
						&& Integer.parseInt(entrada.get(datoActual)) <= 100000) {
					oxigenoMinimo = Integer.parseInt(entrada.get(datoActual));
					datoActual++;
					condiciones++;
					// Comprobar el numero de naves
					if (Integer.parseInt(entrada.get(datoActual)) >= 1
							&& Integer.parseInt(entrada.get(datoActual)) <= 50000) {
						// datoActual++;
						condiciones++;
						numNaves = Integer.parseInt(entrada.get(datoActual));

						// System.out.println("cond antes " + condiciones);
						for (int i = 0; i < numNaves; i++) {
							// System.out.println(i);
							datoActual++;
							if (entrada.get(datoActual).contains(" ") && comprobarNaves(entrada.get(datoActual))) {
								// Si contiene " " y las naves tienen bien los datos de oxigeno y peso
								condiciones++;
							}
							// System.out.println("condiciones mientr "+condiciones);
						}
						// System.out.println("condiciones desp " + condiciones);
					}
				}
				// System.out.println(condiciones);
				// numCasos+numCasos*oxigeno +
				// numCasos*oxigeno+numnaves*2
				casoActual++;
			}
			// System.out.println(totalCasos * 3 + "-" + (entrada.size() - 1));
			// System.out.println((totalCasos * 3) + (numNaves * 2));
			System.out.println(condiciones + "-" + entrada.size());
			if (condiciones == entrada.size() - 1) {
				return true;
			}
		}
		return false;
	}

	private static boolean comprobarNaves(String string) {
		// System.out.println(string);
		String aux[] = string.split(" ");
		if ((Integer.parseInt(aux[0]) >= 1 && Integer.parseInt(aux[0]) <= 100000)
				&& (Integer.parseInt(aux[1]) >= 1 && Integer.parseInt(aux[1]) <= 100000)) {
			return true;
		}
		return false;
	}
}
