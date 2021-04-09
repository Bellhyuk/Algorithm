package no_7;

/*7. 회문 문자열
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열 -> 회문 문자열
해당 문자가 회문 문자열이면 YES, 아니면 NO 출력
단, 대소문자 구분 X

입력 - 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
출력 - 첫 줄에 YES 또는 NO 출력
*/
import java.util.*;

public class Main {
  //풀이2
  //equals() 대소문자 구분, equalsIgnoreCase() 대소문자 구분X
  public String solution(String str) {
    String answer = "NO";
    String tmp = new StringBuilder(str).reverse().toString();
    if(str.equalsIgnoreCase(tmp)) answer = "YES";
    return answer;
  }
  
  //풀이1
  /*public String solution(String str) {
     String answer = "YES";
     int len = str.length();
     for(int i=0; i<len/2; i++) {
       if(str.charAt(i)!=str.charAt(len-i-1)) return "NO";
     }
     return answer;
  }*/
  
  //뒤집는 것이 아닌 중심을 기준으로 비교
  /*public String solution(String str) {
    String answer="";
    str = str.toLowerCase();
    String[] arr = str.split("");
    int len = str.length(), flag=0;
    for(int i=0;i<len/2;i++) {
      if(!arr[i].equals(arr[len-i-1])) {
        flag++;
        break;
      }
    }
    answer = flag>0 ? "NO":"YES";
    return answer;
  }*/
  
  //StrinBuilder 사용
  /*public String solution(String str) {
    String answer = "";
    str = str.toLowerCase();
    StringBuilder sb = new StringBuilder(str);
    String rstr = sb.reverse().toString();
    if(str.equals(rstr)) answer = "YES";
    else answer = "NO";
    
    return answer;
  }*/
  
  //String -> List -> String
  /*public String solution(String str) {
    String answer = "";
    str = str.toUpperCase();
    String[] arr = str.split("");//대소문자 구분X
    
    List<String> list = new ArrayList<String>();
    list = Arrays.asList(arr);
    Collections.reverse(list);
    
    String rstr = "";
    for(String s:list) rstr += s;
    
    if(str.equals(rstr)) answer = "YES";
    else answer = "NO";
    
    return answer;
  }*/
  
  public static void main(String[] args) {
    Main T = new Main();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(T.solution(str));
  }
}
