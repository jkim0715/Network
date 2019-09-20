package http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Http2 {
	//Downloading File from server
	public static void main(String[] args) throws Exception {
		//1. Make URL
		String urlstr = "http://70.12.60.90/test/oracle.zip";
		URL url = new URL(urlstr);
		
		//2. Prepare InputStream
		InputStream is = url.openStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		
		//2-1. Make FileOutputStream for Saving
		String filename = "oracle.zip";
		FileOutputStream fos = new FileOutputStream(filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
				
		//3. Download File
		int data = 0;
		while((data = bis.read())!= -1) {
			bos.write(data);
		}	
		System.out.println("Finish");
		is.close();
		bos.flush();
		bos.close();
	}

}
