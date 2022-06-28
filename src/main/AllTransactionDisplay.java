package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AllTransactionDisplay implements TransactionDisplay {
	private JFrame display = new JFrame();
	private final Dimension START_SIZE = new Dimension(1000,700);
	private JPanel transactionPanel = new JPanel();
	private Book book;
	
	public void addBook(Book b) {
		book = b;
		book.addListeningDisplay(this);
	}
	
	public AllTransactionDisplay() {
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setSize(START_SIZE);
		
		transactionPanel.setLayout(new BoxLayout(transactionPanel, BoxLayout.Y_AXIS));
		transactionPanel.setBackground(Color.white);
		display.add(transactionPanel);
	}
	
	@Override
	public void updateTransactions() {
		updatePanel();
	}
	
	private void updatePanel() {
		if (book != null) {
			transactionPanel.removeAll();
			ArrayList<Transaction> transacs = book.getTransactions();
			for (int t = 0; t < transacs.size(); t++) {
				transactionPanel.add(new TransactionLabel(transacs.get(t).toString()));
			}
		}
	}

	@Override
	public void showDisplay() {
		updatePanel();
		display.setVisible(true);
	}

	@Override
	public void disposeOfDisplay() {
		display.dispose();
		book.removeListeningDisplay(this);
	}	
	
	private class TransactionLabel extends Label {
		private final Dimension maxSize = new Dimension(500,40);
		
		public TransactionLabel(String s) {
			super(s);
			this.setSize(maxSize);
			this.setPreferredSize(maxSize);
			this.setMaximumSize(maxSize);
			this.setMinimumSize(maxSize);
		}
	}
}
