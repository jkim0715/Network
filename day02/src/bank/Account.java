package bank;

public class Account {

	private int balance;
	public Account() {
			
	}
	public Account(int balance) {
		this.balance =balance;
	}
	public void deposit(int money)throws Exception {
		if(money <= 0) {
			throw new Exception();
		}
		balance += money;
	}
	public void withdraw(int money)throws Exception {
		if(balance > 0 ) {
			balance -= money;
		}
		
	
	}
	public int getbalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}

}
