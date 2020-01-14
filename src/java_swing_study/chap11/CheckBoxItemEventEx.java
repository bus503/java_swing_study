package java_swing_study.chap11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CheckBoxItemEventEx extends JFrame implements ItemListener, ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JCheckBox check1;
	private JCheckBox check2;
	private JCheckBox check3;
	private JLabel sumLabel;
	private JButton btn1;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn2;
	private int sum = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxItemEventEx frame = new CheckBoxItemEventEx();
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
	public CheckBoxItemEventEx() {

		initialize();
	}

	private void initialize() {
		setTitle("체크박스와 아이템이벤트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 362);
		contentPane = new JPanel();
		contentPane.setBorder(
				new TitledBorder(null, "\uC608\uC81C11-4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 5, 5));

		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.CYAN, 2));
		contentPane.add(panel);

		lblNewLabel = new JLabel("사과 100원, 배 500원, 체리 20000원");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 13));
		panel.add(lblNewLabel);

		check1 = new JCheckBox("사과");
		check1.addItemListener(this);
		panel.add(check1);

		check2 = new JCheckBox("배");
		check2.addItemListener(this);
		panel.add(check2);

		check3 = new JCheckBox("체리");
		check3.addItemListener(this);
		panel.add(check3);

		sumLabel = new JLabel("현재 합은 0원입니다.");
		panel.add(sumLabel);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.CYAN, 2));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		btn1 = new JButton("사과 취소");
		btn1.addActionListener(this);
		panel_1.add(btn1);
		btn2 = new JButton("배 취소");
		btn2.addActionListener(this);
		panel_1.add(btn2);
		btn3 = new JButton("체리 선택");
		btn3.addActionListener(this);
		panel_1.add(btn3);
		btn4 = new JButton("모든 과일 선택");
		btn4.addActionListener(this);
		panel_1.add(btn4);
		btn5 = new JButton("선택한 과일 확인");
		btn5.addActionListener(this);
		panel_1.add(btn5);

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == check3) {
			check3ItemStateChanged(e);
		}
		if (e.getSource() == check2) {
			check2ItemStateChanged(e);
		}
		if (e.getSource() == check1) {
			check1ItemStateChanged(e);
		}
	}

	protected void check1ItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			sum += 100;

		} else {
			sum -= 100;

		}
		sumLabel.setText("현재" + sum + "원 입니다");
	}

	protected void check2ItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			sum += 500;

		} else {
			sum -= 500;

		}
		sumLabel.setText("현재" + sum + "원 입니다");
	}

	protected void check3ItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			sum += 20000;

		} else {
			sum -= 20000;

		}
		sumLabel.setText("현재" + sum + "원 입니다");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn5) {
			btn5ActionPerformed(e);
		}
		if (e.getSource() == btn4) {
			btn4ActionPerformed(e);
		}
		if (e.getSource() == btn3) {
			btn3ActionPerformed(e);
		}
		if (e.getSource() == btn2) {
			btn2ActionPerformed(e);
		}
		if (e.getSource() == btn1) {
			btn1ActionPerformed(e);
		}
	}

	protected void btn1ActionPerformed(ActionEvent e) {
		if (check1.isSelected()) {
			check1.setSelected(false);
			btn1.setText("사과 선택");
		} else {
			check1.setSelected(true);
			btn1.setText("사과 취소");
		}
	}

	protected void btn2ActionPerformed(ActionEvent e) {
		if (check2.isSelected()) {
			check2.setSelected(false);
			btn2.setText("배 선택");
		} else {
			check2.setSelected(true);
			btn2.setText("배 취소");
		}
	}

	protected void btn3ActionPerformed(ActionEvent e) {
		if (check3.isSelected()) {
			check3.setSelected(false);
			btn3.setText("체리 선택");
		} else {
			check3.setSelected(true);
			btn3.setText("체리 취소");
		}
	}

	protected void btn4ActionPerformed(ActionEvent e) {
		if (check1.isSelected() && check2.isSelected() && check3.isSelected()) {
			check1.setSelected(false);
			check2.setSelected(false);
			check3.setSelected(false);
			btn4.setText("모든과일 선택");
		} else {
			check1.setSelected(true);
			check2.setSelected(true);
			check3.setSelected(true);
			btn4.setText("모든과일 취소");
		}

	}

	protected void btn5ActionPerformed(ActionEvent e) {
//		if (check1.isSelected()) {
//			JOptionPane.showMessageDialog(null, "선택한 과일은 사과입니다.");
//		} else if (check2.isSelected()) {
//			JOptionPane.showMessageDialog(null, "선택한 과일은 배입니다.");
//		} else if (check3.isSelected()) {
//			JOptionPane.showMessageDialog(null, "선택한 과일은 체리입니다.");
//		} else if (check1.isSelected() && check3.isSelected()) {
//			JOptionPane.showMessageDialog(null, "선택한 과일은 사과와 체리입니다.");
//		} else if (check1.isSelected() && check2.isSelected()) {
//			JOptionPane.showMessageDialog(null, "선택한 과일은 사과와 배입니다.");
//		} else if (check2.isSelected() && check3.isSelected()) {
//			JOptionPane.showMessageDialog(null, "선택한 과일은 체리와 배입니다.");
//		} else if (check1.isSelected() && check2.isSelected() && check3.isSelected()) {
//			JOptionPane.showMessageDialog(null, "선택한 과일은 사과,배,체리입니다.");
//		}
		
		String text = "현재 선택된 과일은";
		if(check1.isSelected()) {
			text +="  사과  ";
		}
		if(check2.isSelected()) {
			text +="  배  ";
		}
		if(check3.isSelected()) {
			text +="  체리  ";
		}
		JOptionPane.showMessageDialog(null, text);

	}
}
