package euler.problem;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import euler.exception.EulerException;

public abstract class AbstractEuler {

	protected static Logger logger;

	public AbstractEuler() {
		logger = LoggerFactory.getLogger(this.getClass());
	}

	protected BigInteger result;

	public abstract void compute() throws EulerException;

	/**
	 * Compute the given problem, adding some statistics.
	 * 
	 * @param euler
	 */
	public static void compute(AbstractEuler euler) {
		logger.trace("compute");

		try {
			long t1 = System.nanoTime();
			euler.compute();
			long t2 = System.nanoTime();
			long time = t2 - t1;
			logger.info("{} [{}ns] [{}ms] [{}s]", new Object[] { euler, time,
					time / 1000, time / 1000000 });
		} catch (EulerException e) {
			logger.error(e.getMessage());
		}

		logger.trace("compute");
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " = " + result;
	}

	public BigInteger getResult() {
		return result;
	}

}
