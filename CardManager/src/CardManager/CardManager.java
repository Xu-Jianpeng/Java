package CardManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagLayout.*;
import java.awt.GridBagConstraints.*;


public class CardManager extends JFrame{
	JLabel nameLabel,sexLabel,titleLabel,unitLabel;
	JLabel addressLabel,telLabel1,telLabel2,mobileLabel,faxLabel,emailLabel;
	JTextField nameTxt,unitTxt,addressTxt;
	JTextField telTxt1,telTxt2,mobileTxt,faxTxt,emailTxt;
	JRadioButton sexBtn1,sexBtn2;
	JComboBox titleBx;
	JButton okBtn,cancelBtn;
	
	public CardManager() {
		super("名片录入管理");
		Container c = getContentPane();
		JPanel centerPanel = new JPanel();
		//GridBagLayout layout = new GridBagLayout();
		//GridBagConstraints constraints = new GridBagConstraints();
		//centerPanel.setLayout(layout);
		nameLabel = new JLabel("姓名");
		nameTxt = new JTextField(10);
		centerPanel.add(nameLabel);
		centerPanel.add(nameTxt);
		/*constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=4;                                             
        constraints.gridheight=4;  */          
      //  gridBagLayout.setConstraints(component1, constraints);

		
		sexLabel = new JLabel("性别");
		sexBtn1 = new JRadioButton("男");
		sexBtn2 = new JRadioButton("女");
		ButtonGroup group = new ButtonGroup();
		group.add(sexBtn1);
		group.add(sexBtn2);
		centerPanel.add(sexLabel);
		centerPanel.add(sexBtn1);
		centerPanel.add(sexBtn2);
		
		titleLabel = new JLabel("称谓");
		String title[]= {"总裁","总经理","经理","主任","处长","院长","校长","科长","教授","讲师"};
		titleBx = new JComboBox(title);
		titleBx.setMaximumRowCount(5);
		centerPanel.add(titleLabel);
		centerPanel.add(titleBx);
		unitLabel = new JLabel("工作单位");
		unitTxt = new JTextField(30);
		centerPanel.add(unitLabel);
		centerPanel.add(unitTxt);
		addressLabel = new JLabel("工作地址");
		addressTxt = new JTextField(30);
		centerPanel.add(addressLabel);
		centerPanel.add(addressTxt);
		
		telLabel1 = new JLabel("电话");
		telTxt1 = new JTextField(15);
		centerPanel.add(telLabel1);
		centerPanel.add(telTxt1);
		telLabel2 = new JLabel("电话");
		telTxt2 = new JTextField(15);
		centerPanel.add(telLabel2);
		centerPanel.add(telTxt2);
		
		mobileLabel = new JLabel("手机");
		mobileTxt = new JTextField(15);
		centerPanel.add(mobileLabel);
		centerPanel.add(mobileTxt);
		
		faxLabel = new JLabel("传真");
		faxTxt = new JTextField(15);
		centerPanel.add(faxLabel);
		centerPanel.add(faxTxt);
		
		emailLabel = new JLabel("E-mail");
		emailTxt = new JTextField(32);
		centerPanel.add(emailLabel);
		centerPanel.add(emailTxt);
		
		JPanel sPanel = new JPanel();
		okBtn = new JButton("确定");
		cancelBtn = new JButton("取消");
		cancelBtn.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  if(e.getSource() == cancelBtn) {System.exit(0);
				  }
			  }
		});
		sPanel.add(okBtn);
		sPanel.add(cancelBtn);
		
		c.setLayout(new BorderLayout());
		c.add(centerPanel,BorderLayout.CENTER);
		c.add(sPanel,BorderLayout.SOUTH);
		
		setSize(430,250);
		setVisible(true);
	}
	
	
	
	public static void main(String args[]) {
		CardManager cm = new CardManager();
		cm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
