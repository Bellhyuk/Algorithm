/*
<Problem> - 별 찍기 2
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
*/

import java.util.Scanner;
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.02.
 */
//public class Main {
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		int ototal = sc.nextInt();
//		int ctotal = ototal;
//		int ocnt = 1;
//		while(ctotal-->0) {
//			int dot = ocnt;
//			int space = ototal-(ocnt++);
//			while(space-->0) System.out.print(" ");
//			while(dot-->0) System.out.print("*");
//			System.out.println("");
//		}
//	}
//}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author rootcucu
 * 1.
 * for문 마지막에 꼭 하나만 작성하는 것이 아니라 두개 이상 작성할 수 있다는 것을 되새기자!
 * 2.
 * String.format() 메소드로부터 나온 개념
 * Structure: format string + argument
 * %s 등을 통해 데이터 타입 지정
 * 기본적으로 오른쪽 정렬(-를 붙임으로써 왼쪽 정렬 가능)
 * % + 길이 + string 데이터 타입, argument로 표현
 * 
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "*";
        for (int i = 0; i < n; s += "*", i++)
            System.out.format("%" + n + "s\n", s);
    }
}
