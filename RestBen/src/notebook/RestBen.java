/**
 * ���±�����
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
	private JMenu jm_file, jm_eist, jm_oprnt, jm_view, jm_help;//���˵���
	private JMenuItem jmi_new, jmi_open, jmi_save, jmi_allsave, jmi_ymsz,
			jmi_dy, jmi_exit;//���ļ��������˵���
	private JMenuItem jmi_cancel, jmi_cut, jmi_copy, jmi_paste, jmi_delete, jmi_find, jmi_nextfind, jmi_replace,
			jmi_goto, jmi_allchoose, jmi_timedate;//���༭�������˵���
	private JMenuItem jmi_zt;//����ʽ�������˵�����������
	private JMenuItem jmi_help, jmi_gyjsb;//�������������˵���

	private JMenuBar jmb;//�����˵���jmb
	private JSeparator jse1, jse2, jse3, jse4, jse5, jse6;
	private JPanel jp1;//�������jp1
	JDialog jd = new JDialog(this, "����  ���±�");//�Զ���Ի���
	JTextArea jta;//�����ı�������
	JButton jb3;//������ok
	int y = 1;

	public JTextArea getJta() {
		return jta;
	}
//�������
	private JScrollPane jsp1;//��������ӿڡ���ѡ�Ĵ�ֱ��ˮƽ�������Լ���ѡ���к��б����ӿ�
	private JToolBar jtb;//������
	JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9;
	//private JRadioButton jrb;
	//private ButtonGroup bg;
	private String value;
	private int start = 0;
	private JFrame jf = new JFrame("����");

	private JButton jb = new JButton("��ʼ");
	private JTextField jtf = new JTextField(15);
	private JTextField jt = new JTextField(15);
	private JButton jbt = new JButton("�滻Ϊ");
	private JButton jba = new JButton("ȫ���滻");
	TestFileStyle tfs;
	JCheckBoxMenuItem jmi_ztl;
	JCheckBoxMenuItem jmi_zdhh;

	public RestBen() {
		/**
		 * ���Ľ�����Ϊwindows��
		 */
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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

		JFileChooser file = new JFileChooser();// �ļ��б�
		int result = file.showOpenDialog(this);// ��������
		if (result == file.APPROVE_OPTION)// ���ļ�
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
				System.out.println("û���ҵ��ļ�");
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	// �ļ����淽��
	public void save() {
		JFileChooser file = new JFileChooser();// �ļ��б�
		int result = file.showSaveDialog(this);// ��������
		if (result == file.APPROVE_OPTION)// ���ļ�
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
	
	//��ʼ������
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

		jm_file = new JMenu("�ļ�(F)");
		jm_file.setMnemonic('F');
		jm_eist = new JMenu("�༭(E)");
		jm_eist.setMnemonic('E');
		jm_eist.addMenuListener(this);
		jm_oprnt = new JMenu("��ʽ(O)");
		jm_oprnt.setMnemonic('O');
		jm_view = new JMenu("�鿴(V)");
		jm_view.setMnemonic('V');
		jm_help = new JMenu("����(H)");
		jm_help.setMnemonic('H');

		jmi_new = new JMenuItem("�½�(N)");
		jmi_new.setMnemonic('N');
		jmi_new.setAccelerator(KeyStroke.getKeyStroke("control N"));
		jmi_new.addActionListener(this);

		jmi_open = new JMenuItem("��(O)");
		jmi_open.setMnemonic('O');
		jmi_open.setAccelerator(KeyStroke.getKeyStroke("control O"));
		jmi_open.addActionListener(this);

		jmi_save = new JMenuItem("����(S)");
		jmi_save.setMnemonic('S');
		jmi_save.setAccelerator(KeyStroke.getKeyStroke("control S"));
		jmi_save.addActionListener(this);

		jmi_allsave = new JMenuItem("���Ϊ(A)");

		jmi_allsave.addActionListener(this);

		jmi_ymsz = new JMenuItem("ҳ������(U)");
		jmi_ymsz.addActionListener(this);

		jmi_dy = new JMenuItem("��ӡ(P)");
		jmi_dy.setMnemonic('P');
		jmi_dy.setAccelerator(KeyStroke.getKeyStroke("control P"));//���ü�����
		jmi_dy.addActionListener(this);

		jmi_exit = new JMenuItem("�˳�(X)");
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

		jmi_cancel = new JMenuItem("����(U)");
		jmi_cancel.addActionListener(this);

		jmi_cut = new JMenuItem("����(X)");
		jmi_cut.addActionListener(this);

		jmi_copy = new JMenuItem("����(C)");
		jmi_copy.addActionListener(this);

		jmi_paste = new JMenuItem("ճ��(V)");
		jmi_paste.addActionListener(this);

		jmi_delete = new JMenuItem("ɾ��(N)");
		jmi_delete.addActionListener(this);

		jmi_find = new JMenuItem("����(F)");
		jmi_find.addActionListener(this);

		jmi_nextfind = new JMenuItem("������һ��(N)");
		jmi_nextfind.addActionListener(this);

		jmi_replace = new JMenuItem("�滻(R)");
		jmi_replace.addActionListener(this);

		jmi_goto = new JMenuItem("ת��(G)");
		jmi_allchoose = new JMenuItem("ȫѡ(A)");
		jmi_allchoose.addActionListener(this);

		jmi_timedate = new JMenuItem("ʱ��/����(D)");
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

		jmi_zdhh = new JCheckBoxMenuItem("�Զ�����(W)");// ���Ա�ѡ����ȡ��ѡ���Ĳ˵���
		jmi_zdhh.addActionListener(this);

		jmi_zt = new JMenuItem("����(F)");
		jmi_zt.addActionListener(this);

		jm_oprnt.add(jmi_zdhh);
		jm_oprnt.add(jmi_zt);

		jmi_ztl = new JCheckBoxMenuItem("״̬��(S)");// ���Ա�ѡ����ȡ��ѡ���Ĳ˵���
		jmi_ztl.addActionListener(this);

		jm_view.add(jmi_ztl);

		jmi_help = new JMenuItem("��������(H)");
		jmi_help.addActionListener(this);

		jmi_gyjsb = new JMenuItem("���ڼ��±�(A)");
		jmi_gyjsb.addActionListener(this);

		jm_help.add(jmi_help);
		jm_help.add(jse6);
		jm_help.add(jmi_gyjsb);

		// ��Ӳ˵���

		jmb = new JMenuBar();

		jmb.add(jm_file);
		jmb.add(jm_eist);
		jmb.add(jm_oprnt);
		jmb.add(jm_view);
		jmb.add(jm_help);

		setJMenuBar(jmb);

		jtb = new JToolBar();// ״̬��
		jtb.setVisible(false);
		jl1 = new JLabel("");
		
		jtb.add(jl1);
		add(jtb, BorderLayout.SOUTH);
		

		// ���ڼ��±��Ĵ���

		jb.addActionListener(this);
		jbt.addActionListener(this);
		jba.addActionListener(this);

		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		jb3 = new JButton("ok");

		JLabel l = new JLabel("MICROSOFT ����������");
		jl2 = new JLabel("��Щ��������� Microsoft Corporation");
		jl3 = new JLabel("����֮���ɵ�Э�顣���Ķ���Щ��������ݡ�");
		jl4 = new JLabel("��Щ�������������������");
		jl5 = new JLabel("���а������������ո������ý�壨���У���");
		jl6 = new JLabel("��Щ����Ҳ������ Microsoft Ϊ������ṩ��");
		jl7 = new JLabel("�������������ݸ�����������������ȷʵ������");
		jl8 = new JLabel("�����������������Ӧ���á�");
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

		jb3.addActionListener(this);// ok��ť�¼�
		jta.addCaretListener(this);

	}

	public static void main(String[] args) {
		RestBen ben = new RestBen();
		ben.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();//��ȡ�¼�Դ

		if (e.getSource() == jb3)// ���ڼ��±���ok�¼�
		{

			jd.setVisible(false);
		}
		// �½��¼�
		if (source == jmi_new) {
			if (!jta.getText().equals("")) {

				int recuse = JOptionPane.showConfirmDialog(this,
						"�ļ��ѷ����ı䣬�Ƿ񱣴棿", "�����ļ�", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.OK_OPTION);
				if (recuse == JOptionPane.YES_NO_OPTION) {
					RestBen ben = new RestBen();
					ben.save();

				} else {
					jta.setText("");
				}
			}

		}
		// ���ļ��¼�
		else if (source == jmi_open) {
			if (jta.getText().equals("")) {

				reader();
			}

			else {
				int recuse = JOptionPane.showConfirmDialog(this,
						"�ļ��ѷ����ı䣬�Ƿ񱣴棿", "�����ļ�", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.OK_OPTION);
				if (recuse == JOptionPane.YES_NO_OPTION) {
					save();

				} else {
					reader();
				}
			}
		}
		// �����¼�
		else if (source == jmi_save) {
			save();
		}
		// ���Ϊ
		else if (source == jmi_allsave) {
			save();
		}
		// �˳��¼�
		else if (source == jmi_exit) {
			if (jta.getText().equals("")) {
				System.exit(0);
			} else {
				int recuse = JOptionPane.showConfirmDialog(this,
						"�ļ��ѷ����ı䣬�Ƿ񱣴棿", "�����ļ�", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.OK_OPTION);
				if (recuse == JOptionPane.YES_NO_OPTION) {
					save();
				} else {
					System.exit(0);
				}
			}
		}

		else if (source == jmi_cancel)// ����
		{
			jta.setText(value);
		} else if (source == jmi_copy)// ����
		{
			jta.copy();
		} else if (source == jmi_paste)// ճ��
		{
			jta.paste();
		} else if (source == jmi_cut)// ����
		{

			jta.cut();
		} else if (source == jmi_delete)// ɾ��
		{
			jta.replaceSelection(null);
		} else if (source == jmi_allchoose)// ȫѡ
		{
			jta.selectAll();
		} else if (source == jmi_replace)// �滻
		{
			JFrame jfc = new JFrame("�滻");
			value = jta.getText();
			GridLayout gl = new GridLayout(3, 3);
			JLabel jl1 = new JLabel("��������:");
			JLabel jl2 = new JLabel("�滻Ϊ:");
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

		else if ("�滻Ϊ" == e.getActionCommand()) {
			String temp = jtf.getText();
			int s = value.indexOf(temp, start);
			if (value.indexOf(temp, start) != -1) {
				jta.setSelectionStart(s);
				jta.setSelectionEnd(s + temp.length());
				jta.setSelectedTextColor(Color.GREEN);
				start = s + 1;
				jta.replaceSelection(jt.getText());
			} else {
				JOptionPane.showMessageDialog(jf, "�������!", "��ʾ", 0, null);
				jf.dispose();
			}
		} else if ("ȫ���滻" == e.getActionCommand())// ȫ���滻�¼�
		{
			String temp = jta.getText();
			temp = temp.replaceAll(jtf.getText(), jt.getText());
			jta.setText(temp);

		} else if (source == jmi_find || source == jmi_nextfind)// ����
		{
			value = jta.getText();
			jf.add(jtf, BorderLayout.CENTER);
			jf.add(jb, BorderLayout.SOUTH);

			jf.setBounds(300, 300, 200, 80);
			jf.setVisible(true);
			jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		}
		else if ("��ʼ" == e.getActionCommand()|| "��һ��" == e.getActionCommand())// ��ť����
		{

			String temp = jtf.getText();
			int s = value.indexOf(temp, start);
			if (value.indexOf(temp, start) != -1) {
				jta.setSelectionStart(s);
				jta.setSelectionEnd(s + temp.length());
				jta.setSelectedTextColor(Color.GREEN);
				start = s + 1;
				jb.setText("��һ��");

			} else {
				JOptionPane.showMessageDialog(jf, "�������!", "��ʾ", 0, null);
				jf.dispose();
			}
		} else if (jmi_timedate == source)// ʱ���趨
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��hh��mm:ss");
			Date date = new Date();
			String s = sdf.format(date);
			jta.setText(s);

		}

		else if (source == jmi_zt)// ��������
		{
			TestFileStyle fs = new TestFileStyle();
			fs.setR(this);
			fs.setVisible(true);
		} else if (source == jmi_zdhh)// �Զ�����
		{
			if (!jmi_zdhh.getState()) {//�Զ����б�ѡ��
				jta.setLineWrap(true);//�Զ�����
			} else {
				jta.setLineWrap(false);//���Զ�����
			}

		} else if (source == jmi_gyjsb)// ���ڼ��±�
		{
			jd.setVisible(true);

		} else if (source == jmi_ztl)// ״̬��
		{
			if (jmi_ztl.getState()) {
				jtb.setVisible(true);
				

			} else {
				jtb.setVisible(false);
			}
		}

	}

	@Override
	public void menuCanceled(MenuEvent e)// ����
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void menuDeselected(MenuEvent e)// ����
	{

	}

	@Override
	public void menuSelected(MenuEvent e)// ��ʾ�˵�
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
	public void windowClosing(WindowEvent e)// �رմ����¼�
	{

		if (jta.getText().equals("")) {
			System.exit(0);
		} else {
			int recuse = JOptionPane
					.showConfirmDialog(this, "�ļ��ѷ����ı䣬�Ƿ񱣴棿", "�����ļ�",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.OK_OPTION);
			if (recuse == JOptionPane.YES_NO_OPTION) {
				save();
			} else {
				System.exit(0);
			}
		}
		System.out.println("�ر�");

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
