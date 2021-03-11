/*
<Problem> - 소수 찾기
1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다. (1은 소수가 아닙니다.)
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.11.
 * 
 * <의사코드>
 * 에라토스테네스의 체 + 소수의 성질
 * 소수는 n의 배수가 아니어야 한다.
 * 입력받은 수를 입력받은 수보다 작은 수 들로 나누어서 떨어지면 소수가 아니다.
 * 그러나 모두 나누어볼 필요없이, 루트 n 까지만 나누어서 떨어지면 소수가 아니다.
 */
import java.util.*;
public class Solution {
//알고리즘
  public static int solution(int n) {
    int[] arr = new int[n+1];
    Arrays.fill(arr, 1);
    int cnt=0;
    for(int i=2;i<=Math.sqrt(n);i++) {
      if(arr[i]==0) continue;
      for(int j=2*i; j<=n; j+=i) {
        arr[j]=0;
      }
    }
    for(int i:arr) if(i!=0) cnt++;    
    return cnt-2; // 1과 맨 뒤 여유배열을 삭제하자.
  }
 //실행
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(solution(sc.nextInt()));
  }

}
