package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopiaProb {
	public static void main(String[] args) {
		problemaE(new ArrayList<>(Arrays.asList("2", "100", "3", "100 1000", "50 300", "50 5000", "200", "3",
				"100 1000", "60 300", "50 300"))).toArray();
	}

	public static List<String> problemaE(List<String> entrada) {
		// Muy cutre pero no se me ocurre nada mas de momento
		boolean over = false, lost = false;
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		if (!entrada.isEmpty() && (comprobarProbE(entrada))) { // !entrada.isEmpty() && datosCorrectos??
			// Primero llamar a un metodo que compruebe que hay suficientes datos y que
			// todos estan correctos
			int totalCasos = Integer.parseInt(entrada.get(0));
			int casoActual = 0; // Lo dejo como 0 o como 1? Si lo pongo como 1 en el while sera <=
			int datoActual = 1;
			while (casoActual < totalCasos) {

				casoActual++;
			}
		}
		System.out.println(salida);
		return salida;
	}

	private static boolean comprobarProbE(List<String> entrada) {
		// TODO Auto-generated method stub
		return false;
	}

}
