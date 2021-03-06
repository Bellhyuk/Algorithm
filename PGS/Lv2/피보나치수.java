/*
<Problem> - 피보나치수
피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.15.
 * 
 * <의사코드>
 * 문제만 놓고 봤을 때는 매우 간단하다.
 * 시간 제한도 별도로 없기 때문에 for문으로 쭉 돌리면 되는 것
 * 그러나 int 자료형은 2^32 -2,147,483,648 ~ 2,147,483,647까지의 값만을 표현할 수 있기에
 * 피보나치 수가 44번째만 넘어가도 범위를 넘어가 이상한 값을 할당시킨다.
 * 하지만 이럼에도 불구하고 다음과 같은 성질이 존재하여 우리는 답을 낼 수가 있다.
 * 모듈러 연산을 통해 (A + B) % C의 값은 ( ( A % C ) + ( B % C) ) % C와 같다는 것이 성립함을 알 수 있으며
 * 이를 통해 answer%1234567의 값을 계산할 수 있다.
 */
class Solution {
  public int solution(int n) {
      int answer=1, num1=0, num2=1;
      for(int i=0;i<n-1;i++){
              answer = num1+num2;
              num1 = num2%1234567;
              num2 = answer%1234567;
      }
      return answer%1234567;
  }
}
