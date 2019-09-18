package day02;

class Th2 extends Thread{
	int sum;
	
	public int getSum() {
		return sum;
	}
	
	
	public void run() {
		int i = 1;
		while(!isInterrupted()) {
			sum += i;
			if(i == 10) {
				return;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			System.out.println("Th2:"+i);
			i++;
		}// END while
	}// END run
}// END Thread


public class Join {

	public static void main(String[] args) {
		Th2 th2 = new Th2();
		th2.start();
		try {
			// Makes main thread to pause while th2 is running
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("sum:"+ th2.getSum());

	}

}
