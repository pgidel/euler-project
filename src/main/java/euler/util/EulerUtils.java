package euler.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import euler.exception.EulerException;
import euler.exception.EulerException.CodeError;
import euler.util.math.geometry.Point;
import euler.util.math.geometry.Triangle;

public class EulerUtils {

	/**
	 * Evaluates the sum of the numbers less than max divisible by n.
	 * 
	 * @param n
	 * @return
	 */
	public static long sumDivisibleBy(long n, long max) {
		long p = max / n;
		if (max % n == 0)
			p--;
		return n * p * (p + 1) / 2;
	}

	/**
	 * Evaluates the sum of the digits of the number n.
	 * 
	 * @param n
	 * @return
	 */
	public static long sumDigits(long n) {
		return sumPowDigits(BigInteger.valueOf(n), 1);
	}

	/**
	 * Evaluates the sum of the digits of the number n.
	 * 
	 * @param n
	 * @return
	 */
	public static long sumDigits(BigInteger n) {
		return sumPowDigits(n, 1);
	}

	/**
	 * Evaluates the sum of the digits of the number n.
	 * 
	 * @param n
	 * @return
	 */
	public static long sumPowDigits(long n, long p) {
		return sumPowDigits(BigInteger.valueOf(n), p);
	}

	/**
	 * Evaluates the sum of the digits of the number n.
	 * 
	 * @param n
	 * @return
	 */
	public static long sumPowDigits(BigInteger n, long p) {
		long sum = 0;
		for (char c : n.toString().toCharArray()) {
			sum += Math.pow(Character.getNumericValue(c), p);
		}
		return sum;
	}

	/**
	 * Evaluates the sum of the digits of the number n.
	 * 
	 * @param n
	 * @return
	 */
	public static long sumDigitFactorials(long n) {
		long sum = 0;
		for (char c : String.valueOf(n).toCharArray()) {
			long product = 1;
			for (int i = Character.getNumericValue(c); i > 1; i--) {
				product *= i;
			}
			sum += product;
		}
		return sum;
	}

	public static boolean isAmicable(long n) {
		long a = sumProperDivisorsOf(n);
		long b = sumProperDivisorsOf(a);
		if (n != a && n == b)
			return true;
		return false;
	}

	public static boolean isCircularPrime(long n) {
		String digits = Long.toString(n);
		if (n < 10)
			return MathUtils.isPrime(n);
		for (int i = 0; i < digits.length(); i++) {
			switch (digits.charAt(i)) {
			case '0':
			case '2':
			case '4':
			case '5':
			case '6':
			case '8':
				return false;
			}
		}
		for (String rotation : StringUtils.rotate(digits)) {
			long p = Long.valueOf(rotation);
			if (!MathUtils.isPrime(p))
				return false;
		}
		return true;
	}

	public static boolean isAbundant(long n) {
		return sumProperDivisorsOf(n) > n;
	}

	public static boolean isDeficient(long n) {
		return sumProperDivisorsOf(n) < n;
	}

	public static boolean isPerfect(long n) {
		return sumProperDivisorsOf(n) == n;
	}

	public static boolean isIncreasing(BigInteger n) {
		String s = n.toString();
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) < s.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDecreasing(BigInteger n) {
		String s = n.toString();
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) > s.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isTriangle(long i) {
		long n = MathUtils.sqrt(i * 2);
		return n * (n + 1) == i * 2;
	}

	public static long getTriangle(long n) {
		return n * (n + 1) / 2;
	}

	public static long getSquare(long n) {
		return n * n;
	}

	public static long getPentagonal(long n) {
		return n * (3 * n - 1) / 2;
	}

	public static long getHexagonal(long n) {
		return n * (2 * n - 1);
	}

	public static long getHeptagonal(long n) {
		return n * (5 * n - 3) / 2;
	}

	public static long getOctagonal(long n) {
		return n * (3 * n - 2);
	}

	public static boolean isPandigital(long pandigital, boolean hasZero) {
		String p = String.valueOf(pandigital);
		if (p.length() != (hasZero ? 10 : 9))
			return false;
		for (int i = (hasZero ? 0 : 1); i <= 9; i++)
			if (!p.contains(String.valueOf(i)))
				return false;
		return true;
	}

	public static boolean isPentagonal(long x) {
		double t = (Math.sqrt(24 * x + 1) + 1) / 6;
		return Math.floor(t) == t;
	}

	/**
	 * Evaluates the sum of proper divisors of n.
	 * 
	 * @param n
	 * @return
	 */
	public static long sumProperDivisorsOf(long n) {
		if (n == 1)
			return 0;
		long sum;
		long root = MathUtils.sqrt(n);
		if (root * root == n) {
			sum = 1 + root;
			root--;
		} else {
			sum = 1;
		}
		long f;
		short step;
		if (n % 2 == 0) {
			f = 2;
			step = 1;
		} else {
			f = 3;
			step = 2;
		}
		while (f <= root) {
			if (n % f == 0)
				sum += f + n / f;
			f += step;
		}
		return sum;
	}

	/**
	 * Returns the number of divisors of n.
	 * 
	 * @param n
	 * @return
	 */
	public static int getNbDivisors(long n) {
		if (n == 1)
			return 1;
		int nb;
		long root = MathUtils.sqrt(n);
		if (root * root == n) {
			nb = 3;
			root--;
		} else {
			nb = 2;
		}
		long f;
		short step;
		if (n % 2 == 0) {
			f = 2;
			step = 1;
		} else {
			f = 3;
			step = 2;
		}
		while (f <= root) {
			if (n % f == 0)
				nb += 2;
			f += step;
		}
		return nb;
	}

	/**
	 * Returns the score of n.
	 * 
	 * @param n
	 * @return
	 */
	public static int getScore(String n) {
		int score = 0;
		for (char c : n.toCharArray()) {
			score += Character.getNumericValue(c) - 9;
		}
		return score;
	}

	/**
	 * Finds the maximum total from top to bottom of a binary tree.
	 * 
	 * @param arbre
	 * @param n
	 * @param s
	 * @return
	 */
	public static long maxTreeSum(List<Integer> arbre, int n, long s) {
		if (2 * n + 1 >= arbre.size())
			return arbre.get(n);
		long s1 = maxTreeSum(arbre, 2 * n + 1, s);
		long s2 = maxTreeSum(arbre, 2 * n + 2, s);
		return s1 > s2 ? arbre.get(n) + s1 : arbre.get(n) + s2;
	}

	/**
	 * Finds the maximum total from top to bottom of a triangle.
	 * 
	 * @param triangle
	 * @param triangleCheck
	 * @param s
	 * @return
	 */
	public static long maxTriangleSum(List<Long> triangle,
			List<Boolean> triangleCheck, int n, int i, long sum) {
		// FIXME
		if (triangleCheck.get(i))
			return triangle.get(i);
		if (i + n >= triangle.size())
			return triangle.get(i);
		Long s = triangle.get(i);
		triangle.remove(i);
		s += MathUtils.max(
				maxTriangleSum(triangle, triangleCheck, n + 1, i + n - 1, sum),
				maxTriangleSum(triangle, triangleCheck, n + 1, i + n, sum));
		triangle.add(i, s);
		Boolean b = triangleCheck.get(i);
		triangleCheck.remove(i);
		b = true;
		triangleCheck.add(i, b);
		return triangle.get(i);
	}

	/**
	 * Returns the list of the primes from 2 to n.
	 * 
	 * @param n
	 * @return
	 */
	public static List<Long> getPrimes(long n) {
		List<Long> list = new ArrayList<Long>();
		for (long i = 2; i <= n; i++) {
			if (MathUtils.isPrime(i))
				list.add(i);
		}
		return list;
	}

	/**
	 * Compute the sum of both diagonals in a n by n spiral.
	 * 
	 * @param n
	 * @return
	 */
	public static long sumSpiralDiagonals(int n) {
		long sum = 1;
		while (n > 1) {
			sum += 4 * n * n - 6 * n + 6;
			n -= 2;
		}
		return sum;
	}

	/**
	 * Get the sequence generated by a^(b) for 2<=a<=n and 2<=b<=m.
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static Set<BigInteger> getPowSequence(int n) {
		Set<BigInteger> sequence = new HashSet<BigInteger>();
		for (BigInteger i = BigInteger.valueOf(2); i.compareTo(BigInteger
				.valueOf(n)) <= 0; i = i.add(BigInteger.ONE)) {
			sequence.add(i.pow(i.intValue()));
			for (BigInteger j = i.add(BigInteger.ONE); j.compareTo(BigInteger
					.valueOf(n)) <= 0; j = j.add(BigInteger.ONE)) {
				sequence.add(i.pow(j.intValue()));
				sequence.add(j.pow(i.intValue()));
			}
		}
		return sequence;
	}

	public static BigInteger computeNbWays(long target, long[] coins) {
		return computeNbWays(target, coins.length, coins);
	}

	private static BigInteger computeNbWays(long target, int index, long[] coins) {
		if (target == 0)
			return BigInteger.ONE;
		if (target < 0 || index <= 0 && target >= 1)
			return BigInteger.ZERO;
		return computeNbWays(target, index - 1, coins).add(
				computeNbWays(target - coins[index - 1], index, coins));
	}

	/**
	 * Evaluates if the prime is truncatable.
	 * 
	 * @param p
	 * @return
	 */
	public static boolean isTruncatablePrime(long p) {
		if (p < 10 || !MathUtils.isPrime(p))
			return false;
		String s = String.valueOf(p);
		for (int i = 1; i < s.length(); i++) {
			if (!MathUtils
					.isPrime(Long.valueOf(s.substring(0, s.length() - i)))
					|| !MathUtils.isPrime(Long.valueOf(s.substring(i,
							s.length()))))
				return false;
		}
		return true;
	}

	/**
	 * Generate the list of the n-pandigital numbers.
	 * 
	 * @param n
	 * @return
	 */
	public static List<Integer> generatePandigitalNumbers(int n) {
		String digits = "";
		for (int i = n; i >= 1; i--) {
			digits += i;
		}

		List<Integer> pandigital = new ArrayList<Integer>();
		for (String s : StringUtils.permute(digits)) {
			pandigital.add(Integer.valueOf(s));
		}
		return pandigital;
	}

	/**
	 * Determines if n is a Lychrel number with max tries.
	 * 
	 * @param n
	 * @param max
	 * @return
	 */
	public static boolean isLychrel(BigInteger n, int max) {
		if (max == 0)
			return true;
		BigInteger nL = n.add(new BigInteger(StringUtils.reverse(String
				.valueOf(n))));
		if (StringUtils.isPalindromic(String.valueOf(nL)))
			return false;
		return isLychrel(nL, --max);
	}

	/**
	 * Determines if i is n-pandigital.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isNPandigital(int n, BigInteger p) {
		assert n > 0 && n < 10;
		String s = p.toString();
		if (s.length() != n)
			return false;
		for (int i = 1; i < n; i++) {
			if (!s.contains(Integer.toString(i)))
				return false;
		}
		return true;
	}

	public static String getExpansion(long a, long b) {
		assert b > 0;
		long q = a / b;
		long r = a % b;
		String expansion = Long.toString(q);
		if (r == 0)
			return expansion;
		expansion += ".";
		Map<Long, Integer> remainders = new HashMap<Long, Integer>();
		remainders.put(r, expansion.length());
		while (r != 0) {
			q = r * 10 / b;
			r = r * 10 % b;
			expansion += Long.toString(q);
			if (r == 0)
				break;
			else if (remainders.containsKey(r)) {
				int pos = remainders.get(r);
				r = 0;
				expansion = expansion.substring(0, pos) + '('
						+ expansion.substring(pos, expansion.length()) + ')';
				break;
			} else {
				remainders.put(r, expansion.length());
			}
		}
		return expansion;
	}

	/**
	 * Determine the recurring cycle length of ^(1)/_(n)
	 * 
	 * @param n
	 * @return
	 */
	public static int getRecurringCycleLength(long n) {
		String expansion = getExpansion(1, n);
		if (!expansion.contains("("))
			return 0;
		return expansion.length() - expansion.indexOf("(") - 2;
	}

	public static long makeLargestPermutation(long n) {
		List<Long> digits = new ArrayList<Long>();

		while (n > 0) {
			digits.add(n % 10);
			n /= 10;
		}
		Collections.sort(digits);
		Collections.reverse(digits);

		long largestPermutation = 0;
		for (Long digit : digits) {
			largestPermutation = largestPermutation * 10 + digit;
		}
		return largestPermutation;
	}

	public static BigInteger[][] buildMatrix(String fileName)
			throws EulerException {
		BufferedReader reader = null;
		try {
			int nbLines = FileUtils.getFileLength(fileName);

			BigInteger[][] matrix = new BigInteger[nbLines][nbLines];

			reader = new BufferedReader(new FileReader(fileName));
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] cells = line.split(",");
				int j = 0;
				for (String cell : cells) {
					matrix[i][j] = new BigInteger(cell);
					j++;
				}
				i++;
			}

			return matrix;

		} catch (FileNotFoundException e) {
			throw new EulerException(CodeError.FILE_NOT_FOUND, fileName);
		} catch (IOException e) {
			throw new EulerException(CodeError.ERROR_READING_FILE, fileName);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new EulerException(CodeError.ERROR_CLOSING_FILE,
							fileName);
				}
			}
		}
	}

	public static List<Triangle> buildTriangles(String fileName)
			throws EulerException {
		List<Triangle> triangles = new ArrayList<Triangle>();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] coordinates = line.split(",");
				Point a = new Point(Long.parseLong(coordinates[0]),
						Long.parseLong(coordinates[1]));
				Point b = new Point(Long.parseLong(coordinates[2]),
						Long.parseLong(coordinates[3]));
				Point c = new Point(Long.parseLong(coordinates[4]),
						Long.parseLong(coordinates[5]));
				triangles.add(new Triangle(a, b, c));
			}
		} catch (FileNotFoundException e) {
			throw new EulerException(CodeError.FILE_NOT_FOUND, fileName);
		} catch (IOException e) {
			throw new EulerException(CodeError.ERROR_READING_FILE, fileName);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new EulerException(CodeError.ERROR_CLOSING_FILE,
							fileName);
				}
			}
		}

		return triangles;
	}

	/**
	 * Representation of digits from 0 to 9 depending on their place in a number
	 */
	private static String[][] romanMatrix = { { "", "", "", "" },
			{ "I", "X", "C", "M" }, { "II", "XX", "CC", "MM" },
			{ "III", "XXX", "CCC", "MMM" }, { "IV", "XL", "CD", "MMMM" },
			{ "V", "L", "D", "MMMMM" }, { "VI", "LX", "DC", "MMMMMM" },
			{ "VII", "LXX", "DCC", "MMMMMMM" },
			{ "VIII", "LXXX", "DCCC", "MMMMMMMM" },
			{ "IX", "XC", "CM", "MMMMMMMMM" } };

	public static String translateArabicToRoman(long arabicNumber) {
		String romanNumber = "";
		String aN = String.valueOf(arabicNumber);
		for (int i = aN.length() - 1; i >= 0; i--) {
			int n = Integer.valueOf("" + aN.charAt(aN.length() - i - 1));
			romanNumber += romanMatrix[n][i];
		}
		return romanNumber;
	}

	public static long translateRomanToArabic(String romanNumber) {
		long arabicNumber = 0;
		for (int i = 0; i < romanNumber.length(); i++) {
			switch (romanNumber.charAt(i)) {
			case 'I':
				arabicNumber += 1;
				if (i + 1 < romanNumber.length()) {
					switch (romanNumber.charAt(i + 1)) {
					case 'V':
						arabicNumber += 3;
						i++;
						break;
					case 'X':
						arabicNumber += 8;
						i++;
						break;
					}
				}
				break;
			case 'V':
				arabicNumber += 5;
				break;
			case 'X':
				arabicNumber += 10;
				if (i + 1 < romanNumber.length()) {
					switch (romanNumber.charAt(i + 1)) {
					case 'L':
						arabicNumber += 30;
						i++;
						break;
					case 'C':
						arabicNumber += 80;
						i++;
						break;
					}
				}
				break;
			case 'L':
				arabicNumber += 50;
				break;
			case 'C':
				arabicNumber += 100;
				if (i + 1 < romanNumber.length()) {
					switch (romanNumber.charAt(i + 1)) {
					case 'D':
						arabicNumber += 300;
						i++;
						break;
					case 'M':
						arabicNumber += 800;
						i++;
						break;
					}
				}
				break;
			case 'D':
				arabicNumber += 500;
				break;
			case 'M':
				arabicNumber += 1000;
				break;
			}
		}
		return arabicNumber;
	}

}
