package java_swing_study.chap11.실습문제;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class 실습2번 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JTextField tfAdd;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					실습2번 frame = new 실습2번();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public 실습2번() {
		initialize();
		
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tfAdd = new JTextField();
		tfAdd.addActionListener(this);
		contentPane.add(tfAdd);
		tfAdd.setColumns(10);
		
		comboBox = new JComboBox<>();
		contentPane.add(comboBox);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfAdd) {
			tfAddActionPerformed(e);
		}
	}
	protected void tfAddActionPerformed(ActionEvent e) {
		comboBox.addItem(tfAdd.getText());
		tfAdd.setText(" ");
	}
}
