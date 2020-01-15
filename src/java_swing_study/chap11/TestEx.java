package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TestEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblTop;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestEx frame = new TestEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TestEx() {
		initialize();
	}
	private void initialize() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		panel = new JPanel();
		contentPane.add(panel);
		
		lblTop = new JLabel("입력 후 <Enter>키를 입력하세요.");
		panel.add(lblTop);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		textField = 
				new JTextField();
		textField.addActionListener(this);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(textField);
		textField.setColumns(20);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == textField) {
			textFieldActionPerformed(e);
		}
	}
	protected void textFieldActionPerformed(ActionEvent e) {
		String p = textField.getText();
//		System.out.println(p);
		textArea.append(p + "\n");
		textField.setText("");
		//이런 식으로 해서 입력받는 값을 textArea로 추가하고 
		//텍스트필드는 다시 리셋시킨다
	}
}
