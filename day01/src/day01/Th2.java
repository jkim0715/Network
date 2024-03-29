package day01;

//using interface
//This enable class extends and implements at the same time.
class MyThread2 implements Runnable{
	//Set Thread name
	String name;
	
	public MyThread2(String name) {
		this.name = name;
	}
	
	//Run Thread
	@Override
	public void run() {
		for(int i=0; i<30; i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + ":" +i);
		}
	}
	
	
}

//Process
public class Th2 {

	public static void main(String[] args) {
		//In this case(implement method), I have to make Thread object first
		Thread t1 = new Thread(new MyThread2("T1"));
		Thread t2 = new Thread(new MyThread2("T2"));
	}

}
