package roman;

import static org.junit.Assert.*;
import org.junit.Test;
import roman.RomanConverter;

public class RomanConverterTest {
	
	RomanConverter rcone = new RomanConverter();
	
	@Test
	public void test() {
		assertEquals("V", rcone.toRoman(5));
		assertEquals(5, rcone.fromRoman("V"));
		assertEquals("MMMCMXCIX", rcone.toRoman(3999));
		assertEquals("I", rcone.toRoman(1));
		assertEquals("I", rcone.toRoman(1));
		assertEquals(3999, rcone.fromRoman("MMMCMXCIX"));
		assertEquals(1, rcone.fromRoman("I"));
		assertTrue(0 == rcone.fromRoman(""));
	
		
		String s = "ASDJJDLLD";
		try{
			rcone.fromRoman(s);
		} catch( final IllegalArgumentException e ){
		    final String msg = "Invalid Roman numeral: "+s;
		    assertEquals(msg, e.getMessage());
		 }
		
		try{
			rcone.fromRoman("m");
			rcone.fromRoman("MMMM");
		} catch(final IllegalArgumentException e){
			final String msg2 = "Invalid Roman numeral: m";
			assertEquals(msg2, e.getMessage());
		}
		try{
			//rcone.toRoman(293982);
			rcone.toRoman(0);
			rcone.toRoman(4000);
			rcone.toRoman(4001);
			rcone.toRoman(-1);
		} catch( final IllegalArgumentException e ){
		    final String msg = "number out of range (must be 1..3999)";
		    assertEquals(msg, e.getMessage());
		 }
		
	}

}
