//My code
//@autor Bellhyuk
//@date '21.02.01.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		try {
			int num = Integer.parseInt(br.readLine());//Bufferedreader return 값은 기본적으로 String이기에 integer로 형변환 필요
			br.close();
			for(int i=num; i>0; i--) System.out.println(i);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}

//Best Shortcoding
//@autor natasht31

//데이터 양이 적은 경우 Scanner()를 써도 bufferedreader와 큰 차이가 없다.
//값을 줄이는데 있어서 for문 대신 while문을 써도 된다는 생각..
import java.util.*;
class Main{
	public static void main(String[]t){
		int a=new Scanner(System.in).nextInt();
		while(a>0)System.out.println(a--);
	}
}
