package java_swing_study.chap11.실습문제;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class 실습5번 extends JFrame implements ChangeListener {

	private JPanel contentPane;
	private JSlider slider;
	private JLabel lblNewLabel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					실습5번 frame = new 실습5번();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public 실습5번() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinimum(100);
		slider.setMaximum(200);
		contentPane.add(slider);
		
		lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel);
		
		slider.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider) {
			sliderStateChanged(e);
		}
	}
	protected void sliderStateChanged(ChangeEvent e) {
		lblNewLabel.setText(slider.getValue()+"");
	}
}
