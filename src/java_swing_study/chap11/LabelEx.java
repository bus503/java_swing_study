package java_swing_study.chap11;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class LabelEx extends JFrame {

	private JPanel contentPane;
	private JLabel textLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabelEx frame = new LabelEx();
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
	public LabelEx() {
		initialize();
	}
	private void initialize() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String dirPath = System.getProperty("user.dir") + "\\images\\";
		System.out.println(dirPath);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textLabel = new JLabel("사랑합니다");
		
		textLabel.setIcon(new ImageIcon("D:\\workspace_java\\java_swing_study\\images\\beauty.jpg"));
		contentPane.add(textLabel);
		
		
		
	}

}
