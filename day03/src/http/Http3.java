package http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http3 {

	public static void main(String[] args) throws Exception{
		//1. Prepare ID & PWD
		String id = "ab";
		String pwd = "11";
		
		//1-1. Make URL 
		String urlstr = "http://70.12.60.90/test/login.jsp";
		urlstr += "?id="+id+"&pwd="+pwd;
		URL url = new URL(urlstr);
		
		//1-2. Make Connection
		HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
		conn.setReadTimeout(5000);
		conn.setRequestMethod("GET");
		
		//1-3. Make InputStream
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		//2. Get Response from Server
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
					
	}

}
