package hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Hw3 {
	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
	}

	static String judgeTriangle(int num1, int num2, int num3) {
		int pow1 = (int) Math.pow(num1, 2);
		int pow2 = (int) Math.pow(num2, 2);
		int pow3 = (int) Math.pow(num3, 2);
		if (num1 == 0 || num2 == 0 || num3 == 0) {
			return "不是三角形";
		} else if (num1 == num2 && num1 == num3) {
			return "正三角形";
		} else if ((num1 == num2) || (num2 == num3) || num1 == num3) {
			return "等腰三角形";
		} else if (pow1 + pow2 == pow3 || pow1 + pow3 == pow2 || pow2 + pow3 == pow1) {
			return "直角三角形";
		} else {
			return "其他三角形";
		}
	}

	static void calcPossibleInts(int hatedInt) {
		int sum = 0;
		for (int x = 0; x <= 4; x++) {
			if (x != hatedInt)
				for (int y = 0; y <= 9; y++) {
					if (y != hatedInt) {
						if (x == 0 && y == 0)
							continue;
						System.out.print(10 * x + y + "\t");
						sum++;
						if (sum % 5 == 0)
							System.out.println();
					}
				}
		}
	}

	static int[] calcPossibleIntArr(int hatedInt) {
		int[] possibleIntArr = new int[50];
		int sum = 0;

		for (int x = 0; x <= 4; x++) {
			for (int y = 0; y <= 9; y++) {
				if ((y == hatedInt || x == hatedInt) || (x == 0 && y == 0)) {
					continue;
				}
				int e = possibleIntArr[sum] = 10 * x + y;
				System.out.print(e + "\t");
				sum++;
				if (sum % 5 == 0)
					System.out.println();
			}
		}

		System.out.println("總共" + sum + "個可能數字");
		return possibleIntArr;
	}

	static int[] get6Ints(int hatedInt, int[] filterArr) {
		Arrays.sort(filterArr);
		int[] arr6Int = new int[6];
		for (int i = 0; i < arr6Int.length; i++) {
			boolean isOverlapped = false;
			int arrInt;
			do {
				arrInt = (int) (Math.random() * 49 + 1);
				if (Arrays.binarySearch(filterArr, arrInt) >= 0)
					isOverlapped = true;
			} while (!isOverlapped);
			arr6Int[i] = arrInt;
		}
		return arr6Int;
	}

	public static void main(String[] args) {
//	請設計一隻程式,使用者輸入三個數字後,輸出結果會為正三角形、等腰
//	三角形、其它三角形或不是三角形,如圖示結果:
//
//	(提示:Scanner,三角形成立條件,判斷式if else)
//	(進階功能:加入直角三角形的判斷)
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入三個整數:");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();

		System.out.println(judgeTriangle(num1, num2, num3));

//	請設計一隻程式,會亂數產生一個0~9的數字,然後可以玩猜數字遊戲,猜錯會顯示錯誤訊息,猜
//	對則顯示正確訊息,如圖示結果:
//
//	(提示:Scanner,亂數方法,無窮迴圈)
//	(進階功能:產生0~100亂數,每次猜就會提示你是大於還是小於正確答案)
		int answer = (int) (Math.random() * 9) + 1;
		boolean isGuessRight = false;
		System.out.println("開始猜數字吧");
		do {
			int guess = sc.nextInt();
			if (guess==answer) {
				isGuessRight=true;
				System.out.println("Correct! The answer is "+answer);
			}else {
				System.out.println("Miss it. Try again: ");
			}
		} while (!isGuessRight);

//	• 阿文很喜歡簽大樂透(1~49),但他是個善變的人,上次討厭數字是4,但這次他想要依心情決定討
//	厭哪個數字,請您設計一隻程式,讓阿文可以輸入他不想要的數字(1~9),畫面會顯示他可以選擇
//	的號碼與總數,如圖:
//
//	(提示:Scanner)
//	(進階挑戰:輸入不要的數字後,直接亂數印出6個號碼且不得重複)

		System.out.println("你討厭甚麼數字？");
		int hatedInt = sc.nextInt();
		if (hatedInt > 9 || hatedInt < 1) {
			System.out.println(hatedInt + "不符合限制(1~9)，再試一次：");
			hatedInt = sc.nextInt();
		}
//		以下是不用array的方法：
//		calcPossibleInts(hatedInt);
		
//		以下是使用array並獲得6個數字的方法：
		final int[] result = get6Ints(hatedInt, calcPossibleIntArr(hatedInt));
		printArr(result);
	}
}