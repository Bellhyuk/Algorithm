package Section3_TwoPointer;

/*1. 두 배열 합치기
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력
 * 
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 * 
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
*/

//퀵정렬 시간 복잡도 O(NlogN) 최악(n^2)
//이번 문제는 O(NlogN)->O(n) 풀이를 보고자하는 문제
//즉, 내가 푼 sort 메소드를 쓰지않고 풀어야 한다.

//Two Pointers 알고리즘
import java.util.*;

public class no_1 {
  //강사 풀이
  public List<Integer> solution(int n, int m, int[] a, int[] b){
    List<Integer> answer = new ArrayList<>();
    int p1=0, p2=0;
    while(p1<n && p2<m) {
      if(a[p1]<b[p2]) answer.add(a[p1++]);
      else answer.add(b[p2++]);
    }
    while(p1<n) answer.add(a[p1++]);
    while(p2<m) answer.add(b[p2++]);
    
    return answer;
  }
  
  //강사 설명 듣고 푼 내 풀이
  /*public List<Integer> solution(int[] narr, int[] marr){
    List<Integer> answer = new ArrayList<>();
    int p1=0, p2=0, n, m;
    for(int i=0; i<narr.length+marr.length; i++) {
      if(p1==narr.length) n=Integer.MAX_VALUE;
      else n=narr[p1];
      if(p2==marr.length) m=Integer.MAX_VALUE;
      else m=marr[p2];
      if(n < m) {
        answer.add(n);
        p1++;
      }else {
        answer.add(m);
        p2++;
      }
    }
    return answer;
  }*/
  //내 풀이
  /*public List<Integer> solution(int[] narr, int[] marr){
    List<Integer> answer = new ArrayList<>();
    for(int n:narr) {
      answer.add(n);
    }
    for(int m:marr) {
      answer.add(m);
    }
    Collections.sort(answer);
    return answer;
  }*/
  
  public static void main(String[] args) {
    no_1 T = new no_1();
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n=sc.nextInt();
    int[] narr = new int[n];
    for(int i=0; i<n; i++) {
      narr[i]=sc.nextInt();
    }
    int m=sc.nextInt();
    int[] marr = new int[m];
    for(int i=0; i<m; i++) {
      marr[i]=sc.nextInt();
    }
    /*for(int a:T.solution(narr, marr)) {
      sb.append(a).append(" ");
    }*/
    for(int a:T.solution(n, m, narr, marr)) {
      sb.append(a).append(" ");
    }
    System.out.println(sb.toString());
  }
}
