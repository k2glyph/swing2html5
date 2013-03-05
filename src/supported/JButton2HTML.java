package supported;

import java.awt.Cursor;
import java.net.URL;

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
			URL url = img.getURL();
			if(img.getFilename() != ""){
				imgStyle += "background: url("+img.getFilename()+") no-repeat";
			}else if(url.toString() != ""){
				imgStyle += "background: url("+url+") no-repeat";
			}			
		}
		
		String color = "color:#"+Swing2HTML5.toHex(b.getForeground())+";";
		String backgroundColor = "background-color:#"+Swing2HTML5.toHex(b.getBackground())+";";
		String cursor = "cursor:"+getCursor(b.getCursor())+";";
		
		button += "<button type=\"button\" style=\"position:absolute;width:"+b.getWidth()+"px;height:"+b.getHeight()+"px;top:"+b.getY()+"px;left:"+b.getX()+"px;"+imgStyle+";"+fontStyle(comp)+";"+color+";"+backgroundColor+";"+cursor+"\">"+b.getText();
								
		button+="</button>\n";				
		return button;
	}
	
	
	/**This method takes a Cursor as a parameter, and returns<br />
	 * the css equivalent in the form of a String
	 * 
	 * @param Curcor 
	 * @return String css-property
	 */
	private String getCursor(Cursor cur){
		String result = "default";
		
		if(cur.getType() == Cursor.CROSSHAIR_CURSOR){
			result = "crosshair";
		}else if(cur.getType() == Cursor.HAND_CURSOR){
			result ="hand";
		}else if(cur.getType() == Cursor.MOVE_CURSOR){
			result = "move";
		}else if(cur.getType() == Cursor.TEXT_CURSOR){
			result = "text";
		}else if(cur.getType() == Cursor.WAIT_CURSOR){
			result = "wait";
		}else if(cur.getType() == Cursor.N_RESIZE_CURSOR){		
			result = "n-resize";
		}else if(cur.getType() == Cursor.NE_RESIZE_CURSOR){
			result = "ne-resize";
		}else if(cur.getType() == Cursor.E_RESIZE_CURSOR){
			result = "e-resize";
		}else if(cur.getType() == Cursor.SE_RESIZE_CURSOR){
			result = "se-resize";
		}else if(cur.getType() == Cursor.S_RESIZE_CURSOR){
			result = "s-resize";
		}else if(cur.getType() == Cursor.SW_RESIZE_CURSOR){
			result = "sw-resize";
		}else if(cur.getType() == Cursor.W_RESIZE_CURSOR){
			result = "w-resize";
		}else if(cur.getType() == Cursor.NW_RESIZE_CURSOR){
			result = "nw-resize";
		}else if(cur.getType() == Cursor.CUSTOM_CURSOR){
			result = "url("+cur.getName()+"),default";
		}
		
		return result;		
	}

}
