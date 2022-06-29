package display;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import database.Book;
import main.Transaction;

public class IncomeReport extends JFrame implements TransactionDisplay {
	private final Dimension START_SIZE = new Dimension(500,300);
	private JPanel reportPanel = new JPanel();
	private Book book;
	
	public IncomeReport() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(START_SIZE);
		
		DisplayUtilities.setAllSizes(reportPanel, START_SIZE);
		reportPanel.setLayout(new BoxLayout(reportPanel, BoxLayout.Y_AXIS));
		reportPanel.setBackground(Color.white);
		this.add(reportPanel);
	}

	public void addBook(Book b) {
		book = b;
		book.addListeningDisplay(this);
		updatePanel();
	}
	
	@Override
	public void updateTransactions() {
		updatePanel();
	}
	
	private void updatePanel() {
		if (book != null) {
			reportPanel.removeAll();
			ArrayList<Transaction> transacs = book.getTransactions();
			
			
			
			for (int t = 0; t < transacs.size(); t++) {
				reportPanel.add(new TransactionLabel(transacs.get(t).toString()));
			}
		}
	}

	@Override
	public void showDisplay() {
		updatePanel();
		this.setVisible(true);
	}
	
	@Override
	public void dispose() {
		book.removeListeningDisplay(this);
		super.dispose();
	}

	@Override
	public void disposeOfDisplay() {
		this.dispose();
	}	
	
	private class TransactionLabel extends Label {
		private final Dimension maxSize = new Dimension(500,40);
		
		public TransactionLabel(String s) {
			super(s);
			DisplayUtilities.setAllSizes(this, maxSize);
		}
	}
	
	@Override
	public Container getMainPanel() {
		return reportPanel;
	}
}
