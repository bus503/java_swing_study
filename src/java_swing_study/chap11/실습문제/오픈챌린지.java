package java_swing_study.chap11.실습문제;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class 오픈챌린지 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ArrayList<ImageIcon> icons;
	private JLabel lblimg;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					오픈챌린지 frame = new 오픈챌린지();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public 오픈챌린지() {
		/*
		 * icons = new ArrayList<ImageIcon>(); String imgDirPath
		 * =System.getProperty("user.dir") + "\\images\\"; icons.ap("", new
		 * ImageIcon(imgDirPath + "apple.jpg")); icons.add("배", new ImageIcon(imgDirPath
		 * +"pear.jpg")); icons.add("체리", new ImageIcon(imgDirPath +"cherry.jpg"));
		 */
		initialize();
	}
	private void initialize() {
		setTitle("Open challenge11");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblimg = new JLabel("");
		lblimg.setHorizontalAlignment(SwingConstants.CENTER);
		lblimg.setIcon(new ImageIcon("D:\\workspace_java\\java_swing_study\\images\\icon1.png"));
		contentPane.add(lblimg, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon("D:\\workspace_java\\java_swing_study\\images\\prev_btn.png"));
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setIcon(new ImageIcon("D:\\workspace_java\\java_swing_study\\images\\next_btn.png"));
		panel.add(btnNewButton_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(e);
		}
		if (e.getSource() == btnNewButton_1) {
			btnNewButton_1ActionPerformed(e);
		}
	}
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		for(int i=1; i<4; i++) {
			lblimg.setIcon(new ImageIcon("D:\\workspace_java\\java_swing_study\\images\\icon" + i + ".png"));
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		
		
	}
}
