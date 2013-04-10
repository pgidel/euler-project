package euler.problem.p06;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler062 extends AbstractEuler {

	private long nbPermutations;

	public Euler062(long nbPermutations) {
		this.nbPermutations = nbPermutations;
	}

	@Override
	public void compute() {
		long largestPermutation;
		Map<Long, List<Long>> permutationsPerCubeRoot = new HashMap<Long, List<Long>>();

		long i = 0;
		do {
			largestPermutation = EulerUtils.makeLargestPermutation(i * i * i);
			List<Long> permutations = permutationsPerCubeRoot
					.get(largestPermutation);
			if (permutations == null) {
				permutations = new ArrayList<Long>();
			}
			permutations.add(i);
			permutationsPerCubeRoot.put(largestPermutation, permutations);
			if (permutationsPerCubeRoot.get(largestPermutation).size() == nbPermutations) {
				break;
			}
			i++;
		} while (true);

		BigInteger cubeRoot = BigInteger.valueOf(Collections
				.min(permutationsPerCubeRoot.get(largestPermutation)));
		result = cubeRoot.pow(3);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		compute(new Euler062(5));
	}

}
