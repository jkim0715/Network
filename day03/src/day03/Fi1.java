package day03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fi1 {

	public static void main(String[] args) {
		//Need to read file.
		
		//possible becuase day03 is set as classpath already.
		FileInputStream fi = null;
		//try catch in case there is no such file
		try {
			//make an InputStream
			fi =new FileInputStream("test.txt");
			//type of byte = integer
			int data = 0;
			//Add catch clause to surrounding try
			//if there is nothing to read, it returns -1
			while((data = fi.read()) != -1){
				//unable to read KOREAN because it transfers data w/ 1byte at a time
				char c = (char)data;
				System.out.print(c);
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fi != null) {
			try {
				fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		}//END finally
		
		
		//Using BufferedReader
		//possible becuase day03 is set as classpath already.
				FileReader fi1 = null;
				BufferedReader br = null;
				
				//try catch in case there is no such file
				try {
					//make an InputStream
					fi1 =new FileReader("test.txt");
					br = new BufferedReader(fi1);
					//type of byte = integer
					String data1 = " ";
					//Add catch clause to surrounding try
					//if there is nothing to read, it returns -1
					while((data1 = br.readLine()) != null){
						//unable to read KOREAN because it transfers data w/ 1byte at a time
						
						System.out.print(data1);
					}	
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						fi1.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
		
		
		
	}//END MAIN
	}				
				


