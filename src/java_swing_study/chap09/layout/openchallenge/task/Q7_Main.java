package java_swing_study.chap09.layout.openchallenge.task;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Q7_Main extends JFrame {

	private JPanel contentPane;
	private Q7_North panel;
	private Q7_Center panel_1;
	private Q7_South panel_2;

	public Q7_Main() {
		initialize();
	}
	private void initialize() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new Q7_North();
		contentPane.add(panel, BorderLayout.NORTH);
		
		panel_1 = new Q7_Center();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		panel_2 = new Q7_South();
		contentPane.add(panel_2, BorderLayout.SOUTH);
	}

}
