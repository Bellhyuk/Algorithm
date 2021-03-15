package practice;
/*
<Problem> - 비밀지도
1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
   전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자.
2. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
   지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
3. "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때
   얻어지는 이진수에 해당하는 값의 배열이다.
   
원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.03.15.
 * 
 * <의사코드>
//지도는 한 변의 길이가 n인 정사각형 배열, " " 공백 or "#" 벽 두 종류
//두 장의 지도를 겹쳐야 함. 벽은 or, 공백은 and
//벽과 공백은 정수 배열로 암호화(벽은 1, 공백은 0)
//1. 10진수 -> 5자리 2진수, 자리당 하나씩 배열에 할당
//2. 순서대로 배열 비교하여 and, or 적용
//3. 비교 후 배열의 5자리 2진수 -> 행별로 문자열 변환
 */
class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[n];
        //보물지도
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        int[][] fmap = new int[n][n];
        //10진수 -> 5자리 2진수
        for(int i=0; i<n; i++){
          for(int j=0; j<n; j++) {
            map1[i][j]=arr1[i]%2;
            map2[i][j]=arr2[i]%2;
            arr1[i] /= 2;
            arr2[i] /= 2;
          }
        }
        //순서대로 비교 후 final map 채우기
        for(int i=0; i<n; i++) {
          for(int j=0;j<n;j++) {
            if(map1[i][j]==0 && map1[i][j]==map2[i][j]) fmap[i][j]=0;
            else fmap[i][j]=1;
          }
        }
        //5자리 2진수 -> 문자열
        for(int i=0; i<n; i++) {
          for(int j=0;j<n;j++) {
            if(fmap[i][j]==0) sb.append(" "); 
            else sb.append("#");
          }
          answer[i]=sb.reverse().toString();
          sb.setLength(0);//StringBuilder 초기화
        }
        return answer;
    }
}


//다른사람풀이
//@author -
/*
 * 나의 풀이는 굉장히 직독직해로 풀었다면 출제자의 의도와 가장 부합하는 풀이는 아래와 같은 풀이가 아닐까 생각한다.
 * String이더라도 비교 연산자를 쓴다면 알아서 비트변환을 통해 비트연산을 시행한다.
 * 벽이 1이고 공백이 0이라는 값에 의해 or 비트 연산 진행
 * 각 String 값을 2진수로 변환함고 동시에 해당 조건 값에 알맞는 문자를 더해준다.
 * 이분 풀이에 StringBuilder를 추가했으면 더 좋았겠다싶다.
 */

class Solution1 {
  public String[] solution(int n, int[] arr1, int[] arr2) {
      int[] container = new int[n];

          for (int i = 0; i < n; i++) {
              container[i] = arr1[i] | arr2[i];
          }

          String[] answer = new String[n];

          for (int i = 0; i < n; i++) {
              String ans = "";
              int remainder = container[i];

              for (int j = 0; j < n; j++) {                               
                  if(remainder%2 == 1) { ans = "#" + ans; } 
                  else { ans = " " + ans; }
                  remainder = remainder/2;
              }

              answer[i] = ans;
          }           
          return answer;
  }
}
