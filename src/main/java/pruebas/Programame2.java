package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Programame2 {

	public static void main(String[] args) {
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
				System.out.println();

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


	private static boolean comprobarProbE(List<String> entrada) {
		// TODO Auto-generated method stub
		return true;
	}

}
