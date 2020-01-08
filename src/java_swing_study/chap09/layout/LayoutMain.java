package java_swing_study.chap09.layout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;


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
		pLeft.add(btnFlow);
		
		btnBorder = new JButton("BorderLayout");
		btnBorder.addActionListener(this);
		pLeft.add(btnBorder);
		
		btnGrid = new JButton("GridLayout");
		pLeft.add(btnGrid);
		
		btnAbsolute = new JButton("AbsoluteLayout");
		pLeft.add(btnAbsolute);
		
		btnOpenChallenge = new JButton("OpenChallenge");
		pLeft.add(btnOpenChallenge);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "\uC2E4\uC2B5\uBB38\uC81C \uD480\uC774", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 2, 10, 10));
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		pRight.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		pRight.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		pRight.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		pRight.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("New button");
		pRight.add(btnNewButton_4);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorder) {
			btnBorderActionPerformed(e);
		}
	}
	protected void btnBorderActionPerformed(ActionEvent e) {
		BorderLayoutEx frame = new BorderLayoutEx();
		frame.setVisible(true);
	}
}
