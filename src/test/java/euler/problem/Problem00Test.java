package euler.problem;

import org.junit.Test;

import euler.problem.p00.Euler001;
import euler.problem.p00.Euler002;
import euler.problem.p00.Euler003;
import euler.problem.p00.Euler004;
import euler.problem.p00.Euler005;
import euler.problem.p00.Euler006;
import euler.problem.p00.Euler007;
import euler.problem.p00.Euler008;
import euler.problem.p00.Euler009;

public class Problem00Test {

	@Test
	public void test001() {
		ProblemTest.assertEquals(23, new Euler001(10, 3, 5));
	}

	@Test
	public void test002() {
		ProblemTest.assertEquals(44, new Euler002(89));
	}

	@Test
	public void test003() {
		ProblemTest.assertEquals(29, new Euler003(13195));
	}

	@Test
	public void test004() {
		ProblemTest.assertEquals(9009, new Euler004(2));
	}

	@Test
	public void test005() {
		ProblemTest.assertEquals(2520, new Euler005(10));
	}

	@Test
	public void test006() {
		ProblemTest.assertEquals(2640, new Euler006(10));
	}

	@Test
	public void test007() {
		ProblemTest.assertEquals(13, new Euler007(6));
	}

	@Test
	public void test008() {
		ProblemTest.assertEquals(21, new Euler008(2));
	}

	@Test
	public void test009() {
		ProblemTest.assertEquals(60, new Euler009(3 + 4 + 5));
	}
}
