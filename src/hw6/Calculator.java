package hw6;

public class Calculator {
	public static int powerXY(int x, int y) throws CalException {
		if(x==0&&y==0)throw new CalException("0的0次方沒有意義!");
		if(y<0)throw new CalException("次方為負值，回傳結果不為整數");

		int result= (int) Math.pow(x, y);
		System.out.println(x+"的"+y+"次方等於"+result);
		return result;
	}
}
