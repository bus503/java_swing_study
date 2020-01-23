package java_swing_study.chap14.exam.ui;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.BoxLayout;

import java_swing_study.chap14.exam.dto.Department;
import java_swing_study.chap14.exam.ui.panel.DepartmentPanel;
import java_swing_study.chap14.exam.ui.panel.DepartmentTblPanel;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DepartmentMainPanel extends JPanel implements ActionListener {
	private DepartmentPanel pDepartmentPanel;
	private JPanel pBtns;
	private DepartmentTblPanel pDepartmentTblPanel;
	private JButton btnAdd;
	private JButton btnCancel;
	private ArrayList<Department> depts;
	private int upIdx;

	public DepartmentMainPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pDepartmentPanel = new DepartmentPanel();
		add(pDepartmentPanel);
		
		pBtns = new JPanel();
		add(pBtns);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		pDepartmentTblPanel = new DepartmentTblPanel();
		add(pDepartmentTblPanel);
		
		depts = new ArrayList<Department>();
		depts.add(new Department(1, "영업", 8));
		depts.add(new Department(2, "개발", 9));
		depts.add(new Department(3, "기획", 10));
		
		pDepartmentTblPanel.loadData(depts);
		pDepartmentTblPanel.setPopupMenu(createPop());
		
	}

	private JPopupMenu createPop() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem upItem = new JMenuItem("수정");
		upItem.addActionListener(myPop);
		popMenu.add(upItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPop);
		popMenu.add(deleteItem);
		
		
		return popMenu;
	}
	
	ActionListener myPop = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("수정")) {
				try {
					Department upDept = pDepartmentTblPanel.getSelectedItem();
					upIdx = pDepartmentTblPanel.getSelectedRowIdx();
					pDepartmentTblPanel.addItem(upDept);
					btnAdd.setText("수정");
					pDepartmentTblPanel.clearSelection();
				}catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			
			if(e.getActionCommand().equals("삭제")) {
				try {
					pDepartmentTblPanel.removeRow();
				}catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			
		}
	};
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		Department dept = new Department();
		if(e.getActionCommand().equals("수정")) {
			pDepartmentTblPanel.updateRow(dept, upIdx);
			btnAdd.setText("추가");
		}else {
			pDepartmentTblPanel.addItem(dept);
		}
		pDepartmentPanel.clearTf();
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		pDepartmentPanel.clearTf();
	}
}
