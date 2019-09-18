package day02;
//Get Sum of 2 Thread which loops 1~100 & 101~150 respectively 


class Th4 extends Thread{
	int sum;
	
	public int getSum() {
		return sum;
	}
	
	
	public void run() {
		int i = 1;
		while(!isInterrupted()) {
			sum += i;
			if(i == 100) {
				return;
			}
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			i++;
		}// END while
	}// END run
}// END Thread

class Th3 extends Thread{
	int sum;
	
	public int getSum() {
		return sum;
	}
	
	
	public void run() {
		int i = 101;
		while(!isInterrupted()) {
			sum += i;
			if(i == 150) {
				return;
			}try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}			
			i++;
		}// END while
	}// END run
}// END Thread



public class Join2 {

	public static void main(String[] args) {
		int sum =0;
		Th3 th3 = new Th3();
		Th4 th4 = new Th4();
		th3.start();
		th4.start();
		try {
			// Makes main thread to pause while th2 is running
			th3.join();
			th4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sum = th3.getSum()+th4.getSum();
		System.out.println(th3.getSum());
		System.out.println(th4.getSum());
		System.out.println("sum:"+ sum);
	}

}
