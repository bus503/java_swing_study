package java_swing_study.chap11;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ButtonEx extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonEx frame = new ButtonEx();
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
	public ButtonEx() {
		initialize();
	}
	private void initialize() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		String dirPath = System.getProperty("user.dir")+"\\images\\";
		//System.out.println(dirPath);
		ImageIcon normalIcon = new ImageIcon(dirPath+"normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon(dirPath+"rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon(dirPath+"pressedIcon.gif");
		
		JButton btn = new JButton("call me",normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		contentPane.add(btn);
	}
	

}