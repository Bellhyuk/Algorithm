package practice;

/*
<Problem> - 더하기 사이클 No.1110
0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다.
먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다.
그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.

26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.

N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오
*/

import java.util.Scanner;
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.04.
 * @version 2.0
 * 문자열을 통해 나누고 합하는 것 대신 두자리수로 고정되어있다는 점을 고려하여 %와 /로 작성
 */
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt(), sum=-1, cycle=0, tmp = value;
		while(value!=sum) {
			if(cycle!=0) tmp = sum;
			sum = (tmp%10)*10 + ((tmp/10)+(tmp%10))%10;
			cycle++;
		}
		System.out.println(cycle);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author hyunsu11
 * or 연산자를 통해 if문을 통합하고 변수를 하나 덜 쓸 수 있는 코드를 구현. 
 */
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt(), cycle=0, tmp = value;
		while(value!=tmp||cycle==0) {
			tmp = (tmp%10)*10 + ((tmp/10)+(tmp%10))%10;
			cycle++;
		}
		System.out.println(cycle);
	}
}
