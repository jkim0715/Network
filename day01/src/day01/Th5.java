package day01;

import java.util.Scanner;


class CountThread extends Thread{
	int ipt;
	
	public CountThread(int ipt) {
		this.ipt = ipt;
	}
	public void run() {
			count(ipt);
	}
	
	public void count(int ipt) {
		for(int i=0; i<=ipt ; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}		
	}//END count
}// END CountThread

public class Th5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			while(true) {
			int ipt = sc.nextInt();
			CountThread st = new CountThread(ipt);	
			st.start();
			}		
	}// END MAIN

}
