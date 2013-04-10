package euler;

import java.math.BigInteger;
import java.util.Calendar;

import euler.problem.AbstractEuler;
import euler.problem.p00.Euler001;
import euler.problem.p00.Euler002;
import euler.problem.p00.Euler003;
import euler.problem.p00.Euler004;
import euler.problem.p00.Euler005;
import euler.problem.p00.Euler006;
import euler.problem.p00.Euler007;
import euler.problem.p00.Euler008;
import euler.problem.p00.Euler009;
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
import euler.problem.p02.Euler020;
import euler.problem.p02.Euler021;
import euler.problem.p02.Euler022;
import euler.problem.p02.Euler023;
import euler.problem.p02.Euler024;
import euler.problem.p02.Euler025;
import euler.problem.p02.Euler027;
import euler.problem.p02.Euler028;
import euler.problem.p02.Euler029;
import euler.problem.p03.Euler030;
import euler.problem.p03.Euler031;
import euler.problem.p03.Euler033;
import euler.problem.p03.Euler034;
import euler.problem.p03.Euler035;
import euler.problem.p03.Euler036;
import euler.problem.p03.Euler037;
import euler.problem.p03.Euler038;
import euler.problem.p03.Euler039;
import euler.problem.p04.Euler040;
import euler.problem.p04.Euler041;
import euler.problem.p04.Euler042;
import euler.problem.p04.Euler043;
import euler.problem.p04.Euler044;
import euler.problem.p04.Euler045;
import euler.problem.p04.Euler047;
import euler.problem.p04.Euler048;
import euler.problem.p05.Euler050;
import euler.problem.p05.Euler052;
import euler.problem.p05.Euler053;
import euler.problem.p05.Euler055;
import euler.problem.p05.Euler056;
import euler.problem.p05.Euler058;
import euler.problem.p05.Euler059;
import euler.problem.p06.Euler063;
import euler.problem.p06.Euler067;
import euler.problem.p07.Euler079;
import euler.problem.p09.Euler096;
import euler.problem.p09.Euler097;
import euler.problem.p10.Euler100;
import euler.problem.p17.Euler179;
import euler.problem.p18.Euler187;
import euler.problem.p18.Euler188;
import euler.util.MathUtils;

public class Computer {

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {

		AbstractEuler.compute(new Euler001(1000, 3, 5));
		AbstractEuler.compute(new Euler002(4000000));
		AbstractEuler.compute(new Euler003(65));
		AbstractEuler.compute(new Euler004(3));
		AbstractEuler.compute(new Euler005(20));
		AbstractEuler.compute(new Euler006(100));
		AbstractEuler.compute(new Euler007(10001));
		AbstractEuler.compute(new Euler008(5));
		AbstractEuler.compute(new Euler009(1000));
		AbstractEuler.compute(new Euler010(2000000));

		AbstractEuler.compute(new Euler011(4));
		AbstractEuler.compute(new Euler012(500));
		AbstractEuler.compute(new Euler013());
		AbstractEuler.compute(new Euler014(1000000));
		AbstractEuler.compute(new Euler015(2));
		AbstractEuler.compute(new Euler016(BigInteger.valueOf(MathUtils.pow(2,
				1000))));
		AbstractEuler.compute(new Euler017(1000));
		AbstractEuler.compute(new Euler018());
		AbstractEuler.compute(new Euler019(20, Calendar.SUNDAY));

		AbstractEuler.compute(new Euler020(100));
		AbstractEuler.compute(new Euler021(10000));
		AbstractEuler.compute(new Euler022());
		AbstractEuler.compute(new Euler023());
		AbstractEuler.compute(new Euler024("0123456789", 1000000));
		AbstractEuler.compute(new Euler025(1000));
		AbstractEuler.compute(new Euler027(1000, 1000));
		AbstractEuler.compute(new Euler028(1001));
		AbstractEuler.compute(new Euler029(100));

		AbstractEuler.compute(new Euler030(5));
		AbstractEuler.compute(new Euler031(20));
		AbstractEuler.compute(new Euler031(50));
		AbstractEuler.compute(new Euler031(100));
		AbstractEuler.compute(new Euler031(200));
		AbstractEuler.compute(new Euler033());
		AbstractEuler.compute(new Euler034());
		AbstractEuler.compute(new Euler035(1000000));
		AbstractEuler.compute(new Euler036(1000000));
		AbstractEuler.compute(new Euler037());
		AbstractEuler.compute(new Euler038());
		AbstractEuler.compute(new Euler039(1000));

		AbstractEuler.compute(new Euler040(new int[] { 1, 10, 100, 1000, 10000,
				100000, 1000000 }));
		AbstractEuler.compute(new Euler041());
		AbstractEuler.compute(new Euler042());
		AbstractEuler.compute(new Euler043());
		AbstractEuler.compute(new Euler044());
		AbstractEuler.compute(new Euler045(40755));
		AbstractEuler.compute(new Euler047());
		AbstractEuler.compute(new Euler048(1000, 10));

		AbstractEuler.compute(new Euler050(1000000));
		AbstractEuler.compute(new Euler052(6));
		AbstractEuler.compute(new Euler053(100, 1000000));
		AbstractEuler.compute(new Euler055(10000));
		AbstractEuler.compute(new Euler056(100, 100));
		AbstractEuler.compute(new Euler058(0.1));
		AbstractEuler.compute(new Euler059());

		AbstractEuler.compute(new Euler063());
		AbstractEuler.compute(new Euler067());

		AbstractEuler.compute(new Euler079());

		AbstractEuler.compute(new Euler096());
		AbstractEuler.compute(new Euler097(10));

		AbstractEuler.compute(new Euler100());

		AbstractEuler.compute(new Euler179());

		AbstractEuler.compute(new Euler187(100000000));
		AbstractEuler.compute(new Euler188(1777, 1855, 8));

	}

}