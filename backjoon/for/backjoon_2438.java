/*
<Problem> - 별 찍기 1
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
*/

import java.util.Scanner;
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.02.
 */
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int ocnt = 1;
		while(total-->0) {
			int cnt = ocnt++; 
			while(cnt-->0) System.out.print("*");
			System.out.println("");
		}
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author tjdghk2002
 * while문 하나와 for문 하나를 비교하면 while문이 더 빠르나 결국에는 loop 수가 적은 것이 더 효율적이다.
 * '*' 하나를 가지고 loop를 통해 여러 개를 찍으려는 것과 달리 '*' String을 추가하는 것으로 loop 수를 줄였다. -> String에도 연산자가 적용된다는 사실을 다시 한 번 되새기자.
 */
public class Main{
	public static void main(String[] args){
		Scanner a = new Scanner(System.in);
		int b = a.nextInt();
		String c="*";
		for(int i = 0; i<b;i++){
		System.out.println(c);
		c+="*";
		}
	}
}
