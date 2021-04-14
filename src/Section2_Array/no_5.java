package Section2_Array;

/*5. 에라토스테네스 체
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
입력
첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
출력
첫 줄에 소수의 개수를 출력

소수
->소수의 성질(루트 개수까지만 구해도 되는 것) + 에라토스테네스의 체
n까지 존재하는 소수를 구하는 것(소인수 분해X)
*/
import java.util.*;

public class no_5 {
  public int solution(int n) {
    int answer =0;
    int[] ch = new int[n+1];
    for(int i=2;i<=n;i++) {
      if(ch[i]==0) {
        answer++;
        for(int j=i; j<=n; j+=i) ch[j]=1;
      }
    }
    return answer;
  }
  //내 풀이
  /*public int solution(int n) {
    int answer = 0;
    int[] arr = new int[n+1];//소수 체크
    for(int i=2; i*i<=n; i++) {
      if(arr[i]==1) continue;
      for(int j=2*i; j<=n;j+=i) arr[j]=1;
    }
    for(int k:arr) {
      if(k==0) answer++;
    }
    return answer-2;
  }*/
  
  public static void main(String[] args) {
    no_5 T = new no_5();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(T.solution(n));
  }
}
