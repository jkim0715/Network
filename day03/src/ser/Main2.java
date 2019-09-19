package ser;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Main2 {

	public static void main(String[] args) throws Exception {
		FileInputStream fi = new FileInputStream("user.dat");
		BufferedInputStream bu = new BufferedInputStream(fi);
		ObjectInputStream ois = new ObjectInputStream(bu);
		
		User user = new User();
		user = (User)ois.readObject();
		System.out.println(user.toString());

	}

}
