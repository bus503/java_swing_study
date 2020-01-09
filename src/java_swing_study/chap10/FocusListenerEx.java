package java_swing_study.chap10;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FocusListenerEx extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblNo;
	private JTextField tfNo;
	private JLabel lblDept;
	private JTextField tfDept;
	private JLabel lblSubj;
	private JTextField tfSubj;
	private JLabel lblRes;
	private JPasswordField pw1;
	private JPasswordField pw2;
	private JLabel lblconfom;
	private JButton btnOk;
	private JButton btnCancel;
	Student str;
	public FocusListenerEx() {
		initialize();
	}
	private void initialize() {
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 200); // 좌표와 사이즈를 합친거
//		setSize(300, 200); // 사이즈
//		setLocation(100, 100); //좌표
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 5));
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				msg();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				msg();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				msg();
			}
			
			public void msg() {
				lblRes.setText(String.format(" %s 길이 : %d", tfName.getText() , tfName.getText().length()));

			}
		});
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		lblNo = new JLabel("학번");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(tfName.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요");
				}
			}
		});
		tfNo.setColumns(10);
		contentPane.add(tfNo);
		
		lblDept = new JLabel("학과");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDept);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		contentPane.add(tfDept);
		
		lblSubj = new JLabel("과목");
		lblSubj.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblSubj);
		
		tfSubj = new JTextField();
		tfSubj.setFocusable(true);
		tfSubj.requestFocus();
		tfSubj.setColumns(10);
		contentPane.add(tfSubj);
		
		tfSubj.setRequestFocusEnabled(true);
		
		
		lblRes = new JLabel("이름필드 글자수");
		contentPane.add(lblRes);
		
		lblconfom = new JLabel("");
		lblconfom.setHorizontalAlignment(SwingConstants.CENTER);
		lblconfom.setFont(new Font("굴림", Font.BOLD, 18));
		lblconfom.setForeground(Color.RED);
		contentPane.add(lblconfom);
		
		pw1 = new JPasswordField();
		pw1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				rensyu();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				rensyu();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				rensyu();
			}
			
			private void rensyu() {
				String pass2 = new String(pw2.getPassword());
				String pass1 = new String(pw1.getPassword());
				
				System.out.printf("pw2 = %s  pw1 = %s%n", pass2, pass1);
				
				if(pass2.equals(pass1)) {
					lblconfom.setText("일치");
				}else {
					lblconfom.setText("불일치");
				}
			}

		});
		contentPane.add(pw1);
		
		
		pw2 = new JPasswordField();
		pw2.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				isEqualpw();
			}
		

			@Override
			public void insertUpdate(DocumentEvent e) {
				isEqualpw();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				isEqualpw();
			}
			
			private void isEqualpw() {
				
				String pass1 = new String(pw1.getPassword());
				String pass2 = new String(pw2.getPassword());
				
				System.out.printf("pw1 = %s  pw2 = %s%n", pass1, pass2);
				
				if(pass1.equals(pass2)) {
					lblconfom.setText("일치");
				}else {
					lblconfom.setText("불일치");
				}
			}
		});
		contentPane.add(pw2);
		
		btnOk = new JButton("확인");
		btnOk.addActionListener(this);
		JOptionPane.showMessageDialog(null, btnOk.getText()); 
		contentPane.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
	}
	
	
	public JTextField getTfSubj() {
		return tfSubj;
	}
	
	public static void main(String[] args) {
		FocusListenerEx frame = new FocusListenerEx();
		frame.setVisible(true);
		
//		frame.getTfSubj().setFocusable(true);
		frame.getTfSubj().requestFocus();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
	}
	protected void btnOkActionPerformed(ActionEvent e) {
		Student st = new Student();
		st.setName(tfName.getText());
		st.setStdNo(Integer.parseInt(tfNo.getText()));
		st.setDept(tfDept.getText());
		st.setSubj(tfSubj.getText());
		
		
		JOptionPane.showMessageDialog(null, st.toString());
		
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		Student st = new Student();
		st.setName(tfName.getText());
		st.setStdNo(Integer.parseInt(tfNo.getText()));
		st.setDept(tfDept.getText());
		st.setSubj(tfSubj.getText());
		
		
	}
}
