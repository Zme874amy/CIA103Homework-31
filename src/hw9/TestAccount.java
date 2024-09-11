package hw9;

public class TestAccount {
	public static void main(String[] args) {
//		• 熊大在念大學,生活費倚靠媽媽。媽媽怕熊大一天到晚領
//		錢亂花,不好好唸書,所以只要看到熊大帳戶的餘額超過
//		3000元,就會停止匯款給熊大;但要是帳戶餘額在2000元
//		以下,熊大就會要求媽媽匯款給他。如果帳戶餘額低於熊
//		大要提款的金額,熊大就會暫停提款,直到媽媽告知他錢
//		已經入帳戶。假設媽媽一次匯款 2000 元,熊大一次提款
//		1000元,寫一個Java程式模擬匯款10次與提款10次的情
//		形。
//
//		• 參考範例:TestWaitNotify.java
		Account account = new Account(0);
		Transferer mom = new Transferer("媽媽",account);
		Withdrawer bear = new Withdrawer("熊大",account);
		mom.start();
		bear.start();
		try {
			mom.join();
			bear.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("------兩人各10次的帳戶操作已結束------");

	}
}

class Account {
	private static int balance;
	private static int withdrawedTimes;
	private static int receivedTimes;


	public Account(int initialBalance) {
		this.balance = initialBalance;
	}

	synchronized public void receive(int amount, String name) {
		while (balance > 3000) {
			System.out.println(name + "看到了餘額在3000以上，暫停匯款");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + "被要求匯款");
		}
		balance += amount;
		receivedTimes++;

		System.out.println(name + "存了" + amount + "元，帳戶共有" + balance + "元(第"+receivedTimes+"次匯款)");
		notify();
	}

	synchronized public void withdraw(int amount, String name) {
		while (balance < amount) {
			System.out.println(name + "看到了餘額在" + amount + "以下，暫停提款");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + "被通知已匯款");
		}
		balance -= amount;
		withdrawedTimes++;

		System.out.println(name + "領了" + amount + "元，帳戶共有" + balance + "元(第"+withdrawedTimes+"次提款)");
		if (balance < 2000) {
			notify();
			System.out.println(name + "看到帳戶沒錢，要求匯款");
		}

	}
}

class Transferer extends Thread {
	private String name;
	private Account targetAccount;

	public Transferer(String name, Account targetAccount) {
		this.name = name;
		this.targetAccount = targetAccount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			targetAccount.receive(2000, name);
		}
	}
}

class Withdrawer extends Thread {
	private String name;
	private Account targetAccount;

	public Withdrawer(String name, Account targetAccount) {
		this.name = name;
		this.targetAccount = targetAccount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			targetAccount.withdraw(1000, name);
		}
	}
}
