package hw7;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Hw7 {
	public static void copyFile(File inputFile, File ouputFile) throws IOException {
		// 清空ouputFile
		PrintWriter pw=new PrintWriter(ouputFile);
		pw.close();
		
		FileReader fr = new FileReader(inputFile);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(ouputFile, true);
		String str;
		while ((str = br.readLine()) != null) {
			fw.write(str + "\n");
		}
		fw.close();
		br.close();
		fr.close();
	}

	public static void main(String[] args) throws IOException {
//		請寫一個程式讀取這個Sample.txt檔案,並輸出以下訊息:
//			Sample.txt檔案共有xxx個位元組,yyy個字元,zzz列資料
		File sptxt = new File("Sample.txt");
		String fileName = sptxt.getName();
		FileInputStream fis = new FileInputStream(sptxt);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		int xxx = 0, yyy = 0, zzz = 0;
		String str;
		xxx = (int) sptxt.length();
		while ((str = br.readLine()) != null) {
			zzz++;
			yyy += str.length();
		}
		br.close();
		isr.close();
		fis.close();
		System.out.println(fileName + "檔案共有" + xxx + "個位元組," + yyy + "個字元," + zzz + "列資料");

//		• 請寫一隻程式,能夠亂數產生10個1~1000的整數,並寫入一個名為Data.txt的檔案裡 (請使用
//				append功能讓每次執行結果都能被保存起來)
		File data = new File("Data.txt");
		//清空data
		PrintWriter pw=new PrintWriter(data);
		pw.close();
		
		FileWriter fw = new FileWriter(data, true);

		for (int i = 0; i < 10; i++) {
			int result = (int) (Math.random() * 1000 + 1);
			System.out.println(result);

			fw.write(result + "\n");
		}
		fw.close();
//
//		• 請從無到有試著完成一個方法名為copyFile,這個方法有兩個參數。呼叫此方法時,第一個參數所
//		代表的檔案會複製到第二個參數代表的檔案
		File firstFile = data;
		File secondFile = new File("copyFile.txt");
		copyFile(firstFile, secondFile);
//
//		• 請寫一支程式,利用老師提供的Dog與Cat類別分別產生兩個物件,寫到C:\data\Object.ser裡。注
//		意物件寫入需注意的事項,若C:\內沒有data資料夾,請用程式新增這個資料夾
		Pet[] objs = new Pet[4];
		objs[0] = new Cat("Catty1");
		objs[1] = new Cat("Catty2");
		objs[2] = new Dog("Doggy1");

		objs[3] = new Dog("Doggy2");

		File desDir= new File("C:\\data");
		File des = new File(desDir,"Object.ser");
		if (desDir.exists() == false) {
			desDir.mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(des);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (int i = 0; i < objs.length; i++) {
			oos.writeObject(objs[i]);
		}
		oos.close();
		fos.close();
//
//		• 承上題,請寫一個程式,能讀取Object.ser這四個物件,並執行speak()方法觀察結果如何 (請利用多
//		型簡化本題的程式設計)
		FileInputStream fis2 = new FileInputStream(des);
		ObjectInputStream ois = new ObjectInputStream(fis2);
		try {
			Pet[] objs2 = new Pet[4];
			for (int i = 0; i < objs2.length; i++) {
				objs2[i] = (Pet)ois.readObject();
				objs2[i].speak();
				
			}
		} catch (EOFException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
