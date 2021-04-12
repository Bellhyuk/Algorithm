package Section1_String;

/*8. 유효한 팰린드롬
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열 - 팰린드롬
해당 문자열이 팰린드롬이면 "YES", 아니면 "NO"
다만 회문을 검사할 때 알파벳만 검사, 대소문자 구분X
알파벳 이외 문자는 모두 무시

입력 - 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
출력 - 첫 줄에 YES 또는 NO 출력

전체 길이가 비대칭이여도 알파벳만 대칭이면 ok
index를 고려하지 않아야 한다.
*/
import java.util.*;

public class no_8 {
  //풀이1, 알파벳말고 싹다 없애버리기
  //replaceAll -> 어떻게? 정규식 이용ㅎ
  public String solution(String str) {
    String answer="NO";
    str = str.toLowerCase().replaceAll("^[a~z]", "");
    String tmp = new StringBuilder(str).reverse().toString();
    if(str.equals(tmp)) return "YES";
    return answer;
  }
  
  //알파벳만 고려! index 고려를 버려야 한다!
  /*public String solution(String str) {
    String answer="YES";
    str = str.toLowerCase();
    int len = str.length();
    int s=0, e=len-1;
    while(e-s>0) {
      if(!Character.isAlphabetic(str.charAt(s))) {
        s++;
        continue;
      }
      if(!Character.isAlphabetic(str.charAt(e))) {
        e--;
        continue;
      }
      if(str.charAt(s)!=str.charAt(e)) return "NO";
      else {
        s++;
        e--;
      }
    }
    return answer;
  }*/
  
  public static void main(String[] args) {
    no_8 T = new no_8();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(T.solution(str));
  }
}
