package day03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.crypto.Data;

public class Fi2 {

	public static void main(String[] args) throws Exception{
		FileInputStream fis = null;
		fis = new FileInputStream("C:\\network\\day03\\test.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		System.out.print(fis.available());
		
		//Make outputStream for you to make text2
		FileOutputStream fos = null;
		fos = new FileOutputStream("test2.txt");
		//Set Buffer Size
		BufferedOutputStream bos = new BufferedOutputStream(fos,5);
		
		
		int data = 0;
		
		while((data = bis.read()) != -1) {
			char c = (char)data;
			System.out.print(c);
			bos.write(data);
		}
		
		//Need to close buffer.
		//if buffer is not closed , then there will be some missing data which loc at memory of buffer
		if(fis != null) {	
			bis.close();
		}if(fos != null) {
			bos.flush();
			bos.close();
		}
		
			
	}

}
