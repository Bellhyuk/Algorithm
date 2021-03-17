package practice;

/*
<Problem> - 최댓값과 최솟값
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.17.
 * 
 * <의사코드>
 * split을 통해 공백을 구분자로 문자열 배열 가져오기
 * 문자열을 int 형변환하여 min, max 비교
 * string 값이므로 그대로 +로 연결
 */
import java.util.*;

class Solution {
  public String solution(String s) {
      String[] arr = s.split(" ");
      String min=arr[0], max=arr[0];
      for(int i=1;i<arr.length;i++){
          if(Integer.parseInt(arr[i])>Integer.parseInt(max)) max=arr[i];
          if(Integer.parseInt(arr[i])<Integer.parseInt(min)) min=arr[i];
      }
      String answer = min+" "+max;
      return answer;
  }
}

/*
 * <다른 사람 풀이>
 * int + string을 하면 자동 형변환 되기 때문에 Integer.parseInt를 나보다 덜 쓸 수 있는 방법이 존재
 */

  public String getMinMaxString(String str) {
    String[] tmp = str.split(" ");
    int min, max, n;
    min = max = Integer.parseInt(tmp[0]);
    for (int i = 1; i < tmp.length; i++) {
            n = Integer.parseInt(tmp[i]);
        if(min > n) min = n;
        if(max < n) max = n;
    }
  
    return min + " " + max;
  
  }
}
