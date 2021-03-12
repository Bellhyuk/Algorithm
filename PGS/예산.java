package practice;
/*
<Problem> - 예산
물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다.
예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며,
1,000원보다 적은 금액을 지원해 줄 수는 없습니다.

부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때,
최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.11.
 * 
 * <의사코드>
//각 부서가 신청한 금액만큼 모두 지원
//부서별로 신청한 금액이 들어있는 배열 d, 예산 budget
//최대 몇 개의 부서에 물품 지원이 가능한지?
//의사코드
//배열 d 오름차순 정렬
//정렬의 합이 budget를 넘지못하는 개수 확인
 */
import java.util.*;
class Solution {
  public int solution(int[] d, int budget) {
      Arrays.sort(d);
      int sum=0, cnt=0;
      for(int m:d){
          sum+=m;
          if(sum>budget) break;
          cnt++;
      }
      return cnt;
  }
}
