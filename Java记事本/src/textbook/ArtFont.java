package textbook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ArtFont extends JFrame implements ListSelectionListener,
		ActionListener, ItemListener
{
	private JPanel panel1;
	private JButton button_ok, button_cancel, button_default;
	private JLabel label_1, label_2, label_3, label_4;
	private JComboBox comboBox;
	private JTextField textField_1, textField_2, textField_3;
	TextBook t;
	private JList list_1, list_2;
	private JScrollPane scrollPane_1, scrollPane_2;

	int fontType = 0;
	int size = 12;

	public ArtFont()
	{
		init();
		this.setTitle("字体");
		this.setResizable(false);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
	}

	public void init()
	{
		button_ok = new JButton("确定");
		button_ok.setBounds(10, 240, 60, 20);
		button_ok.addActionListener(this);
		button_cancel = new JButton("取消");
		button_cancel.setBounds(80, 240, 60, 20);
		button_cancel.addActionListener(this);
		button_default = new JButton("默认");
		button_default.setBounds(370, 240, 60, 20);
		button_default.addActionListener(this);

		add(button_ok);
		add(button_cancel);
		add(button_default);

		panel1 = new JPanel();
		panel1.setLayout(null);
		add(panel1);

		label_1 = new JLabel("字体(T):");
		label_1.setBounds(20, 25, 70, 15);
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames=ge.getAvailableFontFamilyNames();
		comboBox = new JComboBox(fontNames);
		comboBox.setEditable(false);
		comboBox.setMaximumRowCount(5);
		comboBox.setBounds(20, 43, 200, 20);
		comboBox.addItemListener(this);
		panel1.add(comboBox);
		panel1.add(label_1);

		label_2 = new JLabel("字形(Y):");
		label_2.setBounds(230, 25, 70, 15);

		textField_1 = new JTextField();
		textField_1.setBounds(230, 43, 100, 20);
		String[] boldanditlic =	{ "加粗", "斜体", "默认", "粗斜体" };
		list_1 = new JList(boldanditlic);
		list_1.addListSelectionListener(this);
		scrollPane_1 = new JScrollPane(list_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(230, 64, 100, 80);
		panel1.add(scrollPane_1);
		panel1.add(textField_1);
		panel1.add(label_2);

		label_3 = new JLabel("字号(S):");
		label_3.setBounds(340, 20, 70, 20);
		textField_2 = new JTextField();
		textField_2.setBounds(340, 43, 70, 20);
		String[] fontSize =	{ "五号", "四号", "三号", "二号", };
		list_2 = new JList(fontSize);
		list_2.addListSelectionListener(this);
		scrollPane_2 = new JScrollPane(list_2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(340, 64, 70, 80);
		panel1.add(scrollPane_2);
		panel1.add(textField_2);
		panel1.add(label_3);

		label_4 = new JLabel("预览");

		label_4.setBounds(20, 160, 70, 15);
		panel1.add(label_4);

		textField_3 = new JTextField("______      微软科技 ABC       ________");
		textField_3.setHorizontalAlignment(JTextField.CENTER);//字体居中
		
		textField_3.setLocation(20, 180);//textField_3的位置
		textField_3.setSize(400,30);
		panel1.add(textField_3);
	}

	public static void main(String[] args)
	{
		try {
			String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			UIManager.setLookAndFeel(lookAndFeel);
			}catch(Exception e) { }
		new ArtFont().setVisible(true);
	}

	public void valueChanged(ListSelectionEvent e)
	{
		textField_1.setText((String) list_1.getSelectedValue());
		textField_2.setText((String) list_2.getSelectedValue());
		String Type = null;

		if (e.getSource() == list_1)
		{
			if (textField_1.getText().equals("默认"))
			{
				fontType = 0;
			}
			if (textField_1.getText().equals("加粗"))
			{
				fontType = 1;
			}
			if (textField_1.getText().equals("斜体"))
			{
				fontType = 2;
			}
			if (textField_1.getText().equals("粗斜体"))
			{
				fontType = 3;
			}
		}
		else if (e.getSource() == list_2)
		{
			if (textField_2.getText().equals("五号"))
			{
				size = 12;
			}
			if (textField_2.getText().equals("四号"))
			{
				size = 14;
			}
			if (textField_2.getText().equals("三号"))
			{
				size = 16;
			}
			if (textField_2.getText().equals("二号"))
			{
				size = 18;
			}
		}
		textField_3.setFont(new Font(Type, fontType, size));
	}

	
	public void itemStateChanged(ItemEvent e)
	{
		String Type;
		if (e.getSource() == comboBox)
		{
			Type = comboBox.getSelectedItem().toString();
			textField_3.setFont(new Font(Type, fontType, size));
		}

	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == button_ok)
		{
			String Type = comboBox.getSelectedItem().toString();
			t.getJta().setFont(new Font(Type, fontType, size));
			this.setVisible(false);
		}
		else if (e.getSource() == button_default)
		{
			t.getJta().setFont(new Font("宋体", Font.BOLD, 12));
			this.setVisible(false);
		}
		else if (e.getSource() == button_cancel)
		{
			this.setVisible(false);
		}
	}
	
	public TextBook getText()
	{
		return t;
	}
	public void setText(TextBook t)
	{
		this.t = t;
	}
}