package java_swing_study.chap11.exam;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DepartmentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pContent;
	private JPanel pBtns;
	private JPanel pTable;
	private DepartmentPanel pDepartment;
	private JButton btnAdd;
	private JButton btnCancel;
	private JTable table;
	private ArrayList<Department> depts;
	private DepartmentTblPanel pDeptTbl;
	private int upIdx;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentFrame frame = new DepartmentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DepartmentFrame() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pContent = new JPanel();
		contentPane.add(pContent);
		pContent.setLayout(new BorderLayout(0, 0));
		
		pDepartment = new DepartmentPanel();
		pContent.add(pDepartment, BorderLayout.NORTH);
		
		pBtns = new JPanel();
		contentPane.add(pBtns);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		pTable = new JPanel();
		contentPane.add(pTable);
		pTable.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pTable.add(table);
		
		pDeptTbl = new DepartmentTblPanel();
		pDeptTbl.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(pDeptTbl);
		
		depts = new ArrayList<Department>();
		depts.add(new Department(1, "영업", 8));
		depts.add(new Department(2, "개발", 9));
		depts.add(new Department(3, "기획", 10));
		
		pDeptTbl.loadData(depts);
		pDeptTbl.setPopupMenu(createPop());
	}
	
//	private void loadData() {
//		
//	}
	
	private JPopupMenu createPop() {
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPop);
		popMenu.add(updateItem);
	
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPop);
		popMenu.add(deleteItem);
		
		return popMenu;
	}
	
	ActionListener myPop = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("수정")) {
			try{
				Department upDept = pDeptTbl.getSelectedItem();
				upIdx = pDeptTbl.getSelectedRowIdx();
				pDepartment.setItem(upDept);
				btnAdd.setText("수정");	
				pDeptTbl.clearSelection();
			}catch (RuntimeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		
			}
			
			if(e.getActionCommand().equals("삭제")) {
				try{
					pDeptTbl.removeRow();
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
//	private void btnUpdateActionPerformed(ActionEvent e) {
//		Department updateDept = pDepartment.getItem();
//		pDeptTbl.updateRow(updateDept, upIdx);
//		btnAdd.setText("추가");
//		pDepartment.clearTf();
//	}

	protected void btnAddActionPerformed(ActionEvent e) {
		Department dept = pDepartment.getItem();
		if(e.getActionCommand().equals("수정")) {
			pDeptTbl.updateRow(dept, upIdx);
			btnAdd.setText("추가");
		}else {
			pDeptTbl.addItem(dept);
		}
		pDepartment.clearTf();
		
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		pDepartment.clearTf();
	}
}
