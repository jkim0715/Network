package http;
//Main에서 Scanner로 ID &PWD
//Thread를 통해서 서버로 전송

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class Http4 {
	public static void main(String[] args) throws Exception{
		//1. Input ID & PWD
		
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		String pwd = sc.nextLine();
		
		
	
	
		//2. Make Thread
		Runnable r = new Runnable() {
			URL url ;
			HttpURLConnection conn;
			@Override
			public void run() {
				String urlstr = "http://70.12.60.90/test/login.jsp";
				urlstr += "?id="+id+"&pwd="+pwd;
				try {
					url = new URL(urlstr);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				
				//1-2. Make Connection
				try {
					conn =  (HttpURLConnection) url.openConnection();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn.setReadTimeout(5000);
				try {
					conn.setRequestMethod("GET");
				} catch (ProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//1-3. Make InputStream
				InputStream is = null ;
				try {
					is = conn.getInputStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // get connected
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);		
				
				
				try {
					if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
						String result = null;
						while((result = br.readLine())!= null) {
							System.out.println(result);
							if(result.equals("1")) {
								System.out.println("Login OK");
							}else if(result.equals("0")){
								System.out.println("Login Failed");
							}
						}
					}else {
						System.out.println("Login Failed");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} //END run()
		};//END Runnable r
		new Thread(r).start();	
	}
}
