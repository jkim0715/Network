package day01;

//Save periodically
class SaveThread extends Thread{
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

public class Th4 {

	public static void main(String[] args) {
		SaveThread st = new SaveThread();
		//Make "st"(endless loop) Thread to stop as Main Thread terminated
		st.setDaemon(true);
		st.start();
		for(int i =0; i<20; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
							e.printStackTrace();
			}
			System.out.println(i);
		}
	
	}

}
