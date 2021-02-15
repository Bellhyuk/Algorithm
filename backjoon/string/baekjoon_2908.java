/*
<Problem> - 상수 No.2908번

상수는 수를 다른 사람과 다르게 거꾸로 읽는다.
예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다.
따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.

첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.15.
 * 
 * <의사코드>
 * 세 자리 수 두 개 입력 받음
 * 받은 값을 split
 * for문을 통해 역순으로 저장
 * 저장 후 합쳐 세자리 수 형성
 * 두 수 크기 비교
 * 
 */
import java.util.*;
/*public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);;
		int count=2, newnum=0, ans=0;
		while(count-->0) {
			int num = sc.nextInt();
			newnum = (num/100)+(num/10%10)*10+(num%10)*100;
			if(ans<newnum) ans=newnum;
		}
		System.out.println(ans);
	}
}*/
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author gongbea
 * 
 * Stringbuffer 메소드를 사용함으로써 reverse() 메소드 사용 int 타입 변환후 Math 클래스 내 max() 메소드를 통해 크기를 비교했다.
 * 
 */
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println(Math.max(Integer.parseInt((new StringBuilder(sc.next())).reverse().toString()),
		Integer.parseInt((new StringBuilder(sc.next())).reverse().toString())));
	}
}
