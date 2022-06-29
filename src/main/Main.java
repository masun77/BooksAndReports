package main;

import database.Book;
import database.DatabaseV1;
import display.AllTransactionDisplay;
import display.ApplicationDisplay;
import display.HomeDisplay;
import display.TransactionDisplay;
import importExport.CSVTransactionReader;
import importExport.TransactionReader;

public class Main {
	
	public static void main(String[] args) {
		Book book = new DatabaseV1();
		
		TransactionReader tr = new CSVTransactionReader();
		tr.setSource("data/Income.6.29.22.csv");
		book.addTransactions(tr.getTransactions());

		ApplicationDisplay app = new HomeDisplay(book);

		TransactionDisplay allDisp = new AllTransactionDisplay();
		
		app.addHomeDisplay(allDisp);
		app.addTransactionDisplay(new AllTransactionDisplay(), "helper");
		
		app.showApplication();
	}
}
