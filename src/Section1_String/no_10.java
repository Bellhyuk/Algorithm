package Section1_String;

/*10.가장 짧은 문자거리
한 개의 문자열 s와 문자t가 주어지면 s의 각 문자가 문자 t와 떨어진 최소거리를 구하는 프로그램 작성
입력 - 첫 줄에 문자열 s와 문자 t가 주어짐, 문자열과 문자는 소문자로만 주어진다.
문자열의 길이는 100을 넘지않는다.
출력 - 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력
*/
import java.util.*;

//어려움...
public class no_10 {
  //tg와 떨어진 가장 짧은 거리, 모든 tg 탐색
  public String solution(String str, String tg) {
    String ans="";
    int[] answer = new int[str.length()];
    int dis=10000;//큰 수로 초기화
    int len=str.length();
    for(int i=0;i<len;i++) {//e를 기준으로 거리 계산
      if(str.charAt(i)==tg.charAt(0)) dis=0;
      else dis++;
      answer[i]=dis;
    }
    dis=10000;//큰 수로 초기화
    for(int i=len-1;i>=0;i--) {//거꾸로 확인해서 값이 작으면 바꾸기
      if(str.charAt(i)==tg.charAt(0)) dis=0;
      else dis++;
      //if(answer[i]>dis) answer[i]=dis;
      answer[i]=Math.min(answer[i], dis);
    }
    for(int a:answer) {
      ans += a+" ";
    }
    return ans;
  }
  
  public static void main(String[] args) {
    no_10 T = new no_10();
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    String t = sc.next();
    System.out.println(T.solution(s, t));
  }
}
