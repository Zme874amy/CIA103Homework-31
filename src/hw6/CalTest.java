package hw6;

import java.util.Scanner;

public class CalTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x;
		int y;
		boolean isInputReasonable = false;
		do {

			try {
				System.out.println("請輸入x的值：");
				x = sc.nextInt();
				System.out.println("請輸入y的值：");
				y = sc.nextInt();
				Calculator.powerXY(x, y);
				isInputReasonable=true;
			} catch (CalException e) {
				System.out.println(e.getMessage());
			}

		} while (!isInputReasonable);

	}
}
