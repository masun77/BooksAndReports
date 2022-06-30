package importExport;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import database.Category;
import database.Date;
import database.DateImp;
import database.Transaction;

public class CSVTransactionReader implements TransactionReader {
	private String sourceFileName = "";
	private String categoryFileName = "backups/categories.csv";
	private final int DATE_INDEX = 0;
	private final int FROM_INDEX = 1;
	private final int CATEGORY_INDEX = 2;
	private final int VALUE_INDEX = 3;
	private final int TO_INDEX = 4;
	private final int NOTES_INDEX = 5;
	private final int CAT_NAME_INDEX = 0;
	private final int CAT_PARENT_INDEX = 1;

	@Override
	public void setSource(String filename) {
		sourceFileName = filename;
	}

	@Override
	public ArrayList<Transaction> getTransactions() {
		 try {
		        FileReader filereader = new FileReader(sourceFileName);
		        CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
		        CSVReader csvReader = new CSVReaderBuilder(filereader)
		                                  .withCSVParser(parser)
		                                  .build();
		 
		        List<String[]> allData = csvReader.readAll();
				return getTransactionsFromList(allData);
		 
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		    }
		 return new ArrayList<Transaction>();
	}
	
	/**
	 * Get orders from a list of string arrays and return them in an arraylist of orders
	 * @param allData the list of string arrays, with each string array representing one item in an order
	 * @return the arraylist of orders
	 */
	public ArrayList<Transaction> getTransactionsFromList(List<String[]> allData) {
		ArrayList<Transaction> allTrans = new ArrayList<Transaction>();
		for (String[] row : allData) {
			String v = row[VALUE_INDEX];
			float value;
			if (v.contains("$")) {
				value = Float.parseFloat(v.substring(1)); 
			}
			else {
				value = Float.parseFloat(v); 
			}
        	String from = row[FROM_INDEX];
        	String toAcc = row[TO_INDEX];
        	String notes = row[NOTES_INDEX];
        	Date date = DateImp.parseDate(row[DATE_INDEX]);
        	String category = row[CATEGORY_INDEX];

			Transaction trans = new Transaction(value, from, toAcc, notes, date, category);
			allTrans.add(trans);
        }
		return allTrans;
	}

	@Override
	public Map<String, Category> getCategories() {
		try {
	        FileReader filereader = new FileReader(categoryFileName);
	        CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
	        CSVReader csvReader = new CSVReaderBuilder(filereader)
	                                  .withCSVParser(parser)
	                                  .build();
	 
	        List<String[]> allData = csvReader.readAll();
			return getCatsFromList(allData);
	 
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	 return new HashMap<String, Category>();
	}
	
	private Map<String, Category> getCatsFromList(List<String[]> allData) {
		Map<String, Category> catsByName = new HashMap<String, Category>();
		for (String[] row : allData) {
			String name = row[CAT_NAME_INDEX];
			Category newCat = new Category(name,null,null);
			catsByName.put(name, newCat);
        }
		for (String[] row : allData) {
			String name = row[CAT_NAME_INDEX];
			String parent = row[CAT_PARENT_INDEX];
			Category cat = catsByName.get(name);
			cat.setParentCategory(catsByName.get(parent));
			ArrayList<Category> subs = new ArrayList<Category>();
			for (int c = 2; c < row.length; c++) {
				subs.add(catsByName.get(row[c]));
			}
			cat.setSubcategories(subs);
        }
		return catsByName;
	}

	@Override
	public void setCategorySource(String filename) {
		categoryFileName = filename;
	}
}
