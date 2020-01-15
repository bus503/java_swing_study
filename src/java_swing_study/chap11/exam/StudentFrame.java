package java_swing_study.chap11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StudentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnAdd;
	private JButton btnReset;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public StudentFrame() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new StudentPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_2.add(btnAdd);
		
		btnReset = new JButton("취소");
		btnReset.addActionListener(this);
		panel_2.add(btnReset);
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReset) {
			btnResetActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		Student std = panel.getItem();
		textArea.append(std.toString() + "\n");
	}
	protected void btnResetActionPerformed(ActionEvent e) {
		panel.clearTf();
	}
	
}
