package java_swing_study.chap09.layout.openchallenge.task;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class Q8_North extends JPanel {
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public Q8_North() {

		initialize();
	}
	private void initialize() {
		setBackground(new Color(128, 128, 128));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton = new JButton("열기");
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("닫기");
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("나가기");
		add(btnNewButton_2);
	}

}
