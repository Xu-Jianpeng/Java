/**
 * 
 */
/**
 * @author lenovo
 *
 */
package beatbox;
import javax.swing.*;
import java.awt.*;

public class TwoButtons {
	
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args) {
		TwoButtons gui = new TwoButtons();
		gui.go();
	}
	
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("Change Label");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Change Circle");
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("I'm a label");
		MyDrawPanel drawpanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawpanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	class LabelListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			label.setText("Ouch!");
		}
	}
	
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}
	
}


class MyDrawPanel extends JPanel{
	public void paintComponent(Graapplicablehics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Color startColor = new Color((int)(Math.random()*225),(int)(Math.random()*225),(int)(Math.random()*225));
		Color endColor = new Color((int)(Math.random()*225),(int)(Math.random()*225),(int)(Math.random()*225));
		
		GradientPaint gradient = new GradientPaint(70,70,startColor,150,150,endColor);
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 150, 150);
	}
}