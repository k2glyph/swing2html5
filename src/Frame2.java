import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import swing2html5.JHImageIcon;
import swing2html5.Swing2HTML5;


@SuppressWarnings("serial")
public class Frame2 extends JFrame {
	
	
	public Frame2(){
		JButton b1 = new JButton("Kevin!");
		this.setSize(400, 400);
		this.add(b1,BorderLayout.NORTH);
		
		
		JLabel label = new JLabel(new JHImageIcon("man.png"));
		this.add(label,BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Frame2 frame = new Frame2();
		frame.setVisible(true);
		
		
		try {
			Swing2HTML5.compileJFrame(frame, "output2.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
