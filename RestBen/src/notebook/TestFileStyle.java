/**
 * 字体设置和格式样式的选择
 * 窗体的实现  
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
	// 字体面板组件--------
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
	// 字符间距面板组件--------
	private JLabel jlz1, jlz2, jlz3, jlz4, jlz5, jlz6, jlz7;
	private JComboBox jcbz1, jcbz2, jcbz3;
	private JSpinner jspz1, jspz2, jspz3;
	private JTextField jtf1z;
	private JCheckBox jcz1, jcz2;
	private Container jta;

	public TestFileStyle()
	{

		init();
		this.setTitle("字体");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 460);
	}

	public void init()
	{
		//r = new RestBen();

		jb_ok = new JButton("确定");
		jb_ok.setBounds(370, 410, 60, 20);
		jb_ok.addActionListener(this);
		jb_qx = new JButton("取消");
		jb_qx.setBounds(300, 410, 60, 20);
		jb_qx.addActionListener(this);
		jb_sz = new JButton("默认");
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
		jtbp.add("字体", panel1);
		jtbp.add("字符间距", panel2);

		add(jtbp);

		jl1 = new JLabel("中文字体(T):");
		jl1.setBounds(20, 25, 70, 15);
		String[] s =
		{ "中文标题", "中文正文", "Arial Unicode MS", "Batang", "BatangChe", "华文细黑",
				"华文新魏", "新宋体", "微软雅黑" };
		jcb1 = new JComboBox(s);
		jcb1.setBounds(20, 43, 200, 20);
		jcb1.addItemListener(this);
		panel1.add(jcb1);
		panel1.add(jl1);
		jl12 = new JLabel("西文字体(F):");
		jl12.setBounds(20, 66, 70, 15);

		String[] s1 =
		{ "BatangChe", "Dotum", "DotumChe", "GulimChe", "MS Gothic", "Bell MT",
				"Imprint MT Shadow" };
		jcb2 = new JComboBox(s1);
		jcb2.setBounds(20, 84, 200, 20);
		jcb2.addItemListener(this);
		panel1.add(jcb2);
		panel1.add(jl12);

		jl2 = new JLabel("字形(Y):");
		jl2.setBounds(230, 25, 70, 15);

		jtf1 = new JTextField();
		jtf1.setBounds(230, 43, 100, 20);
		String[] ss =
		{ "加粗", "斜体", "默认", "粗斜体" };
		jlist1 = new JList(ss);
		jlist1.addListSelectionListener(this);
		jsc1 = new JScrollPane(jlist1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsc1.setBounds(230, 64, 100, 40);
		panel1.add(jsc1);
		panel1.add(jtf1);
		panel1.add(jl2);

		jl3 = new JLabel("字号(S):");
		jl3.setBounds(340, 20, 70, 20);
		jtf2 = new JTextField();
		jtf2.setBounds(340, 43, 70, 20);
		String[] ss1 =
		{ "五号", "四号", "三号", "二号", };
		jlist2 = new JList(ss1);
		jlist2.addListSelectionListener(this);
		jsc2 = new JScrollPane(jlist2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsc2.setBounds(340, 64, 70, 40);
		panel1.add(jsc2);
		panel1.add(jtf2);
		panel1.add(jl3);

		jl4 = new JLabel("所有文字");
		jl4.setBounds(12, 108, 70, 15);
		panel1.add(jl4);

		jl5 = new JLabel("字体颜色(C):");
		jl5.setBounds(20, 125, 85, 15);
		jcb3 = new JComboBox();
		jcb3.setBounds(20, 142, 85, 20);
		panel1.add(jcb3);
		panel1.add(jl5);

		jl6 = new JLabel("下划线线型(U):");
		jl6.setBounds(120, 125, 85, 15);
		jcb4 = new JComboBox();
		jcb4.setBounds(120, 142, 100, 20);
		panel1.add(jcb4);
		panel1.add(jl6);

		jl7 = new JLabel("下划线颜色(I):");
		jl7.setBounds(230, 125, 100, 15);
		jcb5 = new JComboBox();
		jcb5.setBounds(230, 142, 100, 20);
		panel1.add(jcb5);
		panel1.add(jl7);

		jl8 = new JLabel("着重号(*):");
		jl8.setBounds(340, 125, 85, 15);
		jcb6 = new JComboBox();
		jcb6.setBounds(340, 142, 70, 20);
		panel1.add(jcb6);
		panel1.add(jl8);

		jl9 = new JLabel("效果");
		jl9.setBounds(12, 165, 70, 15);
		panel1.add(jl9);
		jc1 = new JCheckBox("删除线(C)");
		jc2 = new JCheckBox("阴影");
		jc3 = new JCheckBox("小型大写字母");
		jc4 = new JCheckBox("双删除线");
		jc5 = new JCheckBox("空心");
		jc6 = new JCheckBox("全部大写字母");
		jc7 = new JCheckBox("上标");
		jc8 = new JCheckBox("阳文");
		jc9 = new JCheckBox("隐藏");
		jc10 = new JCheckBox("下标");
		jc11 = new JCheckBox("阴文");
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

		jl10 = new JLabel("预览");

		jl10.setBounds(20, 250, 70, 15);
		panel1.add(jl10);

		jl11 = new JLabel("这是用于中文正文的字体，定义使用哪种字体格式");
		Font font = new Font(jcb1.getName(), 1, 12);
		jl11.setBounds(20, 310, 300, 15);

		jt3 = new JTextField(
				"___________      微软科技 ABC         _____________________________");
		jt3.setBounds(20, 268, 400, 40);
		jt3.setHorizontalAlignment(JTextField.CENTER);//字体居中

		panel1.add(jt3);
		panel1.add(jl11);

		// 字符间距添加面板组件---------------
		jlz1 = new JLabel("缩放:");
		jlz1.setBounds(12, 10, 70, 20);

		String[] s2 =
		{ "10%", "20%", "30%", "40%", "50%", "60%", "70%", "80%", "90%",
				"100%", "200%" };
		jcbz1 = new JComboBox(s2);
		jcbz1.setBounds(65, 10, 150, 20);
		panel2.add(jcbz1);
		panel2.add(jlz1);

		jlz2 = new JLabel("间距:");
		jlz2.setBounds(12, 35, 70, 20);

		String[] s3 =
		{ "标准", "加宽", "紧缩" };
		jcbz2 = new JComboBox(s3);
		jcbz2.setBounds(65, 35, 150, 20);
		panel2.add(jcbz2);
		panel2.add(jlz2);

		jlz3 = new JLabel("磅值:(B)");
		jlz3.setBounds(220, 35, 100, 20);
		jspz1 = new JSpinner();
		jspz1.setBounds(270, 35, 100, 20);
		panel2.add(jspz1);
		panel2.add(jlz3);

		jlz4 = new JLabel("位置:(D)");
		jlz4.setBounds(12, 60, 100, 20);
		String[] s4 =
		{ "标准", "提升", "降低" };
		jcbz2 = new JComboBox(s4);

		jcbz2.setBounds(65, 60, 70, 20);
		panel2.add(jlz4);
		panel2.add(jcbz2);

		jlz5 = new JLabel("磅值:(Y)");
		jlz5.setBounds(220, 60, 100, 20);
		jspz3 = new JSpinner();
		jspz3.setBounds(270, 60, 100, 20);
		panel2.add(jspz3);
		panel2.add(jlz5);
		jcz1 = new JCheckBox("为字体调整字间距(K):");
		jcz1.setBounds(20, 85, 160, 20);
		panel2.add(jcz1);
		jspz3 = new JSpinner();
		jspz3.setBounds(180, 85, 70, 20);
		panel2.add(jspz3);

		jcz2 = new JCheckBox("如果定义了文档网格，则对齐到网格");
		jcz2.setBounds(20, 110, 300, 20);
		panel2.add(jcz2);

		jlz6 = new JLabel("磅或更大(O)");
		jlz6.setBounds(260, 85, 100, 20);
		panel2.add(jlz6);

		jl7 = new JLabel("预览");
		jl7.setBounds(20, 250, 70, 15);
		panel2.add(jl7);

		jl7 = new JLabel("这是用于中文正文的字体，定义使用哪种字体格式");
		jl7.setBounds(20, 310, 300, 15);
		jtf1z = new JTextField(
				"_________________           微软科技 ABC           _____________________________");
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
			if (jtf1.getText().equals("默认"))
			{
				fontType = 0;
			}
			if (jtf1.getText().equals("加粗"))
			{
				fontType = 1;
			}
			if (jtf1.getText().equals("斜体"))
			{
				fontType = 2;
			}
			if (jtf1.getText().equals("粗斜体"))
			{
				fontType = 3;
			}

		}

		else if (e.getSource() == jlist2)
		{
			if (jtf2.getText().equals("五号"))
			{
				size = 12;
			}
			if (jtf2.getText().equals("四号"))
			{
				size = 14;
			}
			if (jtf2.getText().equals("三号"))
			{
				size = 16;
			}
			if (jtf2.getText().equals("二号"))
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
			r.getJta().setFont(new Font("宋体", Font.BOLD, 12));

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
