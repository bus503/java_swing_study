package java_swing_study.chap10;

import java.awt.Color;
import java.awt.Component;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class MyAction3 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn02 =  (JButton) e.getSource();
		if(e.getSource()== Color.YELLOW) {
			btn02.setBackground(Color.RED);
		}else {
			btn02.setBackground(Color.YELLOW);
		}
	}

}
