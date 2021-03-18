package practice;
/*
<Problem> - 카펫
중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫
갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

/**
 * My code
 * @author Bellhyuk
 * @date '21.03.18.
 * 
 * <의사코드>
//테두리 1줄을 구성하는 갈색, 중앙을 차지하는 노란색 격자 수만 알고 있는 경우
//전체 카펫의 가로, 세로 크기를 도출
//갈색이 테두리 1줄인 것 -> 가로+세로 크기 값을 구할 수 있다.
//갈색 격자 수+4 = (가로+세로 크기) *2
//노란색 격자 수 = (가로-2)*(세로-2)
//두 식을 연립하고 가로>=세로이므로 두 수를 비교하여 큰 수를 가로, 작은 수를 세로로 출력한다.
 */
class Solution {
    public int[] solution(double brown, double yellow) {
        int[] answer = new int[2];
        answer[0] = (int)((brown+4)+Math.sqrt(Math.pow(brown+4, 2)-4*2*(2*(yellow+brown))))/4;
        answer[1] = (int)((brown+4)-Math.sqrt(Math.pow(brown+4, 2)-4*2*(2*(yellow+brown))))/4;
        return answer;
    }
/*
 * <다른 사람 풀이>
 *  brown의 가로길이를 먼저 정하고 두번째 조건과 같을 때까지 반복문을 돌려주는 방식 사용
 */
  public int[] solution(int brown, int yellow) {
      int[] answer = {};
      answer = new int[2];
      int iAllNum = brown + yellow;
      int iHeight = 0;
  
      for (int iBrownWidth = 1; iBrownWidth < brown; iBrownWidth++) {
          iHeight = iAllNum/iBrownWidth;
  
          if((iBrownWidth-2)*(iHeight-2) == yellow) {
              answer[0] = iBrownWidth;
              answer[1] = iHeight;
          }
      }
      return answer;
    }
}
