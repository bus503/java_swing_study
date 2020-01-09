package java_swing_study.chap10;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import java_swing_study.chap09.ConTentPaneEx;
import java_swing_study.chap10.EventListenerEx.MyAction3Listener;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YourEventListenerEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JButton btn01;
	private JButton btn02;
	private JButton btn03;
	private JButton btn04;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YourEventListenerEx frame = new YourEventListenerEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public YourEventListenerEx() {
		initialize();
	}

	private void initialize() {
		setTitle("리스너작성실습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 378);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 20, 10, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 10));

		panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(null, "\uC708\uB3C4\uC6B0\uBE4C\uB354\uC81C\uACF5", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));

		btn01 = new JButton("배경색 변경");
		btn01.addActionListener(this);
		panel1.add(btn01, BorderLayout.CENTER);

		panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(null, "\uB3C5\uB9BD\uD074\uB798\uC2A4", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		contentPane.add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));

		JButton btn02 = new JButton("배경색 변경");
		btn02.addActionListener(new MyAction3());
		panel2.add(btn02);
		/* panel2.add(btn02, BorderLayout.CENTER); */

		panel3 = new JPanel();
		panel3.setBorder(new TitledBorder(null, "\uB0B4\uBD80\uD074\uB798\uC2A4", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		contentPane.add(panel3);
		panel3.setLayout(new BorderLayout(0, 0));

		btn03 = new JButton("배경색 변경");
		btn03.addActionListener(new MyAction4());
		panel3.add(btn03, BorderLayout.CENTER);

		panel4 = new JPanel();
		panel4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC775\uBA85\uD074\uB798\uC2A4",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel4);
		panel4.setLayout(new BorderLayout(0, 0));

		btn04 = new JButton("배경색 변경");
		btn03.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				if (contentPane.getBackground() == Color.PINK) {
//					contentPane.setBackground(Color.RED);
//				} else {
//					contentPane.setBackground(Color.PINK);
//				}
			}
		});
		panel4.add(btn04);
	}

	public class MyAction4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(contentPane.getBackground());
			if (contentPane.getBackground() == Color.YELLOW) {
				contentPane.setBackground(Color.RED);
			} else {
				contentPane.setBackground(Color.YELLOW);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn02) {
			btn02ActionPerformed(e);
		}
		if (e.getSource() == btn01) {
			btn01ActionPerformed(e);
		}
	}

	protected void btn01ActionPerformed(ActionEvent e) {
		System.out.println(contentPane.getBackground());
		if (contentPane.getBackground() == Color.YELLOW) {
			contentPane.setBackground(Color.RED);
		} else {
			contentPane.setBackground(Color.YELLOW);
		}
	}

	protected void btn02ActionPerformed(ActionEvent e) {

	}
}
