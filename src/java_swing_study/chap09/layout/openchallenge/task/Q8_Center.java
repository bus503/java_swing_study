package java_swing_study.chap09.layout.openchallenge.task;

import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Q8_Center extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;

	/**
	 * Create the panel.
	 */
	public Q8_Center() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		lblNewLabel = new JLabel("*");
		lblNewLabel.setBounds(115, 105, 57, 15);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setBounds(259, 184, 57, 15);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setBounds(56, 184, 57, 15);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(259, 88, 57, 15);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(56, 137, 57, 15);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setBounds(172, 184, 57, 15);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("*");
		lblNewLabel_6.setBounds(311, 159, 57, 15);
		add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("*");
		lblNewLabel_7.setBounds(203, 63, 57, 15);
		add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("*");
		lblNewLabel_8.setBounds(259, 137, 57, 15);
		add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("*");
		lblNewLabel_9.setBounds(172, 159, 57, 15);
		add(lblNewLabel_9);
	}

}
