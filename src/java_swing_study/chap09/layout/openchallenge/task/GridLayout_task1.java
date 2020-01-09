package java_swing_study.chap09.layout.openchallenge.task;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GridLayout_task1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNew2;
	private JLabel lblNew1;
	private JLabel lblNew3;
	private JLabel lblNew4;
	private JLabel lblNew5;
	private JLabel lblNew6;
	private JLabel lblNew7;
	private JLabel lblNew8;
	private JLabel lblNew9;
	private JLabel lblNew10;
	private JLabel lblNew11;
	private JLabel lblNew12;
	private JLabel lblNew13;
	private JLabel lblNew14;
	private JLabel lblNew15;
	private JLabel lblNew16;

	public GridLayout_task1() {
		initialize();
	}
	private void initialize() {
		setTitle("4x4 Color Frame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 609, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 0, 0));
		
		lblNew1 = new JLabel("0");
		lblNew1.setBackground(Color.RED);
		lblNew1.setOpaque(true);
		contentPane.add(lblNew1);
		
		lblNew2 = new JLabel("1");
		lblNew2.setOpaque(true);
		lblNew2.setBackground(Color.ORANGE);
		contentPane.add(lblNew2);
		
		lblNew3 = new JLabel("2");
		lblNew3.setOpaque(true);
		lblNew3.setBackground(Color.YELLOW);
		contentPane.add(lblNew3);
		
		lblNew4 = new JLabel("3");
		lblNew4.setBackground(new Color(46, 139, 87));
		lblNew4.setOpaque(true);
		contentPane.add(lblNew4);
		
		lblNew5 = new JLabel("4");
		lblNew5.setBackground(new Color(0, 191, 255));
		lblNew5.setOpaque(true);
		contentPane.add(lblNew5);
		
		lblNew6 = new JLabel("5");
		lblNew6.setBackground(new Color(0, 0, 255));
		lblNew6.setOpaque(true);
		contentPane.add(lblNew6);
		
		lblNew7 = new JLabel("6");
		lblNew7.setBackground(new Color(138, 43, 226));
		lblNew7.setOpaque(true);
		contentPane.add(lblNew7);
		
		lblNew8 = new JLabel("7");
		lblNew8.setBackground(new Color(128, 128, 128));
		lblNew8.setOpaque(true);
		contentPane.add(lblNew8);
		
		lblNew9 = new JLabel("8");
		lblNew9.setBackground(new Color(255, 182, 193));
		lblNew9.setOpaque(true);
		contentPane.add(lblNew9);
		
		lblNew10 = new JLabel("9");
		lblNew10.setBackground(new Color(192, 192, 192));
		lblNew10.setOpaque(true);
		contentPane.add(lblNew10);
		
		lblNew11 = new JLabel("10");
		lblNew11.setBackground(new Color(255, 255, 255));
		lblNew11.setOpaque(true);
		contentPane.add(lblNew11);
		
		lblNew12 = new JLabel("11");
		lblNew12.setBackground(new Color(105, 105, 105));
		lblNew12.setOpaque(true);
		contentPane.add(lblNew12);
		
		lblNew13 = new JLabel("12");
		lblNew13.setBackground(new Color(0, 0, 0));
		lblNew13.setOpaque(true);
		contentPane.add(lblNew13);
		
		lblNew14 = new JLabel("13");
		lblNew14.setBackground(new Color(244, 164, 96));
		lblNew14.setOpaque(true);
		contentPane.add(lblNew14);
		
		lblNew15 = new JLabel("14");
		lblNew15.setBackground(new Color(65, 105, 225));
		lblNew15.setOpaque(true);
		contentPane.add(lblNew15);
		
		lblNew16 = new JLabel("15");
		lblNew16.setBackground(new Color(147, 112, 219));
		lblNew16.setOpaque(true);
		contentPane.add(lblNew16);
	}

}
