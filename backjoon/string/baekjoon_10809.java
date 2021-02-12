/*
<Problem> - 아스키코드 No.10809번

알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.12.
 * 
 * <의사코드>
 * 단어 S 받아오기
 * a부터 z까지 
 * 아스키 코드 값으로 비교하여 존재여부 확인
 * S를 toCharArray()를 통해 한 글자씩으로 분리
 * 분리한 값을 비교 idx값 따로 
 * 
 * 
 */
import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		for(char i='a';i<='z';i++) {
			int idx=0, sign=0;
			for(char c:S.toCharArray()) {
				if(i==c) {
					System.out.print(idx+" ");
					sign++;
					break;
				}
				idx++;
			}
			if(sign==0) System.out.print(-1+" ");
		}
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author sdf7575
 * 
 * indexOf 메소드를 쓰면 이렇게 간단할 줄이야...
 * -> 특정 문자나 문자열이 앞에서부터 처음 발견되는 인덱스를 반환 or 찾지 못했을 경우 -1
 * 아스키 코드를 사용한다는 발상은 똑같이
 * 
 * indexOf를 알고 문제를 보니 애초에 indexOf 쓰는 것을 의도한듯 하다.
 *
 */
public class Main {
	public static void main(String[] args){
		String S = new java.util.Scanner(System.in).next();
		int i='a';
		while(i<=
				'z') System.out.print(S.indexOf(i++)+" ");
	}
}
