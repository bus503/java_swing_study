package java_swing_study.chap14.exam.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java_swing_study.chap14.exam.dto.Student;
import java_swing_study.chap14.exam.ui.panel.StudentPanel;
import java_swing_study.chap14.exam.ui.panel.StudentTblPanel;

@SuppressWarnings("serial")
public class StudentMainPanel extends JPanel implements ActionListener {
	private StudentPanel pStudentPanel;
	private JPanel pBtns;
	private StudentTblPanel pStudentTblPanel;
	private JButton btnAdd;
	private JButton btnCancel;
	private int updateIdx;
	

	
	public StudentMainPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		pStudentPanel = new StudentPanel();
		add(pStudentPanel);
		
		pBtns = new JPanel();
		add(pBtns);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		pStudentTblPanel = new StudentTblPanel();
		add(pStudentTblPanel);
		
		ArrayList<Student> stds = new ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 90, 70));
		stds.add(new Student(2, "이성경", 90, 90, 40));
		stds.add(new Student(3, "이유영", 50, 50, 60));
		
		pStudentTblPanel.loadData(stds);
		pStudentTblPanel.setPopupMenu(createPopupMenu());
		
	}

	private JPopupMenu createPopupMenu() {
		
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenu);
		popMenu.add(updateItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopMenu);
		popMenu.add(deleteItem);
		
		return popMenu;
	}
	
ActionListener myPopMenu = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("수정")) {
				try{
					Student	upStd = pStudentTblPanel.getSelectedItem();
					updateIdx = pStudentTblPanel.getSelectedRowIdx();
					
					pStudentPanel.setItem(upStd);
					btnAdd.setText("수정");	
					pStudentTblPanel.clearSelection();
				}catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
			if(e.getActionCommand().equals("삭제")){
				try {
					pStudentTblPanel.removeRow();
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
		Student std = pStudentPanel.getItem();
		if(e.getActionCommand().equals("수정")) {
			pStudentTblPanel.updateRow(std, updateIdx);
			btnAdd.setText("추가");
		}else{
			pStudentTblPanel.addItem(std);
		}
		pStudentPanel.clearTf();
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		pStudentPanel.clearTf();
		
	}
}
