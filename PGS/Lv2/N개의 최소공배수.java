package practice;

/*
<Problem> - 숫자의 표현
자연수 n이 매개변수로 주어질 때,
연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.17.
 * 
 * <의사코드>
//배열 arr 내 수들의 최소공배수를 구하라
//가장 큰 수에 1부터 곱하면서 나머지 수로 모두 나눠 떨어지는 값을 구해보자.
 */
import java.util.*;

class Solution {
  public int solution(int[] arr) {
    Arrays.sort(arr);
    int num = arr[arr.length - 1];// 가장 큰 수
    int i = 1, minmul = 0;
    while (i++ > 0) {
      int count = 0;
      minmul = num * i;
      for (int j = 0; j < arr.length - 1; j++) {
        if (minmul % arr[j] != 0)
          break;
        else
          count++;
      }
      if (count == arr.length - 1)
        break;
    }
    return minmul;
  }

/*
 * <다른 사람 풀이>
 * gcd(최소공약수)를 활용해서 lcm(최소공배수)을 구해보자.
 * 
 * GCD - 유클리드호제법
 * a, b: 최대공약수를 구하고자 하는 두 수, r: a를 b로 나눈 나머지
 * 식: gcd(a,b) = gcd(b,r) -> 재귀함수를 통해 반복
 * 
 * LCM
 * a, b: 최소공배수를 구하고자 하는 두 수, gcd(a,b): a,b의 최대 공약수
 * 식: lcm(a,b) = a * b / gcd(a,b)
 */

  public long nlcm(int[] num) {
    long answer = num[0], g;
    for (int i = 1; i < num.length; i++) {
      g = gcd(answer, num[i]);
      answer = g * (answer / g) * (num[i] / g);
    }
    return answer;
  }

  public long gcd(long a, long b) {
    if (a > b)
      return (a % b == 0) ? b : gcd(b, a % b);
    else
      return (b % a == 0) ? a : gcd(a, b % a);
  }

  public static void main(String[] args) {
    Solution c = new Solution();
    int[] ex = { 2, 6, 8, 14 };
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    System.out.println(c.nlcm(ex));
  }
}
