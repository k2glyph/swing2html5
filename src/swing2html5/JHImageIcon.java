package swing2html5;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class JHImageIcon extends ImageIcon {
	
	private String filename;
	
	public JHImageIcon(String filename) {
		super(filename);
		this.filename = filename;
		
	}
	
	public String getFilename(){
		return filename;
	}
}
