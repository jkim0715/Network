package tcp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

//1.Structure of Function
//2.How to Handle Exceptions

public class Client {
	
	String ip;
	int port;
	Socket socket;
	
	InputStream in;
	InputStreamReader inr;
	BufferedReader br;
	
	OutputStream out;
	OutputStreamWriter osw;
	BufferedWriter bw;	
	
	

	public Client(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}//END constructor
	
	//1. connect to Other socket (Server Socket)
	public void connect() {
		try {
			socket = new Socket(ip, port);
		}catch (IOException e) {
			boolean flag = true;
			//If connection failed, then keep on retrying 
			while(flag) {
				try {
					Thread.sleep(2000);
					socket = new Socket(ip, port);
					break;
				} catch (Exception e1) {
					System.out.println("Retry");
				}
			}
		}
		
	}//END connect

	public void request() throws IOException {
		try {
			in =socket.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);
			
			String str = br.readLine();
			System.out.println(str);
		} catch (IOException e) {
			throw e;
		}finally {
			if(in != null) {
				in.close();
				}
			if(inr != null) {
				inr.close();
				}
			if(br != null) {
				br.close();
			}
			if(socket != null) {
				socket.close();
			}
		}
	}//END request
	
	public static void main(String[] args) {
		Client client = null;
		client = new Client ("70.12.60.108",8888);
		client.connect();
		try {
			client.request();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//END Main 

}//END Client
