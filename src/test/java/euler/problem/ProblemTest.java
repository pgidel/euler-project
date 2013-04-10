package euler.problem;

import java.math.BigInteger;

import org.junit.Assert;

import euler.exception.EulerException;

public class ProblemTest {

	public static void assertEquals(long expected, AbstractEuler euler) {
		try {
			euler.compute();
		} catch (EulerException e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertNotNull("No result.", euler.getResult());
		Assert.assertEquals(BigInteger.valueOf(expected), euler.getResult());
	}

}
