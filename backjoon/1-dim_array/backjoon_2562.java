/*
<Problem> - 최댓값 No.2562
9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.

첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.

*/

/**
 * My code
 * @author Bellhyuk
 * @date '21.02.05.
 * @version 1.0
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		//배열을 쓰지않고 풀이
		int num = sc.nextInt(), index=1;
		for(int i=2;i<10;i++) {
			int tmp = sc.nextInt();
			if(tmp>num) {
				num = tmp;
				index = i;
			}
		}
		System.out.println(num);
		System.out.print(index);
		
		//정석적인 배열을 사용하여 풀이, 사이즈가 고정되어 있음.
		//값이 작아서인지 속도나 메모리나 크게 차이 x
		int[] arr = new int[9];
		int idx=1, max=arr[0];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
			if(max<arr[i]) {
				max = arr[i];
				idx = i+1;
			}
		}
		System.out.print(max+"\n"+idx);
	}
}
