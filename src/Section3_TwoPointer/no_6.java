package Section3_TwoPointer;

/*6. 최대 길이 연속부분수열
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다.
 * 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
 * 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의
 * 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면 그 길이는 8입니다.
 * 
 * 입력
 * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
 * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 * 
 * 출력
 * 첫 줄에 최대 길이를 출력하세요.
 * 
 * 의사코드
 * 0을 1로 k개 만큼 바꿔 연속부분수열 길이를 최대로 만들어주자.
 * 0의 갯수를 세주면서 확인
*/
import java.util.*;
public class no_6 {
  //강사 풀이
  //if(cnt==k)가 무의미하구나.. 그냥 매번 계산해주는 것으로도 충분
  public int solution(int n, int k, int[] arr) {
    int answer=0, cnt=0, lt=0;
    for(int rt=0; rt<n; rt++) {
      if(arr[rt]==0) cnt++;
      while(cnt>k) {
        if(arr[lt++]==0) cnt--;
      }
      answer = Math.max(answer, rt-lt+1);
    }
    return answer;
  }
  //내 풀이
  /*public int solution(int n, int k, int[] arr) {
    int answer=0, cnt=0, tmp=0, lt=0;
    for(int rt=0; rt<n; rt++) {
      if(arr[rt]==0) cnt++;
      if(cnt==k) {
        tmp = rt-lt+1;
        if(tmp>answer) answer=tmp;
      }
      while(cnt>k) {
        if(arr[lt++]==0) cnt--;
        if(cnt==k) {
          tmp = rt-lt+1;
          if(tmp>answer) answer=tmp;
        }
      }
    }
    return answer;
  }*/
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] arr = new int[n]; //1부터 n-1까지 n-1개를 담은 베열
    for(int i=0; i<n; i++) {
      arr[i]=sc.nextInt();
    }
    System.out.println(new no_6().solution(n, k, arr));
  }
}
