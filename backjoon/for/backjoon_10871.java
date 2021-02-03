import java.util.Scanner;
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.03.
 */
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int x = sc.nextInt();
		for(int i=0;i<size;i++) {
			int num = sc.nextInt();
			if(x>num) System.out.print(num+" ");
		}
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author sdf7575
 * 진짜 Shortcode를 위해 이렇게도 작성하는구나 하네요..
 * for문 조건에 변수 생성 다넣고 삼항연산자 작성.. 특별한 건 없지만 이렇게 생각할 수 있다는게 대단..
 */
public class Main{
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		for(int i=s.nextInt(),j=s.nextInt(),k;i-->0;System.out.print(k<j?k+" ":""))
			k=s.nextInt();
	}
}
