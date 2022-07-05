package importExport;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.Test;

import dataManipulation.Category;

class CSVReaderTests {

	@Test
	void test() {
		Map<String, Category> cats = new CSVTransactionReader().getCategories();
		Object[] readCats = cats.values().toArray();
		for (int c = 0; c < readCats.length; c++) {
			System.out.println(readCats[c].toString());
		}
	}

}
