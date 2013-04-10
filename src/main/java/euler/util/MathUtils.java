package euler.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MathUtils {

	/**
	 * Returns the highest value between a and b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static long max(long a, long b) {
		return a > b ? a : b;
	}

	/**
	 * Returns the highest value between a and b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigInteger max(BigInteger a, BigInteger b) {
		return a.compareTo(b) > 0 ? a : b;
	}

	/**
	 * Computes the squareroot of n.
	 * 
	 * @param n
	 * @return
	 */
	public static long sqrt(long n) {
		return (long) Math.floor(Math.sqrt(n));
	}

	/**
	 * Returns the value of p raised to the power of n.
	 * 
	 * @param n
	 * @return
	 */
	public static long pow(long p, long n) {
		return (long) Math.pow(p, n);
	}

	/**
	 * Returns the largest long value that is less than or equal to n and is
	 * equal to a mathematical integer.
	 * 
	 * @param n
	 * @return
	 */
	public static long floor(double n) {
		return (long) Math.floor(n);
	}

	public static boolean divide(long numerator, long divider) {
		return numerator % divider == 0;
	}

	private static Set<Long> primes = new TreeSet<Long>();

	private static Map<Long, Boolean> primesCache = new HashMap<Long, Boolean>();

	/**
	 * Returns if n is prime.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(BigInteger n) {
		return isPrime(n.longValue());
	}

	/**
	 * Returns if n is prime.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(long n) {
		Boolean isPrime = primesCache.get(n);
		if (isPrime != null)
			return isPrime;
		if (n <= 1) {
			primesCache.put(n, false);
			return false;
		}
		if (n < 4) {
			primesCache.put(n, true);
			primes.add(n);
			return true;
		}
		if (n % 2 == 0) {
			primesCache.put(n, false);
			return false;
		}
		if (n < 9) {
			primesCache.put(n, true);
			primes.add(n);
			return true;
		}
		if (n % 3 == 0) {
			primesCache.put(n, false);
			return false;
		}
		long f = 5;
		while (f <= sqrt(n)) {
			if (n % f == 0 || n % (f + 2) == 0) {
				primesCache.put(n, false);
				return false;
			}
			f += 6;
		}
		primesCache.put(n, true);
		primes.add(n);
		return true;
	}

	public static Set<Long> getPrimes(long n) {
		long lastPrime = primes.isEmpty() ? 2 : Collections.max(primes);
		if (lastPrime == n)
			return primes;
		if (lastPrime > n) {
			Set<Long> list = new TreeSet<Long>();
			for (long p : primes) {
				if (p > n)
					break;
				list.add(p);
			}
			return list;
		}
		for (long i = lastPrime; i <= n; i++) {
			if (isPrime(i))
				primes.add(i);
		}
		return primes;
	}

	public static List<Long> getPrimeDecomposition(long n) {
		List<Long> decomposition = new ArrayList<Long>();
		for (long p : getPrimes(n / 2)) {
			while (divide(n, p)) {
				decomposition.add(p);
				n = n / p;
			}
		}
		return decomposition;
	}

	public static List<Long> getDistinctPrimeDecomposition(long n) {
		List<Long> decomposition = new ArrayList<Long>();
		for (long p : getPrimes(n / 2)) {
			if (divide(n, p)) {
				decomposition.add(p);
				n = n / p;
			}
		}
		return decomposition;
	}

	/**
	 * Returns if a and b are prime together
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean arePrime(long a, long b) {
		return MathUtils.gcd(a, b) == 1;
	}

	/**
	 * Computes the greatest common divisor of a and b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static long gcd(long a, long b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	/**
	 * Computes the least common multiple of a and b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	/**
	 * Returns if the triplet a,b,c is a Pythagorean triplet.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	public static boolean isPythagoreanTriplet(long a, long b, long c) {
		return a * a + b * b == c * c;
	}

	/**
	 * Returns if q divide p.
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean isDivider(long p, long q) {
		return p % q == 0;
	}

	/**
	 * Returns if q divide p.
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean isDivider(BigInteger p, BigInteger q) {
		return BigInteger.ZERO.equals(p.mod(q));
	}

	/**
	 * n^C_r = n! / r!(n−r)!
	 * 
	 * @param n
	 * @param p
	 * @return
	 */
	public static BigInteger C(long n, long r) {
		return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
	}

	/**
	 * n! = n×(n−1)×...×3×2×1, and 0! = 1.
	 * 
	 * @param n
	 * @return
	 */
	public static BigInteger factorial(long n) {
		return n == 0 ? BigInteger.ONE : BigInteger.valueOf(n).multiply(
				factorial(n - 1));
	}

	/**
	 * The hyperexponentiation or tetration of a number a by a positive integer
	 * b, denoted by a↑↑b or ^(b)a, is recursively defined by:
	 * 
	 * a↑↑1 = a, a↑↑(k+1) = a^((a↑↑k)).
	 * 
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	public static BigInteger hyperExponential(long a, long b, int n) {
		BigInteger p = BigInteger.valueOf(a);
		BigInteger r = BigInteger.ONE;
		while (b > 0) {
			r = p.modPow(r, BigInteger.TEN.pow(n));
			b--;
		}
		return r;
	}

}
