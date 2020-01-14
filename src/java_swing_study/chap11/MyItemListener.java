package java_swing_study.chap11;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyItemListener implements ItemListener {
	private int sum = 0;

	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getItem() == "check1") {
				sum += 100;
			} else if (e.getItem() == "check2") {
				sum += 500;
			} else {
				sum += 20000;
			}
		} else {
			if (e.getItem() == "check1") {
				sum -= 100;
			} else if (e.getItem() == "check2") {
				sum -= 500;
			} else {
				sum -= 20000;
			}
		}
		sumLabel.se
	}
}
