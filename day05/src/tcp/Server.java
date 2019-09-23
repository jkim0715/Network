package tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


class ServerThread extends Thread{
	public ServerThread(Socket socket) {
		
	}
	public void run() {
		
	}
}


public class Server {
	
	boolean flag = true;
	
	ServerSocket serverSocket;
	
	OutputStream out;
	DataOutputStream dout;
	
	public Server() {
	
	}
	
	public Server(int port) throws IOException{
		serverSocket = new ServerSocket(port);
		System.out.println("Server Started");
	}
	
	public void start() throws IOException{
		while(flag) {
			System.out.println("Server Ready..");
			Socket socket = serverSocket.accept();
		}
		System.out.println("Sever END");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
