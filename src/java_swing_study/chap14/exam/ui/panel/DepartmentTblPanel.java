package java_swing_study.chap14.exam.ui.panel;

import javax.swing.SwingConstants;

import java_swing_study.chap14.exam.dto.Department;

@SuppressWarnings("serial")
public class DepartmentTblPanel extends AbstractTblPanel<Department> {

	
	public DepartmentTblPanel() {

	}

	@Override
	protected void setTblWidthAlign() {
		tableSetWidth(50, 150, 50);
		tableCellAlign(SwingConstants.CENTER, 0);
		tableCellAlign(SwingConstants.CENTER, 1);
		tableCellAlign(SwingConstants.CENTER, 2);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {"부서번호", "부서이름", "위치"};
	}

	@Override
	protected Object[] toArray(Department item) {
		return new Object[] {
				String.format("%03d", item.getDeptNo()), 
				item.getDeptName(), 
				item.getFloor()};
	}

	@Override
	public void updateRow(Department item, int updateIdx) {
		model.setValueAt(String.format("%d", item.getDeptNo()), updateIdx, 0);
		model.setValueAt(item.getDeptName(), updateIdx, 1);
		model.setValueAt(item.getFloor(), updateIdx, 2);
	}

	@Override
	public Department getSelectedItem() {
		int selectedIdx = getSelectedRowIdx();
		
		int deptNo = Integer.parseInt((String)model.getValueAt(selectedIdx, 0));
		String deptName = (String) model.getValueAt(selectedIdx, 1);
		int floor = (int) model.getValueAt(selectedIdx, 2);
	
		return new Department(deptNo, deptName, floor);
	}


}