package proyectofinal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class CalculatorTest {

	Calculator calc = new Calculator();

	@BeforeAll
	static void init() throws Exception {
		System.out.println("me ejecuto una vez");
	}

	@AfterAll
	static void close() throws Exception {
		System.out.println("me ejectuto al final");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Antes del Test");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Despues del Test");
	}


	@Test
	void testSumTwoNumbers() {

		assertEquals("El test ha fallado," + " el resultado no es 7", 7, calc.sum(2, 5));
		assertEquals("El test ha fallado," + " el resultado no es 13", 13, calc.sum(5, 8));
	}

	@Test
	void testSumTwoEvenNumbers() {
		assertEquals("", 6, calc.sum(2, 4));
		assertEquals("", 24, calc.sum(16, 8));
	}

	@Test
	void testSumTwoOddNumbers() {
		assertEquals("", 6, calc.sum(1, 5));
		assertEquals("", 24, calc.sum(15, 9));
	}

	@Test
	void testSumPariety() {
		assertTrue("", calc.sum(1, 5) % 2 == 0);
		assertTrue("", calc.sum(2, 4) % 2 == 0);
	}

	@Test
	void testIsAnAdult() {
		assertTrue("", calc.isAnAdult(19));
		assertTrue("", calc.isAnAdult(18));
		assertTrue("", calc.isAnAdult(65));
		assertFalse("", calc.isAnAdult(7));
		assertFalse("", calc.isAnAdult(17));
	}

	@Test
	void testAllowAdult() {
		calc.allowOnlyAdults(19);
	}

	@Test
	void testDontAllowUnderAge() {
		try {
			calc.allowOnlyAdults(17);
			fail("Aqui nunca se debe llegar");
		} catch (Exception e) {
		}

	}

//	@Test
//	void testDontAllowUnderAgeAnnotation() {
//		Assertions.assertThows(RuntimeException.class, () -> {calc.allowOnlyAdults(17)});
//	}

	@Test
	void testAllowOverAge() {
		try {
			calc.allowOnlyAdults(18);
		} catch (Exception e) {
			fail("Aqui nunca se debe llegar");
		}

	}

}
