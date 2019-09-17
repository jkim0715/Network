package day01;


class MyThread extends Thread{
	//Set Thread name
	String name;
	
	public MyThread(String name) {
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
			yield();
			System.out.println(name + ":" +i);
		}
	}
	
	
}


//Process
public class Th1 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("T1");
		MyThread t2 = new MyThread("T2");
		MyThread t3 = new MyThread("T3");
		t1.setPriority(1);
		t2.setPriority(2);
		t3.setPriority(3);
		
		t1.start();
		t2.start();
		t3.start();
	
//이러면 하나씩 돌게 됨...
//		t1.run();
//		t2.run();
	}

}
