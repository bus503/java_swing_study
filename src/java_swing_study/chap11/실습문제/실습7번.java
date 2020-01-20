package java_swing_study.chap11.실습문제;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class 실습7번 extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JSlider slider;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					실습7번 frame = new 실습7번();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public 실습7번() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		slider = new JSlider();
	
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinimum(1);
		slider.setMajorTickSpacing(20);
		contentPane.add(slider, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("I Love Java");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		slider.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider) {
			sliderStateChanged(e);
		}
	}
	protected void sliderStateChanged(ChangeEvent e) {
		
		lblNewLabel.setFont(new Font("굴림", 1, slider.getValue()));
		
	}
}
