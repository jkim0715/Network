package pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class OutputThread extends Thread {
	PipedWriter output;
	public OutputThread(String name) {
		super(name);
		output = new PipedWriter();
	}
	public OutputThread(PipedWriter output) {
		this.output = output;
	}
	public PipedWriter getOutput() {
		return output;
	}
	public void connect(PipedReader input) {
		try {
			output.connect(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);	
		try {
			
			String msg = sc.nextLine();
			System.out.println("sent:"+msg);
			output.write(msg);
			output.close();		
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	
	}
	
}
