package database;

import java.util.ArrayList;

import display.TransactionDisplay;

public class DatabaseV1 implements Book {
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	private ArrayList<TransactionDisplay> listeners = new ArrayList<TransactionDisplay>();
	
	@Override
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	@Override
	public void addTransactions(ArrayList<Transaction> newTransactions) {
		transactions.addAll(newTransactions);
	}

	@Override
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	@Override
	public void addListeningDisplay(TransactionDisplay listener) {
		listeners.add(listener);
	}

	@Override
	public void removeListeningDisplay(TransactionDisplay listener) {
		listeners.remove(listener);
	}

	@Override
	public String toString() {
		String s = "Book Transactions:\n";
		for (int t = 0; t < transactions.size(); t++) {
			s += transactions.get(t).toString() + "\n";
		}
		return s;
	}
}
