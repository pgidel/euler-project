package euler.problem;

import java.math.BigInteger;
import java.util.Calendar;

import org.junit.Test;

import euler.problem.p01.Euler010;
import euler.problem.p01.Euler011;
import euler.problem.p01.Euler012;
import euler.problem.p01.Euler013;
import euler.problem.p01.Euler014;
import euler.problem.p01.Euler015;
import euler.problem.p01.Euler016;
import euler.problem.p01.Euler017;
import euler.problem.p01.Euler018;
import euler.problem.p01.Euler019;
import euler.util.MathUtils;

public class Problem01Test {

	@Test
	public void test010() {
		ProblemTest.assertEquals(17, new Euler010(10));
	}

	@Test
	public void test011() {
		ProblemTest.assertEquals(345800, new Euler011(3));
	}

	@Test
	public void test012() {
		ProblemTest.assertEquals(28, new Euler012(5));
	}

	@Test
	public void test013() {
		ProblemTest.assertEquals(8348422521L, new Euler013());
	}

	@Test
	public void test014() {
		ProblemTest.assertEquals(9, new Euler014(10));
	}

	@Test
	public void test015() {
		ProblemTest.assertEquals(6, new Euler015(2));
	}

	@Test
	public void test016() {
		ProblemTest.assertEquals(26, new Euler016(BigInteger.valueOf(MathUtils.pow(2, 15))));
	}

	@Test
	public void test017() {
		ProblemTest.assertEquals(19, new Euler017(5));
	}

	@Test
	public void test018() {
		ProblemTest.assertEquals(23, new Euler018());
	}

	@Test
	public void test019() {
		ProblemTest.assertEquals(171, new Euler019(20, Calendar.SUNDAY));
	}

}
