package com.gms.web.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MariaDBConnTest {

	@Test
	public void test() {
		MariadbConn m = new MariadbConn();
		assertEquals("KIM", m.exam());
	}

}
