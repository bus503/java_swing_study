package java_swing_study.chap13;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class ThreadTimeEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblTimer;
	private JPanel pBtns;
	private JButton btnStart;
	private JButton btnStop;
	private TimerThread th;
	private GugudanThread guTh;
	private JPanel plbls;
	private JLabel lblRunnableTimer;
	private Thread th2;
	private JPanel panel;
	private FlickeringLabel lblFlickering;
	private JLabel lbl;
	private FlickeringLabel lblNewLabel;

	public ThreadTimeEx() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pBtns = new JPanel();
		contentPane.add(pBtns, BorderLayout.SOUTH);

		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		pBtns.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(this);
		pBtns.add(btnStop);

		plbls = new JPanel();
		contentPane.add(plbls, BorderLayout.CENTER);
		plbls.setLayout(new GridLayout(0, 2, 0, 0));

		lblTimer = new JLabel("");
		lblTimer.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 50));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		plbls.add(lblTimer);

		lblRunnableTimer = new JLabel("");
		lblRunnableTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblRunnableTimer.setOpaque(true);
		lblRunnableTimer.setFont(new Font("굴림", Font.BOLD, 50));
		plbls.add(lblRunnableTimer);

		th = new TimerThread(lblTimer);
		guTh = new GugudanThread();
		TimerRunnable tr  = new TimerRunnable(lblRunnableTimer);
		
		panel = new JPanel();
		plbls.add(panel);
		
		lblFlickering = new FlickeringLabel("깜박",500);
		panel.add(lblFlickering);
		
		lbl = new JLabel("안깜박");
		panel.add(lbl);
		
		lblNewLabel = new FlickeringLabel("여기도 깜박",300);
		panel.add(lblNewLabel);
		th2 = new Thread(tr);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStart) {
			btnStartActionPerformed(e);
		}
		if (e.getSource() == btnStop) {
			btnStopActionPerformed(e);
		}
	}

	protected void btnStopActionPerformed(ActionEvent e) {
		System.out.println(th.getState());
		th.interrupt();
		guTh.interrupt();
		th2.interrupt();
		System.out.println(th.getState());
	}

	protected void btnStartActionPerformed(ActionEvent e) {
//		th = new TimerThread(lblTimer);
		System.out.println(th.getState());
		if (th.getState() == Thread.State.TERMINATED) {
			th = new TimerThread(lblTimer);
		}
		if (guTh.getState() == Thread.State.TERMINATED) {
			guTh = new GugudanThread();
		}
		if (th2.getState() == Thread.State.TERMINATED) {
			th2 = new Thread(new TimerRunnable(lblRunnableTimer));
		}
		guTh.start();
		th.start();
		th2.start();
	}
}
