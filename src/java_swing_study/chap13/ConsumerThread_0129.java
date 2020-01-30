package java_swing_study.chap13;

public class ConsumerThread_0129 extends Thread {
	private MyLabel_0129 bar;

	public ConsumerThread_0129(MyLabel_0129 bar) {
		this.bar = bar;
	}

	@Override
	public void run() {
		while(true){
			try {
				sleep(500);
				bar.consume();
			}catch (InterruptedException e) {
				return;
			}
		}
		
	}
}
