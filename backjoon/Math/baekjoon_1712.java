/*
<Problem> - 손익분기점 No.1712번

A만원의 고정 비용, B만원의 가변 비용
노트북 가격 C만원으로 책정
손익분기점(판매수익-총비용(고정비용+가변비용)>0이 되는 지점)까지의 노트북 판매 대수를 구하시오.

첫 번째 줄에 A,B,C 순서대로 공백을 두고 입력 값이 주어짐

판매량 출력, 손익분기점이 존재하지 않는다면 -1

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.17.
 * 
 * <의사코드>
 * 판매 대수 x
 * 총 비용 A + B*x
 * 판매수익 C*x
 * C*x - (A + B*x) >0 -> (C-B)x - A>0인 x를 구하는 것
 * C-B<=0이면 손익분기점 존재x
 * 
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt(), count=0;
		if(C<=B) count=-1;
		else while(true) if((C-B)*(++count)-A>0) break;
		System.out.println(count);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author protoseo
 * 
 * 생각이 짧았습니다...
 * 결국 몫을 구하면 되는 것이기에 while문을 쓰지 않아도 되었으며
 * if와 else if 두개만 존재한다는 것은 삼항연산자를 써도 무관하다는 것!
 * 
 */
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println((c>b)?(a/(c-b))+1:-1);
	}
}
