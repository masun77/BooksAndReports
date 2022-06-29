package display;

import java.awt.Container;

import database.Book;

public interface TransactionDisplay {
	public void showDisplay();
	public void disposeOfDisplay();
	public void addBook(Book b);
	public void updateTransactions();
	public Container getMainPanel();
}
