package supported;

import javax.swing.JComponent;
import javax.swing.JTextArea;

import swing2html5.J2HTML;

public class JTextArea2HTML extends J2HTML {

	@Override
	public String getHTML(JComponent comp) {
		String result = "";
		JTextArea area = (JTextArea)comp;
		
		result = "<textarea style=\"position:absolute;width:"+area.getWidth()+"px;height:"+area.getHeight()+"px;top:"+area.getY()+"px;left:"+area.getX()+"px;"+fontStyle(area)+"\">";                 
        result +="</textarea>";
		
		return result;
	}

}
