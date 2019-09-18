package day02;

import java.util.Scanner;

class Sus implements Runnable{

	@Override
	public void run() {
		System.out.println("*");
//			System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getId());
		}
		
	}
	


public class Suspend {

	public static void main(String[] args) {
		
		Thread t1 = null;
		Scanner sc = new Scanner(System.in);
		while(true) {
			int cmd = sc.nextInt();
			if(cmd ==1 ) {
				t1 = new Thread(new Sus(),"s1");
				t1.start();
			}else if(cmd == 2) {
				//unable to suspend
				t1.suspend();
			}else if(cmd == 3) {
				t1.resume();
			}else if(cmd == 4) {
				//stoped point is not clear... deprecated...
				t1.stop();
			}else if(cmd ==9) {
				return;
			}
			
		}
		
		
	}

}
