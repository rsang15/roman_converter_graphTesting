package roman;

import static org.junit.Assert.*;
import org.junit.Test;
import roman.RomanConverter;

public class RomanConverterTest {
	
	RomanConverter rcone = new RomanConverter();
	@Test
	public void killMutants(){
		/**
		 * Attempt to cover all of the boundaries
		 * literally every case
		 */
		for(int i = -20; i <= 4020; i++){
			if(i <= 0 || i >= 4000){
				try{
					rcone.toRoman(i);
				} catch (final IllegalArgumentException e){
					final String msg = "number out of range (must be 1..3999)";
					assertEquals(msg, e.getMessage());
				}
				try{
					rcone.fromRoman(rcone.toRoman(i));
				} catch (final IllegalArgumentException e){
					final String msg = "number out of range (must be 1..3999)";
					assertEquals(msg, e.getMessage());
				}
			}else{
				assertEquals(i, rcone.fromRoman(rcone.toRoman(i)));
			} 
		}
		try{
			//rcone.toRoman(293982);
			rcone.toRoman(0);
		} catch( final IllegalArgumentException e ){
		    final String msg = "number out of range (must be 1..3999)";
		    assertEquals(msg, e.getMessage());
		 }
		try{
			rcone.toRoman(3999);
		}catch( final IllegalArgumentException e ){
		    final String msg = "number out of range (must be 1..3999)";
		    assertEquals(msg, e.getMessage());
		 }
		try {
			rcone.toRoman(1);
		}catch( final IllegalArgumentException e ){
		    final String msg = "number out of range (must be 1..3999)";
		    assertEquals(msg, e.getMessage());
		 }
		try{
			rcone.toRoman(4000);
		}catch( final IllegalArgumentException e ){
		    final String msg = "number out of range (must be 1..3999)";
		    assertEquals(msg, e.getMessage());
		 }
		try{
			rcone.toRoman(4001);
		}catch( final IllegalArgumentException e ){
		    final String msg = "number out of range (must be 1..3999)";
		    assertEquals(msg, e.getMessage());
		 }
		try{
			rcone.toRoman(-1);
		}catch( final IllegalArgumentException e ){
		    final String msg = "number out of range (must be 1..3999)";
		    assertEquals(msg, e.getMessage());
		 }
		
	}
	@Test
	public void test() {
		
		assertEquals("V", rcone.toRoman(5));
		assertEquals(5, rcone.fromRoman("V"));
		assertEquals("MMMCMXCIX", rcone.toRoman(3999));
		assertEquals("I", rcone.toRoman(1));
		assertEquals("I", rcone.toRoman(1));
		assertEquals(3999, rcone.fromRoman("MMMCMXCIX"));
		assertFalse(0 == rcone.fromRoman("I"));
		assertFalse(4000 == rcone.fromRoman("MMMCMXCIX"));
		assertTrue(0 == rcone.fromRoman(""));
		assertFalse(1 == rcone.fromRoman(""));
		assertFalse(2 == rcone.fromRoman("I"));
		String s = "ASDJJDLLD";
		
		try{
			rcone.fromRoman(s);
		} catch( final IllegalArgumentException e ){
		    final String msg = "Invalid Roman numeral: "+s;
		    assertEquals(msg, e.getMessage());
		 }
		
		try{
			rcone.fromRoman("m");
		} catch(final IllegalArgumentException e){
			final String msg2 = "Invalid Roman numeral: m";
			assertEquals(msg2, e.getMessage());
		}
		try{
			rcone.fromRoman("MMMM");
		} catch( final IllegalArgumentException e){
			final String msg2 = "Invalid Roman numeral: MMMM";
			assertEquals(msg2, e.getMessage());
		}
		try{
			rcone.fromRoman("");
		} catch( final IllegalArgumentException e){
			final String msg2 = "Invalid Roman numeral: ";
			assertEquals(msg2, e.getMessage());
		}
		try{
			//rcone.toRoman(293982);
			rcone.toRoman(0);
			rcone.toRoman(3999);
			rcone.toRoman(1);
			rcone.toRoman(4000);
			rcone.toRoman(4001);
			rcone.toRoman(-1);
		} catch( final IllegalArgumentException e ){
		    final String msg = "number out of range (must be 1..3999)";
		    assertEquals(msg, e.getMessage());
		 }
		
	}

}
