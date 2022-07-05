package dataManipulation;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;

public class DateFilter implements Filter{
	private Date selectedDate = new DateImp();
	private JTextField dateField = new JTextField();
	private final Dimension MAX_SIZE = new Dimension(100,40);
	
	public DateFilter() {
		dateField.setMaximumSize(MAX_SIZE);
		dateField.setMinimumSize(MAX_SIZE);
	}

	@Override
	public boolean meetsFilter(Transaction t) {
		selectedDate = DateImp.parseDate(dateField.getText());
		return selectedDate.equalsDate(t.getDate());
	}

	@Override
	public Component getInputComponent() {
		return dateField;
	}

}
