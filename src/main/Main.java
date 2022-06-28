package main;

public class Main {
	
	public static void main(String[] args) {
		Book book = new DatabaseV1();
		
		book.addTransaction(new Transaction());
		book.addTransaction(new Transaction(3865.75f,"Sunday Marin", "cash",""));

		TransactionDisplay allDisp = new AllTransactionDisplay();
		allDisp.addBook(book);
		
		allDisp.showDisplay();
	}
}
