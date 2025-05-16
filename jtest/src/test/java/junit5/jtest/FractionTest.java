package junit5.jtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ex2.Fraction;

/**
 * Test class for class fraction using JUnit 5
 * @author aabert
 */
public class FractionTest {
	@Test
	public void kehrwertKorrekt() {
		Fraction frac = new Fraction(5, 3);
		frac.Kehrwert();
		assertEquals(5, frac.getNenner());
		assertEquals(3, frac.getZaehler());
	}
	
	@Test
	public void nullInNennerThrowsException() {
		assertThrows(ArithmeticException.class, () -> new Fraction(5, 0));
	}
	
	@ParameterizedTest
	@CsvSource({"5 , 3, 3, 5 , 15, 15 ",
		"5 , 3, 5, 3 , 9, 25 ",
		"0 , 3, 7, 4 , 12, 0 "})
	public void multiplikationKorrekt(int z1, int n1, int z2,  int n2, int r1, int r2) {
		Fraction frac1 = new Fraction(z1, n1);
		Fraction frac2 = new Fraction(z2, n2);
		frac1.multiplikation(frac2);
		assertEquals(r1, frac1.getNenner());
		assertEquals(r2, frac1.getZaehler());
	}
	
	@ParameterizedTest
	@CsvSource({"5,3,5,3,10,3",
		"5,2,5,4,15,4",
		"3,1,2,4,7,2"})
	public void additionKorrekt(int z1, int n1, int z2,  int n2, int r1, int r2) {
		Fraction frac1 = new Fraction(z1, n1);
		Fraction frac2 = new Fraction(z2, n2);
		frac1.addition(frac2);
		assertEquals(r1, frac1.getZaehler());
		assertEquals(r2, frac1.getNenner());
	}
	
	@ParameterizedTest
	@CsvSource({"15, 3, 5, 1",
		"9, 7, 9, 7",
		"0, 5, 0, 1",
		"18, 3, 6, 1"})
	public void kuerztKorrekt(int z1, int n1, int r1, int r2) {
		Fraction frac1 = new Fraction(z1, n1);
		frac1.kuerzen();
		assertEquals(r1, frac1.getZaehler());
		assertEquals(r2, frac1.getNenner());
	}
}
