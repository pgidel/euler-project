package euler.problem.p02;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.StringUtils;

public class Euler024 extends AbstractEuler {

	private String digits;
	private int n;

	public Euler024(String digits, int n) {
		this.digits = digits;
		this.n = n;
	}

	/**
	 * A permutation is an ordered arrangement of objects. For example, 3124 is
	 * one possible permutation of the digits 1, 2, 3 and 4. If all of the
	 * permutations are listed numerically or alphabetically, we call it
	 * lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
	 * 
	 * 012 021 102 120 201 210
	 * 
	 * What is the n-th lexicographic permutation of the digits?
	 */
	@Override
	public void compute() {
		result = new BigInteger(StringUtils.permute(digits).get(n - 1));
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler024("0123456789", 1000000));
	}

}
