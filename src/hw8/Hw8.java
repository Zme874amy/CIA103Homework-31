package hw8;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Hw8 {
	public static void main(String[] args) {
//		• 請建立一個Collection物件並將以下資料加入:
//			Integer(100)、Double(3.14)、Long(21L)、Short(“100”)、Double(5.1)、“Kitty”、Integer(100)、
//			Object物件、“Snoopy”、BigInteger(“1000”)
		Collection c1=new ArrayList();
		c1.add(new Integer(100));
		c1.add(new Double(3.14));
		c1.add(new Long(21L));
		c1.add(new Short("100"));
		c1.add(new Double(5.1));
		c1.add("Kitty");
		c1.add(new Integer(100));
		c1.add(new Object());
		c1.add("Snoopy");
		c1.add(new BigInteger("100"));

//
//		• 印出這個物件裡的所有元素(使用Iterator, 傳統for與foreach)
		Iterator i=c1.iterator();
		System.out.println("This is While-loop");
		while(i.hasNext()) {
			System.out.print(i.next()+"\t");
		}
		System.out.println();
		System.out.println("This is for-loop with Iterator");
		for(Iterator i1=c1.iterator();i1.hasNext();) {
			System.out.print(i1.next()+"\t");
		}
		System.out.println();
		System.out.println("This is for-each");
		for(Object object:c1) {
			System.out.print(object+"\t");
		}
//		• 移除不是java.lang.Number相關的物件
		i=c1.iterator();
		while (i.hasNext()) {
			Object o=i.next();
			if(!(o instanceof Number)) {
				i.remove();
			}
		}
		System.out.println();
		System.out.println("Deleted Non-Number Object");
//		• 再次印出這個集合物件的所有元素,觀察是否已將非Number相關的物件移除成功
		System.out.println("After Delete");
		for(Iterator i1=c1.iterator();i1.hasNext();) {
			System.out.print(i1.next()+"\t");
		}
		System.out.println();
//		• 請設計一個Train類別,並包含以下屬性:
//			- 班次 number,型別為int - 車種 type,型別為String - 出發地 start,型別為String
//			- 目的地 dest,型別為String - 票價 price,型別為double
		
//		• 設計對應的getter/setter方法,並在main方法裡透過建構子產生以下7個Train的物件,放到每小題
//			需使用的集合裡
//			- (202, “普悠瑪”, “樹林”, “花蓮”, 400)
//			- (1254, “區間”, “屏東”, “基隆”, 700)
//			- (118, “自強”, “高雄”, “台北”, 500)
//			- (1288, “區間”, “新竹”, “基隆”, 400)
//			- (122, “自強”, “台中”, “花蓮”, 600)
//			- (1222, “區間”, “樹林”, 七堵, 300)
//			- (1254, “區間”, “屏東”, “基隆”, 700)
		Train[] t=new Train[7];
		t[0]=new Train(202, "普悠瑪", "樹林", "花蓮", 400);
		t[1]=new Train(1254, "區間", "屏東", "基隆", 700);
		t[2]=new Train(118, "自強", "高雄", "台北", 500);
		t[3]=new Train(1288, "區間", "新竹", "基隆", 400);
		t[4]=new Train(122, "自強", "台中", "花蓮", 600);
		t[5]=new Train(1222, "區間", "樹林", "七堵", 300);
		t[6]=new Train(1254, "區間", "屏東", "基隆", 700);
		
//		• 請寫一隻程式,能印出不重複的Train物件
		Set s1=new LinkedHashSet();
		for (Train e:t) {
			s1.add(e);
		}
		System.out.println(s1);
		System.out.println();
//
//		• 請寫一隻程式,讓Train物件印出時,能以班次編號由大到小印出
		PriorityQueue<Train> pq1=new PriorityQueue<Train>();
		for (int j = 0; j < t.length; j++) {
			pq1.add(t[j]);
		}
//		for(Train e: pq1) {
//			System.out.print(e+"\t");
//		}
		Train et;
		while ((et=pq1.poll())!=null) {
			System.out.print(et+"\t");
		}
		System.out.println();
//
//		• 承上,不僅能讓班次編號由大排到小印出, 還可以不重複印出Train物件
		Set s2=new TreeSet<Train>();
		List<Train> tl=Arrays.asList(t);
		for(Iterator<Train> i1=tl.iterator();i1.hasNext();) {
			s2.add(i1.next());
		}
		System.out.println(s2);
//
//		• (以上三題請根據使用的集合,練習各種取值寫法,如迭代器、for迴圈或foreach等)
	}
}
