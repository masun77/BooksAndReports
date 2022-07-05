package importExport;

import java.util.ArrayList;
import java.util.Map;

import dataManipulation.Category;
import dataManipulation.Transaction;

public interface TransactionReader {
	public void setSource(String filename);
	public ArrayList<Transaction> getTransactions();
	public Map<String, Category> getCategories();
	public void setCategorySource(String filename);
}
