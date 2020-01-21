package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import java_swing_study.chap11.exam.Student;
import java_swing_study.chap11.exam.StudentPanel;
import java_swing_study.chap11.exam.StudentTblPanel_원본;

@SuppressWarnings("serial")
public class StudentTableEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentPanel pStudent;
	private JPanel pList;
	private JPanel pBtns;
	private ArrayList<Student> stds;
	private JButton btnAdd;
	private JButton btnCancel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTableEx frame = new StudentTableEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentTableEx() {
//		stds = new ArrayList<Student>();
//		stds.add(new Student (1,"서현진",90,80,70));
//		stds.add(new Student (2,"남궁민",90,90,90));
//		stds.add(new Student (3,"손예진",70,40,50));

		initialize();
	}

	private void initialize() {
		setTitle("학생 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pStudent = new StudentPanel();
		contentPane.add(pStudent, BorderLayout.NORTH);

		pList = new JPanel();
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new BorderLayout(0, 0));
		//모프시켰을때 이게 이렇게 되어있으면 안보임
		//그래서 새로 패널추가해서 모프시킴
		
		pStdTbl = new StudentTblPanel_원본();
		pList.add(pStdTbl, BorderLayout.CENTER);
		

		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
	
		
		loadData();
	}


	private void loadData() {
	}

	private Object[][] getRows() {
		Object[][] rows = new Object[stds.size()][];
		//row가 3개인 2차원배열 생성
		for(int i =0; i<rows.length; i++) {
			rows[i] = toArray(stds.get(i));
		}//한명의 정보를 반복문으로 한명씩 넣어줌
		
		return rows;
	}

	private Object[] toArray(Student std) {
		
		return new Object[] {std.getStdNo(), std.getStdName(), std.getKor(), std.getEng(), std.getMath(), std.total(), (String.format("%.1f",std.avg()))};
	}
	

	private String[] getColumnNames() {
		return new String[] {"학생번호", "학생명", "국어", "영어", "수학", "총점", "평균"};
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(myPopMenuListener);
		popMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(myPopMenuListener);
		popMenu.add(deleteItem);

		return popMenu;

	}

	ActionListener myPopMenuListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("수정")) {
				//jList에서 선택된것이 있는지 보고
				//선택된 인덱스를 다시 텍스트필드창에 한개씩 올림
				//그러고 버튼이 수정으로 바뀌고
				//올라온 값들 중 수정해서 수정버튼 누르면 다시 수정되는거임
//				int selIdx = list.getSelectedIndex();
//				pStudent.setItem(list.getSelectedValue());
//				
//				btnAdd.setText("수정");
//				stds.remove(selIdx);
				
				
//				System.out.println("수정");
			}
			if (e.getActionCommand().equals("삭제")) {
				//jList에서 선택된 것이 있는지 판단 
				//선택된 번호 또는 인덱스를 가져온 후에
				//arraylist에 일치하는 데이터 삭제
				//Jlist에서 setListData()호출해서 변경된 arraylist를 보여주도록한다
				
//				int selIdx = list.getSelectedIndex();
//				stds.remove(selIdx);
//				list.setListData(new Vector<>(stds));
	
//				System.out.println("selIdx" + selIdx);	
//				System.out.println("삭제");
			}
		}
	};
	private StudentTblPanel_원본 pStdTbl;

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
	}

	protected void btnAddActionPerformed(ActionEvent e) {
//		Student student = pStudent.getItem();
//		stds.add(student);
//		list.setListData(new Vector<Student>(stds));
//		pStudent.clearTf();
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		pStudent.clearTf();
	}
}
