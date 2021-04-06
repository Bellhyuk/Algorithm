package no_6;

/*6. 중복문자 제거
소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성
중복이 제거된 문자열의 각 문자는 원래 문자열의 순서 유지

입력 - 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
출력 - 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
*/
import java.util.*;

public class Main {
  //indexOf 사용, index 번호와 indexOf 값이 같으면 처음 발견된 것으로 볼 수 있다.
  public String solution(String str) {
    String answer="";
    for(int i=0;i<str.length();i++) {
      if(str.indexOf(str.charAt(i))==i) answer += str.charAt(i);
    }
    return answer;
  }
  
  public static void main(String[] args) {
    Main T = new Main();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(T.solution(str));
  }
  
  //LinkedHashSet 사용
  /*public void solution(String str){
      char[] s = str.toCharArray();
      Set<Character> ss = new LinkedHashSet<>();
      for(char c:s) {
        ss.add(c);
      }
      Iterator<Character> iter = ss.iterator();
      while(iter.hasNext()) {
        System.out.print(iter.next());
      }
  }
  
  public static void main(String[] args) {
    Main T = new Main();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    T.solution(str);
  }*/
}
