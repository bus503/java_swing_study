package java_swing_study.chap09.layout.openchallenge.task;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GridLayout_task extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	
	public GridLayout_task() {
		initialize();
	}
	private void initialize() {
		setTitle("실습문제 4번");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 10, 0, 0));
		
		btn0 = new JButton("0");
		btn0.addActionListener(this);
		btn0.setBackground(Color.RED);
		contentPane.add(btn0);
		
		btn1 = new JButton("1");
		btn1.setBackground(Color.ORANGE);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBackground(Color.YELLOW);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBackground(new Color(34, 139, 34));
		contentPane.add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBackground(Color.CYAN);
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBackground(Color.BLUE);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBackground(new Color(153, 50, 204));
		contentPane.add(btn6);
		
		btn7 = new JButton("7");
		btn7.setBackground(new Color(128, 128, 128));
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBackground(new Color(255, 192, 203));
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBackground(new Color(169, 169, 169));
		contentPane.add(btn9);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn0) {
			btn0ActionPerformed(e);
		}
	}
	protected void btn0ActionPerformed(ActionEvent e) {
		
	}
}
