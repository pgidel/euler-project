package euler.problem.p02;

import java.math.BigDecimal;
import java.math.BigInteger;

import euler.problem.AbstractEuler;

public class Euler025 extends AbstractEuler {

	private long n;

	public Euler025(long n) {
		this.n = n;
	}

	/**
	 * The Fibonacci sequence is defined by the recurrence relation:
	 * 
	 * F_(n) = F_(n-1) + F_(n-2), where F_(1) = 1 and F_(2) = 1.
	 * 
	 * Hence the first 12 terms will be:
	 * 
	 * F_(1) = 1 F_(2) = 1 F_(3) = 2 F_(4) = 3 F_(5) = 5 F_(6) = 8 F_(7) = 13
	 * F_(8) = 21 F_(9) = 34 F_(10) = 55 F_(11) = 89 F_(12) = 144
	 * 
	 * The 12th term, F_(12), is the first term to contain three digits.
	 * 
	 * What is the first term in the Fibonacci sequence to contain n digits?
	 */
	@Override
	public void compute() {
		long cpt = 2;
		BigDecimal f1 = BigDecimal.ONE;
		BigDecimal f2 = BigDecimal.ONE;
		do {
			BigDecimal tmp = f1;
			f1 = f2;
			f2 = tmp.add(f2);
			cpt++;
		} while (f2.toString().length() != n);
		result = BigInteger.valueOf(cpt);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler025(1000));
	}

}
