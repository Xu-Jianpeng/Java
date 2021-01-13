/**
 * �������ú͸�ʽ��ʽ��ѡ��
 * �����ʵ��  
 * 
 */
package notebook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TestFileStyle extends JFrame implements ListSelectionListener,
		ActionListener, ItemListener
{
	// ����������--------
	private JTabbedPane jtbp;
	private JPanel panel1, panel2, panel3;
	private JButton jb_ok, jb_qx, jb_sz;
	private JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jl11,
			jl12;
	private JComboBox jcb1, jcb2, jcb3, jcb4, jcb5, jcb6;
	private JTextField jtf1, jtf2, jt3;
	private JCheckBox jc1, jc2, jc3, jc4, jc5, jc6, jc7, jc8, jc9, jc10, jc11;
	RestBen r;
	private JList jlist1, jlist2;
	private JScrollPane jsc1, jsc2;

	int fontType = 0;
	int size = 12;
	// �ַ����������--------
	private JLabel jlz1, jlz2, jlz3, jlz4, jlz5, jlz6, jlz7;
	private JComboBox jcbz1, jcbz2, jcbz3;
	private JSpinner jspz1, jspz2, jspz3;
	private JTextField jtf1z;
	private JCheckBox jcz1, jcz2;
	private Container jta;

	public TestFileStyle()
	{

		init();
		this.setTitle("����");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 460);
	}

	public void init()
	{
		//r = new RestBen();

		jb_ok = new JButton("ȷ��");
		jb_ok.setBounds(370, 410, 60, 20);
		jb_ok.addActionListener(this);
		jb_qx = new JButton("ȡ��");
		jb_qx.setBounds(300, 410, 60, 20);
		jb_qx.addActionListener(this);
		jb_sz = new JButton("Ĭ��");
		jb_sz.setBounds(10, 410, 60, 20);
		jb_sz.addActionListener(this);

		add(jb_ok);
		add(jb_qx);
		add(jb_sz);

		jtbp = new JTabbedPane();
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel3 = new JPanel();
		panel3.setBounds(20, 185, 420, 60);
		panel1.add(panel3);
		jtbp.add("����", panel1);
		jtbp.add("�ַ����", panel2);

		add(jtbp);

		jl1 = new JLabel("��������(T):");
		jl1.setBounds(20, 25, 70, 15);
		String[] s =
		{ "���ı���", "��������", "Arial Unicode MS", "Batang", "BatangChe", "����ϸ��",
				"������κ", "������", "΢���ź�" };
		jcb1 = new JComboBox(s);
		jcb1.setBounds(20, 43, 200, 20);
		jcb1.addItemListener(this);
		panel1.add(jcb1);
		panel1.add(jl1);
		jl12 = new JLabel("��������(F):");
		jl12.setBounds(20, 66, 70, 15);

		String[] s1 =
		{ "BatangChe", "Dotum", "DotumChe", "GulimChe", "MS Gothic", "Bell MT",
				"Imprint MT Shadow" };
		jcb2 = new JComboBox(s1);
		jcb2.setBounds(20, 84, 200, 20);
		jcb2.addItemListener(this);
		panel1.add(jcb2);
		panel1.add(jl12);

		jl2 = new JLabel("����(Y):");
		jl2.setBounds(230, 25, 70, 15);

		jtf1 = new JTextField();
		jtf1.setBounds(230, 43, 100, 20);
		String[] ss =
		{ "�Ӵ�", "б��", "Ĭ��", "��б��" };
		jlist1 = new JList(ss);
		jlist1.addListSelectionListener(this);
		jsc1 = new JScrollPane(jlist1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsc1.setBounds(230, 64, 100, 40);
		panel1.add(jsc1);
		panel1.add(jtf1);
		panel1.add(jl2);

		jl3 = new JLabel("�ֺ�(S):");
		jl3.setBounds(340, 20, 70, 20);
		jtf2 = new JTextField();
		jtf2.setBounds(340, 43, 70, 20);
		String[] ss1 =
		{ "���", "�ĺ�", "����", "����", };
		jlist2 = new JList(ss1);
		jlist2.addListSelectionListener(this);
		jsc2 = new JScrollPane(jlist2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsc2.setBounds(340, 64, 70, 40);
		panel1.add(jsc2);
		panel1.add(jtf2);
		panel1.add(jl3);

		jl4 = new JLabel("��������");
		jl4.setBounds(12, 108, 70, 15);
		panel1.add(jl4);

		jl5 = new JLabel("������ɫ(C):");
		jl5.setBounds(20, 125, 85, 15);
		jcb3 = new JComboBox();
		jcb3.setBounds(20, 142, 85, 20);
		panel1.add(jcb3);
		panel1.add(jl5);

		jl6 = new JLabel("�»�������(U):");
		jl6.setBounds(120, 125, 85, 15);
		jcb4 = new JComboBox();
		jcb4.setBounds(120, 142, 100, 20);
		panel1.add(jcb4);
		panel1.add(jl6);

		jl7 = new JLabel("�»�����ɫ(I):");
		jl7.setBounds(230, 125, 100, 15);
		jcb5 = new JComboBox();
		jcb5.setBounds(230, 142, 100, 20);
		panel1.add(jcb5);
		panel1.add(jl7);

		jl8 = new JLabel("���غ�(*):");
		jl8.setBounds(340, 125, 85, 15);
		jcb6 = new JComboBox();
		jcb6.setBounds(340, 142, 70, 20);
		panel1.add(jcb6);
		panel1.add(jl8);

		jl9 = new JLabel("Ч��");
		jl9.setBounds(12, 165, 70, 15);
		panel1.add(jl9);
		jc1 = new JCheckBox("ɾ����(C)");
		jc2 = new JCheckBox("��Ӱ");
		jc3 = new JCheckBox("С�ʹ�д��ĸ");
		jc4 = new JCheckBox("˫ɾ����");
		jc5 = new JCheckBox("����");
		jc6 = new JCheckBox("ȫ����д��ĸ");
		jc7 = new JCheckBox("�ϱ�");
		jc8 = new JCheckBox("����");
		jc9 = new JCheckBox("����");
		jc10 = new JCheckBox("�±�");
		jc11 = new JCheckBox("����");
		panel3.setLayout(new GridLayout(4, 3));
		panel3.add(jc1);
		panel3.add(jc2);
		panel3.add(jc3);
		panel3.add(jc4);
		panel3.add(jc5);
		panel3.add(jc6);
		panel3.add(jc7);
		panel3.add(jc8);
		panel3.add(jc9);
		panel3.add(jc10);
		panel3.add(jc11);

		jl10 = new JLabel("Ԥ��");

		jl10.setBounds(20, 250, 70, 15);
		panel1.add(jl10);

		jl11 = new JLabel("���������������ĵ����壬����ʹ�����������ʽ");
		Font font = new Font(jcb1.getName(), 1, 12);
		jl11.setBounds(20, 310, 300, 15);

		jt3 = new JTextField(
				"___________      ΢��Ƽ� ABC         _____________________________");
		jt3.setBounds(20, 268, 400, 40);
		jt3.setHorizontalAlignment(JTextField.CENTER);//�������

		panel1.add(jt3);
		panel1.add(jl11);

		// �ַ�������������---------------
		jlz1 = new JLabel("����:");
		jlz1.setBounds(12, 10, 70, 20);

		String[] s2 =
		{ "10%", "20%", "30%", "40%", "50%", "60%", "70%", "80%", "90%",
				"100%", "200%" };
		jcbz1 = new JComboBox(s2);
		jcbz1.setBounds(65, 10, 150, 20);
		panel2.add(jcbz1);
		panel2.add(jlz1);

		jlz2 = new JLabel("���:");
		jlz2.setBounds(12, 35, 70, 20);

		String[] s3 =
		{ "��׼", "�ӿ�", "����" };
		jcbz2 = new JComboBox(s3);
		jcbz2.setBounds(65, 35, 150, 20);
		panel2.add(jcbz2);
		panel2.add(jlz2);

		jlz3 = new JLabel("��ֵ:(B)");
		jlz3.setBounds(220, 35, 100, 20);
		jspz1 = new JSpinner();
		jspz1.setBounds(270, 35, 100, 20);
		panel2.add(jspz1);
		panel2.add(jlz3);

		jlz4 = new JLabel("λ��:(D)");
		jlz4.setBounds(12, 60, 100, 20);
		String[] s4 =
		{ "��׼", "����", "����" };
		jcbz2 = new JComboBox(s4);

		jcbz2.setBounds(65, 60, 70, 20);
		panel2.add(jlz4);
		panel2.add(jcbz2);

		jlz5 = new JLabel("��ֵ:(Y)");
		jlz5.setBounds(220, 60, 100, 20);
		jspz3 = new JSpinner();
		jspz3.setBounds(270, 60, 100, 20);
		panel2.add(jspz3);
		panel2.add(jlz5);
		jcz1 = new JCheckBox("Ϊ��������ּ��(K):");
		jcz1.setBounds(20, 85, 160, 20);
		panel2.add(jcz1);
		jspz3 = new JSpinner();
		jspz3.setBounds(180, 85, 70, 20);
		panel2.add(jspz3);

		jcz2 = new JCheckBox("����������ĵ���������뵽����");
		jcz2.setBounds(20, 110, 300, 20);
		panel2.add(jcz2);

		jlz6 = new JLabel("�������(O)");
		jlz6.setBounds(260, 85, 100, 20);
		panel2.add(jlz6);

		jl7 = new JLabel("Ԥ��");
		jl7.setBounds(20, 250, 70, 15);
		panel2.add(jl7);

		jl7 = new JLabel("���������������ĵ����壬����ʹ�����������ʽ");
		jl7.setBounds(20, 310, 300, 15);
		jtf1z = new JTextField(
				"_________________           ΢��Ƽ� ABC           _____________________________");
		jtf1z.setBounds(20, 268, 400, 40);

		panel2.add(jtf1z);
		panel2.add(jl7);

	}

	public static void main(String[] args)
	{
		new TestFileStyle().setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{

		jtf1.setText((String) jlist1.getSelectedValue());
		jtf2.setText((String) jlist2.getSelectedValue());
		String Type = null;

		if (e.getSource() == jlist1)
		{
			if (jtf1.getText().equals("Ĭ��"))
			{
				fontType = 0;
			}
			if (jtf1.getText().equals("�Ӵ�"))
			{
				fontType = 1;
			}
			if (jtf1.getText().equals("б��"))
			{
				fontType = 2;
			}
			if (jtf1.getText().equals("��б��"))
			{
				fontType = 3;
			}

		}

		else if (e.getSource() == jlist2)
		{
			if (jtf2.getText().equals("���"))
			{
				size = 12;
			}
			if (jtf2.getText().equals("�ĺ�"))
			{
				size = 14;
			}
			if (jtf2.getText().equals("����"))
			{
				size = 16;
			}
			if (jtf2.getText().equals("����"))
			{
				size = 18;
			}

		}

		jt3.setFont(new Font(Type, fontType, size));

	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		String Type;
		String xType;
		if (e.getSource() == jcb1)
		{

			Type = jcb1.getSelectedItem().toString();
			
			jt3.setFont(new Font(Type, fontType, size));

		}

		if (e.getSource() == jcb2)
		{
			xType = jcb2.getSelectedItem().toString();
			jt3.setFont(new Font(xType, fontType, size));

		}

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == jb_ok)
		{
			String Type = jcb1.getSelectedItem().toString();
			

			r.getJta().setFont(new Font(Type, fontType, size));

			this.setVisible(false);

		}
		else if (e.getSource() == jb_sz)
		{
			String Type = jcb1.getSelectedItem().toString();
			r.getJta().setFont(new Font("����", Font.BOLD, 12));

			this.setVisible(false);

		}
		else if (e.getSource() == jb_qx)
		{
			this.setVisible(false);
		}

	}

	public RestBen getR()
	{
		return r;
	}

	public void setR(RestBen r)
	{
		this.r = r;
	}

}
