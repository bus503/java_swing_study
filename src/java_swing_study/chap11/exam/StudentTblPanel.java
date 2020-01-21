package java_swing_study.chap11.exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class StudentTblPanel extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private NotEditableModel model;

	public StudentTblPanel() {
		
		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(table);
		
		
		ArrayList<Student> stds = new ArrayList<Student>();
		stds.add(new Student (1,"서현진",90,80,70));
		stds.add(new Student (2,"남궁민",80,90,90));
		stds.add(new Student (3,"손예진",70,40,50));
		
		loadData(stds);
		//외부에서 호출하도록 만들거임

	}
	public void setPopupMenu(JPopupMenu popupMenu) {
		scrollPane.setComponentPopupMenu(popupMenu);
		table.setComponentPopupMenu(popupMenu);
	}
	private void loadData(ArrayList<Student> stds) {
		model = new NotEditableModel(getRows(stds),getColNames());
		table.setModel(model);
		
		setTblWidthAlign();
		
		
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
		table.getColumnModel().getColumn(2).setCellRenderer(new ReturnTableCellRenderer());
	}

	private void setTblWidthAlign() {
		//각 컬럼의 폭과 셀의 수평정렬을 할거임
		tableSetWidth(50, 150, 50, 50, 50, 70, 70);
		tableCellAlign(SwingConstants.CENTER,0,1,2,4);
		tableCellAlign(SwingConstants.RIGHT, 5, 6);
		tableCellAlign(SwingConstants.LEFT,3);
	}
	
	private void tableCellAlign(int align, int...idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0; i<idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
		
//		cModel.getColumn(0).setCellRenderer(dtcr);
//		cModel.getColumn(1).setCellRenderer(dtcr);
//		cModel.getColumn(2).setCellRenderer(dtcr);
//		cModel.getColumn(3).setCellRenderer(dtcr);
//		cModel.getColumn(4).setCellRenderer(dtcr);
//		for(int i=0; i<dtcr. i++) {
//			
//		}
	}
	private void tableSetWidth(int...width) {//가변인수
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0; i<width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
//			System.out.println(width[i]);
		}
//		cModel.getColumn(0).setPreferredWidth(50);
//		cModel.getColumn(1).setPreferredWidth(150);
//		cModel.getColumn(2).setPreferredWidth(50);
//		cModel.getColumn(3).setPreferredWidth(50);
//		cModel.getColumn(4).setPreferredWidth(50);
//		cModel.getColumn(5).setPreferredWidth(50);
//		cModel.getColumn(6).setPreferredWidth(50);
	}
	
	private String[] getColNames() {
		return new String[] {"학생번호", "학생명", "국어", "영어", "수학", "총점", "평균"};
	}
	
	private Object[][] getRows(ArrayList<Student> stds) {
		Object[][] rows = new Object[stds.size()][];
		for(int i=0; i<rows.length; i++) {
			rows[i] = toArray(stds.get(i));
		}
		return rows;
	}
	
	private Object[] toArray(Student std) {
		return new Object[] {
							String.format("S%03d",std.getStdNo()), 
							std.getStdName(), 
							std.getKor(), 
							std.getEng(),
							std.getMath(), 
							std.total(),
							(String.format("%.1f",std.avg()))};
	}
	
	public void removeRow() {
		int selectedIdx = getSelectedRowIdx();
		model.removeRow(selectedIdx);
	}
	
	public void updateRow(Student std, int updateIdx) {
		model.setValueAt(String.format("S%03d",std.getStdNo()), updateIdx, 0);//S001
		model.setValueAt(std.getStdName(), updateIdx, 1);
		model.setValueAt(std.getKor(), updateIdx, 2);
		model.setValueAt(std.getEng(), updateIdx, 3);
		model.setValueAt(std.getMath(), updateIdx, 4);
		model.setValueAt(std.total(), updateIdx, 5);
		model.setValueAt(String.format("%.1f",std.avg()), updateIdx, 6);
		
	}
	
	public void	addItem(Student std) {
		model.addRow(toArray(std));
	}
	
	
	private int getSelectedRowIdx() {
		int selectedIdx = table.getSelectedRow();
//		System.out.println(selectedIdx);
		if(selectedIdx == -1) {
//			throw new Exception("해당 학생을 선택하세요");
			//그냥 이렇게 하면 코드가 더러워지기 시작함
			throw new RuntimeException("해당 학생을 선택하세요");
		}
		return selectedIdx;
	}
	
	public Student getSelectedItem() {
		int selectedIdx = table.getSelectedRow();
		
//		int stdNo = (int) model.getValueAt(selectedIdx, 0);
		String strNo = ((String)model.getValueAt(selectedIdx, 0)).replace("S", "");//S001 -> 001
		int stdNo = Integer.parseInt(strNo);
		String stdName = (String) model.getValueAt(selectedIdx, 1);
//		int stdName = Integer.parseInt((String)model.getValueAt(selectedIdx, 1));
		int kor = (int) model.getValueAt(selectedIdx, 2);
		int math = (int) model.getValueAt(selectedIdx, 3);
		int eng = (int) model.getValueAt(selectedIdx, 4);
				
		return new Student(stdNo, stdName, kor, math, eng);
	}
	
	
	//수정금지하기 위한 모델
	private class NotEditableModel extends DefaultTableModel{

		public NotEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}
		//디폴트테이블 모델에 상속받음

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
	
	
	public class ReturnTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (value==null) return this;
			setText(value.toString());
			setOpaque(true);
			
			if (Integer.parseInt(table.getValueAt(row, 2).toString())>=90) {
				setBackground(Color.CYAN);
			}else if(Integer.parseInt(table.getValueAt(row, 2).toString())>=80) {
				setBackground(Color.LIGHT_GRAY);
			}
			else {
				setBackground(Color.WHITE);
			}
			if (isSelected) {
				setBackground(Color.orange);
			}
			return this;
		}
	}
	
	public static void main(String[] args) {
		//jpanel은 단독으로 화면에 안뜸 그래서 시험해보려고 메인을 만들어봄
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setBounds(10, 10, 450, 500);
		
		StudentTblPanel tbl = new StudentTblPanel();
		frame.add(tbl);
		frame.setVisible(true);
		
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem addItem = new JMenuItem("추가");
		addItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student newStudent = new Student(10,"장현서",80,90,70);
				tbl.addItem(newStudent);
			}
		});
		popMenu.add(addItem);
		
		

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student upStd = new Student(2, "이상원", 100, 100, 100);
				tbl.updateRow(upStd,1); //이성경 학생을 이상원으로 바꿈
//				tbl.updateRow();
			}
		});
		popMenu.add(updateItem);
		
		
		
		JMenuItem getSelectedItem = new JMenuItem("선택한 학생확인");
		getSelectedItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student selectedStd = tbl.getSelectedItem();
				JOptionPane.showMessageDialog(null, "선택한 학생은" + selectedStd);
			}
		});
		popMenu.add(getSelectedItem);
		
		

		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						tbl.removeRow();
					}catch (RuntimeException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
			}
		});
		popMenu.add(deleteItem);
		
		tbl.setPopupMenu(popMenu);
	}
}
