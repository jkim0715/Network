package day01;

public abstract class T1 {
		
	public static void main(String[] args) throws InterruptedException {
		//Single Process
		//Process
		for(int i=0; i<20; i++) {
			Thread.sleep(10);
			System.out.println("A:"+i);
		}
		System.out.println("end");
		//Process END
		//Process 
		for(int i=0; i<20; i++) {
			Thread.sleep(10);
			System.out.println("B:"+i);
		}
		System.out.println("end");
		//Process END
		
	}

}
