/*
<Problem> - 숫자의 개수 No.2577
세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 같거나 크고, 1,000보다 작은 자연수이다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.05.
 * @version 1.0
 * 이중 for문으로 값이 클 경우, 속도가 현저하게 낮아질 우려가 있다.
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int mul = (sc.nextInt())*(sc.nextInt())*(sc.nextInt());
		String[] arr = String.valueOf(mul).split("");
		for(int i=0;i<10;i++) {
			int count = 0;
			for(String num:arr) { //for문을 두번..
				if(Integer.parseInt(num) == i) count++;
			}
			System.out.println(count);
		}
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author sdf7575
 * 숫자를 자르는 방법에 문자열로 변환하여 자르는 방법도 있지만 %10으로 자를 수 있다.
 * 이를 이미 인지하고 있었으나 적용하기 힘들 것이라 생각했는데
 * 이렇게 풀어가다니 감탄 밖에 안나돈다.ㅎㅎ
 */
class Main{static void main(String[]z){
	Scanner S=new Scanner(System.in);
	int A[] = new int[10], a = S.nextInt() * S.nextInt() * S.nextInt();
	for(;a>0;a/=10) A[a % 10]++; //맨 끝자리 하나씩 빼서 해당 숫자의 칸 값을 1 올림.
	for(int i:A) System.out.println(i);
	}
}
