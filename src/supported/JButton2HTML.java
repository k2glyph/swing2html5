package supported;

import javax.swing.JButton;
import javax.swing.JComponent;

import swing2html5.J2HTML;
import swing2html5.JHImageIcon;

public class JButton2HTML extends J2HTML {

	@Override
	public String getHTML(JComponent comp) {
		JButton b = (JButton)comp;
		String button = "";
		String imgStyle = "";
		
		if(b.getIcon() != null){
			JHImageIcon img = (JHImageIcon) b.getIcon();
			imgStyle += "background: url("+img.getFilename()+") no-repeat";
		}
		
		//String color = b.getForeground();
		
		button += "<button type=\"button\" style=\"position:absolute;width:"+b.getWidth()+"px;height:"+b.getHeight()+"px;top:"+b.getY()+"px;left:"+b.getX()+"px;"+imgStyle+";"+fontStyle(comp)+"\">"+b.getText();
		
		
		
		button+="</button>\n";		
		
		return button;
	}

}
