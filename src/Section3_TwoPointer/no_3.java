package Section3_TwoPointer;

/*3. 최대 매출
 * 현수 아빠는 현수에게 N일 동안의 매출기록을 주고
 * 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다.
 * 이때 K=3이면 12 15 11 20 25 10 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 * 
 * 입력
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 * 
 * 출력
 * 첫 줄에 최대 매출액을 출력합니다.
 * 
 * 의사코드
 * for문 돌면서 본인부터 k개 계산
 * for문 돌면서 합 값 비교
 * 시간복잡도 O(N^2)
 * 
 * 시간 복잡도를 줄일 수 있는 방법이 없을까?
 * 스스로 못풀었다.. ㅠ
 *
 * Sliding window 기법
 * 와.. 비슷한 방법까지 생각하다가 지나쳤는데 너무 아쉽네..
 * k개의 합을 더한 후 그 이후부터 FIFO 느낌으로 밀어주면서 합을 비교한다.
*/
import java.util.*;

public class no_3 {
  //강사 풀이
  public int solution(int n, int k, int[] a) {
    int answer, sum=0;
    for(int i=0; i<k; i++) sum+=a[i];
    answer=sum;
    for(int i=k; i<n; i++) {
      sum+=(a[i]-a[i-k]);
      answer=Math.max(answer, sum);
    }
    return answer;
  }
  
  //강사 설명 듣고 푼 풀이, Sliding Window 사용
  /*public int solution(int n, int k, int[] a) {
    int answer=0;
    //기준 창 합 구하기
    for(int i=0; i<k; i++) {
      answer+=a[i];
    }
    //창 밀기
    int sum=answer;
    for(int i=k; i<n; i++) {
      sum=sum+a[i]-a[i-k];
      if(answer<sum) answer = sum;
    }
    return answer;
  }*/
  
  //이건 가장 최악의 시간복잡도인데.. -> Time Limit Exceeded 걸림...
  /*public int solution(int n, int k, int[] a){
    int answer=0;
    for(int i=0; i<n-k+1; i++) {
      int sum=0;
      for(int j=i; j<i+k; j++) {
        sum += a[j]; 
      }
     if(answer<sum) answer=sum;
    }
    return answer;
  }*/
  
  public static void main(String[] args) {
    no_3 T = new no_3();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i]=sc.nextInt();
    }
    System.out.println(T.solution(n, k, arr));
  }
}
