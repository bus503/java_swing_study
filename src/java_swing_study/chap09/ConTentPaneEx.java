package java_swing_study.chap09;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ConTentPaneEx extends JFrame {

	public ConTentPaneEx() {
		setTitle("ContentPane과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout());
		//컴포넌트들을 좌에서 우로 배치하는거 flowlayout
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(300,150); //가로 300 높이 150
		setVisible(true); 
		
	}
	
	public static void main(String[] args) {
         new ConTentPaneEx();
	}

}