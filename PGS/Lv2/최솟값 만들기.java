package practice;

/*
<Problem> - 최솟값 만들기
길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다.
이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다. (단, 각 
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.17.
 * 
 * <의사코드>
//촤소값을 만드는 것이 목표
//다 계산하는 방법? No 가장 작은 수 x 가장 큰 수 순서대로 곱한 것의 합
//두 배열을 합해서 오름차순 정렬 후 맨 앞 x 맨 뒤로 반복문 돌리자 -> 순서가 섞여버리는 구나...
//배열 오름차순해서 따로 곱해보자
 */
import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        //배열 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        //값 곱해서 최소값 도출하기
        int answer=0;
        for(int i=0;i<A.length;i++){
            answer += A[i]*B[A.length-i-1];
        }
        return answer;
    }

/*
 * <다른 사람 풀이>
 * 없음
 */

  public void getMinMaxString(String str) {
  }
}
