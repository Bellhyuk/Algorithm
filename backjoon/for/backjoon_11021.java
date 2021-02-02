import java.util.Scanner;
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.01.
 */
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int num = 1;
		while(cnt-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("Case #"+(num++)+": "+(a+b));
		}
	}
}

/**
 * Best Shortcoding
 * @author sdf7575
 * printf와 %d의 사용
 * println()이 변수의 값을 그대로 출력하는 것과 달리 printf()는 지시자를 통해 변수의 값을 여러가지 형식으로 변환하여 출력 가능
 * 그러나 이 과정에서 시간과 메모리를 더 소모하므로 내 코드를 쓰되 알아만 두자.
 */
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		int num = 1;
		while(cnt-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("Case #%d: %d\n",(num++),(a+b));
		}
	}
}
