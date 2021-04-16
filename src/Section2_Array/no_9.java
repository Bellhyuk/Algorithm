package Section2_Array;

/*9. 격자판 최대합
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력
 * 
 * 입력
 * 첫 줄에 자연수 N이 주어짐
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 * 출력
 * 최대합을 출력
*/
import java.util.*;

public class no_9 {
  public int solution(int n, int[][] arr) {
    int answer=Integer.MIN_VALUE;
    int sum1=0, sum2=0;
    //행, 열의 합
    for(int i=0; i<n; i++) {
      sum1=sum2=0;
      for(int j=0; j<n; j++) {
        sum1+=arr[i][j]; //행의 합
        sum2+=arr[j][i]; //열의 합
      }
      if(answer<sum1) answer=sum1;
      if(answer<sum2) answer=sum2;
    }
    //대각선 합
    sum1=sum2=0;
    for(int i=0; i<n; i++) {
      sum1+=arr[i][i]; 
      sum2+=arr[i][n-i-1];
    }
    if(answer<sum1) answer=sum1;
    if(answer<sum2) answer=sum2;
    
    return answer;
  }
  
  public static void main(String[] args) {
    no_9 T = new no_9();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][n];
    for(int i=0;i<n;i++) {
      for(int j=0;j<n;j++) {
        arr[i][j]=sc.nextInt();
      }
    }
    System.out.println(T.solution(n, arr));
  }
}
