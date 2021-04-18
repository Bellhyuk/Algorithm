package Section3_TwoPointer;

/*5. 연속된 자연수의 합
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로
 * 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면 7+8=15 / 4+5+6=15 / 1+2+3+4+5=15 와 같이 총 3가지 경우가 존재
 * 
 * 입력
 * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 * 
 * 출력
 * 첫 줄에 총 경우수를 출력합니다.
 * 
 * 의사코드
 * 연속된 자연수의 합
 * 창의 크기를 조절하는 방식으로 계산해보자. 2개 이상의 연속된 자연수
*/
import java.util.*;
public class no_5 {
  //강사 풀이
  public int solution(int n) {
    int answer=0, sum=0, lt=0;
    int m = n/2+1;
    int[] arr = new int[m];
    for(int i=0; i<m; i++) arr[i]=i+1;//1부터 m까지 배열에 대입
    for(int rt=0; rt<m; rt++) {
      sum+=arr[rt];
      if(sum==n) answer++;
      while(sum>=n) {
        sum -= arr[lt++];
        if(sum==n) answer++;
      }
    }
    return answer;
  }
  //내 풀이
  /*public int solution(int n, int[] arr) {
    int answer=0, sum=0, lt=0;
    sum = arr[lt];
    for(int rt=1; rt<(n/2+1); rt++) {
      sum += arr[rt];
      if(sum==n) answer++;
      while(sum>=n) {
        sum -= arr[lt++];
        if(sum==n) answer++;
      }
    }
    return answer;
  }*/
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n-1]; //1부터 n-1까지 n-1개를 담은 베열
    for(int i=0; i<n-1; i++) {
      arr[i]=i+1;
    }
    //System.out.println(new no_5().solution(n, arr));
    System.out.println(new no_5().solution(n));
  }
}
