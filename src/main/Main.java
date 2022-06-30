package main;

import database.Book;
import database.DatabaseV1;
import display.AllTransactionDisplay;
import display.ApplicationDisplay;
import display.HomeDisplay;
import display.IncomeReport;
import display.TransactionDisplay;
import importExport.CSVTransactionReader;
import importExport.TransactionReader;

public class Main {
	
	public static void main(String[] args) {
		Book book = new DatabaseV1();
		
		TransactionReader tr = new CSVTransactionReader();
		tr.setSource("data/Income.6.26.22.csv");
		book.addTransactions(tr.getTransactions());

		ApplicationDisplay app = new HomeDisplay(book);
		
		app.addHomeDisplay(new AllTransactionDisplay());
		app.addTransactionDisplay(new IncomeReport(), "Income by month Report");
		
		app.showApplication();
	}
}
