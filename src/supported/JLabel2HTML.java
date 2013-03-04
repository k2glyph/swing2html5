package supported;

import javax.swing.JComponent;
import javax.swing.JLabel;

import swing2html5.J2HTML;
import swing2html5.JHImageIcon;

public class JLabel2HTML extends J2HTML {
	
	public String getHTML(JComponent comp) {
		JLabel l = (JLabel)comp;
		
		String button = "";
		String imgStyle = "";
		if(l.getIcon() != null){
			JHImageIcon img = (JHImageIcon) l.getIcon();
			imgStyle += "background: url("+img.getFilename()+") ;background-repeat:no-repeat;background-position:center center;";
		}
		
		String txt = l.getText();
		
		if(txt == null){
			txt = "";
		}
		
		
		
		button += "<p style=\"position:absolute;top:"+l.getY()+"px;left:"+l.getX()+"px;"+imgStyle+";width:"+l.getWidth()+";height:"+l.getHeight()+"\">"+txt;
		
		if(l.getIcon() != null){
			JHImageIcon img = (JHImageIcon) l.getIcon();
			
			button+="\n<img src=\""+ img.getFilename() +"\"";
		}
		
		button+="</p>\n";
		return button;
	}
 
}
