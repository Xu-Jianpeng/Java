/**
 * 记事本功能
 */
package notebook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.text.BadLocationException;

public class RestBen extends JFrame implements ActionListener, MenuListener,CaretListener,
		WindowListener {

	private static final String YES_NO_CANCEL_OPTION = null;
	private static Object YES_NO_OPTION;
	private JMenu jm_file, jm_eist, jm_oprnt, jm_view, jm_help;//主菜单栏
	private JMenuItem jmi_new, jmi_open, jmi_save, jmi_allsave, jmi_ymsz,
			jmi_dy, jmi_exit;//“文件”下拉菜单栏
	private JMenuItem jmi_cancel, jmi_cut, jmi_copy, jmi_paste, jmi_delete, jmi_find, jmi_nextfind, jmi_replace,
			jmi_goto, jmi_allchoose, jmi_timedate;//“编辑”下拉菜单栏
	private JMenuItem jmi_zt;//“格式”下拉菜单栏——字体
	private JMenuItem jmi_help, jmi_gyjsb;//“帮助”下拉菜单栏

	private JMenuBar jmb;//创建菜单栏jmb
	private JSeparator jse1, jse2, jse3, jse4, jse5, jse6;
	private JPanel jp1;//创建面板jp1
	JDialog jd = new JDialog(this, "关于  记事本");//自定义对话框
	JTextArea jta;//定义文本输入区
	JButton jb3;//帮助的ok
	int y = 1;

	public JTextArea getJta() {
		return jta;
	}
//基本组件
	private JScrollPane jsp1;//定义管理视口、可选的垂直和水平滚动条以及可选的行和列标题视口
	private JToolBar jtb;//工具栏
	JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9;
	//private JRadioButton jrb;
	//private ButtonGroup bg;
	private String value;
	private int start = 0;
	private JFrame jf = new JFrame("查找");

	private JButton jb = new JButton("开始");
	private JTextField jtf = new JTextField(15);
	private JTextField jt = new JTextField(15);
	private JButton jbt = new JButton("替换为");
	private JButton jba = new JButton("全部替换");
	TestFileStyle tfs;
	JCheckBoxMenuItem jmi_ztl;
	JCheckBoxMenuItem jmi_zdhh;

	public RestBen() {
		/**
		 * 更改界面风格为windows；
		 */
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		init();//初始化整个程序
		this.setTitle("记事本");
		this.setBounds(200, 100, 600, 600);//JLabel。setBounds(x,y,width,height)初始位置和大小设定

		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//不执行任何操作；要求程序在已注册的 WindowListener 对象的 windowClosing 方法中处理该操作。 
		addWindowListener(this);// 给关闭窗体添加监听事件

	}

	// 文件读取方法
	public void reader() {

		JFileChooser file = new JFileChooser();// 文件列表
		int result = file.showOpenDialog(this);// 弹出窗口
		if (result == file.APPROVE_OPTION)// 打开文件
		{
			File f = file.getSelectedFile();
			try {
				BufferedReader fr = new BufferedReader(new FileReader(f));
				String s = null;
				while ((s = fr.readLine()) != null) {
					jta.append(s + "\n");
				}

				fr.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("没有找到文件");
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	// 文件保存方法
	public void save() {
		JFileChooser file = new JFileChooser();// 文件列表
		int result = file.showSaveDialog(this);// 弹出窗口
		if (result == file.APPROVE_OPTION)// 打开文件
		{
			File f = file.getSelectedFile();
			try {

				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				String s = null;
				bw.write(jta.getText(), 0, jta.getText().length());

				bw.flush();
				bw.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	//初始化方法
	public void init() {
		jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		jp1.setBounds(0, 0, 400, 370);
		jta = new JTextArea(30, 40);
		jsp1 = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		jp1.add(jsp1, BorderLayout.CENTER);

		add(jp1);

		jse4 = new JSeparator();
		jse5 = new JSeparator();
		jse6 = new JSeparator();

		jm_file = new JMenu("文件(F)");
		jm_file.setMnemonic('F');
		jm_eist = new JMenu("编辑(E)");
		jm_eist.setMnemonic('E');
		jm_eist.addMenuListener(this);
		jm_oprnt = new JMenu("格式(O)");
		jm_oprnt.setMnemonic('O');
		jm_view = new JMenu("查看(V)");
		jm_view.setMnemonic('V');
		jm_help = new JMenu("帮助(H)");
		jm_help.setMnemonic('H');

		jmi_new = new JMenuItem("新建(N)");
		jmi_new.setMnemonic('N');
		jmi_new.setAccelerator(KeyStroke.getKeyStroke("control N"));
		jmi_new.addActionListener(this);

		jmi_open = new JMenuItem("打开(O)");
		jmi_open.setMnemonic('O');
		jmi_open.setAccelerator(KeyStroke.getKeyStroke("control O"));
		jmi_open.addActionListener(this);

		jmi_save = new JMenuItem("保存(S)");
		jmi_save.setMnemonic('S');
		jmi_save.setAccelerator(KeyStroke.getKeyStroke("control S"));
		jmi_save.addActionListener(this);

		jmi_allsave = new JMenuItem("另存为(A)");

		jmi_allsave.addActionListener(this);

		jmi_ymsz = new JMenuItem("页面设置(U)");
		jmi_ymsz.addActionListener(this);

		jmi_dy = new JMenuItem("打印(P)");
		jmi_dy.setMnemonic('P');
		jmi_dy.setAccelerator(KeyStroke.getKeyStroke("control P"));//设置键操作
		jmi_dy.addActionListener(this);

		jmi_exit = new JMenuItem("退出(X)");
		jmi_exit.addActionListener(this);

		jm_file.add(jmi_new);

		jm_file.add(jmi_open);
		jm_file.add(jmi_save);
		jm_file.add(jmi_allsave);

		jm_file.addSeparator();
		jm_file.add(jmi_ymsz);
		jm_file.add(jmi_dy);

		jm_file.addSeparator();
		jm_file.add(jmi_exit);

		jmi_cancel = new JMenuItem("撤销(U)");
		jmi_cancel.addActionListener(this);

		jmi_cut = new JMenuItem("剪切(X)");
		jmi_cut.addActionListener(this);

		jmi_copy = new JMenuItem("复制(C)");
		jmi_copy.addActionListener(this);

		jmi_paste = new JMenuItem("粘贴(V)");
		jmi_paste.addActionListener(this);

		jmi_delete = new JMenuItem("删除(N)");
		jmi_delete.addActionListener(this);

		jmi_find = new JMenuItem("查找(F)");
		jmi_find.addActionListener(this);

		jmi_nextfind = new JMenuItem("查找下一个(N)");
		jmi_nextfind.addActionListener(this);

		jmi_replace = new JMenuItem("替换(R)");
		jmi_replace.addActionListener(this);

		jmi_goto = new JMenuItem("转到(G)");
		jmi_allchoose = new JMenuItem("全选(A)");
		jmi_allchoose.addActionListener(this);

		jmi_timedate = new JMenuItem("时间/日期(D)");
		jmi_timedate.addActionListener(this);

		jm_eist.add(jmi_cancel);
		jmi_cancel.setEnabled(false);
		jm_eist.add(jmi_cut);
		jmi_cut.setEnabled(false);
		jm_eist.add(jmi_copy);
		jmi_copy.setEnabled(false);
		jm_eist.add(jmi_paste);
		jm_eist.add(jmi_delete);
		jmi_delete.setEnabled(false);
		jm_eist.add(jse4);
		jm_eist.add(jmi_find);
		jmi_find.setEnabled(false);
		jm_eist.add(jmi_nextfind);
		jmi_nextfind.setEnabled(false);
		jm_eist.add(jmi_replace);
		jm_eist.add(jmi_goto);
		jmi_goto.setEnabled(false);
		jm_eist.add(jse5);
		jm_eist.add(jmi_allchoose);
		jm_eist.add(jmi_timedate);

		jmi_zdhh = new JCheckBoxMenuItem("自动换行(W)");// 可以被选定或取消选定的菜单项
		jmi_zdhh.addActionListener(this);

		jmi_zt = new JMenuItem("字体(F)");
		jmi_zt.addActionListener(this);

		jm_oprnt.add(jmi_zdhh);
		jm_oprnt.add(jmi_zt);

		jmi_ztl = new JCheckBoxMenuItem("状态栏(S)");// 可以被选定或取消选定的菜单项
		jmi_ztl.addActionListener(this);

		jm_view.add(jmi_ztl);

		jmi_help = new JMenuItem("帮助主题(H)");
		jmi_help.addActionListener(this);

		jmi_gyjsb = new JMenuItem("关于记事本(A)");
		jmi_gyjsb.addActionListener(this);

		jm_help.add(jmi_help);
		jm_help.add(jse6);
		jm_help.add(jmi_gyjsb);

		// 添加菜单项

		jmb = new JMenuBar();

		jmb.add(jm_file);
		jmb.add(jm_eist);
		jmb.add(jm_oprnt);
		jmb.add(jm_view);
		jmb.add(jm_help);

		setJMenuBar(jmb);

		jtb = new JToolBar();// 状态栏
		jtb.setVisible(false);
		jl1 = new JLabel("");
		
		jtb.add(jl1);
		add(jtb, BorderLayout.SOUTH);
		

		// 关于记事本的窗体

		jb.addActionListener(this);
		jbt.addActionListener(this);
		jba.addActionListener(this);

		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		jb3 = new JButton("ok");

		JLabel l = new JLabel("MICROSOFT 软件许可条款");
		jl2 = new JLabel("这些许可条款是 Microsoft Corporation");
		jl3 = new JLabel("与您之间达成的协议。请阅读这些条款的内容。");
		jl4 = new JLabel("这些条款适用于上述软件，");
		jl5 = new JLabel("其中包括您用来接收该软件的媒体（若有）。");
		jl6 = new JLabel("这些条款也适用于 Microsoft 为此软件提供的");
		jl7 = new JLabel("（除非下述内容附带有其他条款）。如果确实附带有");
		jl8 = new JLabel("其他条款，则其他条款应适用。");
		p2.add(l);
		p2.add(jl2);
		p2.add(jl3);
		p2.add(jl4);
		p2.add(jl5);
		p2.add(jl6);
		p2.add(jl7);
		p2.add(jl8);
		p3.add(jb3, RIGHT_ALIGNMENT);
		jd.add(p2, BorderLayout.CENTER);
		jd.add(p3, BorderLayout.SOUTH);
		jd.setBounds(300, 200, 300, 300);

		jb3.addActionListener(this);// ok按钮事件
		jta.addCaretListener(this);

	}

	public static void main(String[] args) {
		RestBen ben = new RestBen();
		ben.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();//获取事件源

		if (e.getSource() == jb3)// 关于记事本的ok事件
		{

			jd.setVisible(false);
		}
		// 新建事件
		if (source == jmi_new) {
			if (!jta.getText().equals("")) {

				int recuse = JOptionPane.showConfirmDialog(this,
						"文件已发生改变，是否保存？", "保存文件", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.OK_OPTION);
				if (recuse == JOptionPane.YES_NO_OPTION) {
					RestBen ben = new RestBen();
					ben.save();

				} else {
					jta.setText("");
				}
			}

		}
		// 打开文件事件
		else if (source == jmi_open) {
			if (jta.getText().equals("")) {

				reader();
			}

			else {
				int recuse = JOptionPane.showConfirmDialog(this,
						"文件已发生改变，是否保存？", "保存文件", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.OK_OPTION);
				if (recuse == JOptionPane.YES_NO_OPTION) {
					save();

				} else {
					reader();
				}
			}
		}
		// 保存事件
		else if (source == jmi_save) {
			save();
		}
		// 另存为
		else if (source == jmi_allsave) {
			save();
		}
		// 退出事件
		else if (source == jmi_exit) {
			if (jta.getText().equals("")) {
				System.exit(0);
			} else {
				int recuse = JOptionPane.showConfirmDialog(this,
						"文件已发生改变，是否保存？", "保存文件", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.OK_OPTION);
				if (recuse == JOptionPane.YES_NO_OPTION) {
					save();
				} else {
					System.exit(0);
				}
			}
		}

		else if (source == jmi_cancel)// 撤销
		{
			jta.setText(value);
		} else if (source == jmi_copy)// 复制
		{
			jta.copy();
		} else if (source == jmi_paste)// 粘贴
		{
			jta.paste();
		} else if (source == jmi_cut)// 剪切
		{

			jta.cut();
		} else if (source == jmi_delete)// 删除
		{
			jta.replaceSelection(null);
		} else if (source == jmi_allchoose)// 全选
		{
			jta.selectAll();
		} else if (source == jmi_replace)// 替换
		{
			JFrame jfc = new JFrame("替换");
			value = jta.getText();
			GridLayout gl = new GridLayout(3, 3);
			JLabel jl1 = new JLabel("查找内容:");
			JLabel jl2 = new JLabel("替换为:");
			jfc.setLayout(gl);
			jfc.add(jtf);
			jfc.add(jl1);
			jfc.add(jb);
			jfc.add(jl2);
			jfc.add(jt);
			jfc.add(jbt);
			JLabel jl3 = new JLabel();
			JLabel jl4 = new JLabel();
			jfc.add(jl3);
			jfc.add(jl4);
			jfc.add(jba);

			jfc.setBounds(300, 300, 300, 120);
			jfc.setResizable(false);
			jfc.setVisible(true);
			jfc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}

		else if ("替换为" == e.getActionCommand()) {
			String temp = jtf.getText();
			int s = value.indexOf(temp, start);
			if (value.indexOf(temp, start) != -1) {
				jta.setSelectionStart(s);
				jta.setSelectionEnd(s + temp.length());
				jta.setSelectedTextColor(Color.GREEN);
				start = s + 1;
				jta.replaceSelection(jt.getText());
			} else {
				JOptionPane.showMessageDialog(jf, "查找完毕!", "提示", 0, null);
				jf.dispose();
			}
		} else if ("全部替换" == e.getActionCommand())// 全部替换事件
		{
			String temp = jta.getText();
			temp = temp.replaceAll(jtf.getText(), jt.getText());
			jta.setText(temp);

		} else if (source == jmi_find || source == jmi_nextfind)// 查找
		{
			value = jta.getText();
			jf.add(jtf, BorderLayout.CENTER);
			jf.add(jb, BorderLayout.SOUTH);

			jf.setBounds(300, 300, 200, 80);
			jf.setVisible(true);
			jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}
		else if ("开始" == e.getActionCommand()|| "下一个" == e.getActionCommand())// 按钮设置
		{

			String temp = jtf.getText();
			int s = value.indexOf(temp, start);
			if (value.indexOf(temp, start) != -1) {
				jta.setSelectionStart(s);
				jta.setSelectionEnd(s + temp.length());
				jta.setSelectedTextColor(Color.GREEN);
				start = s + 1;
				jb.setText("下一个");

			} else {
				JOptionPane.showMessageDialog(jf, "查找完毕!", "提示", 0, null);
				jf.dispose();
			}
		} else if (jmi_timedate == source)// 时间设定
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh：mm:ss");
			Date date = new Date();
			String s = sdf.format(date);
			jta.setText(s);

		}

		else if (source == jmi_zt)// 字体设置
		{
			TestFileStyle fs = new TestFileStyle();
			fs.setR(this);
			fs.setVisible(true);
		} else if (source == jmi_zdhh)// 自动换行
		{
			if (!jmi_zdhh.getState()) {//自动换行被选中
				jta.setLineWrap(true);//自动换行
			} else {
				jta.setLineWrap(false);//不自动换行
			}

		} else if (source == jmi_gyjsb)// 关于记事本
		{
			jd.setVisible(true);

		} else if (source == jmi_ztl)// 状态栏
		{
			if (jmi_ztl.getState()) {
				jtb.setVisible(true);
				

			} else {
				jtb.setVisible(false);
			}
		}

	}

	@Override
	public void menuCanceled(MenuEvent e)// 无用
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void menuDeselected(MenuEvent e)// 无用
	{

	}

	@Override
	public void menuSelected(MenuEvent e)// 显示菜单
	{
		Object source = e.getSource();
		if (source == jm_eist) {
			if (!jta.getText().equals("")) {
				jmi_cancel.setEnabled(true);

				jmi_find.setEnabled(true);
				jmi_nextfind.setEnabled(true);
				if (jta.getSelectedText() != null) {
					jmi_cut.setEnabled(true);
					jmi_copy.setEnabled(true);

					jmi_delete.setEnabled(true);
				} else {
					jmi_cut.setEnabled(false);
					jmi_copy.setEnabled(false);

					jmi_delete.setEnabled(false);
				}
			}

		}

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e)// 关闭窗体事件
	{

		if (jta.getText().equals("")) {
			System.exit(0);
		} else {
			int recuse = JOptionPane
					.showConfirmDialog(this, "文件已发生改变，是否保存？", "保存文件",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.OK_OPTION);
			if (recuse == JOptionPane.YES_NO_OPTION) {
				save();
			} else {
				System.exit(0);
			}
		}
		System.out.println("关闭");

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void caretUpdate(CaretEvent e) {
		// TODO Auto-generated method stub
		int offset=e.getDot();
		int line;
		try {
			line = jta.getLineOfOffset(offset);
			int column=offset-jta.getLineStartOffset(line);
			jl1.setText(line+","+column);
		System.out.println(line);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 
		
	}

}
