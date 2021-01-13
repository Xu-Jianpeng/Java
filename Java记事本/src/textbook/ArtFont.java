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
		this.setTitle("����");
		this.setResizable(false);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
	}

	public void init()
	{
		button_ok = new JButton("ȷ��");
		button_ok.setBounds(10, 240, 60, 20);
		button_ok.addActionListener(this);
		button_cancel = new JButton("ȡ��");
		button_cancel.setBounds(80, 240, 60, 20);
		button_cancel.addActionListener(this);
		button_default = new JButton("Ĭ��");
		button_default.setBounds(370, 240, 60, 20);
		button_default.addActionListener(this);

		add(button_ok);
		add(button_cancel);
		add(button_default);

		panel1 = new JPanel();
		panel1.setLayout(null);
		add(panel1);

		label_1 = new JLabel("����(T):");
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

		label_2 = new JLabel("����(Y):");
		label_2.setBounds(230, 25, 70, 15);

		textField_1 = new JTextField();
		textField_1.setBounds(230, 43, 100, 20);
		String[] boldanditlic =	{ "�Ӵ�", "б��", "Ĭ��", "��б��" };
		list_1 = new JList(boldanditlic);
		list_1.addListSelectionListener(this);
		scrollPane_1 = new JScrollPane(list_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(230, 64, 100, 80);
		panel1.add(scrollPane_1);
		panel1.add(textField_1);
		panel1.add(label_2);

		label_3 = new JLabel("�ֺ�(S):");
		label_3.setBounds(340, 20, 70, 20);
		textField_2 = new JTextField();
		textField_2.setBounds(340, 43, 70, 20);
		String[] fontSize =	{ "���", "�ĺ�", "����", "����", };
		list_2 = new JList(fontSize);
		list_2.addListSelectionListener(this);
		scrollPane_2 = new JScrollPane(list_2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(340, 64, 70, 80);
		panel1.add(scrollPane_2);
		panel1.add(textField_2);
		panel1.add(label_3);

		label_4 = new JLabel("Ԥ��");

		label_4.setBounds(20, 160, 70, 15);
		panel1.add(label_4);

		textField_3 = new JTextField("______      ΢��Ƽ� ABC       ________");
		textField_3.setHorizontalAlignment(JTextField.CENTER);//�������
		
		textField_3.setLocation(20, 180);//textField_3��λ��
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
			if (textField_1.getText().equals("Ĭ��"))
			{
				fontType = 0;
			}
			if (textField_1.getText().equals("�Ӵ�"))
			{
				fontType = 1;
			}
			if (textField_1.getText().equals("б��"))
			{
				fontType = 2;
			}
			if (textField_1.getText().equals("��б��"))
			{
				fontType = 3;
			}
		}
		else if (e.getSource() == list_2)
		{
			if (textField_2.getText().equals("���"))
			{
				size = 12;
			}
			if (textField_2.getText().equals("�ĺ�"))
			{
				size = 14;
			}
			if (textField_2.getText().equals("����"))
			{
				size = 16;
			}
			if (textField_2.getText().equals("����"))
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
			t.getJta().setFont(new Font("����", Font.BOLD, 12));
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