package Section1_String;

/*12. 암호
현수는 영희에게 알파벳 대문자로 구성된 비밀편지를 매일 컴퓨터를 이용해 보냅니다.
비밀편지는 알파벳 한 문자마다 # 또는 *이 일곱 개로 구성되어 있습니다.
조건
1. “#*****#”를 일곱자리의 이진수로 바꿉니다.
#은 이진수의 1로, *이진수의 0으로 변환합니다. 결과는 “1000001”로 변환됩니다.
2. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.
3. 아스키 번호가 65문자로 변환합니다. 즉 아스크번호 65는 대문자 'A'입니다.

의사코드
1.replace 함수를 통해 #을 1로 *을 0으로 변환
2.7자리씩 문자열을 자름
3.이진수 -> 십진수
4.char를 통해 아스키 번호 -> 문자
5.문자 합치기
*/
import java.util.*;

public class no_12 {
  //풀이
  public String solution(int n, String str) {
    String answer ="";
    for(int i=0;i<n;i++) {
      String tmp=str.substring(0,7).replace('#','1').replace('*', '0');//앞에서부터 7개 뽑아온 것만 다루기
      int num = Integer.parseInt(tmp, 2);
      answer += (char)num;
      str = str.substring(7);//이렇게 저장해 놓으면 하나씩 뽑아쓸 수 있다.
    }
    return answer;
  }
  
  //내 풀이
  /*public String solution(int n, String str) {
    String answer="";
    int len = str.length();
    //replace를 통해 변환
    str = str.replace('#', '1');
    str = str.replace('*', '0');
    //7자리씩 문자열 자름
    String[] ans = new String[len/7];
    for(int i=0;i<len/7;i++) {
      ans[i]=str.substring(0+i*7, 7+i*7);
    }
    for(String s:ans) {
      int num = Integer.parseInt(s, 2);
      answer += (char)num;
    }
    return answer;
  }*/
  
  public static void main(String[] args) {
    no_12 T = new no_12();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String str = sc.next();
    System.out.println(T.solution(n, str));
  }
}
