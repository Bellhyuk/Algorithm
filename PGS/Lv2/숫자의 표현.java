package practice;
/*
<Problem> - 숫자의 표현
자연수 n이 매개변수로 주어질 때,
연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.16.
 * 
 * <의사코드>
  자연수 n을 연속한 자연수들로 표현하는 방법의 수
  뒤에서부터 순차적으로 더해
  자연수 n이 나오면 count
  n을 넘으면 다음 숫자부터 순차 합
  1을 만나면 종료
 */
class Solution {
    public int solution(int n) {
        //뒤에서부터 시작, n=n이므로 기본으로 1개 count하고 넘어가자
        int count=0;
        for(int i=n-1;i>0;i--){
            int start = i, sum=0;
            while(true){
                sum += start--;
                if(sum==n){
                    count++;
                    break;
                }else if(sum>n) break;
                else{
                    if(start<1) break;
                }
            }
            if(start<1) break;
        }
        return count+1;
    }

/*
 * <다른 사람 풀이>
 * 정수론 정리에 근거하여 주어진 자연수를 연속도니 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다.
 * 그러므로 이중 for문을 쓰지않고 다음과 같이 표현하여 시간복잡도 O(N)을 만들 수 있다.
*/
    
  public int solution1(int num) {
      int answer = 0;
      for (int i = 1; i <= num; i += 2) {
          if (num % i == 0) {
              answer++;
          }
      }
      return answer;
  }
}
