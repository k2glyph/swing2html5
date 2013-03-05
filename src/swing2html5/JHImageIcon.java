package swing2html5;

import java.net.URL;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class JHImageIcon extends ImageIcon {
	
	private String filename;
	private URL url;
	
	public JHImageIcon(String filename) {
		super(filename);		
		this.filename = filename;		
	}
	
	public JHImageIcon(URL url){
		super(url);
		this.url = url;
	}
	
	public String getFilename(){
		return filename;
	}
	
	public URL getURL(){
		return url;
	}	
	
}
