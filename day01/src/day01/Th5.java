package day01;

import java.util.Scanner;


class CountThread extends Thread{
	public void run() {
		//This is endless loop
		while(true) {
			Scanner sc = new Scanner(System.in);
			int ipt = sc.nextInt();
			count(ipt);
		}
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
		
	}
}

public class Th5 {

	public static void main(String[] args) {
		while (true) {
			CountThread st = new CountThread();	
			st.start();
		}
		
	}// END MAIN

}
