package java_swing_study.chap09.layout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FlowLayoutEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;
	private JButton btnCalculate;

	public FlowLayoutEx() {
		initialize();
	}
	private void initialize() {
		setTitle("FlowLayout Sample");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		
		btnAdd = new JButton("Add");
		contentPane.add(btnAdd);
		
		btnSub = new JButton("Sub");
		contentPane.add(btnSub);
		
		btnMul = new JButton("Mul");
		contentPane.add(btnMul);
		
		btnDiv = new JButton("Div");
		contentPane.add(btnDiv);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(this);
		contentPane.add(btnCalculate);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCalculate) {
			btnCalculateActionPerformed(e);
		}
	}
	protected void btnCalculateActionPerformed(ActionEvent e) {
	}
}
