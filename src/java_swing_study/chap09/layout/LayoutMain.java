package java_swing_study.chap09.layout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import java_swing_study.chap09.layout.openchallenge.OpenChallengeEx;
import java_swing_study.chap09.layout.openchallenge.task.BorderLayout_task;
import java_swing_study.chap09.layout.openchallenge.task.GridLayout_task;
import java_swing_study.chap09.layout.openchallenge.task.GridLayout_task1;
import java_swing_study.chap09.layout.openchallenge.task.Q7_Main;
import java_swing_study.chap09.layout.openchallenge.task.Q8_Main;

@SuppressWarnings("serial")
public class LayoutMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JButton btnFlow;
	private JButton btnBorder;
	private JButton btnGrid;
	private JButton btnAbsolute;
	private JButton btnOpenChallenge;
	private JPanel pRight;
	private JButton btntask2;
	private JButton btntask4;
	private JButton btntask5;
	private JButton btntask7;
	private JButton btntask8;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayoutMain frame = new LayoutMain();
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

	public LayoutMain() {
		initialize();
	}
	private void initialize() {
		setTitle("배치레이아웃 해제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC81C9\uC7A5 GUI \uAE30\uCD08", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null, "\uB808\uC774\uC544\uC6C3 \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnFlow = new JButton("Flowlayout");
		btnFlow.addActionListener(this);
		pLeft.add(btnFlow);
		
		btnBorder = new JButton("BorderLayout");
		btnBorder.addActionListener(this);
		pLeft.add(btnBorder);
		
		btnGrid = new JButton("GridLayout");
		btnGrid.addActionListener(this);
		pLeft.add(btnGrid);
		
		btnAbsolute = new JButton("AbsoluteLayout");
		btnAbsolute.addActionListener(this);
		pLeft.add(btnAbsolute);
		
		btnOpenChallenge = new JButton("OpenChallenge");
		btnOpenChallenge.addActionListener(this);
		pLeft.add(btnOpenChallenge);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "\uC2E4\uC2B5\uBB38\uC81C \uD480\uC774", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 2, 10, 10));
		
		btntask2 = new JButton("실습 2번");
		btntask2.addActionListener(this);
		pRight.add(btntask2);
		
		btntask4 = new JButton("실습 4번");
		btntask4.addActionListener(this);
		pRight.add(btntask4);
		
		btntask5 = new JButton("실습 5번");
		btntask5.addActionListener(this);
		pRight.add(btntask5);
		
		btntask7 = new JButton("실습 7번");
		btntask7.addActionListener(this);
		pRight.add(btntask7);
		
		btntask8 = new JButton("실습 8번");
		btntask8.addActionListener(this);
		btntask8.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getButton() + ":" + e.getClickCount());
			}
		});
		pRight.add(btntask8);
	}

	public void actionPerformed(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, e.getSource());
		System.out.println(e.getActionCommand());
		
		if (e.getSource() == btnOpenChallenge) {
			btnOpenChallengeActionPerformed(e);
		}
		if (e.getSource() == btnAbsolute) {
			btnAbsoluteActionPerformed(e);
		}
		if (e.getSource() == btnGrid) {
			btnGridActionPerformed(e);
		}
		if (e.getSource() == btnBorder) {
			btnBorderActionPerformed(e);
		}
		if (e.getSource() == btnFlow) {
			btnFlowActionPerformed(e);
		}
		if (e.getSource() == btntask8) {
			btntask8ActionPerformed(e);
		}
		if (e.getSource() == btntask7) {
			btntask7ActionPerformed(e);
		}
		if (e.getSource() == btntask5) {
			btntask5ActionPerformed(e);
		}
		if (e.getSource() == btntask4) {
			btntask4ActionPerformed(e);
		}
		if (e.getSource() == btntask2) {
			btntask2ActionPerformed(e);
		}
	}
	protected void btntask2ActionPerformed(ActionEvent e) {
		BorderLayout_task frame = new BorderLayout_task();
		frame.setVisible(true);
	}
	protected void btntask4ActionPerformed(ActionEvent e) {
		GridLayout_task frame = new GridLayout_task();
		frame.setVisible(true);
	}
	protected void btntask5ActionPerformed(ActionEvent e) {
		GridLayout_task1 frame = new GridLayout_task1();
		frame.setVisible(true);
	}
	protected void btntask7ActionPerformed(ActionEvent e) {
		Q7_Main frame = new Q7_Main();
		frame.setVisible(true);
	}
	protected void btntask8ActionPerformed(ActionEvent e) {
		Q8_Main frame = new Q8_Main();
		frame.setVisible(true);
	}
	protected void btnFlowActionPerformed(ActionEvent e) {
		FlowLayoutEx frame = new FlowLayoutEx();
		frame.setVisible(true);
	}
	protected void btnBorderActionPerformed(ActionEvent e) {
		BorderLayoutEx frame = new BorderLayoutEx();
		frame.setVisible(true);
	}
	protected void btnGridActionPerformed(ActionEvent e) {
		GridLayoutEx frame = new GridLayoutEx();
		frame.setVisible(true);
	}
	protected void btnAbsoluteActionPerformed(ActionEvent e) {
		AbsoluteLayoutEx frame = new AbsoluteLayoutEx();
		frame.setVisible(true);
	}
	protected void btnOpenChallengeActionPerformed(ActionEvent e) {
		OpenChallengeEx frame = new OpenChallengeEx();
		frame.setVisible(true);
	}
}
