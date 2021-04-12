package Section1_String;

import java.util.Scanner;

public class no_3{
  //문장 속 단어
  //한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력
  public String solution(String str) {
    String answer="";
    int max=Integer.MIN_VALUE, pos;
    while((pos=str.indexOf(' '))!=-1) {
    //indexOf는 해당 문자를 발견하면 문자열 내 index 발견못하면 -1
      String s=str.substring(0, pos);
      int len = s.length();
      if(len>max) {
        max = len;
        answer = s;
      }
      str = str.substring(pos+1);
    }
    if(str.length()>max) answer=str;
    return answer;
    
    /*    String answer="";
    int max = Integer.MIN_VALUE;
    String[] arr = str.split(" ");
    for(String x : arr) {
      int len=x.length();
      if(len>max) {
        max=len;
        answer=x;
      }
    }
    return answer;*/
    
/*    String[] arr = str.split(" ");
    int max=-1, idx=0;
    for(int i=0; i<arr.length; i++) {
      if(arr[i].length()>max) {
        max=arr[i].length();
        idx=i;
      }
    }
    return arr[idx];*/
  }
  
  public static void main(String[] args) {
    no_3 T = new no_3();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();// 문자열
    System.out.println(T.solution(str));
  }
}
