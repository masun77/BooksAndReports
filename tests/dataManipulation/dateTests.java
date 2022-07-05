package dataManipulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class dateTests {

	private static Date d;
	private static Date d2;
	private static Date d3;
	private static Date d4;
	private static Date d5;
	private static Date d6;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		d = new DateImp();
		d2 = new DateImp(4,20,2022);
		d3 = new DateImp(4,20,2021);
		d4 = new DateImp(5,20,2022);
		d5 = new DateImp(4,2,2022);
		d6 = new DateImp(4,20,2022);
	}
	
	@Test
	void dateEqualsTest() {
		assertFalse(d.equalsDate(d2));
		assertFalse(d2.equalsDate(d3));
		assertFalse(d2.equalsDate(d4));
		assertFalse(d2.equalsDate(d5));
		assertTrue(d2.equalsDate(d2));
		assertTrue(d2.equalsDate(d6));
	}

	@Test
	void testGetDate() {
		assertEquals(d.getDateMMDDYYYY(), "01/01/1900");
		assertEquals(d2.getDateMMDDYYYY(), "04/20/2022");
	}

	@Test
	void testGetMonthName() {
		assertEquals(d.getMonthName(), "January");
		assertEquals(d2.getMonthName(), "April");
	}
	
	@Test
	void testGetPackDateName() {
		assertEquals(d.getAsPackDate(), "Jan 01");
		assertEquals(d2.getAsPackDate(), "Apr 20");
	}
	
	@Test
	void testYYMMDD() {
		assertEquals(d.getDateYYMMDD(), "000101");
		assertEquals(d2.getDateYYMMDD(), "220420");
	}
	
	@Test
	void testParseDate() {
		assertEquals(DateImp.parseDate("").getDateMMDDYYYY(), "01/01/2022");
		assertEquals(DateImp.parseDate("5/1/22").getDateMMDDYYYY(), "05/01/2022");
	}

}
