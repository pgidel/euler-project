package euler.utils;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

import euler.util.MathUtils;

public class MathUtilsTest {

	@Test
	public void testIsPrime() {
		Assert.assertFalse(MathUtils.isPrime(-1));
		Assert.assertFalse(MathUtils.isPrime(0));
		Assert.assertFalse(MathUtils.isPrime(1));
		Assert.assertTrue(MathUtils.isPrime(2));
		Assert.assertTrue(MathUtils.isPrime(3));
		Assert.assertFalse(MathUtils.isPrime(4));
		Assert.assertFalse(MathUtils.isPrime(9));
		Assert.assertTrue(MathUtils.isPrime(41));
		Assert.assertFalse(MathUtils.isPrime(49));
	}

	@Test
	public void testArePrime() {
		Assert.assertFalse(MathUtils.arePrime(2, 4));
		Assert.assertFalse(MathUtils.arePrime(4, 2));
		Assert.assertFalse(MathUtils.arePrime(6, 2));
		Assert.assertFalse(MathUtils.arePrime(6, 3));
		Assert.assertTrue(MathUtils.arePrime(7, 5));
	}

	@Test
	public void testGcd() {
		Assert.assertEquals(2, MathUtils.gcd(4, 2));
		Assert.assertEquals(3, MathUtils.gcd(6, 3));
		Assert.assertEquals(2, MathUtils.gcd(6, 4));
		Assert.assertEquals(1, MathUtils.gcd(7, 5));
	}

	@Test
	public void testLcm() {
		Assert.assertEquals(6, MathUtils.lcm(6, 3));
		Assert.assertEquals(12, MathUtils.lcm(6, 4));
		Assert.assertEquals(35, MathUtils.lcm(7, 5));
	}

	@Test
	public void testIsPythagoreanTriplet() {
		Assert.assertTrue(MathUtils.isPythagoreanTriplet(3, 4, 5));
		Assert.assertTrue(MathUtils.isPythagoreanTriplet(5, 12, 13));
		Assert.assertFalse(MathUtils.isPythagoreanTriplet(1, 2, 3));
	}

	@Test
	public void testC() {
		Assert.assertEquals(BigInteger.valueOf(1), MathUtils.C(0, 0));
		Assert.assertEquals(BigInteger.valueOf(10), MathUtils.C(5, 3));
		Assert.assertEquals(BigInteger.valueOf(1144066), MathUtils.C(23, 10));
	}

	@Test
	public void testFactorial() {
		Assert.assertEquals(BigInteger.valueOf(1), MathUtils.factorial(0));
		Assert.assertEquals(BigInteger.valueOf(1), MathUtils.factorial(1));
		Assert.assertEquals(BigInteger.valueOf(2), MathUtils.factorial(2));
		Assert.assertEquals(BigInteger.valueOf(6), MathUtils.factorial(3));
	}

	@Test
	public void testHyperExponential() {
		Assert.assertEquals(BigInteger.valueOf(27),
				MathUtils.hyperExponential(3, 2, 2));
		Assert.assertEquals(BigInteger.valueOf(7625597484987L),
				MathUtils.hyperExponential(3, 3, 13));
	}

}
