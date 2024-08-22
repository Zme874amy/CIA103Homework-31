package hw1;

public class hw1 {
	public static void main(String[] args) {
//	• 請設計一隻Java程式,計算12,6這兩個數值的和與積
		System.out.println("積為" + 12 * 6);
		System.out.println("和為" + (12 + 6));

//	• 請設計一隻Java程式,計算200顆蛋共是幾打幾顆? (一打為12顆)
		System.out.println("總共" + 200 / 12 + "打，" + 200 % 12 + "顆");

//	• 請由程式算出256559秒為多少天、多少小時、多少分與多少秒
		int secADay = 60 * 60 * 24;
		int days = 256559 / secADay, hours = (256559 % secADay) / (60 * 60),
				mins = ((256559 % secADay) % (60 * 60)) / 60, secs = ((256559 % secADay) % (60 * 60)) % 60;
		System.out.println("總共" + days + "天，" + hours + "小時，" + mins + "分，" + secs + "秒");

//	• 請定義一個常數為3.1415(圓周率),並計算半徑為5的圓面積與圓周長
		double pi = 3.1415;
		System.out.println("圓面積為" + 5 * 5 * pi + "，圓周長為" + 5 * 2 * pi);

//	• 某人在銀行存入150萬,銀行利率為2%,如果每年利息都繼續存入銀行,請用程式計算10年後,本
//	金加利息共有多少錢 (用複利計算,公式請自行google)
		double sum = 1500000 * Math.pow(1.02, 10);
		System.out.println("10年後總共" + sum);

//	• 請寫一隻程式,利用System.out.println()印出以下三個運算式結果:
//	5 + 5
//	5 + ‘5’
//	5 + “5”
//	並請用註解各別說明答案的產生原因
		System.out.println(5 + 5);
		// 5+5為兩int相加，得出結果為int型態的10
		System.out.println(5 + '5');
		// 前面的5為int型態，後者為char型態
		// char型態會被轉為Unicode的對應值，也就是\u0035
		// 此為十六進位，換算為十進位則為53
		// 因此與5相加結果為58
		System.out.println(5 + "5");
		// 前面的5為int型態，後面者為String型態，與String相加則做字串串接
	}
}
