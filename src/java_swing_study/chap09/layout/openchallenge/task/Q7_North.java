package java_swing_study.chap09.layout.openchallenge.task;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class Q7_North extends JPanel {
	private JTextField textField;
	private JLabel lblNewLabel;

	public Q7_North() {

		initialize();
	}
	private void initialize() {
		setBackground(new Color(105, 105, 105));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel = new JLabel("수식입력");
		add(lblNewLabel);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
	}

}
