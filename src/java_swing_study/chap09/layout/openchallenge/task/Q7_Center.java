package java_swing_study.chap09.layout.openchallenge.task;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class Q7_Center extends JPanel {
	private JButton btnNewButton_0;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JButton btnNewButton_11;
	private JButton btnNewButton_12;
	private JButton btnNewButton_13;
	private JButton btnNewButton_14;
	private JButton btnNewButton_15;

	/**
	 * Create the panel.
	 */
	public Q7_Center() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 4, 0, 0));
		
		btnNewButton_0 = new JButton("0");
		add(btnNewButton_0);
		
		btnNewButton_1 = new JButton("1");
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("2");
		add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("3");
		add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("4");
		add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("5");
		add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("6");
		add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("7");
		add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("8");
		add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("9");
		add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("CE");
		add(btnNewButton_10);
		
		btnNewButton_11 = new JButton("계산");
		add(btnNewButton_11);
		
		btnNewButton_12 = new JButton("+");
		btnNewButton_12.setBackground(new Color(30, 144, 255));
		add(btnNewButton_12);
		
		btnNewButton_13 = new JButton("-");
		btnNewButton_13.setBackground(new Color(30, 144, 255));
		add(btnNewButton_13);
		
		btnNewButton_14 = new JButton("x");
		btnNewButton_14.setBackground(new Color(30, 144, 255));
		add(btnNewButton_14);
		
		btnNewButton_15 = new JButton("/");
		btnNewButton_15.setBackground(new Color(30, 144, 255));
		add(btnNewButton_15);
	}

}
