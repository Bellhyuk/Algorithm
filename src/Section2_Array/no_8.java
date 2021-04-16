package Section2_Array;

/*8. 등수 구하기
N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

입력
첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
출력
입력된 순서대로 등수를 출력한다.

의사코드 map을 활용해볼까
*/
import java.util.*;

public class no_8 {
  //강사 풀이
  //수가 많을수록 효율은 떨어지나 코드가 간단하다
  public int[] solution(int n, int[] arr) {
    int[] answer = new int[n];
    for(int i=0; i<n; i++) {
      int cnt=1;
      for(int j=0; j<n; j++) {
        if(arr[j]>arr[i]) cnt++;
      }
      answer[i]=cnt;
    }
    return answer;
  }
  
  public static void main(String[] args) {
      no_8 T = new no_8();
      Scanner sc = new Scanner(System.in);
      int n=sc.nextInt();
      int[] arr = new int[n];
      for(int i=0;i<n;i++) {
        arr[i]=sc.nextInt();
      }
      for(int x:T.solution(n, arr)) System.out.println(x+' ');
    }
  //내풀이
/*  public ArrayList<Integer> solution(int n, int[] arr) {
    Map<Integer,Integer> m = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    //key-점수, value-등수
    int[] sarr = arr.clone();
    Arrays.sort(sarr);
    int max=1000, grade=0, gr=0;
    for(int i=n-1;i>=0;i--) {
      if(max>sarr[i]) {
        max=sarr[i];
        grade++;
        if(gr>0) {
          grade+=gr;
          gr=0;
        } 
      }
      else gr++;
      m.put(max, grade);
    }
    for(int x:arr) {
      list.add(m.get(x));
    }
    return list;
  }
  
  public static void main(String[] args) {
    no_8 T = new no_8();
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i]=sc.nextInt();
    }
    for(int a: T.solution(n, arr)) {
     sb.append(a).append(" "); 
    }
    System.out.println(sb.toString());
  }*/
}
