package ser;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		//Save an object as a file 
		FileOutputStream fos = new FileOutputStream("user.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		User user = new User("id01", "pwd01", 20);
		oos.writeObject(user);
		
		//always close the last
		oos.close();

	}

}
