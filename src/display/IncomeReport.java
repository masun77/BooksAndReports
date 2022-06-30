package display;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import database.Book;
import database.Category;
import database.Date;
import database.DateImp;
import database.Transaction;
import importExport.CSVTransactionReader;

public class IncomeReport extends JFrame implements TransactionDisplay {
	private final Dimension START_SIZE = new Dimension(500,500);
	private JPanel reportPanel = new VPanel();
	private Book book;
	
	public IncomeReport() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(START_SIZE);
		
		DisplayUtilities.setAllSizes(reportPanel, START_SIZE);
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
		ArrayList<ArrayList<Transaction>> transByMonth = new ArrayList<ArrayList<Transaction>>();
		
		if (book != null) {
			reportPanel.removeAll();
			ArrayList<Transaction> transacs = book.getTransactions();
			
			for (int i = 0; i < 12; i++) {
				transByMonth.add(new ArrayList<Transaction>());
			}
			
			Map<String, Category> allCats = new CSVTransactionReader().getCategories();
			
			for (int t = 0; t < transacs.size(); t++) {
				Transaction curr = transacs.get(t);
				boolean isIncome = allCats.get(curr.getCategory()).isCategoryType("Income");
				if (isIncome) {
					Date d = curr.getDate();
					int month = d.getMonthofYear() - 1;
					transByMonth.get(month).add(curr);
				}
			}

			for (int i = 0; i < transByMonth.size(); i++) {
				Container monthRow = new HPanel();
				monthRow.add(new MonthLabel(new DateImp().getMonthName(i+1)));
				ArrayList<Transaction> currMonth = transByMonth.get(i);
				float sum = 0;
				for (int t = 0; t < currMonth.size(); t++) {
					sum += currMonth.get(t).getValue();
				}
				monthRow.add(new MonthLabel(Float.toString(sum)));
				reportPanel.add(monthRow);
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
	
	@Override
	public Container getMainPanel() {
		return reportPanel;
	}
	
	private class MonthLabel extends Label {
		private final Dimension maxSize = new Dimension(100,40);
		
		public MonthLabel(String s) {
			super(s);
			DisplayUtilities.setAllSizes(this, maxSize);
		}
	}
}
