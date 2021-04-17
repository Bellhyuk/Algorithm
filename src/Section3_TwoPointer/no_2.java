package Section3_TwoPointer;

/*2. 공통원소 구하기, 교집합
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성
 * 
 * 입력
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다
 * 
 * 출력
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 * 
 * 이것 또한 Two Pointers Algorithm을 쓰는 것이 아닐까 조심스레 생각해보자.
 * 그러므로 정렬 메소드를 쓰지않고 풀어보고 싶은데 딱히 안떠오르네..
 * 기준 배열 sort하고 Two Pointers 알고리즘 사용
 * 
 * Two Pointers 알고리즘은 무조건 오름차순 정렬이 되어있어야 한다.
*/
import java.util.*;

public class no_2 {
  //강사 풀이 - 내가 하나 놓친게 있네 ㅎㅎ
  public List<Integer> solution(int n, int m, int[] a, int[] b){
    List<Integer> answer = new ArrayList<Integer>();
    Arrays.sort(a);
    Arrays.sort(b);
    int p1=0, p2=0;
    while(n>p1 && m>p2) {
      if(a[p1]==b[p2]) {
        answer.add(a[p1++]);
        p2++;
      } 
      else if(a[p1]<b[p2]) p1++;
      else p2++;
    }
    return answer;
  }
  
  //내 풀이 O(NlogN)
  /*public List<Integer> solution(int n, int m, int[] a, int[] b){
    List<Integer> answer = new ArrayList<Integer>();
    Arrays.sort(a);
    Arrays.sort(b);
    int p1=0, p2=0;
    while(n>p1 && m>p2) {
      if(a[p1]==b[p2]) answer.add(a[p1++]);
      else if(a[p1]<b[p2]) p1++;
      else p2++;
    }
    return answer;
  }*/
  
  public static void main(String[] args) {
    no_2 T = new no_2();
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    int[] narr = new int[n];
    for(int i=0; i<n; i++) {
      narr[i]=sc.nextInt();
    }
    int m = sc.nextInt();
    int[] marr = new int[m];
    for(int i=0; i<m; i++) {
      marr[i]=sc.nextInt();
    }
    for(int a:T.solution(n, m, narr, marr)) {
      sb.append(a).append(" ");
    }
    System.out.println(sb.toString());
  }
}
