package display;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import database.Book;

public class HomeDisplay implements ApplicationDisplay {
	private ArrayList<TransactionDisplay> transDisplays = new ArrayList<TransactionDisplay>();
	private Book currentBook;
	private JFrame homeFrame = new JFrame();
	private final Dimension APP_SIZE = new Dimension(1200,1000);
	private JPanel mainPanel = new HPanel();
	private JPanel sidePanel = new VPanel();
	
	public HomeDisplay(Book b) {
		currentBook = b;
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel.add(new JPanel());
		mainPanel.add(sidePanel);
	
		homeFrame.add(mainPanel);
	}
	
	@Override
	public void addBookToAll(Book b) {
		currentBook = b;
		for (int t = 0; t < transDisplays.size(); t++) {
			transDisplays.get(t).addBook(b);
		}
	}

	@Override
	public void addTransactionDisplay(TransactionDisplay td, String name) {
		transDisplays.add(td);
		td.addBook(currentBook);
		
		JButton funcButton = new JButton(name);
		funcButton.addActionListener(new FunctionListener(td));
		
		sidePanel.add(funcButton); 
		sidePanel.add(Box.createRigidArea(new Dimension(1,10)));
	}
	
	@Override
	public void addHomeDisplay(TransactionDisplay td) {
		transDisplays.add(td);
		td.addBook(currentBook);
		mainPanel.remove(0);
		mainPanel.add(td.getMainPanel(), 0);
	}
	
	@Override
	public void showApplication() {
		homeFrame.setSize(APP_SIZE);
		homeFrame.setVisible(true);
	}

	@Override
	public void removeTransactionDisplay(TransactionDisplay td) {
		td.disposeOfDisplay();
	}
	
	private class FunctionListener implements ActionListener {
		private TransactionDisplay functionDisplay;
		
		public FunctionListener(TransactionDisplay td) {
			functionDisplay = td;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			functionDisplay.showDisplay();
		}
		
	}

}
