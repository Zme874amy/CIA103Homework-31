package hw2;

public class hw2 {
	public static void main(String[] args) {
//	• 請設計一隻Java程式,計算1~1000的偶數和 (2+4+6+8+...+1000)
		int sum=0;
		for(int i =1;i<=1000;i++){
			if(i%2==0) {
				sum+=i;
			}
		}
		System.out.println(sum);
//	• 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用for迴圈)
		sum = 1;
		for(int i =1;i<=10;i++) {
			sum=sum*i;
		}
		System.out.println(sum);
		System.out.println("===============");
//	• 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用while迴圈)
		sum=1;
		int index =1;
		while(index<=10) {
			sum=sum*index;
			index++;
		}
		System.out.println(sum);
		System.out.println("===============");
//	• 請設計一隻Java程式,輸出結果為以下:
//	1 4 9 16 25 36 49 64 81 100
		for(int i=1;i<=10;i++) {
			System.out.print((int)Math.pow(i, 2)+" ");
		}
		System.out.println();
		System.out.println("===============");
//	• 阿文很熱衷大樂透 (1 ~ 49),但他不喜歡有4的數字,不論是個位數或是十位數。請設計一隻程式,
//	輸出結果為阿文可以選擇的數字有哪些?總共有幾個?
		sum=0;
		for(int x = 0;x<4;x++) {
			for(int y = 0 ; y<=9;y++) {
				if(y==4)continue;
				System.out.print(10*x+y+" ");
				sum++;
			}
		}
		System.out.println();
		System.out.println("總共"+sum+"個");
		System.out.println("===============");
//	• 請設計一隻Java程式,輸出結果為以下:
//	1 2 3 4 5 6 7 8 9 10
//	1 2 3 4 5 6 7 8 9
//	1 2 3 4 5 6 7 8
//	1 2 3 4 5 6 7
//	1 2 3 4 5 6
//	1 2 3 4 5
//	1 2 3 4
//	1 2 3
//	1 2
//	1
		for (int a = 10; a > 0 ; a--) {
			for(int b =1; b<=a; b++) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
		System.out.println("===============");
//	• 請設計一隻Java程式,輸出結果為以下:
//		A
//		BB
//		CCC
//		DDDD
//		EEEEE
//		FFFFFF
		char l = 'A'-1;
		for(int i =1;i<=6;i++) {
			l++;
			for(int j =1 ;j<=i;j++ ) {
				System.out.print(l);
			}
			System.out.println();
		}
		
//		以下是*星號版本的
		for(int i =1;i<=6;i++) {
			l++;
			for(int j =1 ;j<=i;j++ ) {
				System.out.print('*');
			}
			System.out.println();
		}
		
	}
}
