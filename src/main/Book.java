package main;

import java.util.ArrayList;

public interface Book {
	
	public void addTransactions(ArrayList<Transaction> newTransactions);
	public void addTransaction(Transaction transaction);
	public ArrayList<Transaction> getTransactions();
	public void addListeningDisplay(TransactionDisplay listener);
	public void removeListeningDisplay(TransactionDisplay listener);
} 
