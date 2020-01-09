package java_swing_study.chap09.layout.openchallenge.task;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Q8_Main extends JFrame {

	private JPanel contentPane;
	private Q8_North panel;
	private Q8_South panel_1;
	private Q8_Center panel_2;
	private JLabel la;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Q8_Main frame = new Q8_Main();
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
	public Q8_Main() {
		initialize();
	}
	private void initialize() {
		setTitle("여러 개의 패널을 가진 프레임");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new Q8_North();
		contentPane.add(panel, BorderLayout.NORTH);
		
		panel_1 = new Q8_South();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		panel_2 = new Q8_Center();
		contentPane.add(panel_2, BorderLayout.CENTER);
		
//		for(int i=1; i<=10; i++) {
//			JLabel btn = new JLabel(Integer.toString(i));
//			btn.setLocation(Math.random()*10+1);
//			contentPane.add(btn);
		}
	}

