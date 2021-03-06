package java_swing_study.chap11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Slider_SpinnerEx extends JFrame implements ChangeListener, ActionListener {

	private JPanel contentPane;
	private JPanel pSlider1;
	private JPanel pSlider2;
	private JPanel pSpinner1;
	private JPanel pSpinner2;
	private JSlider slider1;
	private JLabel lblValue1;
	private JSlider sliderRed;
	private JSlider sliderGreen;
	private JSlider sliderBlue;
	private JLabel lblValue2;
	private JPanel panel;
	private JLabel lblRed;
	private JTextField tfRed;
	private JLabel lblGreen;
	private JTextField tfGreen;
	private JLabel lblBlue;
	private JTextField tfBlue;
	private JButton btnOk;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JSpinner spList;
	private JLabel lblList;
	private JSpinner spNumber;
	private JLabel lblNumber;
	private JSpinner spDate;
	private JLabel lblDate;
	private JButton btnNewButton;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slider_SpinnerEx frame = new Slider_SpinnerEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Slider_SpinnerEx() {
		initialize();
	}
	private void initialize() {
		setTitle("Slider / JSpinner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		
		pSlider1 = new JPanel();
		pSlider1.setBorder(new TitledBorder(null, "\uC608\uC81C 11-14", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSlider1);
		pSlider1.setLayout(new GridLayout(0, 1, 0, 0));
		
		slider1 = new JSlider();
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setMinorTickSpacing(10);
		slider1.setMajorTickSpacing(50);
		slider1.setMaximum(200);
		pSlider1.add(slider1);
		
		lblValue1 = new JLabel("0");
		lblValue1.setFont(new Font("굴림", Font.BOLD, 15));
		lblValue1.setForeground(Color.BLUE);
		lblValue1.setHorizontalAlignment(SwingConstants.CENTER);
		pSlider1.add(lblValue1);
		
		pSlider2 = new JPanel();
		pSlider2.setBorder(new TitledBorder(null, "\uC608\uC81C 11-15", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSlider2);
		pSlider2.setLayout(new GridLayout(0, 1, 3, 0));
		
		panel = new JPanel();
		pSlider2.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblRed = new JLabel("Red");
		lblRed.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRed);
		
		tfRed = new JTextField();
		tfRed.addActionListener(this);
		tfRed.setColumns(10);
		tfRed.setText(" ");
		panel.add(tfRed);
		
		lblGreen = new JLabel("Green");
		lblGreen.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGreen);
		
		tfGreen = new JTextField();
		tfGreen.setColumns(10);
		panel.add(tfGreen);
		
		lblBlue = new JLabel("Blue");
		lblBlue.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblBlue);
		
		tfBlue = new JTextField();
		tfBlue.setColumns(10);
		panel.add(tfBlue);
		
		btnOk = new JButton("적용");
		btnOk.addActionListener(this);
		panel.add(btnOk);
		
		sliderRed = new JSlider();
		sliderRed.setMinorTickSpacing(10);
		sliderRed.setPaintTicks(true);
		sliderRed.setPaintLabels(true);
		sliderRed.setMaximum(250);
		sliderRed.setMajorTickSpacing(50);
		sliderRed.setForeground(Color.RED);
		pSlider2.add(sliderRed);
		
		sliderGreen = new JSlider();
		sliderGreen.setMinorTickSpacing(10);
		sliderGreen.setMajorTickSpacing(50);
		sliderGreen.setMaximum(250);
		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);
		sliderGreen.setForeground(Color.GREEN);
		pSlider2.add(sliderGreen);
		
		sliderBlue = new JSlider();
		sliderBlue.setMinorTickSpacing(10);
		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);
		sliderBlue.setMaximum(250);
		sliderBlue.setMajorTickSpacing(50);
		sliderBlue.setForeground(Color.BLUE);
		pSlider2.add(sliderBlue);
		
		lblValue2 = new JLabel("SLIDER EXAMPLE");
		lblValue2.setForeground(Color.GRAY);
		lblValue2.setFont(new Font("굴림", Font.BOLD, 18));
		lblValue2.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue2.setBackground(Color.ORANGE);
		lblValue2.setOpaque(true);
		pSlider2.add(lblValue2);
		
		pSpinner1 = new JPanel();
		pSpinner1.setBorder(new TitledBorder(null, "JSpinner \uC608\uC81C1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSpinner1);
		pSpinner1.setLayout(new GridLayout(0, 1, 0, 20));
		
		panel_1 = new JPanel();
		pSpinner1.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		spList = new JSpinner();
		spList.setModel(new SpinnerListModel(new String[] {"\uC18C\uC124", "\uC7A1\uC9C0", "\uC804\uACF5\uC11C\uC801", "\uCDE8\uBBF8"}));
		panel_1.add(spList);
		
		lblList = new JLabel("List");
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setForeground(Color.RED);
		lblList.setFont(new Font("굴림", Font.ITALIC, 35));
		panel_1.add(lblList);
		
		panel_2 = new JPanel();
		pSpinner1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		spNumber = new JSpinner();
		spNumber.setModel(new SpinnerNumberModel(0, -10, 10, 1));
		panel_2.add(spNumber);
		
		lblNumber = new JLabel("Number");
		lblNumber.setToolTipText("");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setForeground(Color.ORANGE);
		lblNumber.setFont(new Font("굴림", Font.BOLD, 35));
		panel_2.add(lblNumber);
		
		panel_3 = new JPanel();
		pSpinner1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		spDate = new JSpinner();
		spDate.setModel(new SpinnerDateModel(new Date(1579186800000L), new Date(1579186800000L), new Date(1989500400000L), Calendar.YEAR));
		panel_3.add(spDate);
		
		lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblDate.setForeground(Color.MAGENTA);
		panel_3.add(lblDate);
		
		pSpinner2 = new JPanel();
		pSpinner2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC2A4\uC719 \uD398\uC778\uD305 \uBA54\uCEE4\uB2C8\uC998", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pSpinner2);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		pSpinner2.add(btnNewButton);
		
		slider1.addChangeListener(this);
		slider1.setValue(100);
		
		sliderRed.addChangeListener(this);
		sliderRed.setValue(0);
		sliderGreen.addChangeListener(this);
		sliderGreen.setValue(0);
		sliderBlue.addChangeListener(this);
		sliderBlue.setValue(0);
		
		spList.addChangeListener(this);
		spNumber.addChangeListener(this);
		spDate.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == spDate) {
			spDateStateChanged(e);
		}
		if (e.getSource() == spNumber) {
			spNumberStateChanged(e);
		}
		if (e.getSource() == spList) {
			spListStateChanged(e);
		}
		if (e.getSource() == sliderBlue) {
			sliderBlueStateChanged(e);
		}
		if (e.getSource() == sliderGreen) {
			sliderGreenStateChanged(e);
		}
		if (e.getSource() == sliderRed) {
			sliderRedStateChanged(e);
		}
		if (e.getSource() == slider1) {
			slider1StateChanged(e);
		}
	}
	protected void slider1StateChanged(ChangeEvent e) {
//		slider1.get
		
//		System.out.println("눈금값" + slider1.getValue());
		
		lblValue1.setText(slider1.getValue()+"");//문자열로 만들어줌
		
	}
	protected void sliderRedStateChanged(ChangeEvent e) {
		int r = sliderRed.getValue();
		int g = sliderGreen.getValue();
		int b = sliderBlue.getValue();
		lblValue2.setBackground(new Color(r,g,b));
		tfRed.setText(sliderRed.getValue()+"");
		
		
	}
	protected void sliderGreenStateChanged(ChangeEvent e) {
		int r = sliderRed.getValue();
		int g = sliderGreen.getValue();
		int b = sliderBlue.getValue();
		lblValue2.setBackground(new Color(r,g,b));
		tfGreen.setText(sliderGreen.getValue()+"");
		
	}
	protected void sliderBlueStateChanged(ChangeEvent e) {
		int r = sliderRed.getValue();
		int g = sliderGreen.getValue();
		int b = sliderBlue.getValue();
		lblValue2.setBackground(new Color(r,g,b));
		tfBlue.setText(sliderBlue.getValue()+"");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			btnNewButtonActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
		if (e.getSource() == tfRed) {
			tfRedActionPerformed(e);
		}
	}
	protected void tfRedActionPerformed(ActionEvent e) {
	}
	protected void btnOkActionPerformed(ActionEvent e) {
//		String a = tfRed.getText();
//		String b = tfGreen.getText()
//		tfBlue.getText()
		sliderRed.setValue(Integer.parseInt(tfRed.getText()));
		sliderGreen.setValue(Integer.parseInt(tfGreen.getText()));
		sliderBlue.setValue(Integer.parseInt(tfBlue.getText()));
	}
	protected void spListStateChanged(ChangeEvent e) {
		lblList.setText(spList.getValue() + "");
	}
	protected void spNumberStateChanged(ChangeEvent e) {
		lblNumber.setText(spNumber.getValue()+ "");
	}
	protected void spDateStateChanged(ChangeEvent e) {
//		Date date = new Date();
		lblDate.setText(spDate.getValue() + "");
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		System.out.println(contentPane.getComponentCount());
		contentPane.remove(pSlider1);
		System.out.println(contentPane.getComponentCount());
		revalidate();
		repaint();
		
		JLabel lblTest = new JLabel("텍스트");
		contentPane.add(lblTest);
		System.out.println(contentPane.getComponentCount());
		revalidate();
		repaint();
	}
}
