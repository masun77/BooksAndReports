package database;

import java.util.ArrayList;

import display.TransactionDisplay;
import main.Transaction;

public interface Book {
	
	public void addTransactions(ArrayList<Transaction> newTransactions);
	public void addTransaction(Transaction transaction);
	public ArrayList<Transaction> getTransactions();
	public void addListeningDisplay(TransactionDisplay listener);
	public void removeListeningDisplay(TransactionDisplay listener);
} 
