package org.market.mp;

import org.market.mp.Type;

import junit.framework.TestCase;

public class TypeTest extends TestCase {
    Type type = new Type();
    
	public void testTypeName() {
		// write test case for each type
		String[] t = type.getType();
		String s = t[0];
		assertEquals("vegetable", s);
		assertEquals("fruit", t[1]);
	}


}
