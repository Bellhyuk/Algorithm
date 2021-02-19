package practice;
/*
<Problem> - 달팽이는 올라가고 싶다 No.2869번
땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다.
또, 정상에 올라간 후에는 미끄러지지 않는다.
달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.20.
 * 
 * <의사코드>
 * 낮에 올라가는 거리 A, 밤에 미끄러지는 거리 B, 높이 V, 정상에서 끝
 * 조건에서 이미 A-B>0이므로 체크 필요x
 * 필요 날짜 수 N
 * 1. 낮에 많이 올라가므로 N*(A-B)+A>V인 N 체크 필요
 * 받는 횟수가 1번이고 그렇게 길지 않기 때문에 Scanner 그래도 사용
 * 1번만 고려해도 충분
 * 
 * 시간 부족..
 * 
 * 나누기 이용 -> 반복문 사용x
 * (A-B)로 나누면서 발생하는 2가지 경우,
 * 1. 나누어 떨어짐 %=0
 * 2. 나누어 떨어지지 않고 %<=A
 * 
 * (V-A)/(A-B)를 함으로써 N 하나 전 값을 구하고 나머지는 0이거나 A보다 작거나 같으므로
 * 나머지가 없으면 1을 더해주고 존재하면 2를 더해줌으로써 해결
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int A=sc.nextInt(), B=sc.nextInt(), V=sc.nextInt(), N=0;
		N = (V-A)/(A-B);
		System.out.print((V-A)%(A-B)==0?N+1:N+2);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author dbckdqur12
 * 
 * Math 클래스를 사용
 * ceil 메소드: 올림값.
 * 그렇다 올림값을 사용한다면 굳이 삼항연산자를 통해 N+1과 N+2를 구분지을 필요가 없는 것...
 * 
 */
public class Main {
	public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int a=sc.nextInt(), b=sc.nextInt(), x=sc.nextInt();
        System.out.println((int)Math.ceil((double)(x-a)/(a-b))+1);	
	}
}
