package hw5;

public class Hw5_2 {

	public static void randAvg() {
		System.out.println("本次亂數結果：");
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			int result = (int) (Math.random() * 100 + 1);
			sum+=result;
			System.out.print(result + "\t");
		}
		System.out.println();
		System.out.println("平均值為：");
		System.out.println(sum/10);
	}
	public static void main(String[] args) {

//		請設計一個方法為randAvg(),從10個 0~100(含100)的整數亂數中取平均值並印出這10個亂數與平均值,如圖:
		randAvg();
	}
}
