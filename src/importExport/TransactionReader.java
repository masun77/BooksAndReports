package importExport;

import java.util.ArrayList;
import java.util.Map;

import database.Category;
import database.Transaction;

public interface TransactionReader {
	public void setSource(String filename);
	public ArrayList<Transaction> getTransactions();
	public Map<String, Category> getCategories();
	public void setCategorySource(String filename);
}
