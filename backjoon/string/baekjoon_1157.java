package practice;
import java.io.IOException;
/*
<Problem> - 단어 공부 No.2675번

알파벳 대소문자로 된 단어가 주어지면,
이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
단, 대문자와 소문자를 구분하지 않는다.

첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.15.
 * 
 * <의사코드>
 * Scanner로 단어 문자열 한 번 받기
 * 아스키 코드 값으로 확인
 * 모든 단어 대문자로 변경
 * 알파벳별로 갯수 카운트
 * 최대 갯수의 알파벳이 두 개 이상이면 ? 출력 아니면 대문자로 출력
 * 
 * 
 */
import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String words = sc.next().toUpperCase(); //공백이 없으니 next() + 모두 대문자화
		char ans = ' ';
		int max=0; 
		for(int i='A';i<='Z';i++) {
			int count=0;
			for(char word: words.toCharArray()) { //알파벳 하나씩 비교
				if(i == word) count++; 
			}
			if(max==count) ans='?'; 
			if(max<count) {
				max=count; 
				ans=(char)i;
			}
		}
		System.out.print(ans);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author itpl5972
 * 
 * System 클래스의 read 메소드를 통해 하나씩 읽음
 * 소문자가 대문자보다 아스키코드 값이 크다는 것을 이용
 * 한번에 처리하는 내 코드와 달리 두 개로 나눠 오히려 이중 for문을 피함으로써 시간을 줄임.
 *
 */
public class Main {
	public static void main(String[] args) throws IOException{
		int[] count = new int[26];
		int max =0;
		char result = '?';
		for(int i=System.in.read(); i>='A'; i=System.in.read()) {
			if(i >= 'a') {
				count[i-'a']++;
			} else{
				count[i-'A']++;
			}
		}
		
		for(int i=0; i<count.length; i++) {
			if(count[i] >max) {
				max = count[i];
				result = (char)(i+'A');
			} else if(count[i] == max) {
				result = '?';
			}
		}
		System.out.println(result);
	}
}
