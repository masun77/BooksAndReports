package display;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class VPanel extends JPanel {
	public VPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);
	}
}
