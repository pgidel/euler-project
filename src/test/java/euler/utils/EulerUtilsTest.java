package euler.utils;

import java.math.BigInteger;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import euler.util.EulerUtils;

public class EulerUtilsTest {

	@Test
	public void testSumDivisibleBy() {
		Assert.assertEquals(18, EulerUtils.sumDivisibleBy(3, 10));
		Assert.assertEquals(5, EulerUtils.sumDivisibleBy(5, 10));
	}

	@Test
	public void testSumPowDigits() {
		Assert.assertEquals(45, EulerUtils.sumPowDigits(123456789, 1));
		Assert.assertEquals(1634, EulerUtils.sumPowDigits(1634, 4));
	}

	@Test
	public void testSumDigitFactorials() {
		Assert.assertEquals(145, EulerUtils.sumDigitFactorials(145));
	}

	@Test
	public void testIsAmicable() {
		Assert.assertFalse(EulerUtils.isAmicable(10));
		Assert.assertTrue(EulerUtils.isAmicable(220));
		Assert.assertTrue(EulerUtils.isAmicable(284));
	}

	@Test
	public void testIsCircularPrime() {
		Assert.assertTrue(EulerUtils.isCircularPrime(2));
		Assert.assertFalse(EulerUtils.isCircularPrime(4));
		Assert.assertTrue(EulerUtils.isCircularPrime(11));
		Assert.assertFalse(EulerUtils.isCircularPrime(12));
		Assert.assertTrue(EulerUtils.isCircularPrime(13));
		Assert.assertTrue(EulerUtils.isCircularPrime(197));
		Assert.assertTrue(EulerUtils.isCircularPrime(719));
		Assert.assertTrue(EulerUtils.isCircularPrime(971));
		Assert.assertFalse(EulerUtils.isCircularPrime(100));
	}

	@Test
	public void testIsAbundant() {
		Assert.assertFalse(EulerUtils.isAbundant(11));
		Assert.assertTrue(EulerUtils.isAbundant(12));
		Assert.assertFalse(EulerUtils.isAbundant(28));
	}

	@Test
	public void testIsDeficient() {
		Assert.assertTrue(EulerUtils.isDeficient(11));
		Assert.assertFalse(EulerUtils.isDeficient(12));
		Assert.assertFalse(EulerUtils.isDeficient(28));
	}

	@Test
	public void testIsPerfect() {
		Assert.assertFalse(EulerUtils.isPerfect(11));
		Assert.assertFalse(EulerUtils.isPerfect(12));
		Assert.assertTrue(EulerUtils.isPerfect(28));
	}

	@Test
	public void testSumProperDivisorsOf() {
		Assert.assertEquals(284, EulerUtils.sumProperDivisorsOf(220));
		Assert.assertEquals(220, EulerUtils.sumProperDivisorsOf(284));
	}

	@Test
	public void testGetNbDivisors() {
		Assert.assertEquals(1, EulerUtils.getNbDivisors(1));
		Assert.assertEquals(2, EulerUtils.getNbDivisors(2));
		Assert.assertEquals(6, EulerUtils.getNbDivisors(28));
	}

	@Test
	public void testGetScore() {
		Assert.assertEquals(53, EulerUtils.getScore("COLIN"));
	}

	@Test
	public void testMaxTreeSum() {
	}

	@Test
	public void testMaxTriangleSum() {
	}

	@Test
	public void testGetPrimes() {
		Assert.assertEquals(0, EulerUtils.getPrimes(1).size());
		Assert.assertEquals(25, EulerUtils.getPrimes(100).size());
		Assert.assertEquals(168, EulerUtils.getPrimes(1000).size());
	}

	@Test
	public void testSumSpiralDiagonals() {
		Assert.assertEquals(101, EulerUtils.sumSpiralDiagonals(5));
	}

	@Test
	public void testGetPowSequence() {
		Assert.assertEquals(15, EulerUtils.getPowSequence(5).size());
	}

	@Test
	public void testIsTriangle() {
		Assert.assertTrue(EulerUtils.isTriangle(1));
		Assert.assertFalse(EulerUtils.isTriangle(2));
		Assert.assertTrue(EulerUtils.isTriangle(3));
		Assert.assertTrue(EulerUtils.isTriangle(10));
		Assert.assertTrue(EulerUtils.isTriangle(28));
		Assert.assertFalse(EulerUtils.isTriangle(40));
		Assert.assertTrue(EulerUtils.isTriangle(55));
	}

	@Test
	public void testIsTruncablePrime() {
		Assert.assertFalse(EulerUtils.isTruncatablePrime(2));
		Assert.assertTrue(EulerUtils.isTruncatablePrime(23));
		Assert.assertFalse(EulerUtils.isTruncatablePrime(24));
		Assert.assertTrue(EulerUtils.isTruncatablePrime(317));
		Assert.assertFalse(EulerUtils.isTruncatablePrime(417));
		Assert.assertTrue(EulerUtils.isTruncatablePrime(3797));
		Assert.assertFalse(EulerUtils.isTruncatablePrime(4173));
	}

	@Test
	public void testGeneratePandigital() {
		List<Integer> list;

		list = EulerUtils.generatePandigitalNumbers(1);
		Assert.assertEquals(1, list.size());
		Assert.assertTrue(list.contains(1));

		list = EulerUtils.generatePandigitalNumbers(2);
		Assert.assertEquals(2, list.size());
		Assert.assertTrue(list.contains(12));
		Assert.assertTrue(list.contains(21));

		list = EulerUtils.generatePandigitalNumbers(3);
		Assert.assertEquals(6, list.size());
		Assert.assertTrue(list.contains(123));
		Assert.assertTrue(list.contains(132));
		Assert.assertTrue(list.contains(213));
		Assert.assertTrue(list.contains(231));
		Assert.assertTrue(list.contains(312));
		Assert.assertTrue(list.contains(321));
	}

	@Test
	public void testGetTriangle() {
		Assert.assertEquals(28, EulerUtils.getTriangle(7));
		Assert.assertEquals(40755, EulerUtils.getTriangle(285));
	}

	@Test
	public void testGetPentagonal() {
		Assert.assertEquals(40755, EulerUtils.getPentagonal(165));
	}

	@Test
	public void testGetHexagonal() {
		Assert.assertEquals(40755, EulerUtils.getHexagonal(143));
	}

	@Test
	public void testIsLychrel() {
		Assert.assertFalse(EulerUtils.isLychrel(BigInteger.valueOf(47), 1));
		Assert.assertFalse(EulerUtils.isLychrel(BigInteger.valueOf(349), 3));
		Assert.assertTrue(EulerUtils.isLychrel(BigInteger.valueOf(196), 50));
		Assert.assertTrue(EulerUtils.isLychrel(BigInteger.valueOf(4994), 50));
		Assert.assertFalse(EulerUtils.isLychrel(BigInteger.valueOf(10677), 53));
	}

	@Test
	public void testIsNPandigital() {
		Assert.assertFalse(EulerUtils.isNPandigital(0, BigInteger.valueOf(0)));
		Assert.assertFalse(EulerUtils.isNPandigital(10,
				BigInteger.valueOf(12345678910L)));
		Assert.assertTrue(EulerUtils.isNPandigital(5, BigInteger.valueOf(12345)));
		Assert.assertFalse(EulerUtils.isNPandigital(5,
				BigInteger.valueOf(123456)));
		Assert.assertTrue(EulerUtils.isNPandigital(1, BigInteger.valueOf(1)));
	}

	@Test
	public void testGetRecurringCycleLength() {
		Assert.assertEquals(0, EulerUtils.getRecurringCycleLength(2));
		Assert.assertEquals(1, EulerUtils.getRecurringCycleLength(3));
		Assert.assertEquals(0, EulerUtils.getRecurringCycleLength(4));
		Assert.assertEquals(0, EulerUtils.getRecurringCycleLength(5));
		Assert.assertEquals(1, EulerUtils.getRecurringCycleLength(6));
		Assert.assertEquals(6, EulerUtils.getRecurringCycleLength(7));
		Assert.assertEquals(0, EulerUtils.getRecurringCycleLength(8));
		Assert.assertEquals(1, EulerUtils.getRecurringCycleLength(9));
		Assert.assertEquals(0, EulerUtils.getRecurringCycleLength(10));
		Assert.assertEquals(2, EulerUtils.getRecurringCycleLength(11));
		Assert.assertEquals(1, EulerUtils.getRecurringCycleLength(12));
		Assert.assertEquals(6, EulerUtils.getRecurringCycleLength(13));
		Assert.assertEquals(6, EulerUtils.getRecurringCycleLength(14));
		Assert.assertEquals(1, EulerUtils.getRecurringCycleLength(15));
		Assert.assertEquals(0, EulerUtils.getRecurringCycleLength(16));
		Assert.assertEquals(16, EulerUtils.getRecurringCycleLength(17));
	}

	@Test
	public void testGetCoinWays() {
		long[] coins = new long[] { 1, 2, 5, 10, 20, 50, 100, 200 };

		Assert.assertEquals(1, EulerUtils.computeNbWays(1, coins));
		Assert.assertEquals(2, EulerUtils.computeNbWays(2, coins));
		Assert.assertEquals(4, EulerUtils.computeNbWays(5, coins));
		Assert.assertEquals(11, EulerUtils.computeNbWays(10, coins));
		Assert.assertEquals(41, EulerUtils.computeNbWays(20, coins));
	}

}
