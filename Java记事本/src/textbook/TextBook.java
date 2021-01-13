package textbook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class TextBook extends JFrame implements ActionListener, MenuListener,KeyListener,
		WindowListener {

	private JMenu menu_file, menu_edit, menu_format, menu_view, menu_help;//主菜单栏
	private JMenuItem menuItem_new, menuItem_open, menuItem_save, menuItem_allsave, menuItem_pagesetting,
			menuItem_print, menuItem_exit;//“文件”下拉菜单栏
	private JMenuItem menuItem_cancel, menuItem_cut, menuItem_copy, menuItem_paste, menuItem_delete, menuItem_find, menuItem_nextfind, menuItem_replace,
			menuItem_goto, menuItem_allchoose, menuItem_timedate;//“编辑”下拉菜单栏
	private JMenuItem menuItem_font;//“格式”下拉菜单栏——字体ff
	private JMenuItem menuItem_help, menuItem_about;//“帮助”下拉菜单栏

	private JMenuBar menuBar;//创建菜单栏menuBar
	private JPanel panel1;//创建面板panel1
	JDialog dialog = new JDialog(this, "关于  记事本");//自定义对话框
	JTextArea textArea;//定义文本输入区
	JButton button3;//帮助对话框里的ok

	public JTextArea getJta() {
		return textArea;
	}
//基本组件
	private JScrollPane scrollPane1;//定义带滚动条的面板、可选的垂直和水平滚动条以及可选的行和列标题视口
	JLabel label1, label2, label3, label4, label5, label6, label7, label8;//关于记事本中的组件
	private String value;
	private int start = 0;
	private JFrame frame = new JFrame("查找");

	private JButton button_begin_next = new JButton("开始");
	private JTextField textField_find = new JTextField(15);
	private JTextField textField_replace = new JTextField(15);
	private JButton button_replace = new JButton("替换");//替换按钮
	private JButton button_allreplace = new JButton("全部替换");//全部替换按钮
	ArtFont artFont;
	JCheckBoxMenuItem menuItem_statusbar;//状态栏
	JCheckBoxMenuItem menuItem_autoline;//自动换行

	public TextBook() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// 更改界面风格为windows
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
		JFileChooser fileChooser = new JFileChooser();// 文件列表
		int result = fileChooser.showOpenDialog(this);// 弹出窗口
		if (result == JFileChooser.APPROVE_OPTION)// 打开文件、 APPROVE_OPTION:获取选中的文件对象
		{
			File file = fileChooser.getSelectedFile();//获取文件内容
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				String s = null;
				while ((s = bufferedReader.readLine()) != null) {//读数据
					textArea.append(s + "\n");//若数据未读完则继续向后增补数据。
				}
				bufferedReader.close();//输入流关闭
			} catch (FileNotFoundException e1) {
				
				System.out.println("没有找到文件");
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
	}

	// 文件保存方法
	public void save() {
		JFileChooser fileChooser = new JFileChooser();// 文件列表
		int result = fileChooser.showSaveDialog(this);// 弹出窗口
		if (result == JFileChooser.APPROVE_OPTION)// 打开文件
		{
			File file = fileChooser.getSelectedFile();
			try {

				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
				bufferedWriter.write(textArea.getText(), 0, textArea.getText().length());

				bufferedWriter.flush();
				bufferedWriter.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void justsave() {
		File file = ;
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write(textArea.getText(),0,textArea.getText().length());;
		
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	//初始化方法
	public void init() {
		panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		//panel1.setBounds(0, 0, 400, 370);
		textArea = new JTextArea(30, 40);
		textArea.addKeyListener(this);
		scrollPane1 = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//竖直滚动条一直显示，水平滚动条需要时显示
		panel1.add(scrollPane1, BorderLayout.CENTER);
		add(panel1);

		menu_file = new JMenu("文件(F)");
		menu_file.setMnemonic('F');
		menu_edit = new JMenu("编辑(E)");
		menu_edit.setMnemonic('E');
		menu_edit.addMenuListener(this);
		menu_format = new JMenu("格式(O)");
		menu_format.setMnemonic('O');
		menu_view = new JMenu("查看(V)");
		menu_view.setMnemonic('V');
		menu_help = new JMenu("帮助(H)");
		menu_help.setMnemonic('H');

		menuItem_new = new JMenuItem("新建(N)");
		menuItem_new.setMnemonic('N');
		menuItem_new.setAccelerator(KeyStroke.getKeyStroke("control N"));//设置快捷键操作
		menuItem_new.addActionListener(this);

		menuItem_open = new JMenuItem("打开(O)");
		menuItem_open.setMnemonic('O');
		menuItem_open.setAccelerator(KeyStroke.getKeyStroke("control O"));//设置快捷键操作
		menuItem_open.addActionListener(this);

		menuItem_save = new JMenuItem("保存(S)");
		menuItem_save.setMnemonic('S');
		menuItem_save.setAccelerator(KeyStroke.getKeyStroke("control S"));//设置快捷键操作
		menuItem_save.addActionListener(this);

		menuItem_allsave = new JMenuItem("另存为(A)");
		menuItem_allsave.addActionListener(this);

		menuItem_pagesetting = new JMenuItem("页面设置(U)");
		menuItem_pagesetting.addActionListener(this);
		menuItem_pagesetting.setEnabled(false);

		menuItem_print = new JMenuItem("打印(P)");
		menuItem_print.setMnemonic('P');
		menuItem_print.setAccelerator(KeyStroke.getKeyStroke("control P"));//设置快捷键操作
		menuItem_print.addActionListener(this);
		menuItem_print.setEnabled(false);

		menuItem_exit = new JMenuItem("退出(X)");
		menuItem_exit.addActionListener(this);

		menu_file.add(menuItem_new);
		menu_file.add(menuItem_open);
		menu_file.add(menuItem_save);
		menu_file.add(menuItem_allsave);
		menu_file.add(menuItem_pagesetting);
		menu_file.add(menuItem_print);
		menu_file.add(menuItem_exit);

		menuItem_cancel = new JMenuItem("撤销(U)");
		menuItem_cancel.addActionListener(this);
		menuItem_cancel.setAccelerator(KeyStroke.getKeyStroke("control Z"));

		menuItem_cut = new JMenuItem("剪切(T)");
		menuItem_cut.addActionListener(this);
		menuItem_cut.setAccelerator(KeyStroke.getKeyStroke("control X"));
		
		menuItem_copy = new JMenuItem("复制(C)");
		menuItem_copy.addActionListener(this);
		menuItem_copy.setAccelerator(KeyStroke.getKeyStroke("control C"));

		menuItem_paste = new JMenuItem("粘贴(P)");
		menuItem_paste.addActionListener(this);
		menuItem_paste.setAccelerator(KeyStroke.getKeyStroke("control V"));
		
		menuItem_delete = new JMenuItem("删除(L)");
		menuItem_delete.addActionListener(this);
		menuItem_delete.setAccelerator(KeyStroke.getKeyStroke("delete"));
		
		menuItem_find = new JMenuItem("查找(F)");
		menuItem_find.addActionListener(this);
		menuItem_find.setAccelerator(KeyStroke.getKeyStroke("control F"));

		menuItem_nextfind = new JMenuItem("查找下一个(N)");
		menuItem_nextfind.addActionListener(this);
		menuItem_nextfind.setAccelerator(KeyStroke.getKeyStroke("control F"));
		
		menuItem_replace = new JMenuItem("替换(R)");
		menuItem_replace.addActionListener(this);
		menuItem_replace.setAccelerator(KeyStroke.getKeyStroke("control alt F"));

		menuItem_goto = new JMenuItem("转到(G)");
		
		menuItem_allchoose = new JMenuItem("全选(A)");
		menuItem_allchoose.addActionListener(this);
		menuItem_allchoose.setAccelerator(KeyStroke.getKeyStroke("control A"));
		
		menuItem_timedate = new JMenuItem("时间/日期(D)");
		menuItem_timedate.addActionListener(this);
		menuItem_timedate.setAccelerator(KeyStroke.getKeyStroke("control alt D"));
		
		menu_edit.add(menuItem_cancel);
		menuItem_cancel.setEnabled(false);
		menu_edit.add(menuItem_cut);
		menuItem_cut.setEnabled(false);
		menu_edit.add(menuItem_copy);
		menuItem_copy.setEnabled(false);
		menu_edit.add(menuItem_paste);
		menu_edit.add(menuItem_delete);
		menuItem_delete.setEnabled(false);
		menu_edit.add(menuItem_find);
		menuItem_find.setEnabled(false);
		menu_edit.add(menuItem_nextfind);
		menuItem_nextfind.setEnabled(false);
		menu_edit.add(menuItem_replace);
		menu_edit.add(menuItem_goto);
		menuItem_goto.setEnabled(false);
		menu_edit.add(menuItem_allchoose);
		menu_edit.add(menuItem_timedate);

		menuItem_autoline = new JCheckBoxMenuItem("自动换行(W)");// 可以被选定或取消选定的菜单项
		menuItem_autoline.addActionListener(this);

		menuItem_font = new JMenuItem("字体(F)...");
		menuItem_font.addActionListener(this);

		menu_format.add(menuItem_autoline);
		menu_format.add(menuItem_font);

		menuItem_statusbar = new JCheckBoxMenuItem("状态栏(S)");// 可以被选定或取消选定的菜单项
		menuItem_statusbar.addActionListener(this);

		menu_view.add(menuItem_statusbar);
		menuItem_statusbar.setEnabled(false);

		menuItem_help = new JMenuItem("查看帮助(H)");
		menuItem_help.addActionListener(this);
		menuItem_help.setEnabled(false);
		

		menuItem_about = new JMenuItem("关于记事本(A)");
		menuItem_about.addActionListener(this);

		menu_help.add(menuItem_help);
		menu_help.add(menuItem_about);

		// 添加菜单项
		menuBar = new JMenuBar();

		menuBar.add(menu_file);
		menuBar.add(menu_edit);
		menuBar.add(menu_format);
		menuBar.add(menu_view);
		menuBar.add(menu_help);

		setJMenuBar(menuBar);

		//关于查找/替换的窗体中的按钮
		
		button_begin_next.addActionListener(this);//开始
		button_replace.addActionListener(this);//替换
		button_allreplace.addActionListener(this);//全部替换

		// 关于记事本的窗体
		
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		button3 = new JButton("ok");

		label1 = new JLabel("Windows 7 旗舰版");
		label2 = new JLabel("Microsoft Windows");
		label3 = new JLabel("版本6.1 (内部版本 7601：Service Pack1)");
		label4 = new JLabel("版权所有 2009 Microsoft Corporation。保留所有权利。");
		label5 = new JLabel("Windows7 旗舰版 操作系统及其用户界面受美国和其他国家/地区的");
		label6 = new JLabel("商标法和其他待颁布的知识产权法保护。");
		label7 = new JLabel("根据Mircrosoft 软件许可条款，本产品使用权属于：");
		label8 = new JLabel("Win7_64、Win7_64");
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(label5);
		panel2.add(label6);
		panel2.add(label7);
		panel2.add(label8);
		panel3.add(button3, RIGHT_ALIGNMENT);
		dialog.add(panel2, BorderLayout.CENTER);
		dialog.add(panel3, BorderLayout.SOUTH);
		dialog.setBounds(300, 200, 400, 220);

		button3.addActionListener(this);// ok按钮事件
	}
	
	public static void main(String[] args) {
		TextBook text = new TextBook();
		text.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();//获取事件源

		if (source == button3)// 关于记事本的ok事件
		{
			dialog.setVisible(false);
		}
		// 新建事件
		if (source == menuItem_new) {
			if (!textArea.getText().equals("")) {
				int recuse = JOptionPane.showConfirmDialog(this,
						"文件已发生改变，是否保存？", "保存文件",JOptionPane.OK_CANCEL_OPTION);
				if (recuse == JOptionPane.OK_OPTION) {
					TextBook text = new TextBook();
					text.save();
				} else {
					textArea.setText("");
				}
			}
		}
		// 打开文件事件
		else if (source == menuItem_open) {
			if (textArea.getText().equals("")) {
				reader();
			}else {
				int recuse = JOptionPane.showConfirmDialog(this,
						"文件已发生改变，是否保存？", "保存文件", JOptionPane.OK_CANCEL_OPTION);
				if (recuse == JOptionPane.OK_OPTION) {
					save();

				} else {
					reader();
				}
			}
		}
		// 保存事件
		else if (source == menuItem_save) {
			save();
		}
		// 另存为
		else if (source == menuItem_allsave) {
			save();
		}
		// 退出事件
		else if (source == menuItem_exit) {
			if (textArea.getText().equals("")) {
				System.exit(0);
			} else {
				int recuse = JOptionPane.showConfirmDialog(this,
						"文件已发生改变，是否保存？", "保存文件", JOptionPane.OK_CANCEL_OPTION);
				if (recuse == JOptionPane.OK_OPTION) {
					save();
				} else {
					System.exit(0);
				}
			}
		}

		else if (source == menuItem_cancel)// 撤销
		{
			textArea.setText(value);
		} else if (source == menuItem_copy)// 复制
		{
			textArea.copy();
		} else if (source == menuItem_paste)// 粘贴
		{
			textArea.paste();
		} else if (source == menuItem_cut)// 剪切
		{
			textArea.cut();
		} else if (source == menuItem_delete)// 删除
		{
			textArea.replaceSelection(null);
		} else if (source == menuItem_allchoose)// 全选
		{
			textArea.selectAll();
		} else if (source == menuItem_replace)// 替换
		{
			JFrame frame_replace = new JFrame("替换");
			value = textArea.getText();
			GridLayout gridLayout = new GridLayout(3, 3);
			JLabel label1 = new JLabel("查找内容:");
			JLabel label2 = new JLabel("替换为:");
			frame_replace.setLayout(gridLayout);
			frame_replace.add(label1);
			frame_replace.add(textField_find);//查找（被替换）内容输入框
			frame_replace.add(button_begin_next);//开始
			frame_replace.add(label2);
			frame_replace.add(textField_replace);//替换成内容输入框
			frame_replace.add(button_replace);//替换
			JLabel label3 = new JLabel();//仅用作占空间
			JLabel label4 = new JLabel();//仅用作占空间
			frame_replace.add(label3);
			frame_replace.add(label4);
			frame_replace.add(button_allreplace);//全部替换

			frame_replace.setBounds(300, 300, 300, 120);//位置和大小（x,y,width,height)
			frame_replace.setResizable(false);//设置窗体不可改变大小
			frame_replace.setVisible(true);//显示窗口
			frame_replace.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//点击关闭时自动隐藏并释放该窗体
		}
		else if ("替换" == e.getActionCommand()) {
			value = textArea.getText();
			String temp = textField_find.getText();
			int s = value.indexOf(temp, start);//求字符串所在位置的索引
			if ( value.indexOf(temp, start)!= -1) {
				textArea.setSelectionStart(s);//设置起点位置
				textArea.setSelectionEnd(s + temp.length());//设置终点位置(起点终点的设定是为了让被选中字符串处于高亮状态）
				textArea.setSelectedTextColor(Color.WHITE);
				start = s + 1;
				textArea.replaceSelection(textField_replace.getText());
			}
			else {
				JOptionPane.showMessageDialog(frame, "查找完毕!", "提示", 0, null);
				start = 0;
				frame.dispose();//释放窗口所占用屏幕资源
			}
		} else if ("全部替换" == e.getActionCommand())// 全部替换事件
		{
			String temp = textArea.getText();
			temp = temp.replaceAll(textField_find.getText(), textField_replace.getText());
			textArea.setText(temp);
		} else if (source == menuItem_find || source == menuItem_nextfind)// 查找
		{
			value = textArea.getText();
			frame.add(textField_find, BorderLayout.CENTER);
			frame.add(button_begin_next, BorderLayout.SOUTH);
			frame.setBounds(300, 300, 200, 100);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else if ("开始" == e.getActionCommand()|| "下一个" == e.getActionCommand())// 按钮设置
		{
			value = textArea.getText();
			String temp = textField_find.getText();
			int s = value.indexOf(temp, start);
			if (value.indexOf(temp, start) != -1) {
				textArea.setSelectionStart(s);
				textArea.setSelectionEnd(s + temp.length());
				textArea.setSelectedTextColor(Color.WHITE);
				start = s + 1;
				button_begin_next.setText("下一个");
			} else {
				JOptionPane.showMessageDialog(frame, "查找完毕!", "提示", 0, null);
				start = 0;
				frame.dispose();//释放窗口占用屏幕资源
			}
		} 
		else if (source == menuItem_timedate )// 时间设定
		{
			value = textArea.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("HH：mm y\\M\\d  E ");//y年M月d日 E周几 H0-24时 m分 s秒
			Date date = new Date();
			String s = sdf.format(date);
			textArea.setText(value + s);
		}
		else if (source == menuItem_font)// 字体设置
		{
			ArtFont art = new ArtFont();
			art.setText(this);
			art.setVisible(true);
		} 
		else if (source == menuItem_autoline)// 自动换行
		{
			if (!menuItem_autoline.getState()) {//自动换行未被选中
				textArea.setLineWrap(false);//不自动换行
			} else {
				textArea.setLineWrap(true);//自动换行
			}

		} else if (source == menuItem_about)// 关于记事本
		{
			dialog.setVisible(true);
		}
	}
	
	public void windowClosing(WindowEvent e)// 关闭窗体事件
	{
		if (textArea.getText().equals("")) {
			System.exit(0);
		} else {
			int recuse = JOptionPane
					.showConfirmDialog(this, "文件已发生改变，是否保存？", "保存文件",
							JOptionPane.OK_CANCEL_OPTION);
			if (recuse == JOptionPane.OK_OPTION) {
				save();
			} else {
				System.exit(0);
			}
		}
		System.out.println("关闭");
	}

	public void keyReleased(KeyEvent e) {
		int source = e.getKeyCode();
		if(source>=KeyEvent.VK_A&&source<=KeyEvent.VK_Z||
			source==KeyEvent.VK_BACK_SPACE||source==KeyEvent.VK_DELETE) {
		if (!textArea.getText().equals("")) {
			menuItem_cancel.setEnabled(true);

			menuItem_find.setEnabled(true);
			menuItem_nextfind.setEnabled(true);
			if (textArea.getSelectedText() != null) {
				menuItem_cut.setEnabled(true);
				menuItem_copy.setEnabled(true);

				menuItem_delete.setEnabled(true);
			} else {
				menuItem_cut.setEnabled(false);
				menuItem_copy.setEnabled(false);

				menuItem_delete.setEnabled(false);
			}
			}
		else if(textArea.getText().equals("")) {
			menuItem_cancel.setEnabled(false);

			menuItem_find.setEnabled(false);
			menuItem_nextfind.setEnabled(false);
		}
		}
	}
	//后面是一堆为了声明而声明的函数
	public void menuCanceled(MenuEvent e){	}	
	public void menuDeselected(MenuEvent e){	}
	public void menuSelected(MenuEvent e){
			if (!textArea.getText().equals("")) {
				menuItem_cancel.setEnabled(true);

				menuItem_find.setEnabled(true);
				menuItem_nextfind.setEnabled(true);
				if (textArea.getSelectedText() != null) {
					menuItem_cut.setEnabled(true);
					menuItem_copy.setEnabled(true);

					menuItem_delete.setEnabled(true);
				} else {
					menuItem_cut.setEnabled(false);
					menuItem_copy.setEnabled(false);

					menuItem_delete.setEnabled(false);
				}


		}
	}	
	public void windowActivated(WindowEvent e) {	}
	public void windowClosed(WindowEvent e) {	}	
	public void windowDeactivated(WindowEvent e) {	}	
	public void windowDeiconified(WindowEvent e) {	}
	public void windowIconified(WindowEvent e) {	}
	public void windowOpened(WindowEvent e) {	}
	public void keyPressed(KeyEvent e) {	}
	public void keyTyped(KeyEvent e) {	}
}
