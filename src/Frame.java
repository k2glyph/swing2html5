import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		b1.setForeground(Color.BLACK);

		b1.setBounds(50, 200, 100, 30);
		this.add(b1);
		
		JButton b2 = new JButton(new JHImageIcon("man.png"));
		b2.setBounds(0, 0, 40, 40);
		this.add(b2);

		JLabel label = new JLabel("Min Label");
		label.setFont(new Font("Times New Roman",Font.ITALIC,14));
		label.setBounds(100, 0, 100, 40);
		this.add(label);		
		
		JTextField text = new JTextField("Test");
		text.setBounds(150, 150, 100, 20);
		text.setFont(new Font("Times New Roman",Font.BOLD,26));
		this.add(text);
		
		JTextArea area = new JTextArea("Test område");
		area.setFont(new Font("Times New Roman",Font.PLAIN,22));
		area.setBounds(0, 200, 200, 200);
		this.add(area);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);

		try {
			Swing2HTML5.compileJFrame(frame, "output.html");
			System.out.println("HTML5 page compiled");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
