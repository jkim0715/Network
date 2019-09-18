package day02;

import java.util.Scanner;

class Sus2 implements Runnable{
	
	boolean spd = false;
	boolean stp = false;
	
	public void setStop() {
		stp = true;
	}	
	public void setSus() {
		spd = true;
	}
	public void setRes() {
		spd = false;
	}
	
	@Override
	public void run() {
		while(!stp) {
			if(!spd) {
				System.out.println("-");
			}			
		}
	}
	
}//END runnable

public class Suspend2 {

	public static void main(String[] args) {
		Thread t1 = null;
		Sus2 ss = null;
		Scanner sc = new Scanner(System.in);
		while(true) {
			int cmd = sc.nextInt();
			if(cmd ==1 ) {
				ss = new Sus2();
				t1 = new Thread(ss,"s1");
				t1.start();
			}else if(cmd == 2) {
				ss.setSus();
			}else if(cmd == 3) {
				ss.setRes();
			}else if(cmd == 4) {
				ss.setStop();
			}else if(cmd ==9) {
				return;
			}
			
		}
		

	}

}
