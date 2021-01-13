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

	private JMenu menu_file, menu_edit, menu_format, menu_view, menu_help;//���˵���
	private JMenuItem menuItem_new, menuItem_open, menuItem_save, menuItem_allsave, menuItem_pagesetting,
			menuItem_print, menuItem_exit;//���ļ��������˵���
	private JMenuItem menuItem_cancel, menuItem_cut, menuItem_copy, menuItem_paste, menuItem_delete, menuItem_find, menuItem_nextfind, menuItem_replace,
			menuItem_goto, menuItem_allchoose, menuItem_timedate;//���༭�������˵���
	private JMenuItem menuItem_font;//����ʽ�������˵�����������ff
	private JMenuItem menuItem_help, menuItem_about;//�������������˵���

	private JMenuBar menuBar;//�����˵���menuBar
	private JPanel panel1;//�������panel1
	JDialog dialog = new JDialog(this, "����  ���±�");//�Զ���Ի���
	JTextArea textArea;//�����ı�������
	JButton button3;//�����Ի������ok

	public JTextArea getJta() {
		return textArea;
	}
//�������
	private JScrollPane scrollPane1;//���������������塢��ѡ�Ĵ�ֱ��ˮƽ�������Լ���ѡ���к��б����ӿ�
	JLabel label1, label2, label3, label4, label5, label6, label7, label8;//���ڼ��±��е����
	private String value;
	private int start = 0;
	private JFrame frame = new JFrame("����");

	private JButton button_begin_next = new JButton("��ʼ");
	private JTextField textField_find = new JTextField(15);
	private JTextField textField_replace = new JTextField(15);
	private JButton button_replace = new JButton("�滻");//�滻��ť
	private JButton button_allreplace = new JButton("ȫ���滻");//ȫ���滻��ť
	ArtFont artFont;
	JCheckBoxMenuItem menuItem_statusbar;//״̬��
	JCheckBoxMenuItem menuItem_autoline;//�Զ�����

	public TextBook() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// ���Ľ�����Ϊwindows
		} catch (Exception e) {
			e.printStackTrace();
		}
		init();//��ʼ����������
		this.setTitle("���±�");
		this.setBounds(200, 100, 600, 600);//JLabel��setBounds(x,y,width,height)��ʼλ�úʹ�С�趨

		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//��ִ���κβ�����Ҫ���������ע��� WindowListener ����� windowClosing �����д���ò����� 
		addWindowListener(this);// ���رմ�����Ӽ����¼�
	}

	// �ļ���ȡ����
	public void reader() {
		JFileChooser fileChooser = new JFileChooser();// �ļ��б�
		int result = fileChooser.showOpenDialog(this);// ��������
		if (result == JFileChooser.APPROVE_OPTION)// ���ļ��� APPROVE_OPTION:��ȡѡ�е��ļ�����
		{
			File file = fileChooser.getSelectedFile();//��ȡ�ļ�����
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				String s = null;
				while ((s = bufferedReader.readLine()) != null) {//������
					textArea.append(s + "\n");//������δ�������������������ݡ�
				}
				bufferedReader.close();//�������ر�
			} catch (FileNotFoundException e1) {
				
				System.out.println("û���ҵ��ļ�");
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
	}

	// �ļ����淽��
	public void save() {
		JFileChooser fileChooser = new JFileChooser();// �ļ��б�
		int result = fileChooser.showSaveDialog(this);// ��������
		if (result == JFileChooser.APPROVE_OPTION)// ���ļ�
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
	
	//��ʼ������
	public void init() {
		panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		//panel1.setBounds(0, 0, 400, 370);
		textArea = new JTextArea(30, 40);
		textArea.addKeyListener(this);
		scrollPane1 = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//��ֱ������һֱ��ʾ��ˮƽ��������Ҫʱ��ʾ
		panel1.add(scrollPane1, BorderLayout.CENTER);
		add(panel1);

		menu_file = new JMenu("�ļ�(F)");
		menu_file.setMnemonic('F');
		menu_edit = new JMenu("�༭(E)");
		menu_edit.setMnemonic('E');
		menu_edit.addMenuListener(this);
		menu_format = new JMenu("��ʽ(O)");
		menu_format.setMnemonic('O');
		menu_view = new JMenu("�鿴(V)");
		menu_view.setMnemonic('V');
		menu_help = new JMenu("����(H)");
		menu_help.setMnemonic('H');

		menuItem_new = new JMenuItem("�½�(N)");
		menuItem_new.setMnemonic('N');
		menuItem_new.setAccelerator(KeyStroke.getKeyStroke("control N"));//���ÿ�ݼ�����
		menuItem_new.addActionListener(this);

		menuItem_open = new JMenuItem("��(O)");
		menuItem_open.setMnemonic('O');
		menuItem_open.setAccelerator(KeyStroke.getKeyStroke("control O"));//���ÿ�ݼ�����
		menuItem_open.addActionListener(this);

		menuItem_save = new JMenuItem("����(S)");
		menuItem_save.setMnemonic('S');
		menuItem_save.setAccelerator(KeyStroke.getKeyStroke("control S"));//���ÿ�ݼ�����
		menuItem_save.addActionListener(this);

		menuItem_allsave = new JMenuItem("���Ϊ(A)");
		menuItem_allsave.addActionListener(this);

		menuItem_pagesetting = new JMenuItem("ҳ������(U)");
		menuItem_pagesetting.addActionListener(this);
		menuItem_pagesetting.setEnabled(false);

		menuItem_print = new JMenuItem("��ӡ(P)");
		menuItem_print.setMnemonic('P');
		menuItem_print.setAccelerator(KeyStroke.getKeyStroke("control P"));//���ÿ�ݼ�����
		menuItem_print.addActionListener(this);
		menuItem_print.setEnabled(false);

		menuItem_exit = new JMenuItem("�˳�(X)");
		menuItem_exit.addActionListener(this);

		menu_file.add(menuItem_new);
		menu_file.add(menuItem_open);
		menu_file.add(menuItem_save);
		menu_file.add(menuItem_allsave);
		menu_file.add(menuItem_pagesetting);
		menu_file.add(menuItem_print);
		menu_file.add(menuItem_exit);

		menuItem_cancel = new JMenuItem("����(U)");
		menuItem_cancel.addActionListener(this);
		menuItem_cancel.setAccelerator(KeyStroke.getKeyStroke("control Z"));

		menuItem_cut = new JMenuItem("����(T)");
		menuItem_cut.addActionListener(this);
		menuItem_cut.setAccelerator(KeyStroke.getKeyStroke("control X"));
		
		menuItem_copy = new JMenuItem("����(C)");
		menuItem_copy.addActionListener(this);
		menuItem_copy.setAccelerator(KeyStroke.getKeyStroke("control C"));

		menuItem_paste = new JMenuItem("ճ��(P)");
		menuItem_paste.addActionListener(this);
		menuItem_paste.setAccelerator(KeyStroke.getKeyStroke("control V"));
		
		menuItem_delete = new JMenuItem("ɾ��(L)");
		menuItem_delete.addActionListener(this);
		menuItem_delete.setAccelerator(KeyStroke.getKeyStroke("delete"));
		
		menuItem_find = new JMenuItem("����(F)");
		menuItem_find.addActionListener(this);
		menuItem_find.setAccelerator(KeyStroke.getKeyStroke("control F"));

		menuItem_nextfind = new JMenuItem("������һ��(N)");
		menuItem_nextfind.addActionListener(this);
		menuItem_nextfind.setAccelerator(KeyStroke.getKeyStroke("control F"));
		
		menuItem_replace = new JMenuItem("�滻(R)");
		menuItem_replace.addActionListener(this);
		menuItem_replace.setAccelerator(KeyStroke.getKeyStroke("control alt F"));

		menuItem_goto = new JMenuItem("ת��(G)");
		
		menuItem_allchoose = new JMenuItem("ȫѡ(A)");
		menuItem_allchoose.addActionListener(this);
		menuItem_allchoose.setAccelerator(KeyStroke.getKeyStroke("control A"));
		
		menuItem_timedate = new JMenuItem("ʱ��/����(D)");
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

		menuItem_autoline = new JCheckBoxMenuItem("�Զ�����(W)");// ���Ա�ѡ����ȡ��ѡ���Ĳ˵���
		menuItem_autoline.addActionListener(this);

		menuItem_font = new JMenuItem("����(F)...");
		menuItem_font.addActionListener(this);

		menu_format.add(menuItem_autoline);
		menu_format.add(menuItem_font);

		menuItem_statusbar = new JCheckBoxMenuItem("״̬��(S)");// ���Ա�ѡ����ȡ��ѡ���Ĳ˵���
		menuItem_statusbar.addActionListener(this);

		menu_view.add(menuItem_statusbar);
		menuItem_statusbar.setEnabled(false);

		menuItem_help = new JMenuItem("�鿴����(H)");
		menuItem_help.addActionListener(this);
		menuItem_help.setEnabled(false);
		

		menuItem_about = new JMenuItem("���ڼ��±�(A)");
		menuItem_about.addActionListener(this);

		menu_help.add(menuItem_help);
		menu_help.add(menuItem_about);

		// ��Ӳ˵���
		menuBar = new JMenuBar();

		menuBar.add(menu_file);
		menuBar.add(menu_edit);
		menuBar.add(menu_format);
		menuBar.add(menu_view);
		menuBar.add(menu_help);

		setJMenuBar(menuBar);

		//���ڲ���/�滻�Ĵ����еİ�ť
		
		button_begin_next.addActionListener(this);//��ʼ
		button_replace.addActionListener(this);//�滻
		button_allreplace.addActionListener(this);//ȫ���滻

		// ���ڼ��±��Ĵ���
		
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		button3 = new JButton("ok");

		label1 = new JLabel("Windows 7 �콢��");
		label2 = new JLabel("Microsoft Windows");
		label3 = new JLabel("�汾6.1 (�ڲ��汾 7601��Service Pack1)");
		label4 = new JLabel("��Ȩ���� 2009 Microsoft Corporation����������Ȩ����");
		label5 = new JLabel("Windows7 �콢�� ����ϵͳ�����û���������������������/������");
		label6 = new JLabel("�̱귨���������䲼��֪ʶ��Ȩ��������");
		label7 = new JLabel("����Mircrosoft �������������Ʒʹ��Ȩ���ڣ�");
		label8 = new JLabel("Win7_64��Win7_64");
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

		button3.addActionListener(this);// ok��ť�¼�
	}
	
	public static void main(String[] args) {
		TextBook text = new TextBook();
		text.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();//��ȡ�¼�Դ

		if (source == button3)// ���ڼ��±���ok�¼�
		{
			dialog.setVisible(false);
		}
		// �½��¼�
		if (source == menuItem_new) {
			if (!textArea.getText().equals("")) {
				int recuse = JOptionPane.showConfirmDialog(this,
						"�ļ��ѷ����ı䣬�Ƿ񱣴棿", "�����ļ�",JOptionPane.OK_CANCEL_OPTION);
				if (recuse == JOptionPane.OK_OPTION) {
					TextBook text = new TextBook();
					text.save();
				} else {
					textArea.setText("");
				}
			}
		}
		// ���ļ��¼�
		else if (source == menuItem_open) {
			if (textArea.getText().equals("")) {
				reader();
			}else {
				int recuse = JOptionPane.showConfirmDialog(this,
						"�ļ��ѷ����ı䣬�Ƿ񱣴棿", "�����ļ�", JOptionPane.OK_CANCEL_OPTION);
				if (recuse == JOptionPane.OK_OPTION) {
					save();

				} else {
					reader();
				}
			}
		}
		// �����¼�
		else if (source == menuItem_save) {
			save();
		}
		// ���Ϊ
		else if (source == menuItem_allsave) {
			save();
		}
		// �˳��¼�
		else if (source == menuItem_exit) {
			if (textArea.getText().equals("")) {
				System.exit(0);
			} else {
				int recuse = JOptionPane.showConfirmDialog(this,
						"�ļ��ѷ����ı䣬�Ƿ񱣴棿", "�����ļ�", JOptionPane.OK_CANCEL_OPTION);
				if (recuse == JOptionPane.OK_OPTION) {
					save();
				} else {
					System.exit(0);
				}
			}
		}

		else if (source == menuItem_cancel)// ����
		{
			textArea.setText(value);
		} else if (source == menuItem_copy)// ����
		{
			textArea.copy();
		} else if (source == menuItem_paste)// ճ��
		{
			textArea.paste();
		} else if (source == menuItem_cut)// ����
		{
			textArea.cut();
		} else if (source == menuItem_delete)// ɾ��
		{
			textArea.replaceSelection(null);
		} else if (source == menuItem_allchoose)// ȫѡ
		{
			textArea.selectAll();
		} else if (source == menuItem_replace)// �滻
		{
			JFrame frame_replace = new JFrame("�滻");
			value = textArea.getText();
			GridLayout gridLayout = new GridLayout(3, 3);
			JLabel label1 = new JLabel("��������:");
			JLabel label2 = new JLabel("�滻Ϊ:");
			frame_replace.setLayout(gridLayout);
			frame_replace.add(label1);
			frame_replace.add(textField_find);//���ң����滻�����������
			frame_replace.add(button_begin_next);//��ʼ
			frame_replace.add(label2);
			frame_replace.add(textField_replace);//�滻�����������
			frame_replace.add(button_replace);//�滻
			JLabel label3 = new JLabel();//������ռ�ռ�
			JLabel label4 = new JLabel();//������ռ�ռ�
			frame_replace.add(label3);
			frame_replace.add(label4);
			frame_replace.add(button_allreplace);//ȫ���滻

			frame_replace.setBounds(300, 300, 300, 120);//λ�úʹ�С��x,y,width,height)
			frame_replace.setResizable(false);//���ô��岻�ɸı��С
			frame_replace.setVisible(true);//��ʾ����
			frame_replace.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����ر�ʱ�Զ����ز��ͷŸô���
		}
		else if ("�滻" == e.getActionCommand()) {
			value = textArea.getText();
			String temp = textField_find.getText();
			int s = value.indexOf(temp, start);//���ַ�������λ�õ�����
			if ( value.indexOf(temp, start)!= -1) {
				textArea.setSelectionStart(s);//�������λ��
				textArea.setSelectionEnd(s + temp.length());//�����յ�λ��(����յ���趨��Ϊ���ñ�ѡ���ַ������ڸ���״̬��
				textArea.setSelectedTextColor(Color.WHITE);
				start = s + 1;
				textArea.replaceSelection(textField_replace.getText());
			}
			else {
				JOptionPane.showMessageDialog(frame, "�������!", "��ʾ", 0, null);
				start = 0;
				frame.dispose();//�ͷŴ�����ռ����Ļ��Դ
			}
		} else if ("ȫ���滻" == e.getActionCommand())// ȫ���滻�¼�
		{
			String temp = textArea.getText();
			temp = temp.replaceAll(textField_find.getText(), textField_replace.getText());
			textArea.setText(temp);
		} else if (source == menuItem_find || source == menuItem_nextfind)// ����
		{
			value = textArea.getText();
			frame.add(textField_find, BorderLayout.CENTER);
			frame.add(button_begin_next, BorderLayout.SOUTH);
			frame.setBounds(300, 300, 200, 100);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else if ("��ʼ" == e.getActionCommand()|| "��һ��" == e.getActionCommand())// ��ť����
		{
			value = textArea.getText();
			String temp = textField_find.getText();
			int s = value.indexOf(temp, start);
			if (value.indexOf(temp, start) != -1) {
				textArea.setSelectionStart(s);
				textArea.setSelectionEnd(s + temp.length());
				textArea.setSelectedTextColor(Color.WHITE);
				start = s + 1;
				button_begin_next.setText("��һ��");
			} else {
				JOptionPane.showMessageDialog(frame, "�������!", "��ʾ", 0, null);
				start = 0;
				frame.dispose();//�ͷŴ���ռ����Ļ��Դ
			}
		} 
		else if (source == menuItem_timedate )// ʱ���趨
		{
			value = textArea.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("HH��mm y\\M\\d  E ");//y��M��d�� E�ܼ� H0-24ʱ m�� s��
			Date date = new Date();
			String s = sdf.format(date);
			textArea.setText(value + s);
		}
		else if (source == menuItem_font)// ��������
		{
			ArtFont art = new ArtFont();
			art.setText(this);
			art.setVisible(true);
		} 
		else if (source == menuItem_autoline)// �Զ�����
		{
			if (!menuItem_autoline.getState()) {//�Զ�����δ��ѡ��
				textArea.setLineWrap(false);//���Զ�����
			} else {
				textArea.setLineWrap(true);//�Զ�����
			}

		} else if (source == menuItem_about)// ���ڼ��±�
		{
			dialog.setVisible(true);
		}
	}
	
	public void windowClosing(WindowEvent e)// �رմ����¼�
	{
		if (textArea.getText().equals("")) {
			System.exit(0);
		} else {
			int recuse = JOptionPane
					.showConfirmDialog(this, "�ļ��ѷ����ı䣬�Ƿ񱣴棿", "�����ļ�",
							JOptionPane.OK_CANCEL_OPTION);
			if (recuse == JOptionPane.OK_OPTION) {
				save();
			} else {
				System.exit(0);
			}
		}
		System.out.println("�ر�");
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
	//������һ��Ϊ�������������ĺ���
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
