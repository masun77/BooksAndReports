package importExport;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import main.Date;
import main.DateImp;
import main.Transaction;

public class CSVTransactionReader implements TransactionReader {
	private String sourceFileName = "";
	private final int DATE_INDEX = 0;
	private final int VALUE_INDEX = 1;
	private final int FROM_INDEX = 2;
	private final int TO_INDEX = 3;
	private final int NOTES_INDEX = 4;

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

			Transaction trans = new Transaction(value, from, toAcc, notes, date);
			allTrans.add(trans);
        }
		return allTrans;
	}
}
