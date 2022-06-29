package importExport;

import java.util.ArrayList;

import main.Transaction;

public interface TransactionReader {
	public void setSource(String filename);
	public ArrayList<Transaction> getTransactions();
	
}
