package display;

import database.Book;

public interface ApplicationDisplay {
	public void addBookToAll(Book b);
	public void addTransactionDisplay(TransactionDisplay td, String name);
	public void removeTransactionDisplay(TransactionDisplay td);
	public void addHomeDisplay(TransactionDisplay td);
	public void showApplication();
}
