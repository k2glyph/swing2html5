package swing2html5;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Swing2HTML5 {
	
	static String startHtml = "<!DOCTYPE HTML>\n<html>";
	static String endHtml = "</html>";	
	
	static JFrame frame;
	
	
	static HashMap<String,String> supportedTypes;
	
	
	static{
		supportedTypes = new HashMap<String,String>();
		String path = "bin/supported"; 

		String files;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles(); 

		for (int i = 0; i < listOfFiles.length; i++) 
		{

			if (listOfFiles[i].isFile()) 
			{
				files = listOfFiles[i].getName();
				String temp = files.substring(0, files.indexOf("2"));
				supportedTypes.put(temp, "supported."+files.substring(0, files.length()-6));
			}
		}
	}
	
		
	public static void compileJFrame(JFrame inFrame, String filename) throws IOException{
		PrintWriter writer = new PrintWriter(new File(filename));		
		frame = inFrame;
		writer.println(startHtml);
		writer.println(headTeag());
		writer.println(bodyTag());
		writer.println(endHtml);
		writer.flush();
		writer.close();		
	}
			
	public static String headTeag(){
		String result = "<meta charset=\"utf-8\" />\n";
		result += "<head><title>"+frame.getTitle()+"</title></head>";
		
		return result;		
	}
	
	
	public static String toHex(Color col){
		String hex = Integer.toHexString(col.getRGB());
		hex = hex.substring(2, hex.length());
		return hex;		
	}
	
	public static String bodyTag(){
		String result = "<body style=\"background-color:#"+toHex(frame.getContentPane().getBackground())+";width:"+frame.getWidth()+";height:\""+frame.getHeight()+"\">\n";		
				
		result += jPanel2html5tags();
		
		result += "</body>";
		return result;		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static String jPanel2html5tags(){
		String result = "";
		
		Component comp = null;
		for(int i = 0; i < frame.getContentPane().getComponentCount();i++){
			comp = frame.getContentPane().getComponents()[i];
			
			String temp = comp.getClass().getName();
			temp = temp.substring(temp.indexOf("J"));
			String htmlTag = supportedTypes.get(temp);
			
			if(htmlTag != null){
				try {
					Class cls = Class.forName(htmlTag);
					Object obj = cls.newInstance();			
			
					Method method = cls.getDeclaredMethod("getHTML", JComponent.class);
					Object returnType = method.invoke(obj, comp);
					result += (String) returnType;				
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
			
			
		}
		
		
		
		
		
		
		return result;
	}

}
