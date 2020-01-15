package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class ListEx extends JFrame implements ActionListener, ListSelectionListener {

	private JPanel contentPane;
	private ArrayList<String> listFruits;
//	private ArrayList<String> listImage;
//	private ImageIcon[] images;
	private JPanel p1;
	private JList<String> strList;
	private JPanel pBtns1;
	private JButton btnOk1;
	private JButton btnSet1;
	private JPanel p2;
	private JPanel panel;
	private JButton btnOk2;
	private JButton btnSet2;
	private JScrollPane scrollPane;
	private JList imgList;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListEx frame = new ListEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListEx() {
		loadListData();
//		listImage = new ArrayList<String>();
//		listImage.add("image/icon1.png");
//		listImage.add("image/icon2.png");
//		listImage.add("image/icon3.png");
//		listImage.add("image/icon4.png");

//		ImageIcon[] images = { new ImageIcon("image/icon1.png"), new ImageIcon("image/icon2.png"),
//				new ImageIcon("image/icon3.png"), new ImageIcon("image/icon4.png") };

		/* JList<ImageIcon> imageList = new JList<ImageIcon>(); */
		initialize();

	}

	private void loadListData() {
		listFruits = new ArrayList<String>();
		listFruits.add("apple");
		listFruits.add("bananna");
		listFruits.add("kiwi");
		listFruits.add("mango");
		listFruits.add("pear");
		listFruits.add("peach");
		listFruits.add("berry");
		listFruits.add("strawberry");
		listFruits.add("blackberry");

	}

	private void initialize() {
		setTitle("JList & JCombo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 10, 10));

		p1 = new JPanel();
		p1.setBorder(new TitledBorder(null, "List \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(p1);
		p1.setLayout(new BorderLayout(0, 0));

		strList = new JList(new Vector<>(listFruits));
		strList.addListSelectionListener(this);
		p1.add(strList, BorderLayout.NORTH);

		pBtns1 = new JPanel();
		p1.add(pBtns1, BorderLayout.SOUTH);
		pBtns1.setLayout(new GridLayout(0, 1, 0, 0));

		btnOk1 = new JButton("확인");
		btnOk1.addActionListener(this);
		pBtns1.add(btnOk1);

		btnSet1 = new JButton("선택하기");
		btnSet1.addActionListener(this);
		pBtns1.add(btnSet1);

		p2 = new JPanel();
		p2.setBorder(new TitledBorder(null, "List \uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(p2);
		p2.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		p2.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		btnOk2 = new JButton("확인");
		panel.add(btnOk2);

		btnSet2 = new JButton("선택하기");
		panel.add(btnSet2);

		scrollPane = new JScrollPane();
		p2.add(scrollPane, BorderLayout.CENTER);

		imgList = new JList();
				/*(new Object [] images);*/
		scrollPane.setViewportView(imgList);
		p2.add(imgList, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSet1) {
			btnSet1ActionPerformed(e);
		}
		if (e.getSource() == btnOk1) {
			btnOk1ActionPerformed(e);
		}
	}

	protected void btnOk1ActionPerformed(ActionEvent e) {
		String selectValue = strList.getSelectedValue();
		JOptionPane.showMessageDialog(null, "선택한 과일은?" + selectValue);
	}

	protected void btnSet1ActionPerformed(ActionEvent e) {
		strList.setSelectedIndex(5);
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == strList) {
			strlistValueChanged(e);
		}
	}

	protected void strlistValueChanged(ListSelectionEvent e) {
//		System.out.println(strList.getSelectedIndex() + listFruits.get(strList.getSelectedIndex()));
		JOptionPane.showMessageDialog(null, "선택한 과일은?" + strList.getSelectedValue());
	}
}
