package java_swing_study.chap09.layout.openchallenge.task;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GridLayout_task extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	
	public GridLayout_task() {
		initialize();
	}
	private void initialize() {
		setTitle("실습문제 4번");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnNewButton = new JButton("0");
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.RED);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("1");
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("2");
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("3");
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("4");
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("5");
		contentPane.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("6");
		contentPane.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("7");
		contentPane.add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("8");
		contentPane.add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("9");
		contentPane.add(btnNewButton_9);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(e);
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
	}
}
