package java_swing_study.chap11.실습문제;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class 실습1번 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JCheckBox check1;
	private JCheckBox check2;
	private JButton btncheck;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					실습1번 frame = new 실습1번();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public 실습1번() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		check1 = new JCheckBox("버튼 비활성화");
		check1.addActionListener(this);
		contentPane.add(check1);
		
		check2 = new JCheckBox("버튼 감추기");
		check2.addActionListener(this);
		contentPane.add(check2);
		
		btncheck = new JButton("test button");
		contentPane.add(btncheck);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == check2) {
			check2ActionPerformed(e);
		}
		if (e.getSource() == check1) {
			check1ActionPerformed(e);
		}
	}
	protected void check1ActionPerformed(ActionEvent e) {
		if(check1.isSelected()) {
			btncheck.setEnabled(false);
		}
		if(check1.isSelected()!=true){
			btncheck.setEnabled(true);
		}
	}
	protected void check2ActionPerformed(ActionEvent e) {
		if(check2.isSelected()) {
			btncheck.setVisible(false);
		}
		if(check2.isSelected()!=true){
			btncheck.setVisible(true);
		}
	}
}
