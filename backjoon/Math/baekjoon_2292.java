/*
<Problem> - 벌집 No.2292번
육각형으로 이루어진 벌집
중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 
벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을
지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성

첫째 줄에 N이 주어진다.

입력으로 주어진 방까지 몇 개의 방을 지나는지 출력
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.17.
 * 
 * <의사코드>
 * 결과적으로 몇 번째 육각형 라인에 속해있는 수인가?를 확인하는 것이 중요
 * 기준 수 1 7 19 37 61 ..
 * 사이 간격 6 12 18 24으로 6씩 등차수열 6+6*(n-1)
 * -> 계차수열 일반항: 1 + 등차수열의 합 -> 1 + 3n*(n-1) (n은 1부터)
 * 일반항 값으로 /했을 때 0이 나오는 순간의 n값
 * 
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(), count=1; 
		while(++count>0) {
			int sol = 1+3*count*(count-1);
			if(num==1) {
				count=1;
				break;
			}
			if(num/sol==0 || num==sol) break;
		}
		System.out.println(count);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author pnatasht31
 * 
 * 계차수열의 합을 적용한 것은 동일하나
 * 코드를 적절하게 활용하여 이와같이 표현하지 못한 것이 아쉽다.
 * 기준 값의 a0 값이 1이고 간격 값이 6의 배수로 증가하기에
 * 값에서 간격 값을 빼고 1 이하가 나올 때 다음 라인으로 넘어간다는 것을 이용
 * 더한다고 생각하지말고 빼는 것으로 생각하는게 더 간단하게 풀 수 있었구나 싶네요.
 * 
 */
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt(), a=1;
		while(n>1) {
			n-=6*a++;
		}
		System.out.print(a);	
	}
}

