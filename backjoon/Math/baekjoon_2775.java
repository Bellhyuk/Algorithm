package practice;
/*
<Problem> - 부녀회장이 될테야 No.2775번
이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.

입력 - 테스트 케이스 t, 층수 k, 호수 n 순서로 입력(1 ≤ k, n ≤ 14)
출력 - 해당 집의 거주민 수
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.24.
 * 
 * <의사코드>
 * 대충 다음과 같은 형태로 출력
 * 3층 1  5   15
 * 2층 1  4   10  25
 * 1층 1  3    6  10  15 
 * 0층 1  2    3   4   5  6
 * k/n 1호 2호 3호 4호
 * k층 n호에 살고 있는 사람의 수 = k층 n-1호 거주민 수 + k-1층 n호 거주민 수로 계산됨을 확인할 수 있다.
 * 그러나 전부 계산하여 배열에 저장하는 것은 비효율적이므로 일반항을 정리해보자.
 * 일반항
 * 0층-> 초항 1 공차가 1인 등차수열 -> n
 * 
 * 아 단순 일반항으로 어떻게 만들어야 하는지 모르겠다.
 * 일단 배열로 풀어보자
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int k=sc.nextInt(), n=sc.nextInt();
			int[][] table = new int[k+1][n];
			for(int i=0;i<k+1;i++) {
				for(int j=0;j<n;j++) {
					if(i==0) {
						table[i][j]=j+1;
					}
					else if(j==0) {
						table[i][j]=1;
					}
					else table[i][j] = table[i][j-1] + table[i-1][j];
				}
			}
			System.out.println(table[k][n-1]);
		}
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author jinjean0123
 * 
 * 이것말고도 다양한 풀이가 있던데 그 사람들의 계산 방법을 좀 듣고 싶다..
 * 한 층의 배열을 생성하고 층 수만큼 호수별로 값을 더해 거주민 값을 계산
 * 그런데 헷갈릴 소지가 다분히 있어 내 방식을 고수하는 것도 나쁘지않다고 본다. 
 * 
 */
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		while(a-- > 0) {
			int k = s.nextInt(), n = s.nextInt();
			int[] b = new int[n];
			b[0] = 1;
			for(int i = 0; i < k+2; i++) {
				for(int j = 1; j < n; j++) {
					b[j] += b[j-1];
				}
			}
			System.out.println(b[n-1]);
		}
	}
}

