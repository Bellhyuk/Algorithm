/*
<Problem> - 그룹 단어 체커 No.1316번

그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다.
단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

첫째 줄에 그룹 단어의 개수를 출력한다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.02.17.
 * 
 * <의사코드>
 * 받아오는 단어의 개수 -> 반복 횟수
 * count = 단어 개수
 * for문{
 * 		단어 받기
 * 		해당 index 글자와 그전 index 글자가 다른 경우(index 1부터 시작)
 * 		그전에 글자 중에 해당 index 글자와 같은 글자가 존재하면 count--;
 * }
 * 
 * 
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt(), count=loop;
		while(loop-->0) {
			int sign = 0;
			String str = sc.next();
			for(int i=1;i<str.length();i++) {
				if(sign==1) break;
				if(str.charAt(i)!=str.charAt(i-1)) {
					for(int j=i-1;j>=0;j--) {
						if(str.charAt(i)==str.charAt(j)) {
							sign++;
							count--;
							break;
						}
					}
				}
			}
		}
		System.out.println(count);
	}
}
/**
 * Best Shortcoding(메모리와 시간이 작은 것을 중심으로)
 * @author hyunsu11
 * 
 * a~z까지의 배열을 하나 선언해주고 for문을 돌 때 해당 글자가 나오면 더해주는 것으로 나온 글자 체크
 * 그리고 index 글자와 그전 글자가 다른 경우에 index 글자의 값이 1이상인 경우 count를 하지 않는 방식
 * 알파벳을 소문자로만 받았기에 가능한 방법 -> 문제에 이미 주어진 것으로 보아 이런 식으로 풀기를 원했을 수도..
 * 반복문을 하나 덜 쓴만큼 시간 복잡도에서 이득을 본다.
 * 다양한 방법을 고민해보고 바로 적용해보도록 하자.
 * 
 */
public class Main {
	public static void main(String[] args){
		Scanner S=new Scanner(System.in);
		int R=0;
		for(int N=S.nextInt(),i=0;i<N;i++){
			String T=S.next();
			int[]I=new int[26];
			int P=0;
			I[T.charAt(0)-97]++;
			for(int j=1;j<T.length();j++){
				if(T.charAt(j)!=T.charAt(j-1)) ++I[T.charAt(j)-97];
				if(I[T.charAt(j)-97]>1) P=1;
				}
			if(P==0)R++;
			}
		System.out.print(R);
	}
}
