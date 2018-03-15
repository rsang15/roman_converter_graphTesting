package roman;

import static org.junit.Assert.*;

import org.junit.Test;

import roman.RomanConverter;

public class RomanConverterInterTest {
	
	private RomanConverter romanConverter = new RomanConverter(); 
	
	/**
	 * Begin Interface-based testing
	 */
	
	@Test
	public void testToRomanb2() {
		assertEquals( "I", romanConverter.toRoman(1));
	}
	
	@Test(expected = Exception.class)
	public void testToRomanb1(){
		//less than 0, equal to 0 
		assertEquals("-MMMMM", romanConverter.toRoman(-5000));
		assertEquals("", romanConverter.toRoman(0));
	}

	@Test(expected = Exception.class)
	public void testToRomanb3(){
		//greater than 0
		romanConverter.toRoman(4002);
	}
	
	@Test
	public void testFromRomanb1() {
		assertEquals( 5, romanConverter.fromRoman("V"));
	}
	
	@Test(expected = Exception.class)
	public void testFromRomanb2(){
		romanConverter.fromRoman("Ж");
		romanConverter.fromRoman("Ü");
	}

	@Test(expected = Exception.class)
	public void testFromRomanb3(){
		romanConverter.fromRoman("i");
	}
	
	@Test(expected = Exception.class)
	public void testFromRomanb4(){
        romanConverter.fromRoman("V2");
	}
	
	@Test(expected = Exception.class)
	public void testFromRomanb5(){
		romanConverter.fromRoman("C#");
	}
	
	@Test(expected = Exception.class)
	public void testFromRomanb6(){
		//length 1
		romanConverter.fromRoman(" ");
	}
	@Test(expected = Exception.class)
	public void testFromRomanb7(){
		//string longer than 1
		romanConverter.fromRoman("SDFR");
	}
	@Test
	public void testFromRomanb8(){
		//empty string
		romanConverter.fromRoman("");
	}
	@Test(expected = Exception.class)
	public void testFromRomanb9(){
		//test null
		romanConverter.fromRoman(null);
	}
}
