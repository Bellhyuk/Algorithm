package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
<Problem> - 설탕 배달 No.2839번
지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
최대한 적은 봉지를 들고가는 것이 목표
-> 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달
설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성

입력 - 첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
출력 - 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.25.
 * 
 * <의사코드>
 * 최소한의 봉지 수를 구하는 것
 * 1. 설탕 N을 5로 먼저 나눈 값 A와 나머지a
 * 2. a를 3으로 나눈 값 B와 나머지b
 * b가 0이면 A+B, 0이 아니면 -1
 * 
 * 문제는 한 번만 돌려서 되는 것이 아니라는 것
 * 2번 과정에서 -1이 나왔을 때 A--를 통해 a 재계산 반복
 * 12의 경우 5짜리가 1개라도 들어가면 나눌 수 없지만 3으로만 채우면 나눠 가져갈 수 있다.
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(),A=N/5,B=0,a=0,b=0;
		for(int i=A, j=0;i>=0;i=--A) {
			a = N%5+5*(j++); B=a/3; b=a%3;
			if(a==0 || b==0) break;
		}
		System.out.println(b==0?A+B:-1);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author code1995
 * 
 * BufferedReader는 현재 입력 값 수가 그렇게 많지는 않기때문에 큰 의미는X
 * 삼항연산자를 3번 사용 5와 3으로 구성할 수 없는 4,7을 따로 빼고
 * 5로 나눴을 때 나머지가 1 또는 3일 떄 +1
 * 5로 나눴을 떄 나머지가 2 또는 4일 때 +2
 * 어떻게 저런 식으로 나눌 수 있는지는 잘 모르겠는데 반복문을 한 번도 안썼다는게 대단..
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int mod = N%5;
		System.out.println(N==4||N==7 ? -1 : mod==0 ? N/5 : mod==1||mod==3 ? N/5+1 : N/5+2);
	}
}

