package supported;

import javax.swing.JComponent;
import javax.swing.JTextField;

import swing2html5.J2HTML;

public class JTextField2HTML extends J2HTML {

	public String getHTML(JComponent comp) {
		JTextField field = (JTextField) comp;
		String result= "<input type = \"text\" style=position:absolute;width:"+field.getWidth()+"px;height:"+field.getHeight()+"px;top:"+field.getY()+"px;left:"+field.getX()+"px;"+"/>";
		
		
		
		return result;
	}

}
