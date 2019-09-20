package tcp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread extends Thread{
	public void run() {
		//This is endless loop
		while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			save();
		}
	}
	public void save() {
		System.out.println("SAVED..");
	}
}


public class Server {
	//1. Consider what kind of member variables should be init
	
	int port;
	//1-1. Sockets should be existed at both end side 
	ServerSocket serverSocket;
	Socket socket;
	
	//1-2. Server needs OutputStream
	OutputStream out;
	OutputStreamWriter osw;
	BufferedWriter bw;	
	boolean flag = true;
	//1-3. Set constructor
	public Server() {
		
	}

	public Server(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port); //throws Exception, then Main will catch this.
		
	}
	//1-4. make Start Server function.
	public void startServer() throws IOException {
		while(flag) {
		System.out.println("Server Started");
		try {
		System.out.println("Server Ready...");
		socket = serverSocket.accept();
		System.out.println("Accepted .." +socket.getInetAddress());
		
		//1-5. Make OutputStream by using socket.
		out = socket.getOutputStream();
		osw = new OutputStreamWriter(out);
		bw = new BufferedWriter(osw);
		bw.write("멀티캠퍼스 입니당");
		bw.flush();
		
		}catch(IOException e) {
			throw e;
		}finally {
			
			if(socket != null) {
				socket.close();
			}
			
			if(bw != null) {
				bw.close();
			}
		
		}
		}//END While
		
		System.out.println("Server Stopped");
	}
	
	public static void main(String[] args) {
	
	//2. Set Server port & start Server.
	Server server = null;
	try {
		server = new Server(8888);
		server.startServer();
	} catch (IOException e) {
		e.printStackTrace();
	}
	

	}//END Main

}
