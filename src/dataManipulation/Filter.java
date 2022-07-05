package dataManipulation;

import java.awt.Component;

public interface Filter {
	public boolean meetsFilter(Transaction t);
	public Component getInputComponent();
}
