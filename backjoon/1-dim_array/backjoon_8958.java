/*
<Problem> - OX퀴즈 No.8958
"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.10.
 * @version 1.0
 * 
 * <의사코드>
 * 테스트 케이스 - 반복문 횟수
 * 배열 굳이 안써도 될거같긴한데.. -> 입력값이 한줄 문자열이라 받아야하는구나..
 * 1) O인가?
 * 2) O면 점수 +1
 * 3) X면 점수 reset
 * 4) sum변수에 합산
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		for(int i=0;i<loop;i++) {//테스트 케이스만큼 반복
			String word = sc.next();//한줄 문자열로 입력값 제공 받음
			String[] words = word.split("");//개별 문자로 split
			int point=0, sum=0;
			for(String w : words) {
				if(w.equals("O")) {
					point++;
				}else {
					point=0;
				}
				sum += point;	
			}
			System.out.println(sum);
		}
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author hyunsu11
 * 
 * 내가 잘 안쓰던 charAt(int index) method 사용
 * 입력받은 index번째 문자를 반환 -> split을 굳이 사용할 필요가 없다!!
 * 
 */
class Main { 
	public static void main(String[]z){
		Scanner S=new Scanner(System.in);
		for(int T=S.nextInt(),i=0;i<T;i++){ //for문 내에서 선언해 받을 수 있구나
			String B=S.next();//공백이 없는 문자열로 next()로 받기
			int R=0;
			for(int j=0,a=0;j<B.length();j++){
				if(B.charAt(j)=='O') R+=++a;
				else a=0;
		}
		System.out.println(R);}
	}
}
