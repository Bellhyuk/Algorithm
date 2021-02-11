package practice;
/*
<Problem> - 한수 No.1065

어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.11.
 * 
 * <의사코드>
 * 양의 정수 X의 각 자리가 등차수열을 이룬다.(N<=1000)
 * for문을 통해 반복하며 1부터 수를 받고
 * if문을 통해 수의 각 자리수가 일정한 차를 같는지 확인
 * 확인되면 count
 * 
 * 솔직히 좀 우겨넣은 느낌이 강하다...ㅎ
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int count=0, N=sc.nextInt();
		for(int n=1;n<=N;n++) {
			if(n<100) count++;
			else {
				if((n/100) - ((n/10)%10)==((n/10)%10)-(n%10)) count++; //100을 나누고 %를 하지않음으로 1000에 제외 가능
			}
		}
		System.out.println(count);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author pts119
 * 
 *3자리 정수로 가정하여 양쪽 1의 자리와 100의 자리의 합이 10의 자리X2라는 사실을 이용함 신박하네 ㅎㅎ
 *
 */
public class Main {
	public static void main(String[] args) {
		int n=new java.util.Scanner(System.in).nextInt()+1,m=0;
		if(n>1000) n--;
		while(--n>110) {
			if(n/100+n%10==n/10%10*2)m++; 
		}System.out.print(n<100?n:m+99);
	}
}
