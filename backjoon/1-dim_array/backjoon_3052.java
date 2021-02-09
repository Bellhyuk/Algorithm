/*
<Problem> - 나머지 No.3052
수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다. 이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.09.
 * @version 1.0
 */
import java.util.*;
public class Main {
	//수 10개 - 10개니 Scanner로 받고
	//42로 나눈 나머지 - 변수%42 배열에 저장
	//서로 다른 값이 몇개 있는지 출력 - for문을 통해 하나씩 비교
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int idx=0, count=10;
		for(int a: arr) {//배열 생성
			a = sc.nextInt()%42;
			arr[idx++]= a;
		}
		for(int i=0;i<9;i++) {
			for(int j=i+1;j<10;j++) {
				if(arr[i]==arr[j]) {
					count--; //총 10개에서 같은 수가 있으면 -1씩
					break;//중복으로 count -1하는 것을 피해주기위해 중복 하나씩만 골라내기
				}
			}
		}
		System.out.println(count);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author dhwhc0711
 * 
 * 염두해두고 있던 HashSet()을 이용한 풀이
 * 중복 값을 받지 않는다는 성질을 이용한 최적의 class라 생각된다.
 * 역시 list, map, set 등을 이용하는 연습이.. 언제까지 array만 쓸 수 는 없는 노릇이니.
 * 
 */
class Main { 
	public static void main(String[]z){
		Scanner sc =new Scanner(System.in);
		HashSet<Integer> a = new HashSet<>();
		for(int i=0;i<10;i++) a.add(sc.nextInt()%42);
		System.out.println(a.size());
	}
}
