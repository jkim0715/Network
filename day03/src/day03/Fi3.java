package day03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fi3 {

	public static void main(String[] args) {
		FileReader fir = null;
		BufferedReader bir = null;
		
		
		FileWriter fiw = null;
		BufferedWriter bfw = null;
		try {
			fir = new FileReader("test.txt");
			bir = new BufferedReader(fir);
			fiw = new FileWriter("test3.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		String data = " ";
		
		bfw = new BufferedWriter(fiw);
		try {
			while((data = bir.readLine()) != null) {
				System.out.println(data);
				bfw.write(data);
				bfw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bir.close();
				bfw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	
		

	}

}
