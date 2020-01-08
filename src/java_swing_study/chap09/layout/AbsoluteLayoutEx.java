package java_swing_study.chap09.layout;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AbsoluteLayoutEx extends JFrame {

	private JPanel contentPane;
	private JLabel la;

	public AbsoluteLayoutEx() {
		initialize();
	}
	private void initialize() {
		setTitle("Absolute Layout Sample");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		la = new JLabel("Hello, Press Buttons!");
		la.setHorizontalAlignment(SwingConstants.LEFT);
		la.setForeground(Color.ORANGE);
		la.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		la.setBounds(130, 50, 200, 20);
		contentPane.add(la);
		
		for(int i=1; i<=9; i++) {
			JButton btn = new JButton(Integer.toString(i));//숫자를 넣고 다시 스트링을 리턴받음
			btn.setBounds(i*15, i*15, 50, 20);
			contentPane.add(btn);
		}
	}
}