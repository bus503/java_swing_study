package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java_swing_study.chap11.exam.Student;
import java_swing_study.chap11.exam.StudentPanel;

@SuppressWarnings("serial")
public class StudentListEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private StudentPanel pStudent;
	private JPanel pList;
	private JPanel pBtns;
	private JScrollPane scrollPane;
	private JList<Student> list;
	private ArrayList<Student> stds;
	private JButton btnAdd;
	private JButton btnCancel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentListEx frame = new StudentListEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentListEx() {
		stds = new ArrayList<Student>();
		stds.add(new Student (1,"서현진",90,80,70));
		stds.add(new Student (2,"남궁민",90,90,90));
		stds.add(new Student (3,"손예진",70,40,50));
		
		initialize();
		
		list.setListData(new Vector<>(stds));
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

		scrollPane = new JScrollPane();
		pList.add(scrollPane, BorderLayout.CENTER);

		list = new JList();
		scrollPane.setViewportView(list);

		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);

		list.setComponentPopupMenu(createPopupMenu());
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
				int selIdx = list.getSelectedIndex();
				pStudent.setItem(list.getSelectedValue());
				
				btnAdd.setText("수정");
				stds.remove(selIdx);
				
				
				
				
				
//				System.out.println("수정");
			}
			if (e.getActionCommand().equals("삭제")) {
				//jList에서 선택된 것이 있는지 판단 
				//선택된 번호 또는 인덱스를 가져온 후에
				//arraylist에 일치하는 데이터 삭제
				//Jlist에서 setListData()호출해서 변경된 arraylist를 보여주도록한다
				
				int selIdx = list.getSelectedIndex();
				stds.remove(selIdx);
				list.setListData(new Vector<>(stds));
	
//				System.out.println("selIdx" + selIdx);	
//				System.out.println("삭제");
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
		Student student = pStudent.getItem();
		stds.add(student);
		list.setListData(new Vector<Student>(stds));
//		pStudent.clearTf();
	}

	protected void btnCancelActionPerformed(ActionEvent e) {
		pStudent.clearTf();
	}
}
