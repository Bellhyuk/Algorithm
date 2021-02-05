import java.util.*;
/*
<Problem> - 최소,최대 No.10818
N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.05.
 * @version 1.0
 * Arrays 클래스를 이용하는 방법과 for문을 통해 출력하는 방법 사용
 */
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[sc.nextInt()];
		for(int i=0;i<num.length;i++) {
			num[i]=sc.nextInt();
		}
		//Arrays 라이브러리
		Arrays.sort(num);
		System.out.println(num[0]+" "+num[num.length-1]);
		
		//for문, Arrays 라이브러리를 쓰는 것보다 빠른 값이 나왔다.
		int min=num[0], max=num[0];
		for(int i=0;i<num.length;i++) {
			if(min>num[i]) min = num[i];
			if(max<num[i]) max = num[i];
		}
		System.out.print(min+" "+max);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author rlfrbdnjs
 * 문제 자체가 최대, 최소만 구하는 것이기 때문에 그냥 바로 비교를 했는데 내 코드와 크게 차이가 없다. 오히려 삼항연산자를 굳이 쓸 필요가 있었을까 싶음.
 */
class Main{public static void main(String[]a){
	Scanner c=new Scanner(System.in);
	int l=c.nextInt(), n=c.nextInt(), b=n, s=n;
	for(int i=1;i<l;i++){
		n=c.nextInt();
		b=n> b ? n : b;
		s=n> s ? s : n;
		}
	System.out.print(s+" "+b);
	}
}
