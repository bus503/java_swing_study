package java_swing_study.chap14.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java_swing_study.chap14.exam.ui.DepartmentMainPanel;
import java_swing_study.chap14.exam.ui.StudentMainPanel;

@SuppressWarnings("serial")
public class ERPFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnScreen;
	private JMenuItem mntmStudent;
	private JMenuItem mntmDepartment;
	private JMenuItem mntmExit;
	private JScrollPane scrollPane;
	private JPanel panel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERPFrame frame = new ERPFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ERPFrame() {
		initialize();
	}
	private void initialize() {
		setTitle("관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 395);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnScreen = new JMenu("Screen");
		menuBar.add(mnScreen);
		
		mntmStudent = new JMenuItem("학생관리");
		mntmStudent.addActionListener(this);
		mnScreen.add(mntmStudent);
		
		mntmDepartment = new JMenuItem("부서관리");
		mntmDepartment.addActionListener(this);
		mnScreen.add(mntmDepartment);
		
		mntmExit = new JMenuItem("나가기");
		mnScreen.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmDepartment) {
			mntmDepartmentActionPerformed(e);
		}
		if (e.getSource() == mntmStudent) {
			mntmStudentActionPerformed(e);
		}
	}
	protected void mntmStudentActionPerformed(ActionEvent e) {
		StudentMainPanel newStd = new StudentMainPanel();
		panel.removeAll();
		panel.add(newStd,BorderLayout.SOUTH);
		revalidate();
		repaint();
		
	}
	protected void mntmDepartmentActionPerformed(ActionEvent e) {
		DepartmentMainPanel newDept = new DepartmentMainPanel();
			panel.removeAll();
			panel.add(newDept);
			revalidate();
			repaint();	
	}
}
