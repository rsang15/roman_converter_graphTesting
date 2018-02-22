package romantest;

import static org.junit.Assert.*;
import org.junit.Test;
import roman.RomanConverter;

public class RomanConverterTest {
	
	RomanConverter rcone = new RomanConverter();
	
	@Test
	public void test() {
		assertEquals("V", rcone.toRoman(5));
		assertEquals(5, rcone.fromRoman("V"));
		String s = "ASDJJDLLD";
		try{
			rcone.fromRoman(s);
		} catch( final IllegalArgumentException e ){
		    final String msg = "Invalid Roman numeral: "+s;
		    assertEquals(msg, e.getMessage());
		 }
		
		try{
			rcone.toRoman(293982);
		} catch( final IllegalArgumentException e ){
		    final String msg = "number out of range (must be 1..3999)";
		    assertEquals(msg, e.getMessage());
		 }
	}

}
