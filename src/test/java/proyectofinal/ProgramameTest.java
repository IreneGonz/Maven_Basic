package proyectofinal;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import pruebas.Programame;

@RunWith(JUnitPlatform.class)
class ProgramameTest {
	Programame ej = new Programame();

	/**
	 * Enunciado en ProblemaA.pdf
	 */
	// @Test
	void testProblemaA() {
		assertNotNull(ej.problemaA(Collections.EMPTY_LIST));
		assertArrayEquals(new String[] { "-8", "5", "21", "ERROR", "-8" },
				ej.problemaA(new ArrayList<>(Arrays.asList("5", "5 + -13", "10 / 2", "7 * 3", "3 / 0", "5 - 13")))
						.toArray());

		// Comprobar si paso numeros >10000 o <-10000
	}

	// @Test
	void testProblemaATestLimite() {
		// No espera que devuelva nada porque esta mal hecho el caso de prueba
		assertArrayEquals(new String[] {},
				ej.problemaA(new ArrayList<>(Arrays.asList("50", "5 + -13", "10 / 2", "7 * 3", "3 / 0", "5 - 13")))
						.toArray());
	}

	// @Test // No se si funciona asi
	void testProblemaALimite() {
		try {
			ej.problemaA(new ArrayList<>(Arrays.asList("3", "5 + -13", "10 / 2", "7 * 3", "3 / 0", "5 - 13")))
					.toArray();
			fail("Algo ha fallado");
		} catch (Exception e) {
		}
	}

	/**
	 * Enunciado en ProblemaB.pdf
	 */
	// @Test
	void testProblemaB() {
		assertNotNull(ej.problemaB(Collections.EMPTY_LIST));
		assertArrayEquals(new String[] { "OK", "ERROR", "OK", "ERROR", "ERROR", "ERROR" },
				ej.problemaB(new ArrayList<>(Arrays.asList("6", "Polonio", "TT", "RADIO", "helio", "BeCeRRo", "AHA")))
						.toArray());
	}

	// @Test
	void testProblemaBLimite() {
		assertArrayEquals(new String[] {},
				ej.problemaB(new ArrayList<>(Arrays.asList("10", "Polonio", "TT", "RADIO", "helio", "BeCeRRo", "AHA")))
						.toArray());
		assertArrayEquals(new String[] {},
				ej.problemaB(new ArrayList<>(Arrays.asList("6", "AAA", "TT", "RADIO", "helio", "BeCeRRo", "AHA")))
						.toArray());
	}

	/**
	 * Enunciado en ProblemaC.pdf
	 */
	// @Test
	void testProblemaC() {
		assertNotNull(ej.problemaC(Collections.EMPTY_LIST));

		// Esta puesto al reves
		// assertArrayEquals(new String[] { "3", "100", "137", "7" },
		// ej.problemaC(new ArrayList<>(Arrays.asList("4", "12", "0"))).toArray());

		assertArrayEquals(new String[] { "4", "12", "0" },
				ej.problemaC(new ArrayList<>(Arrays.asList("3", "100", "137", "7"))).toArray());
	}

	// @Test
	void testProblemaC2() {
		assertArrayEquals(new String[] { "4", "12", "0" },
				ej.problemaC(new ArrayList<>(Arrays.asList("3", "100", "137", "7"))).toArray());
	}

	// @Test
	void testProblemaCLimite() {
		assertArrayEquals(new String[] {},
				ej.problemaC(new ArrayList<>(Arrays.asList("3", "0", "137", "7"))).toArray());
	}

	// @Test // No se si esto funciona asi
	void testProblemaC3() {
		try {
			ej.problemaC(new ArrayList<>(Arrays.asList("4", "100", "137", "7"))).toArray();
			fail("Algo ha fallado");
		} catch (Exception e) {
		}
	}

	/**
	 * Enunciado en ProblemaD.pdf
	 */
	// @Test
	void testProblemaD() {
		assertNotNull(ej.problemaD(Collections.EMPTY_LIST));
		// Arreglado el problema con el caso de prueba 12 en vez de 1 2
		assertArrayEquals(new String[] { "VICTORIA", "GAMEOVER", "PERDIDO" }, ej.problemaD(new ArrayList<>(
				Arrays.asList("3", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "1 2", "3 2", "2,3")))
				.toArray());
	}

	// @Test
	void testProblemaDCasosMalPasados() {
		assertArrayEquals(new String[] {},
				ej.problemaD(new ArrayList<>(
						Arrays.asList("7", "2", "1", "1 2", "2", "3", "1", "1 2", "2,3", "5", "2", "12", "3 2", "2,3")))
						.toArray());
		assertArrayEquals(new String[] {},
				ej.problemaD(new ArrayList<>(Arrays.asList("1", "41", "1", "2 3", "4"))).toArray());
		assertArrayEquals(new String[] {},
				ej.problemaD(new ArrayList<>(Arrays.asList("1", "1", "2", "2 3", "4,"))).toArray());
	}

	/**
	 * Enunciado en ProblemaE.pdf
	 */
	@Test
	void testProblemaE() {
		assertNotNull(ej.problemaE(Collections.EMPTY_LIST));
		assertArrayEquals(
				new String[] { "Caso 1:", "100 1000", "50 300", "50 5000", "Caso 2:", "60 300", "50 300", "100 1000" },
				ej.problemaE(new ArrayList<>(Arrays.asList("2", "100", "3", "100 1000", "50 300", "50 5000", "200", "3",
						"100 1000", "60 300", "50 300"))).toArray());
	}

	@Test
	void testProblemaECasosLimite() {
		assertArrayEquals(new String[] { "" }, ej.problemaE(new ArrayList<>(Arrays.asList("10", "1000000", "3",
				"100 1000", "50 300", "50 5000", "200", "3", "100 1000", "60 300", "50 300"))).toArray());
		assertArrayEquals(new String[] { "" }, ej.problemaE(new ArrayList<>(Arrays.asList("2", "1000001", "3",
				"100 1000", "50 300", "50 5000", "200", "3", "100 1000", "60 300", "50 300"))).toArray());
		assertArrayEquals(new String[] { "" }, ej.problemaE(new ArrayList<>(Arrays.asList("2", "100", "500000",
				"100 1000", "50 300", "50 5000", "200", "3", "100 1000", "60 300", "50 300"))).toArray());
		assertArrayEquals(new String[] { "" }, ej.problemaE(new ArrayList<>(Arrays.asList("2", "100", "3", "100 1000",
				"50 300", "50 5000", "200", "3", "1000000 1000", "60 300", "50 300"))).toArray());
		assertArrayEquals(new String[] { "" }, ej.problemaE(new ArrayList<>(Arrays.asList("2", "100", "3", "100 1000",
				"50 300", "50 5000", "200", "3", "100 1000", "60 1000000", "50 300"))).toArray());
	}

}
