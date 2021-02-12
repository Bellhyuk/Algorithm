/*
<Problem> - 문자열 반복 No.2675번

문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
S의 길이는 적어도 1이며, 20글자를 넘지 않는다. 

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.13.
 * 
 * <의사코드>
 * 테스트 케이스 수만큼 while문
 * 문자 반복 횟수 r받기
 * 문자열 S받기
 * 문자열 S의 한 단어 뽑고 반복문을 통해 r번 반복 출력 
 * 
 */
import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);//문자열 S가 20자를 넘지 않기 때문에 Scanner
		int count = sc.nextInt();
		while(count-->0) {
			int R = sc.nextInt(), idx=0, r=0;
			String[] S = sc.next().split("");//buffer에 올라간 개행 문자를 받지 않기 위해 next(), 공백도 없어서 가능
			int len = S.length;
			while(len-->0) {
				r=R;
				while(r-->0) System.out.print(S[idx]);
				idx++;
			}
			System.out.print("\n");
		}
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author emffkd
 * 
 * String을 두 개 선언, 데이터를 받는 용, 출력 용
 * charAt()를 통해 각 문자를 반복하여 String에 추가
 * 배울 점은 print 메소드를 한번만 썼다는 것.
 * 아무래도 정규식으로 구성된 print 메소드를 반복해서 쓰는 것은 좋지않다.
 * 이 분의 코드와 같이 한번에 모아서 출력을 해주는 것을 도전해보자.
 *
 */
public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String S, P="";
		int R,T;
		T=in.nextInt();
		for(int j=0;j<T;j++) {
			R=in.nextInt();
			S=in.next();
			for(int i=0;i<S.length();i++) {
				for(int k=0;k<R;k++) {
					P+=S.charAt(i);
				}
			}
			System.out.println(P);
			P="";
		}
	}
}
