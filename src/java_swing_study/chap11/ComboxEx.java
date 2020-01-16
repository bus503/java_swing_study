package java_swing_study.chap11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java_swing_study.chap11.exam.Student;

@SuppressWarnings("serial")
public class ComboxEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JComboBox<String> cmbFruit;
	private DefaultComboBoxModel<String> model;
	private JTextField tfFruit;
	private JLabel lblName;
	private JButton btnOk;
	private JComboBox<Student> cmdStudent;
	private DefaultComboBoxModel<Student> model1;
	private JLabel lblStudent;
	private JButton btnConfirm;
	private JPanel panel;
	private JLabel lblNum;
	private JTextField tfNum;
	private JButton btnSearch;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboxEx frame = new ComboxEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ComboxEx() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		pLeft = new JPanel();
		pLeft.setBorder(
				new TitledBorder(null, "\uC608\uC81C11-12", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 1, 0, 0));

		cmbFruit = new JComboBox<>();// 위에서 제네릭 필드 String 넣고 여기서는 <>만
		cmbFruit.addActionListener(this);
		cmbFruit.setMaximumRowCount(5);
		pLeft.add(cmbFruit);

		tfFruit = new JTextField();
		tfFruit.addActionListener(this);
		pLeft.add(tfFruit);
		tfFruit.setColumns(10);

		lblName = new JLabel("과일");
		lblName.setForeground(Color.RED);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lblName);

		pRight = new JPanel();
		pRight.setBorder(
				new TitledBorder(null, "\uC608\uC81C11-13", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));

		cmdStudent = new JComboBox<>();
		cmdStudent.setModel(getStudentModel());
		cmdStudent.setSelectedIndex(-1);
		cmdStudent.addActionListener(this);
		pRight.add(cmdStudent);

		lblStudent = new JLabel("학생 정보");
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setForeground(Color.RED);
		pRight.add(lblStudent);

		btnConfirm = new JButton("학생 확인");
		btnConfirm.addActionListener(this);
		pRight.add(btnConfirm);

		panel = new JPanel();
		pRight.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNum);

		tfNum = new JTextField();
		panel.add(tfNum);
		tfNum.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		panel.add(btnSearch);

		cmbFruit.setModel(getModel());
		cmbFruit.setSelectedIndex(-1);

		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		pLeft.add(btnOk);
	}

	private ComboBoxModel<Student> getStudentModel() {
		model1 = new DefaultComboBoxModel<Student>();
		
		ArrayList<Student> std = new ArrayList<Student>();
		std.add(new Student(1, "서현진", 80, 90, 70));
		std.add(new Student(2, "이성경", 90, 90, 40));
		std.add(new Student(3, "이유영", 50, 50, 60));

		for (Student s : std) {
			 model1.addElement(s);
		}
		return model1;
	}

	private ComboBoxModel<String> getModel() {
		model = new DefaultComboBoxModel<String>();

		String[] fs = new String[] { "apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry",
				"balckberry" };
//		List<String> fruits = new ArrayList();//컨트롤 쉬프트 o 유틸로 뺌
		for (String f : fs) {
			model.addElement(f);
		}
		return model;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			btnSearchActionPerformed(e);
		}
		if (e.getSource() == btnConfirm) {
			btnConfirmActionPerformed(e);
		}
		if (e.getSource() == cmdStudent) {
			cmdStudentActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
		if (e.getSource() == cmbFruit) {
			cmbFruitActionPerformed(e);
		}
		if (e.getSource() == tfFruit) {
			textFieldActionPerformed(e);
		}
	}

	protected void textFieldActionPerformed(ActionEvent e) {
//		String ffs = tfFruit.Text();
		model.addElement(tfFruit.getText());
		tfFruit.setText("");
	}

	protected void cmbFruitActionPerformed(ActionEvent e) {
		int Idx = cmbFruit.getSelectedIndex();
		lblName.setText(cmbFruit.getItemAt(Idx));
	}

	protected void btnOkActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "선택된 과일은" + cmbFruit.getSelectedItem());
	}
	
	protected void cmdStudentActionPerformed(ActionEvent e) {
		lblStudent.setText(cmdStudent.getSelectedItem().toString());
//		lblStudent.setText(getStudentModel().toString());
//		lblStudent.setText(cmdStudent.getParent());
		System.out.println(e);
		
	}
	protected void btnConfirmActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, cmdStudent.getSelectedItem());
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		cmdStudent.setSelectedIndex(Integer.parseInt(tfNum.getText())-1);
	}
}
