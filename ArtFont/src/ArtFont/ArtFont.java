package ArtFont;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArtFont extends JFrame implements ActionListener {
	JComboBox fontType,fontSize;
	JCheckBox boldBx;
	JCheckBox italicBx;
	JButton colorBtn;
	String[] fontNames;
	String[] fontSizes;
	JLabel label;
	JTextField inputText;
	JTextArea txtArea;
	JPanel fontPanel;
	JPanel showPanel;
	Font font;
	int boldStyle,italicStyle,underlineStyle;
	int fontSizeStyle;
	String fontNameStyle;
	Color colorStyle = Color.black;
	public ArtFont() {
		super("字体设置");
		
		boldStyle=0;
		italicStyle=0;
		underlineStyle=0;
		fontSizeStyle=10;
		fontNameStyle="宋体";
		font=new Font(fontNameStyle,boldStyle+italicStyle,fontSizeStyle);
		fontPanel=new JPanel();
		fontPanel.setLayout(new FlowLayout());
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		fontNames=ge.getAvailableFontFamilyNames();
		
		fontType=new JComboBox(fontNames);
		fontType.setEditable(false);
		fontType.setMaximumRowCount(10);
		fontType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//程序段1
				fontNameStyle = (String) fontType.getSelectedItem();
				font = new Font(fontNameStyle,boldStyle+italicStyle,fontSizeStyle);
				txtArea.setFont(font);
				txtArea.setText(String.valueOf(inputText.getText()).toString());
			}
		});
		
		fontSizes=new String[63];
		for (int i=0;i<63;i++) {
			fontSizes[i]=Integer.toString((i+10));
		}
		fontSize=new JComboBox(fontSizes);
		fontSize.setEditable(false);
		fontSize.setMaximumRowCount(10);
		fontSize.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//程序段2
				fontSizeStyle = Integer.parseInt((String)fontSize.getSelectedItem());
				font = new Font(fontNameStyle,boldStyle+italicStyle,fontSizeStyle);
				txtArea.setFont(font);
				txtArea.setText(String.valueOf(inputText.getText()).toString());
			}
		});
		
		boldBx=new JCheckBox("粗体");
		boldBx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//程序段3
				if(boldBx.isSelected()) boldStyle = Font.BOLD;
				else boldStyle = 0;
				font = new Font(fontNameStyle,boldStyle+italicStyle,fontSizeStyle);
				txtArea.setFont(font);
				txtArea.setText(String.valueOf(inputText.getText()).toString());
			}
		});
		
		italicBx=new JCheckBox("斜体");
		italicBx.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//程序段4
				if(italicBx.isSelected()) italicStyle = Font.ITALIC;
				else italicStyle = 0;
				font = new Font(fontNameStyle,boldStyle+italicStyle,fontSizeStyle);
				txtArea.setFont(font);
				txtArea.setText(String.valueOf(inputText.getText()).toString());
			}
		});

		colorBtn=new JButton("颜色");
		colorBtn.addActionListener(this);
		/*
		 colorBtn.addActionListener(new ActionListener(){
			if(e.getSource()==colorBtn){//改变颜色
	        colorStyle=JColorChooser.showDialog(this,"选择字体颜色",colorStyle);
	        colorBtn.setForeground(colorStyle);
	        txtArea.setForeground(colorStyle);
		    } 
	    });*/
		fontPanel.add(fontType);
		fontPanel.add(fontSize);
		fontPanel.add(boldBx);
		fontPanel.add(italicBx);
		fontPanel.add(colorBtn);
		
		label=new JLabel("输入");
		inputText=new JTextField(40);
		inputText.addActionListener(this);
		txtArea=new JTextArea(10,100);
		txtArea.setFont(font);
		showPanel=new JPanel();
		showPanel.add(label);
		showPanel.add(inputText);
		showPanel.setLayout(new FlowLayout());
		showPanel.add(new JScrollPane(txtArea));
		
		Container container=getContentPane();
		container.setLayout(new BorderLayout());
		container.add(fontPanel,BorderLayout.NORTH);
		container.add(showPanel,BorderLayout.CENTER);
		setSize(600,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==colorBtn) {
			colorStyle=JColorChooser.showDialog(this, "选择字体颜色",colorStyle);
			colorBtn.setForeground(colorStyle);
			txtArea.setForeground(colorStyle);
		}
		else if(e.getSource()==inputText) {
			txtArea.setText(inputText.getText());
		}
	}
	public static void main(String args[]) {
		try {
			String lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			UIManager.setLookAndFeel(lookAndFeel);
			}catch(Exception e) { }
		ArtFont artFont=new ArtFont();
		artFont.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
