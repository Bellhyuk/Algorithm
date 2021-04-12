package Section1_String;

import java.util.*;

public class no_4 {
  //단어 뒤집기
  /*public String solution(String str) {
    int len = str.length();
    String answer="";
    StringBuilder sb = new StringBuilder();
    String[] arr = str.split("");
    for(int i=len-1; i>=0; i--) {
      sb.append(arr[i]);
    }
    answer = sb.toString();
    return answer;
  }*/
  public List<String> solution(int n, String[] str){
    List<String> answer = new ArrayList<>();
    /*for(String x:str) {//String을 뒤집는 경우
      String tmp = new StringBuilder(x).reverse().toString(); //StringBuilder 객체 생성, reverse, toString 연속 실행
      answer.add(tmp);
    }*/
    for(String x:str) {//String을 대칭으로 뒤집는 경우
      char[] s = x.toCharArray();
      //양쪽을 lt, rt로 지정해두고 가운데서 수렴하는 방법으로
      int lt=0, rt=x.length()-1;
      while(lt<rt) {
        char tmp=s[lt];
        s[lt]=s[rt];
        s[rt]=tmp;
        lt++;
        rt--;
      }
      String tmp = String.valueOf(s); //char 배열 String 전환
      answer.add(tmp);
    }
    return answer;
  }
  
  
  
  public static void main(String[] args) {
    no_4 T = new no_4();
    Scanner sc = new Scanner(System.in);
    int run = sc.nextInt();
    String[] str=new String[run];
    for(int i=0; i<run; i++) {
      str[i]=sc.next();
    }
    /*for(String x:str) {
      System.out.println(T.solution(x));
    }*/
    for(String x: T.solution(run, str)) { //List를 foreach로 출력할 수 있다.
      System.out.println(x);
    }
  }
}
