package hw5;


public class Hw5_5 {
	static void genAuthCode() {
		System.out.println("本次隨機產生驗證碼為：");
		char []possibleCode= new char[62];
		for (int i = 0; i <= 9; i++) {
			possibleCode[i]=(char) (i+'0');
		}
		for(int i=0;i<26;i++) {
			possibleCode[i+10]=(char)('A'+i);
		}
		for(int i=0;i<26;i++) {
			possibleCode[i+36]=(char)('a'+i);
		}
		String finalCode = null;
		for (int i = 0; i < 8; i++) {
			char e=possibleCode[(int)(Math.random()*62)];
			System.out.print(e);
		}
	}
	public static void main(String[] args) {
//		身為程式設計師的你,收到一個任務,要幫系統的註冊新增驗證碼的功能,請設計一個方法
//		genAuthCode(),當呼叫此方法時,會回傳一個8位數的驗證碼,此驗證碼內容包含了英文大小寫
//		與數字的亂數組合,如圖:
		genAuthCode();
	}
}
