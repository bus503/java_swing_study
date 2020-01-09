package java_swing_study.chap09.layout.openchallenge.task;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class Q7_South extends JPanel {
	private JLabel lblNewLabel;
	private JTextField textField;

	public Q7_South() {

		initialize();
	}
	private void initialize() {
		setBackground(new Color(255, 215, 0));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel = new JLabel("계산 결과");
		add(lblNewLabel);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
	}

}
