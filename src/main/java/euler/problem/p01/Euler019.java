package euler.problem.p01;

import java.math.BigInteger;
import java.util.Calendar;

import euler.problem.AbstractEuler;

public class Euler019 extends AbstractEuler {

	private int day;
	private int n;

	public Euler019(int n, int day) {
		this.n = n;
		this.day = day;
	}

	/**
	 * You are given the following information, but you may prefer to do some
	 * research for yourself.
	 * 
	 * 1 Jan 1900 was a Monday.
	 * 
	 * Thirty days has September, April, June and November. All the rest have
	 * thirty-one, Saving February alone, Which has twenty-eight, rain or shine.
	 * And on leap years, twenty-nine.
	 * 
	 * A leap year occurs on any year evenly divisible by 4, but not on a
	 * century unless it is divisible by 400.
	 * 
	 * How many 'days' fell on the first of the month during the n-th century?
	 */
	@Override
	public void compute() {
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(0);
		date.set(Calendar.YEAR, n * 100 + 1 - 100);
		date.set(Calendar.DAY_OF_MONTH, 1);

		Calendar endDate = Calendar.getInstance();
		endDate.setTimeInMillis(0);
		endDate.set(Calendar.YEAR, n * 100 + 1);
		endDate.set(Calendar.DAY_OF_MONTH, 1);

		int n = 0;
		while (date.compareTo(endDate) < 1) {
			if (date.get(Calendar.DAY_OF_WEEK) == day) {
				n++;
			}
			date.add(Calendar.MONTH, 1);
		}

		result = BigInteger.valueOf(n);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler019(20, Calendar.SUNDAY));
	}

}
