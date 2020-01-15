package java_swing_study.chap11.exam;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class StudentPanel extends AbsItemPanel<Student> {
	private JLabel lblStdNo;
	private JTextField tfStdNo;
	private JLabel lblStdName;
	private JTextField tfStdName;
	private JLabel lblKor;
	private JTextField tfKor;
	private JLabel lblMath;
	private JTextField tfMath;
	private JLabel lblEng;
	private JTextField tfEng;

	public StudentPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uD559\uC0DD \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		lblStdNo = new JLabel("학생번호");
		lblStdNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStdNo);
		
		tfStdNo = new JTextField();
		tfStdNo.setHorizontalAlignment(SwingConstants.LEFT);
		add(tfStdNo);
		tfStdNo.setColumns(10);
		
		lblStdName = new JLabel("학생이름");
		lblStdName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStdName);
		
		tfStdName = new JTextField();
		tfStdName.setHorizontalAlignment(SwingConstants.LEFT);
		add(tfStdName);
		tfStdName.setColumns(10);
		
		lblKor = new JLabel("국어점수");
		lblKor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblKor);
		
		tfKor = new JTextField();
		tfKor.setHorizontalAlignment(SwingConstants.LEFT);
		add(tfKor);
		tfKor.setColumns(10);
		
		lblMath = new JLabel("수학점수");
		lblMath.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblMath);
		
		tfMath = new JTextField();
		tfMath.setHorizontalAlignment(SwingConstants.LEFT);
		add(tfMath);
		tfMath.setColumns(10);
		
		lblEng = new JLabel("영어점수");
		lblEng.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblEng);
		
		tfEng = new JTextField();
		tfEng.setHorizontalAlignment(SwingConstants.LEFT);
		add(tfEng);
		tfEng.setColumns(10);
	}
	
	
	@Override
	public void clearTf() {
		tfStdNo.setText("");
		tfStdName.setText("");
		tfKor.setText("");
		tfMath.setText("");
		tfEng.setText("");
	}
	@Override
	public Student getItem() {
		int stdNo = Integer.parseInt(tfStdNo.getText().trim());
		String name = tfStdName.getText().trim();
		int kor = Integer.parseInt(tfKor.getText().trim());
		int	math = Integer.parseInt(tfMath.getText().trim());
		int eng = Integer.parseInt(tfEng.getText().trim());
		Student student = new Student(stdNo, name, kor, math, eng);
		return student;
	}
	
	@Override
	public void setItem(Student item) {
		tfStdNo.setText(item.getStdNo()+"");
		tfStdName.setText(item.getStdName()+"");
		tfKor.setText(item.getKor()+"");
		tfMath.setText(item.getMath()+"");
		tfEng.setText(item.getEng()+"");
		
	}

}
