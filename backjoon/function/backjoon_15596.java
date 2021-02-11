/*
<Problem> - 정수 N개의 합 No.15596

양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의
Ex. d(75) = 75+7+5 = 87이다.

양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다. 

예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다. 이런식으로 다음과 같은 수열을 만들 수 있다.
33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...

n을 d(n)의 생성자라고 한다. 위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다. 생성자가 한 개보다 많은 경우도 있다. 예를 들어, 101은 생성자가 2개(91과 100) 있다. 

생성자가 없는 숫자를 셀프 넘버라고 한다.
100보다 작은 셀프 넘버는 총 13개가 있다. 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97

10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.11.
 * @version 1.0
 * 
 * <의사코드>
 * d(n)에 대한 함수, n + n에 대한 charAt(i) for문
 * n에 d(n)값 할당 후 반복
 * 생성자자가 없다는 것은 d(n)수열로 만들 수 없는 수
 * 1부터 10000까지 0을 할당한 배열
 * d(n)수열로 만들 수 있는 수는 플러스
 * false인 값 검색하여 출력
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		int size = 100;
		int arr[] = new int[size]; //int로 선언하면 자동 0으로 초기화
		for(int i=1;i<size+1;i++) {
			int dn=i;
			while(dn<size+1) {
				int n=0;
				String tmp = String.valueOf(dn);
				for(int j=0;j<tmp.length();j++) n += (tmp.charAt(j)-'0'); //char 값이 ASCII코드 값으로 int 형변환 -> '0'값을 빼줌으로 원하던 값을 맞춰줄 수 있다.
				dn+=n;
				if(dn<size+1) arr[dn-1]++;
				else break;
			}
		}
		for(int k=0;k<arr.length;k++) {
			if(arr[k]==0) System.out.println(k+1);
		}
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author pts119
 * 
 * n=9999일 떄 d(n)값이 9999+36까지 나올것을 고려하여 배열크기를 10036으로 잡음
 * 정수에서 한 자리씩 뽑아낼 떄 /와 %를 이용하는 것이 효율이 좋다. 좀더 적극적으로 활용해보자.
 * 반복문을 최대한 덜 쓸 수 있는 방법 다음과 같은 방법을 연습하자!
 * 
 */
public class Main {
	public static void main(String[] args) {
		boolean[] arr = new boolean[10036];
		for(int n = 1 ; n <= 10000 ; n++) {
			arr[d(n)] = true;
			if(!arr[n])	System.out.println(n);
		}
	}
	
	static int d(int n) {
		n += ((n/1000)%10) + ((n/100)%10) + ((n/10)%10) + (n%10);
		return n;
	}
}

