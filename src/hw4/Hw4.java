package hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Hw4 {
	static double getAvgInArray(double[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double result = sum / arr.length;
		System.out.println("The Average is " + result);
		return result;
	}

	static void printHigherThanAvg(double[] arr) {
		double avg = getAvgInArray(arr);
		Arrays.sort(arr);
//		int index=Arrays.binarySearch(arr, sum);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > avg)
				System.out.print((int) arr[i] + "\t");
		}
		System.out.println();
	}

	static void printReversedString(String str) {
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
	}

	static int calcVowels(String[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				char letter = arr[i].charAt(j);
				switch (letter) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					sum++;
					break;
				default:
					break;
				}
			}
		}
		System.out.println("總共有" + sum + "個母音");
		return sum;
	}

	static void printMoneyLenter(int amount) {
		int[][] arr = { { 25, 32, 8, 19, 27 }, { 2500, 800, 500, 1000, 1200 } };
		int sum = 0;
		System.out.println("有錢可借的員工編號: ");
		for (int i = 0; i < arr[1].length; i++) {
			if (arr[1][i] > amount) {
				System.out.println(arr[0][i]);
				sum++;
			}
		}
		System.out.println("共" + sum + "人");
	}

	static boolean isReasonableDate(int y, int m, int d) {
		if (isLeapYear(y)) {
			if (d > monthlyDaysInLeapYear[m - 1]) {
				System.out.println("日期超過該月最大日期");
				return false;
			}
			return true;
		} else {
			if (d > monthlyDays[m - 1]) {
				System.out.println("日期超過該月最大日期");
				return false;
			}
			return true;
		}
	};

	static int[] monthlyDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int[] monthlyDaysInLeapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	static void calcDateNumInAYear(int y, int m, int d) {
		int sum = 0;
		boolean isLeapYear = isLeapYear(y);

		// 計算這個月以前的天數
		for (int i = 1; i <= m - 1; i++) {
			if (isLeapYear) {
				sum += monthlyDaysInLeapYear[i - 1];
			} else {
				sum += monthlyDays[i - 1];
			}
		}

		// 計算這個月的天數
		sum += d;
		System.out.println("輸入的日期為該年的第" + sum + "天");
	}

	static boolean isLeapYear(int y) {
		if (y % 100 == 0 && y % 400 == 0)
			return true;
		else if (y % 100 != 0 && y % 4 == 0)
			return true;
		else
			return false;
	}

	static void calcHighestScoreTimes(int[][] arr) {
		int[] times = new int[8]; // 每個同學最高分的次數
		for (int i = 0; i < arr.length; i++) {
			int highestIndex = 0;
			// 比較一次考試中誰最高
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > arr[i][highestIndex])
					highestIndex = j;
			}
			times[highestIndex]++;
		}
		for (int i = 0; i < times.length; i++) {
			System.out.println(i + 1 + "號同學最高分的次數有" + times[i] + "次");
		}
	}

	public static void main(String[] args) {
//		• 有個一維陣列如下:
//		{29, 100, 39, 41, 50, 8, 66, 77, 95, 15}
//		請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素
//		(提示:陣列,length屬性)
		double[] arr1 = { 29, 100, 39, 41, 50, 8, 66, 77, 95, 15 };
		printHigherThanAvg(arr1);

		System.out.println("======");
//		• 請建立一個字串,經過程式執行後,輸入結果是反過來的
//		例如String s = “Hello World”,執行結果即為dlroW olleH
//		(提示:String方法,陣列)
		printReversedString("Hello World");

		System.out.println("======");
//		• 有個字串陣列如下 (八大行星):
//		{“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”, “neptune”}
//		請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)
//		(提示:字元比對,String方法)
		String[] arr2 = { "mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune" };
		calcVowels(arr2);

		System.out.println("======");
//		阿文上班時忘了帶錢包,想要向同事借錢,和他交情比較好的同事共有 5 個,其員工編號與身上現金列
//		表如下:
//
//		請設計一個程式,可以讓小華輸入欲借的金額後,便會顯示哪些員工編號的同事
//		有錢可借他;並且統計有錢可借的總人數:例如輸入 1000 就顯示「有錢可借的
//		員工編號: 25 19 27 共 3 人!」
//
//		(提示:Scanner,二維陣列)
		printMoneyLenter(1000);

		System.out.println("======");
//		• 請設計由鍵盤輸入三個整數,分別代表西元yyyy年,mm月,dd日,執行後會顯示是該年的第幾天
//
//		例:輸入 1984 9 8 三個號碼後,程式會顯示「輸入的日期為該年第252天」
//
//		(提示1:Scanner,陣列)
//		(提示2:需將閏年條件加入)
//		(提示3:擋下錯誤輸入:例如月份輸入為2,則日期不該超過29)

		Scanner sc = new Scanner(System.in);
		int y = 0, m = 0, d = 0;
		do {
			System.out.println("請輸入年月日：");
			y = sc.nextInt();
			m = sc.nextInt();
			d = sc.nextInt();
		} while (!isReasonableDate(y, m, d));
		calcDateNumInAYear(y, m, d);

		System.out.println("=======");
//		班上有8位同學,他們進行了6次考試結果如下:
//
//		請算出每位同學考最高分的次數
//		(提示:二維陣列)
		int[][] arr3 = new int[6][8];
		arr3[0] = new int[] { 10, 35, 40, 100, 90, 85, 75, 70 };
		arr3[1] = new int[] { 37, 75, 77, 89, 64, 75, 70, 95 };
		arr3[2] = new int[] { 100, 70, 79, 90, 75, 70, 79, 90 };
		arr3[3] = new int[] { 77, 95, 70, 89, 60, 75, 85, 89 };
		arr3[4] = new int[] { 98, 70, 89, 90, 75, 90, 89, 90 };
		arr3[5] = new int[] { 90, 80, 100, 75, 50, 20, 99, 75 };
		calcHighestScoreTimes(arr3);
	}
}
