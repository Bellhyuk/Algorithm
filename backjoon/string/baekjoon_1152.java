/*
<Problem> - 단어 공부 No.1152번

영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까?
이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.

첫 줄에 영어 대소문자와 띄어쓰기로 이루어진 문자열이 주어진다.
이 문자열의 길이는 1,000,000을 넘지 않는다. 단어는 띄어쓰기 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다.
또한 문자열의 앞과 뒤에는 공백이 있을 수도 있다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.15.
 * 
 * <의사코드>
 * nextLine() 및 split()를 통해 공백으로 구분지어 값을 입력받음
 * 한 단어가 여러번 등장해도 등장한 횟수만큼 세는 것으로 중복 무시
 * 
 * 
 */
import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().trim().split(" ");
		System.out.println(str[0].equals("")?0:str.length);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author rlfrbdnjs
 * 
 * enter나 space 값만 들어간 경우에도 split에 의해 ""라는 배열이 형성되어 이를 처리해줘야했다.
 * 나는 str[0].equals("")을 통해 제거했지만 length를 통해 해결한 사례를 가져와 봤다.
 *
 */
public class Main {
	public static void main(String[] args){
		String[] str=new Scanner(System.in).nextLine().trim().split(" ");
		System.out.print(str[0].length()<1 ? 0 : str.length); //길이가 1 이하라는 사실 적용
	}
}

/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author djmann1
 * 
 * StringTokenizer를 사용하여 공백 뒤의 문자열이 공백을 땡겨 채우며 값을 저장
 *
 */
public class Main {
	public static void main(String[] args){
		StringTokenizer str = new StringTokenizer((new Scanner(System.in)).nextLine());
		System.out.print(str.countTokens());
	}
}
