package display;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataManipulation.Category;
import dataManipulation.Date;
import dataManipulation.DateImp;
import dataManipulation.Filter;
import dataManipulation.FilterFact;
import dataManipulation.FilterFactory;
import dataManipulation.Transaction;
import database.Book;
import importExport.CSVTransactionReader;

public class FilterReport extends JFrame implements TransactionDisplay {
	private final Dimension START_SIZE = new Dimension(500,500);
	private final Dimension FILTER_SIZE = new Dimension(100,40);
	private final Dimension LABEL_SIZE = new Dimension(150,40);
	private JPanel reportPanel = new VPanel();
	private Book book;
	JPanel filterPanel = new VPanel();
	private ArrayList<Filter> filters = new ArrayList<>();
	private JPanel newFilterPanel = new HPanel();
	private FilterFactory filterFact = new FilterFact();
	private Filter currentFilter;
	
	public FilterReport() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(START_SIZE);
		
		DisplayUtilities.setAllSizes(reportPanel, START_SIZE);
		reportPanel.setBackground(Color.white);
		initialize();
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
	
	private void initialize() {
		Label filterLabel = new Label("Filter transactions by: ");
		filterLabel.setMaximumSize(LABEL_SIZE);
		String[] filterOptions = { "Date", "Category", "From Account", "To Account"};
		JComboBox<String> filterType = new JComboBox<>(filterOptions);
		filterType.setSelectedIndex(0);
		filterType.setMaximumSize(FILTER_SIZE);
		filterType.addActionListener(new FilterTypeListener(filterType));
		
		currentFilter = filterFact.getFilterFor((String)filterType.getSelectedItem());
		Component filterSelection = currentFilter.getInputComponent();

		JButton addFilterBtn = new JButton("Add Filter");
		addFilterBtn.addActionListener(new AddFilterListener());
		
		newFilterPanel.add(filterLabel);
		newFilterPanel.add(filterType);
		newFilterPanel.add(filterSelection);
		newFilterPanel.add(addFilterBtn);

		JButton clearFiltersBtn = new JButton("Clear Filters");
		
		filterPanel.add(newFilterPanel);
		filterPanel.add(clearFiltersBtn);
		
		reportPanel.add(filterPanel);
	}
	
	private void updatePanel() {
		this.validate();
		
//		ArrayList<ArrayList<Transaction>> transByMonth = new ArrayList<ArrayList<Transaction>>();
//		
//		if (book != null) {
//			reportPanel.removeAll();
//			ArrayList<Transaction> transacs = book.getTransactions();
//			
//			for (int i = 0; i < 12; i++) {
//				transByMonth.add(new ArrayList<Transaction>());
//			}
//			
//			Map<String, Category> allCats = new CSVTransactionReader().getCategories();
//			
//			for (int t = 0; t < transacs.size(); t++) {
//				Transaction curr = transacs.get(t);
//				boolean isIncome = allCats.get(curr.getCategory()).isCategoryType("Income");
//				if (isIncome) {
//					Date d = curr.getDate();
//					int month = d.getMonthofYear() - 1;
//					transByMonth.get(month).add(curr);
//				}
//			}
//
//			for (int i = 0; i < transByMonth.size(); i++) {
//				Container monthRow = new HPanel();
//				monthRow.add(new MonthLabel(new DateImp().getMonthName(i+1)));
//				ArrayList<Transaction> currMonth = transByMonth.get(i);
//				float sum = 0;
//				for (int t = 0; t < currMonth.size(); t++) {
//					sum += currMonth.get(t).getValue();
//				}
//				monthRow.add(new MonthLabel(Float.toString(sum)));
//				reportPanel.add(monthRow);
//			}
//		}
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
	
	private class FilterTypeListener implements ActionListener {
		private JComboBox<String> combo;
		
		public FilterTypeListener(JComboBox<String> c) {
			combo = c;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			newFilterPanel.remove(2);
			currentFilter = filterFact.getFilterFor((String)combo.getSelectedItem());
			Component filterSelection = currentFilter.getInputComponent();
			newFilterPanel.add(filterSelection, 2);
			reportPanel.validate();
		}
		
	}
	
	private class AddFilterListener implements ActionListener {		
		@Override
		public void actionPerformed(ActionEvent e) {
			filters.add(currentFilter);
			
			
			// add visual line listing filter above 'clear filters' button
			// reset newFilterPanel
		}
		
	}
 }