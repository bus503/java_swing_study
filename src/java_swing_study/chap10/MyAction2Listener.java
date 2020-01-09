package java_swing_study.chap10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MyAction2Listener implements ActionListener {
//액션이 발생하면 myAction2가 처리하겠다
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=null;
		if(e.getSource() instanceof JButton) {
			btn = (JButton) e.getSource();
		}
		
		JOptionPane.showMessageDialog(null, btn.getText());
	}
}
