package euler.problem;

import org.junit.Test;

import euler.problem.p02.Euler020;
import euler.problem.p02.Euler021;
import euler.problem.p02.Euler022;
import euler.problem.p02.Euler023;
import euler.problem.p02.Euler024;
import euler.problem.p02.Euler025;
import euler.problem.p02.Euler027;
import euler.problem.p02.Euler028;
import euler.problem.p02.Euler029;

public class Problem02Test {

	@Test
	public void test020() {
		ProblemTest.assertEquals(6, new Euler020(4));
	}

	@Test
	public void test021() {
		ProblemTest.assertEquals(31626, new Euler021(10000));
	}

	@Test
	public void test022() {
		ProblemTest.assertEquals(602, new Euler022());
	}

	@Test
	public void test023() {
		ProblemTest.assertEquals(4179871, new Euler023());
	}

	@Test
	public void test024() {
		ProblemTest.assertEquals(102, new Euler024("012", 3));
	}

	@Test
	public void test025() {
		ProblemTest.assertEquals(12, new Euler025(3));
	}

	@Test
	public void test027() {
		ProblemTest.assertEquals(-41, new Euler027(2, 42));
	}

	@Test
	public void test028() {
		ProblemTest.assertEquals(101, new Euler028(5));
	}

	@Test
	public void test029() {
		ProblemTest.assertEquals(15, new Euler029(5));
	}

}
