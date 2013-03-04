import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import swing2html5.JHImageIcon;
import swing2html5.Swing2HTML5;


@SuppressWarnings("serial")
public class Frame extends JFrame {
	
	public Frame(){
		this.setSize(400, 400);		
		this.setTitle("swing2HTML5");
		this.setLayout(null);
		this.getContentPane().setBackground(Color.GREEN);
		
		JButton b1 = new JButton("Kevin");
		b1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		b1.setForeground(Color.red);
		//b1.setBackground(Color.YELLOW);
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b1.setBounds(50, 200, 100, 30);
		this.add(b1);
		
		JButton b2 = new JButton(new JHImageIcon("man.png"));
		b2.setBounds(0, 0, 40, 40);
		this.add(b2);
		
		
		JLabel label = new JLabel("Min Label");
		label.setBounds(100, 0, 100, 40);
		this.add(label);		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
		
		try {
			Swing2HTML5.compileJFrame(frame, "output.html");
			System.out.println("HTML5 page compiled");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
