package java_swing_study.chap11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class JComponentEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComponentEx frame = new JComponentEx();
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
	public JComponentEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 330);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 5, 5));
		
		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "11-1\uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pLeft);
		
		btn1 = new JButton("Magenta/Yellow Button");
		btn1.addActionListener(this);
		btn1.setBackground(Color.YELLOW);
		btn1.setForeground(Color.MAGENTA);
		btn1.setFont(new Font("Arial", Font.ITALIC, 20));
		pLeft.add(btn1);
		
		btn2 = new JButton("     Disavled Button     ");
		btn2.setEnabled(false);
		pLeft.add(btn2);
		
		btn3 = new JButton("getX() , getY()");
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
				frame.setTitle(b.getX() + " , " + b.getY());
				
			}
		});
		
		pLeft.add(btn3);
		
		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "JComponentEx", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			btn1ActionPerformed(e);
		}
	}
	protected void btn1ActionPerformed(ActionEvent e) {
		if(btn2.isVisible()==false) {
			
			btn2.setEnabled(true);
		}else {
			btn2.setEnabled(false);
		}
	}
}
