package euler.problem.p04;

import java.util.HashSet;
import java.util.Set;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;
import euler.util.StringUtils;

public class Euler049 extends AbstractEuler {

	private long a;
	private long b;

	public Euler049(long a, long b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void compute() {
		// TODO improve
		for (long i = a; i <= b; i++) {
			MathUtils.isPrime(i);
			Set<String> permutations = new HashSet<String>(
					StringUtils.permute(String.valueOf(i)));
			for (String p : permutations) {
				long p1 = Long.valueOf(p);
				long p2 = p1 + 3330;
				long p3 = p2 + 3330;
				if (p1 < 1000 || p2 < 1000 || p3 < 1000)
					continue;
				if (permutations.contains(String.valueOf(p2))
						&& permutations.contains(String.valueOf(p3))) {
					if (MathUtils.isPrime(p1) && MathUtils.isPrime(p2)
							&& MathUtils.isPrime(p3)) {
						System.out.println(p1 + "" + p2 + "" + p3);
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler049(1000, 9999));
	}

}
