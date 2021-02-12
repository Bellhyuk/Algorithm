import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
<Problem> - 아스키코드 No.11720번

N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.12.
 * 
 * <의사코드>
 * 이번에는 Scanner말고 BufferedReader로 입력받기를 해보자
 * 첫 번째 입력 문자열 사이즈 두 번째 입력 값
 * split을 통해 문자열 나누고
 * for문을 통해 합해주기
 * 
 */
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] nums= new String[Integer.valueOf(bf.readLine())]; //그냥 read()로 입력받으면 ASCII 값을 int로 변환해주는 것이기에 -48을 해줘야하고 개행문자인 /n을 따로 받아줘야하기에 바로 아래 readLine()을 추가해줘야하는 불편함이 있다.
		nums = bf.readLine().split("");
		int sum=0;
		for(String num:nums) sum += Integer.valueOf(num);
		System.out.println(sum);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author sdf7575
 * 
 * Scanner 클래스를 사용하되 toCharArray()를 쓰고 그래로 char 값으로 계산함으로써 코드를 간추렸다.
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		int a=0;
		Scanner s=new Scanner(System.in);
		s.next(); // 가볍게 무시 ㅋㅋㅋㅋ 나도 이렇게 생각했지만 일단 받으려고는 했는데 참..
		for(char i:s.next().toCharArray()) a += i-48;
		System.out.print(a);
	}
}
