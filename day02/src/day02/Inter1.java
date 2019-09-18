package day02;


//Create Thread
class Th1 extends Thread{
	public void run() {
		//Give a condition on while loop check if its interrupted
		while(!isInterrupted()) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			System.out.println("Th1");
		}// END while
	}// END run
}// END Thread

public class Inter1 {
	public static void main(String[] args) {
		Th1 th1 = new Th1();
		th1.start();
		try {
			th1.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//unable to interrupt th1 in sleeping condition
		th1.interrupt();
		System.out.println("END....");
	}// END MAIN

}
