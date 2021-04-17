package Section3_TwoPointer;

/*4. 연속 부분수열
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 * 
 * 입력
 * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
 * 수열의 원소값은 1,000을 넘지 않는 자연수
 * 
 * 출력
 * 첫 줄에 경우의 수을 출력합니다.
 * 
 * 의사코드
 * 연속 부분 수열
 * 연속적인 수로 이뤄진 부분 수열이라는 조건이 존재하므로 Sliding Window 기법을 사용할 수 있다.
 * 창의 크기는 1부터 N까지
 * 합 값을 통해 비교
*/

//문제 혼자 못 품.. 강사 풀이를 보고 풀어보겠습니다.
//복합적 문제
//N값이 10만이상이 되면 O(N^2)부터 허용되지 않는 효율이라는 것을 알아두자.
//O(n^2) -> O(n)으로 만들어보자.
//for문을 통해 창의 크기 k값을 바꿔주는 것이 아니라 rt, lt를 통해 k값을 바꿔주자.
//창의 크기를 고정해서 for문을 돌려 하나씩 하는 것이 아니라
//창의 크기를 유동적으로 조절하면서 확인하자
//sliding window가 한쪽으로 움직이면서 하는 방식이 아닌 창의 크기를 늘리고 줄이면서 찾는 방식

//강의 듣고 풀어보기 -> 끝까지 못품...
import java.util.*;
public class no_4 {
  //강사 풀이
  public int solution(int n, int m, int[] a) {
    int answer=0, sum=0, lt=0;
    for(int rt=0; rt<n; rt++) {
      sum += a[rt];
      if(sum==m) answer++;
      while(sum>=m) {
        sum-=a[lt++];
        if(sum==m) answer++;
      }
    }
    return answer;
  }
  
  //이게 Time Limit Exceeded가 뜨네..
  /*private int solution(int n, int m, int[] a) {
    int sum, cnt=0, ;
    //연속 부분 수열 크기 1~n까지
    for(int k=1; k<n+1; k++) {
      sum=0;
      //창 만들기
      for(int i=0; i<k; i++) {
        sum+=a[i];
      }
      if(sum==m) cnt++;
      //창 옮기면서 비교
      for(int j=k; j<n; j++) {
        sum+=(a[j]-a[j-k]);
        if(sum==m) cnt++;
      }
    }
    return cnt;
  }*/
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i]=sc.nextInt();
    }
    System.out.println(new no_4().solution(n, m, arr));
  }
}
