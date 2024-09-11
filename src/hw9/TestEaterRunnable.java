package hw9;

public class TestEaterRunnable {
	public static void main(String[] args) {
//		• 開啓2個執行緒模擬饅頭人與詹姆士參加快胃王比賽所做的
//		競賽過程。
//		• 每個動作都以 Thread.sleep()暫停一下,以達到顯示效果。
//		Sleep時間由亂數產生500~3000之間的毫秒數,如圖所示
//		• 參考範例:CounterRunnable.java
//		• 需留意主執行緒執行順序
		EaterRunnable et1 = new EaterRunnable("饅頭人");
		Thread t1 = new Thread(et1);
		EaterRunnable et2 = new EaterRunnable("詹姆士");
		Thread t2 = new Thread(et2);
		System.out.println("--------大胃王比賽開始啦--------");

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------大胃王比賽結束了--------");
	
	}
}

class EaterRunnable implements Runnable {
	private String name;
	private int readyToEatBowls;

	public EaterRunnable(String name) {
		this.name = name;
	}

	private void eat() throws InterruptedException {
		System.out.println(name + "吃第" + readyToEatBowls + "碗飯");
		Thread.sleep((long) (Math.random() * 2500 + 500));
		readyToEatBowls++;
	}

	@Override
	public void run() {
		while (readyToEatBowls <= 10) {
			try {
				eat();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "吃完了");

	}

}
