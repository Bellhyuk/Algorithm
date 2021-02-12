package practice;

import java.io.IOException;

/*
<Problem> - 아스키코드 No.11654번

알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때,
주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.11.
 * 
 * <의사코드>
 * 아스키코드를 만드는 법
 * String으로 숫자, 문자 상관없이 받고 아스키 코드로 변환
 * charAt()으로 char값을 만들고 0을 더하는 연산을 해주면 형변환
 * 
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		System.out.println(n.charAt(0)+0);//char은 연산에 의해 형변환이 자동으로 이루어진다.
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author sdf7575
 * 
 * System 클래스의 read method는 기본적으로 아스키 코드값이 입력된다.
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		System.out.print(System.in.read());
	}
}
