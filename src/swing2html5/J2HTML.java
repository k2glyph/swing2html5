package swing2html5;

import java.awt.Font;

import javax.swing.JComponent;

public abstract class J2HTML {
	
	public String fontStyle(JComponent comp){		
		String fontStyle = "";
		Font font = comp.getFont();
		
		//font family
		fontStyle +="font-family:'"+font.getFamily()+"';";
		
		//font size
		fontStyle +="font-size:"+font.getSize()+"px;";
		
		if(font.isItalic()){
			fontStyle += "font-style:italic;";
		}
		
		if(font.isBold()){
			fontStyle += "font-weight:bold;";
		}
		
		System.out.println(fontStyle);
		
		return fontStyle;
	}
	
	public abstract String getHTML(JComponent comp);

}
