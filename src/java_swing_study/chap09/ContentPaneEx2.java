package java_swing_study.chap09;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ContentPaneEx2 extends JFrame {

	private JPanel contentPane;

	public ContentPaneEx2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300); //좌표
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // 상하좌우의 패딩마진값
		contentPane.setLayout(new BorderLayout(0, 0)); // 수평과 수직의 갭?
		setContentPane(contentPane); //프레임안에 넣어라
	}

}
