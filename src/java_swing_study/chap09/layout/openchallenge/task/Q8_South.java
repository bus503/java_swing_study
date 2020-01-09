package java_swing_study.chap09.layout.openchallenge.task;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

@SuppressWarnings("serial")
public class Q8_South extends JPanel {
	private JTextField textField;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public Q8_South() {

		initialize();
	}
	private void initialize() {
		setBackground(new Color(255, 215, 0));
		
		lblNewLabel = new JLabel("Word Input");
		add(lblNewLabel);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
	}

}
