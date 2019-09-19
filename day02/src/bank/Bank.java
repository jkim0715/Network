package bank;

class Header extends Thread{
	Account acc;	
	public Header(Account acc) {
		this.acc = acc;
	}

	public void run() {
		for(int i=0; i<100;i++) {
			int money = (int)(Math.random()*3+1)*100;
			try {
				Thread.sleep(50);
				acc.deposit(money);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class Branch extends Thread{
	Account acc;
	String name;
	
	
	public Branch( String name, Account acc) {
		this.acc = acc;
		this.name = name;
	}


	public void run() {
		while(acc.getbalance() >0 ) {
			int money = (int)(Math.random()*3+1)*200;
			try {
				Thread.sleep(1000);
				acc.withdraw(money);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(name + " " + acc.getbalance());
		}
	}
}
public class Bank {

	public static void main(String[] args) {
		Account acc = new Account(10000);
		Branch b1 = new Branch("b1",acc);
		Branch b2 = new Branch("b2",acc);
		Branch b3 = new Branch("b3",acc);
		Branch b4 = new Branch("b4",acc);
//		Header h1 = new Header(acc);
//		h1.start();
		b1.start();
		b2.start();
		b3.start();
		b4.start();
	}

}
