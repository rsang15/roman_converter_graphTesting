package roman;

import static org.junit.Assert.*;

import org.junit.Test;

import roman.RomanConverter;

public class RomanConvFuncTests {
	
	private RomanConverter romanConverter = new RomanConverter(); 
	/**
	 * NOTE: CANT TEST NUMBERS OUT OF RANGE BECAUSE COMPILER ALREADY 
	 * FULFILLS THAT REQUIREMENT
	 */
	@Test
	public void testToRomanFunctionalB1() {
		//check in range
		assertEquals( "I", romanConverter.toRoman(1));
	}
	
	@Test
	public void testToRomanFunctionalB2() {
		assertEquals( "X", romanConverter.toRoman(10));
	}
	
	@Test
	public void testToRomanFunctionalB3() {
		assertEquals( "D", romanConverter.toRoman(500));
	}
	
	@Test
	public void testToRomanFunctionalB4() {
		assertEquals( "M", romanConverter.toRoman(1000));
	}
	@Test
	public void testFromRomanb1() {
		assertEquals( 5, romanConverter.fromRoman("V"));
	}

	@Test(expected = Exception.class)
	public void testToRomanFunctionalB6() {
		//test if outside range fails
		assertEquals( "MMMMMM", romanConverter.toRoman(6000));
		assertEquals( "M", romanConverter.toRoman(-100));
	}
	
	//fromRoman functional testing
	@Test
	public void testFromRomanFunctionalB1() {
		//accurate for a value 1-3999
		//also captures requirement s
		assertEquals(2000, romanConverter.fromRoman("MM"));
	}
	@Test(expected = Exception.class)
	public void testFromRomanFunctionalB2() {
		//invalid roman numeral
		assertEquals(2000, romanConverter.fromRoman("MMIJDlLKS"));
	}
	@Test
	public void testFromRomanFunctionalB3() {
		//check if using both functions works
		assertEquals(1000, romanConverter.fromRoman(romanConverter.toRoman(1000)));
	}
	@Test(expected = Exception.class)
	public void testFromRomanFunctionalB4() {
		//given lowercase input, expect a failure
		assertEquals(2000, romanConverter.fromRoman("mm"));
	}
}
