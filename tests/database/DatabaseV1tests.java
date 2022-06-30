package database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DatabaseV1tests {

	@Test
	void testCatIsType() {
		Category income = new Category("Income",null,null);
		Category fm = new Category("Farmers market", income, null);
		Category sunMarin = new Category("Sunday Marin Market", fm, null);
		Category wholesale = new Category("Wholesale", null, null);
		Category casaRosa = new Category("Casa Rosa", wholesale, null);
		assertTrue(income.isCategoryType("Income"));
		assertTrue(fm.isCategoryType("Income"));
		assertTrue(sunMarin.isCategoryType("Income"));
		assertTrue(casaRosa.isCategoryType("Wholesale"));
		assertFalse(income.isCategoryType("Wholesale"));
	}

}
