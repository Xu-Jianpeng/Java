package TextViewer2;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyVetoException;

import javax.swing.*;

public class TextViewer2 extends JFrame implements ActionListener{
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem openItem,closeItem,exitItem;
	JDesktopPane deskPane;
	JInternalFrame contentFrame;
	JTextArea displayArea;
	public TextViewer2() {
		super("文件浏览器");
		Container container=getContentPane();
		deskPane=new JDesktopPane();
		container.add(deskPane);
		createMenu();
		setJMenuBar(menuBar);
		setSize(400,300);
		setVisible(true);
	}
	public void createMenu(){
		menuBar=new JMenuBar();
		fileMenu=new JMenu("文件");
		openItem=new JMenuItem("打开");
		openItem.addActionListener(this);
		closeItem=new JMenuItem("关闭");
		closeItem.addActionListener(this);
		exitItem=new JMenuItem("退出");
		exitItem.addActionListener(this);
		fileMenu.add(openItem);
		fileMenu.add(closeItem);
		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==openItem){
			JFileChooser filechooser=new JFileChooser();
			filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int result=filechooser.showOpenDialog(filechooser);
        
			if(result==JFileChooser.CANCEL_OPTION) return;
			File fileName=filechooser.getSelectedFile();
       
			if(fileName.isFile())
				readFileContent(fileName);
			else
				JOptionPane.showMessageDialog(this,"非法的文件名称","警告",JOptionPane.WARNING_MESSAGE);
        	}
        	else if(e.getSource()==closeItem){
        		try {
					contentFrame.setClosed(true);
				} catch (PropertyVetoException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
        	}
        	else if(e.getSource()==exitItem){
        		System.exit(0);
        	}
      	}
	
	public void readFileContent(File fileName){
		if(fileName.isFile()){
			contentFrame=new JInternalFrame("文件内容",true,true,true,true);
			displayArea=new JTextArea(10,20);
			displayArea.setText("hello");
			contentFrame.getContentPane().add(new JScrollPane(displayArea));
			contentFrame.setVisible(true);
			contentFrame.pack();
			deskPane.add(contentFrame);
				try{
					BufferedReader output=new BufferedReader(new FileReader(fileName));
					StringBuffer buffer=new StringBuffer();
					String text;
					while((text=output.readLine())!=null);
					buffer.append(text+"\n");
					output.close();
					displayArea.setText(buffer.toString());
				}catch(IOException ex){
				}
			}
		}
		
		public static void main(String[] args){
			TextViewer2 textviewer=new TextViewer2();
			textviewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	