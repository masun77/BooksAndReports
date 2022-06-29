package display;

import java.awt.Component;
import java.awt.Dimension;

public class DisplayUtilities {
	public static void setAllSizes(Component c, Dimension d) {
		c.setSize(d);
		c.setPreferredSize(d);
		c.setMaximumSize(d);
		c.setMinimumSize(d);
	}
}
