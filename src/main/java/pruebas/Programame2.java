package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programame2 {

	public static void main(String[] args) {
		// No peta pero esta mal el caso de prueba (no es 12 sino 1 2)
		problemaD2(new ArrayList<>(
				Arrays.asList("3", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "1 2", "3 2", "2,3")));
		
		// Peta pero el caso de prueba esta bien

		// problemaD(new ArrayList<>(
		// Arrays.asList("3", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "1
		// 2", "3 2", "2,3")));

		// problemaD(new ArrayList<>(
		// Arrays.asList("2", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3")));

		// Lo de arriba tiene que dar VICTORIA y GAME OVER
		// problemaD(new ArrayList<>(Arrays.asList("1", "2", "1", "1 2", "2"))); //
		// Tiene que dar VICTORIA

		// problemaD(new ArrayList<>(
		// Arrays.asList("3", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "1
		// 2", "3 2", "2,3")));

		// problemaD(new ArrayList<>(Arrays.asList("1", "2", "1", "1 2", "2")));
	}

	public static List<String> problemaD2(List<String> entrada) { // Otra prueba más
		ArrayList salida = new ArrayList();
		System.out.println(entrada);

		if (!entrada.isEmpty()) {
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
						if (casoActual == 1) {
						}
						habitacionesConectadas[i][j] = Integer.parseInt(aux.get(x));
						x++;
					}
				}
				List<Integer> habsConec = new ArrayList<Integer>();
				for (int i = 0; i < habitacionesConectadas.length; i++) {
					for (int j = 0; j < habitacionesConectadas[i].length; j++) {
						habsConec.add(habitacionesConectadas[i][j]);
					}
				}
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


				System.out.println("Habitaciones: " + habitaciones + " Num conexiones: " + conexionesEntreHabitaciones
						+ " Habitaciones conectadas: " + habsConec + " Pasos: " + pasos);

				casoActual++; // Cambiamos de caso cuando cogemos todos los datos
			}
		}

		System.out.println(salida);
		return salida;
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

				//String habitacionesConectadas[] = new String[conexHab * 2];
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
