package com.test.triton;

import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Test;

public class LamaWoolServiceTest {
	
	@Test
	 public void checkShearDate_AllOk() throws Exception {
		
	 LamaWoolService service = new LamaWoolService();
		
	 assertTrue(service.isWoolTooOldToSell(new DateTime(2013, 01, 15, 00, 00)));

	 }

}
