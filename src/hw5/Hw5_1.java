package hw5;

import java.util.Scanner;

public class Hw5_1 {
	public static void starSquare(int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
//	• 請設計一個方法為starSquare(int width, int height),當使用者鍵盤輸入寬與高時,即會印出對應的*長方形,如
//	圖:
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入寬與高：");
		int width = sc.nextInt();
		int height = sc.nextInt();
		starSquare(width, height);

	}
}
