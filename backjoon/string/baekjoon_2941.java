package practice;
/*
<Problem> - 크로아티아 알파벳 No.2941번

예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다.
단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다.
위 목록에 없는 알파벳은 한 글자씩 센다.

첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.16.
 * 
 * <의사코드>
 * 두 글자 연속, 세 글자 연속이 둘다 보이는 것으로 연속된 값으로 찾는데는 어려움이 있음
 * 문자열의 뒤에서부터 탐색하여 "=, -, j"가 있을 때 그 다음 값을 조건문으로 비교
 * index와 count를 별도로 지정
 * 
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();//공백이 없으므로 next()
		int count=0;
		for(int i=str.length()-1;i>=0;i--) {
			if(i-1>0) {
				if(str.charAt(i)=='=') {
					if(i-2>=0 && str.charAt(i-1)=='z' && str.charAt(i-2)=='d') i-=2;
					else i--;
				}
				if(str.charAt(i)=='-') i--;
				if(str.charAt(i)=='j') {
					if(str.charAt(i-1)=='l'||str.charAt(i-1)=='n') i--;
				}
			}
			count++;
		}
		System.out.print(count);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author jinjean0123
 * 
 * String replace(), replaceAll();
 * 크로아티아 알파벳 값을 모두 1로 바꿔주고 갯수를 세기위해 length()를 해준다.
 * 진심.. method()를 많이 알면 알수록 손이 편하구나..
 * 
 */
public class Main {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println(s.next().replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "1").length());
	}
}
