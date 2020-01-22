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
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StudentFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pContent;
	private StudentTblPanel pList;
	private StudentPanel pStudent;
	private JPanel pBtns;
	private JButton btnAdd;
	private JButton btnCancel;
	private int UpdateIdx;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentFrame() {
		initialize();
		
	
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pContent = new JPanel();
		contentPane.add(pContent);
		pContent.setLayout(new BorderLayout(0, 0));
		
		pStudent = new StudentPanel();
		pContent.add(pStudent, BorderLayout.CENTER);
		
		pBtns = new JPanel();
		contentPane.add(pBtns);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);
		
		pList = new StudentTblPanel();
		pList.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(pList);
		
		
		ArrayList<Student> stds = new ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 90, 70));
		stds.add(new Student(2, "이성경", 90, 90, 40));
		stds.add(new Student(3, "이유영", 50, 50, 60));
		
		pList.loadData(stds);
		pList.setPopupMenu(createPopupMenu());
//		pList.setLayout(new BorderLayout(0, 0));
		
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
				Student	upStd = pList.getSelectedItem();
				
				
				//테이블에서 선택된 놈을 upStd라고 하겠다
				UpdateIdx = pList.getSelectedRowIdx();
				//위에있는 추상클래스에 있는건데 빈칸을 수정하면 창이 뜸
//				System.out.println(UpdateIdx);
				pStudent.setItem(upStd);
				btnAdd.setText("수정");	
				pList.clearSelection();
				//선택한놈을 리셋시킴
			}
			if(e.getActionCommand().equals("삭제")){
					pList.removeRow();
			}
				//그냥 이렇게만 하면 연결된 추상에 빈칸연결하면 창뜨게 하는거 그쪽으로 연결되는데
				//오류가 나오면 더러워보이니까 try 캐치를 쓴다
				//e1겟메시지는 추상에 throw new RuntimeException이놈 메시지가 뜸
				//다르게 하면 2번뜨거나 하니까
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
//	private void btnUpdateActionperformed(ActionEvent e) {
//		Student updateStd = pStudent.getItem();
//		stds.set(stds.indexOf(updateStd), updateStd);
//		
//	}
	
	protected void btnAddActionPerformed(ActionEvent e) {
		Student std = pStudent.getItem();
		if(e.getActionCommand().equals("수정")) {
			pList.updateRow(std,UpdateIdx);
			btnAdd.setText("추가");
		}else {
			pList.addItem(std);
		}
		pStudent.clearTf();
	}
	
	protected void btnCancelActionPerformed(ActionEvent e) {
		pStudent.clearTf();
	}
}
