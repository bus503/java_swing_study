package java_swing_study.chap13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyLabel_0129 extends JLabel {
	private int barSize = 0;
	private int maxBarSize;
	
	
	public MyLabel_0129(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width = (int)(((double)(this.getWidth()))/maxBarSize*barSize);

		if(width==0) {
			return;
		}
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized public void fill() {
		if(barSize ==maxBarSize) {
			try {
				wait();
			}catch (InterruptedException e) {
				return;
			}
		}
		barSize++;
		System.out.println(barSize);
		repaint();
		notify();
	}
	
	synchronized public void consume() {
		if(barSize ==0) {
			try {
				wait();
			}catch (InterruptedException e) {
				return;
			}
		}
		barSize--;
		System.out.println(barSize);
		repaint();
		notify();
	}
	
	
	
}
