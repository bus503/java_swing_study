package java_swing_study.chap09.layout.openchallenge.task;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class BorderLayout_task extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNorth;
	private JButton btnWest;
	private JButton btnCenter;
	private JButton btnEast;
	private JButton btnSouth;

	public BorderLayout_task() {
		initialize();
	}
	private void initialize() {
		setTitle("실습문제 2번");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5, 7));
		
		btnNorth = new JButton("North");
		btnNorth.addActionListener(this);
		contentPane.add(btnNorth, BorderLayout.NORTH);
		
		btnWest = new JButton("West");
		contentPane.add(btnWest, BorderLayout.WEST);
		
		btnCenter = new JButton("Center");
		btnCenter.addActionListener(this);
		contentPane.add(btnCenter, BorderLayout.CENTER);
		
		btnEast = new JButton("East");
		contentPane.add(btnEast, BorderLayout.EAST);
		
		btnSouth = new JButton("South");
		contentPane.add(btnSouth, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNorth) {
			btnNorthActionPerformed(e);
		}
	}
	private void btnNorthActionPerformed(ActionEvent e) {
		BorderLayout_task frame = new BorderLayout_task();
		frame.setVisible(true);
	}
}
