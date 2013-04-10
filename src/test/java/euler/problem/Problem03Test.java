package euler.problem;

import org.junit.Test;

import euler.problem.p03.Euler030;
import euler.problem.p03.Euler031;
import euler.problem.p03.Euler032;
import euler.problem.p03.Euler034;
import euler.problem.p03.Euler035;
import euler.problem.p03.Euler036;
import euler.problem.p03.Euler037;

public class Problem03Test {

	@Test
	public void test030() {
		ProblemTest.assertEquals(19316, new Euler030(4));
	}

	@Test
	public void test031() {
		ProblemTest.assertEquals(1, new Euler031(1));
		ProblemTest.assertEquals(2, new Euler031(2));
		ProblemTest.assertEquals(4, new Euler031(5));
		ProblemTest.assertEquals(11, new Euler031(10));
		ProblemTest.assertEquals(41, new Euler031(20));
	}

	@Test
	public void test032() {
		ProblemTest.assertEquals(12, new Euler032(4));
	}

	@Test
	public void test034() {
		ProblemTest.assertEquals(40730, new Euler034());
	}

	@Test
	public void test035() {
		ProblemTest.assertEquals(13, new Euler035(100));
	}

	@Test
	public void test036() {
		ProblemTest.assertEquals(25, new Euler036(10));
	}

	@Test
	public void test037() {
		ProblemTest.assertEquals(748317, new Euler037());
	}

}
