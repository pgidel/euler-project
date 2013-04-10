package euler.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import euler.exception.AlphabeticException;
import euler.exception.PrimeException;

public class StringUtils {

	private static final String CLASS_NAME = "StringUtils";

	private static Logger logger = Logger.getLogger(CLASS_NAME);

	/**
	 * Returns if n is a palindrome.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindromic(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}

	/**
	 * Returns the permutations the given digits
	 * 
	 * @param digits
	 * @return
	 */
	public static List<String> permute(String digits) {
		List<String> result;
		List<String> resultSub;
		String digitsSub;
		int length = 1;
		for (int i = 1; i <= digits.length(); i++) {
			length *= i;
		}

		result = new ArrayList<String>(length);
		if (length == 1) {
			result.add(0, digits);
			return result;
		}

		for (int i = 0; i < digits.length(); i++) {
			digitsSub = digits.substring(0, i) + digits.substring(i + 1);
			resultSub = permute(digitsSub);
			for (int j = 0; j < resultSub.size(); j++) {
				result.add(i * resultSub.size() + j, digits.charAt(i)
						+ resultSub.get(j));
			}
		}
		return result;
	}

	/**
	 * Returns the rotations the given digits
	 * 
	 * @param digits
	 * @return
	 */
	public static List<String> rotate(String digits) {
		List<String> result = new ArrayList<String>(digits.length());
		for (int i = 0; i < digits.length(); i++) {
			result.add(
					i,
					digits.substring(i, digits.length()).concat(
							digits.substring(0, i)));
		}
		return result;
	}

	/**
	 * Cipher the given string to have a unique result for each different s.
	 * 
	 * @param s
	 * @return
	 */
	public static BigInteger cipherUnically(String s) throws PrimeException {
		BigInteger code = BigInteger.ONE;
		for (Character c : s.toLowerCase().toCharArray()) {
			Integer car = PRIMES.get(c);
			if (car == null) {
				PrimeException e = new PrimeException(c);
				if (logger.isLoggable(Level.FINER)) {
					logger.throwing(CLASS_NAME, "cipherUnically", e);
				}
				throw e;
			}
			code = code.multiply(new BigInteger(String.valueOf(car)));
		}
		return code;
	}

	/**
	 * Cipher s to get the sum of the alphabetic order of each characters.
	 * 
	 * @param s
	 * @return
	 */
	public static long cipherAlphabeticaly(String s) {
		int code = 0;
		for (char c : s.toLowerCase().toCharArray()) {
			if (Character.isLetter(c))
				code += c - 'a' + 1;
		}
		return code;
	}

	/**
	 * Write out in words the given number.
	 * 
	 * @param n
	 * @return
	 * @throws Exception
	 */
	public static String toAlphabetic(BigInteger n) throws AlphabeticException {
		if (BigInteger.ZERO.compareTo(n) > 0)
			return "minus " + toAlphabetic(n.multiply(new BigInteger("-1")));
		if (n.compareTo(BigInteger.valueOf(20)) < 0)
			return DICTIONARY.get(n);
		if (n.compareTo(BigInteger.valueOf(20)) >= 0
				&& n.compareTo(BigInteger.valueOf(100)) < 0) {
			if (MathUtils.isDivider(n, BigInteger.TEN))
				return DICTIONARY.get(n);
			return DICTIONARY.get(n.subtract(n.mod(BigInteger.TEN))) + "-"
					+ DICTIONARY.get(n.mod(BigInteger.TEN));
		}
		if (n.compareTo(BigInteger.valueOf(100)) >= 0
				&& n.compareTo(BigInteger.valueOf(1000)) < 0)
			return toBaseAlphabetic(n, new BigInteger("100"), " and ");
		for (int i = 3; i < 21; i += 3) {
			if (n.compareTo(BigInteger.TEN.pow(i)) >= 0
					&& n.compareTo(BigInteger.TEN.pow(i + 3)) < 0)
				return toBaseAlphabetic(n, BigInteger.TEN.pow(i), ", ");
		}
		// Enable to write the maximum Long value, but not higher.
		AlphabeticException e = new AlphabeticException(n);
		if (logger.isLoggable(Level.FINER)) {
			logger.throwing(CLASS_NAME, "toAlphabetic", e);
		}
		throw e;
	}

	/**
	 * Write the given number thanks to a base and a delimitation.
	 * 
	 * @param n
	 * @param base
	 * @param delim
	 * @return
	 * @throws AlphabeticException
	 */
	private static String toBaseAlphabetic(BigInteger n, BigInteger base,
			String delim) throws AlphabeticException {
		if (MathUtils.isDivider(n, base))
			return toAlphabetic(n.divide(base)) + " " + DICTIONARY.get(base);
		return toAlphabetic(n.divide(base)) + " " + DICTIONARY.get(base)
				+ delim + toAlphabetic(n.mod(base));
	}

	/**
	 * Determines the passcode thanks to a list of tries.
	 * 
	 * @param tries
	 * @return
	 */
	public static String determinePasscode(List<String> tries) {
		List<Character> passlist = new ArrayList<Character>();
		for (String trii : tries) {
			int index = 0;
			for (Character digit : trii.toCharArray()) {
				boolean found = false;
				int i = 0;
				while (i < passlist.size()) {
					if (passlist.get(i).equals(digit)) {
						if (i < index) {
							passlist.remove(i);
							passlist.add(index, digit);
						}
						found = true;
						index = i;
					}
					i++;
				}
				if (!found) {
					passlist.add(digit);
					index = i;
				}
			}
		}

		String passcode = "";
		for (Character i : passlist) {
			passcode += i;
		}
		return passcode;
	}

	/**
	 * Reverses the given string.
	 * 
	 * @param s
	 * @return
	 */
	public static String reverse(String s) {
		String reverse = "";
		for (int i = 0; i < s.length(); i++) {
			reverse += s.charAt(s.length() - i - 1);
		}
		return reverse;
	}

	/**
	 * Maps useful numbers with its lexical representation.
	 */
	private static Map<BigInteger, String> DICTIONARY;
	static {
		DICTIONARY = new HashMap<BigInteger, String>();
		DICTIONARY.put(BigInteger.ZERO, "zero");
		DICTIONARY.put(BigInteger.ONE, "one");
		DICTIONARY.put(BigInteger.valueOf(2), "two");
		DICTIONARY.put(BigInteger.valueOf(3), "three");
		DICTIONARY.put(BigInteger.valueOf(4), "four");
		DICTIONARY.put(BigInteger.valueOf(5), "five");
		DICTIONARY.put(BigInteger.valueOf(6), "six");
		DICTIONARY.put(BigInteger.valueOf(7), "seven");
		DICTIONARY.put(BigInteger.valueOf(8), "eight");
		DICTIONARY.put(BigInteger.valueOf(9), "nine");
		DICTIONARY.put(BigInteger.TEN, "ten");
		DICTIONARY.put(BigInteger.valueOf(11), "eleven");
		DICTIONARY.put(BigInteger.valueOf(12), "twelve");
		DICTIONARY.put(BigInteger.valueOf(13), "thirteen");
		DICTIONARY.put(BigInteger.valueOf(14), "fourteen");
		DICTIONARY.put(BigInteger.valueOf(15), "fifteen");
		DICTIONARY.put(BigInteger.valueOf(16), "sixteen");
		DICTIONARY.put(BigInteger.valueOf(17), "seventeen");
		DICTIONARY.put(BigInteger.valueOf(18), "eighteen");
		DICTIONARY.put(BigInteger.valueOf(19), "nineteen");
		DICTIONARY.put(BigInteger.valueOf(20), "twenty");
		DICTIONARY.put(BigInteger.valueOf(30), "thirty");
		DICTIONARY.put(BigInteger.valueOf(40), "forty");
		DICTIONARY.put(BigInteger.valueOf(50), "fifty");
		DICTIONARY.put(BigInteger.valueOf(60), "sixty");
		DICTIONARY.put(BigInteger.valueOf(70), "seventy");
		DICTIONARY.put(BigInteger.valueOf(80), "eighty");
		DICTIONARY.put(BigInteger.valueOf(90), "ninety");
		DICTIONARY.put(BigInteger.valueOf(100), "hundred");
		DICTIONARY.put(BigInteger.valueOf(1000), "thousand");
		DICTIONARY.put(BigInteger.valueOf(1000000), "million");
		DICTIONARY.put(BigInteger.valueOf(1000000000), "billion");
		DICTIONARY.put(BigInteger.valueOf(1000000000000L), "trillion");
		DICTIONARY.put(BigInteger.valueOf(1000000000000000L), "quadrillion");
		DICTIONARY.put(BigInteger.valueOf(1000000000000000000L), "quintillion");
	}

	/**
	 * Maps digits with a prime number.
	 */
	private static Map<Character, Integer> PRIMES;
	static {
		PRIMES = new HashMap<Character, Integer>();
		PRIMES.put('0', 2);
		PRIMES.put('1', 3);
		PRIMES.put('2', 5);
		PRIMES.put('3', 7);
		PRIMES.put('4', 11);
		PRIMES.put('5', 13);
		PRIMES.put('6', 17);
		PRIMES.put('7', 19);
		PRIMES.put('8', 23);
		PRIMES.put('9', 29);
		PRIMES.put('a', 31);
		PRIMES.put('b', 37);
		PRIMES.put('c', 41);
		PRIMES.put('d', 43);
		PRIMES.put('e', 47);
		PRIMES.put('f', 53);
		PRIMES.put('g', 59);
		PRIMES.put('h', 61);
		PRIMES.put('i', 67);
		PRIMES.put('j', 71);
		PRIMES.put('k', 73);
		PRIMES.put('l', 79);
		PRIMES.put('m', 83);
		PRIMES.put('n', 89);
		PRIMES.put('o', 97);
		PRIMES.put('p', 101);
		PRIMES.put('q', 103);
		PRIMES.put('r', 107);
		PRIMES.put('s', 109);
		PRIMES.put('t', 113);
		PRIMES.put('u', 127);
		PRIMES.put('v', 131);
		PRIMES.put('w', 137);
		PRIMES.put('x', 139);
		PRIMES.put('y', 149);
		PRIMES.put('z', 151);
	}

}
