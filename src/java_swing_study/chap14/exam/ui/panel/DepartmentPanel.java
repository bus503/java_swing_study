package java_swing_study.chap14.exam.ui.panel;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java_swing_study.chap14.exam.dto.Department;

@SuppressWarnings("serial")
public class DepartmentPanel extends AbsItemPanel<Department> {
	private JLabel lbldeptNo;
	private JLabel lbldeptName;
	private JLabel lblfloor;
	private JTextField tfdeptNo;
	private JTextField tfdeptName;
	private JTextField tffloor;

	
	public DepartmentPanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uBD80\uC11C \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 10, 10));
		
		lbldeptNo = new JLabel("부서번호");
		lbldeptNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbldeptNo);
		
		tfdeptNo = new JTextField();
		add(tfdeptNo);
		tfdeptNo.setColumns(10);
		
		lbldeptName = new JLabel("부서이름");
		lbldeptName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lbldeptName);
		
		tfdeptName = new JTextField();
		add(tfdeptName);
		tfdeptName.setColumns(10);
		
		lblfloor = new JLabel("부서위치");
		lblfloor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblfloor);
		
		tffloor = new JTextField();
		add(tffloor);
		tffloor.setColumns(10);
	}

	@Override
	public Department getItem() {
		int deptNo = Integer.parseInt(tfdeptNo.getText().trim());
		String deptName = tfdeptName.getText().trim();
		int floor = Integer.parseInt(tffloor.getText().trim());
		return new Department(deptNo, deptName, floor);
	}

	@Override
	public void setItem(Department item) {
		tfdeptNo.setText(item.getDeptNo()+"");
		tfdeptName.setText(item.getDeptName()+"");
		tffloor.setText(item.getFloor()+"");
	}

	@Override
	public void clearTf() {
		tfdeptNo.setText(" ");
		tfdeptName.setText(" ");
		tffloor.setText(" ");
	}

}
