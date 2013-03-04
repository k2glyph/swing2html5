package supported;

import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JComponent;

import swing2html5.J2HTML;
import swing2html5.JHImageIcon;
import swing2html5.Swing2HTML5;

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
		
		String color = "color:#"+Swing2HTML5.toHex(b.getForeground())+";";
		String backgroundColor = "background-color:#"+Swing2HTML5.toHex(b.getBackground())+";";
		String cursor = "cursor:"+getCursor(b.getCursor())+";";		
		
		button += "<button type=\"button\" style=\"position:absolute;width:"+b.getWidth()+"px;height:"+b.getHeight()+"px;top:"+b.getY()+"px;left:"+b.getX()+"px;"+imgStyle+";"+fontStyle(comp)+";"+color+";"+backgroundColor+";"+cursor+"\">"+b.getText();
						
		button+="</button>\n";		
		
		return button;
	}
	
	
	private String getCursor(Cursor c){
		String result = "default";
		
		if(c.getType() == Cursor.CROSSHAIR_CURSOR){
			result = "crosshair";
		}
		
		
		return result;
		
	}

}
