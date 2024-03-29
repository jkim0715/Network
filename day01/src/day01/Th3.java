package day01;

public class Th3 {

	public static void main(String[] args) {
		//Make Runnable 
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<1000; i++) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("R:"+i);
				}
				
			} //END run()
		};//END Runnable r
		
		//Make Runnable "r2"
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<1000; i++) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("R2:"+i);
				}
				
			} //END run()
		}; //END Runnable r2
		//Make Thread Group
		ThreadGroup tg1 = new ThreadGroup("TG1");
		tg1.setMaxPriority(3);
		
		//Put "r"&"r2" into a Thread Group "tg1"
		new Thread(tg1,r,"th1").start();
		new Thread(tg1,r2,"th1").start();
		
	}//END MAIN

}
