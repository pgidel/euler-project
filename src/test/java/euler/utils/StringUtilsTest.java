package euler.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import euler.exception.AlphabeticException;
import euler.exception.PrimeException;
import euler.util.StringUtils;

public class StringUtilsTest {

	@Test
	public void testIsPalindromic() {
		Assert.assertTrue(StringUtils.isPalindromic("585"));
		Assert.assertTrue(StringUtils.isPalindromic("1001001001"));
		Assert.assertFalse(StringUtils.isPalindromic("10010001"));
	}

	@Test
	public void testPermute() {
		List<String> permuts = StringUtils.permute("123");
		Assert.assertEquals(6, permuts.size());
		Assert.assertEquals("123", permuts.get(0));
		Assert.assertEquals("132", permuts.get(1));
		Assert.assertEquals("213", permuts.get(2));
		Assert.assertEquals("231", permuts.get(3));
		Assert.assertEquals("312", permuts.get(4));
		Assert.assertEquals("321", permuts.get(5));
	}

	@Test
	public void testRotate() {
		List<String> rotats = StringUtils.rotate("123");
		Assert.assertEquals(3, rotats.size());
		Assert.assertEquals("123", rotats.get(0));
		Assert.assertEquals("231", rotats.get(1));
		Assert.assertEquals("312", rotats.get(2));
	}

	@Test
	public void testCipherUnically() {
		try {
			Assert.assertEquals(BigInteger.valueOf(31 * 37 * 41 * 43 * 47),
					StringUtils.cipherUnically("abcde"));
		} catch (PrimeException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testCipherAlphabeticaly() {
		Assert.assertEquals(49714,
				StringUtils.cipherAlphabeticaly("COLIN") * 938);
	}

	@Test
	public void testToAlphabetic() {
		try {
			Assert.assertEquals("minus two", StringUtils
					.toAlphabetic(new BigInteger("-2")));
			Assert.assertEquals("zero", StringUtils
					.toAlphabetic(new BigInteger("0")));
			Assert.assertEquals("one", StringUtils.toAlphabetic(new BigInteger(
					"1")));
			Assert.assertEquals("eleven", StringUtils
					.toAlphabetic(new BigInteger("11")));
			Assert.assertEquals("one hundred and one", StringUtils
					.toAlphabetic(new BigInteger("101")));
			Assert
					.assertEquals(
							"one quintillion, two hundred and thirty-four quadrillion, five hundred and sixty-seven trillion, eight hundred and ninety billion, one hundred and twenty-three million, four hundred and fifty-six thousand, seven hundred and eighty-nine",
							StringUtils.toAlphabetic(new BigInteger(
									"1234567890123456789")));
		} catch (AlphabeticException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testDeterminePasscode() {
		List<String> tries = new ArrayList<String>();
		tries.add("12");
		Assert.assertEquals("12", StringUtils.determinePasscode(tries));
		tries.add("23");
		Assert.assertEquals("123", StringUtils.determinePasscode(tries));
		tries.add("13");
		Assert.assertEquals("123", StringUtils.determinePasscode(tries));
		tries.add("34");
		Assert.assertEquals("1234", StringUtils.determinePasscode(tries));
	}

	@Test
	public void testReverse() {
		Assert.assertEquals("a", StringUtils.reverse("a"));
		Assert.assertEquals("ab", StringUtils.reverse("ba"));
		Assert.assertEquals("abc", StringUtils.reverse("cba"));
	}

}
