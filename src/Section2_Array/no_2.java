package Section2_Array;

/*2. 보이는 학생
선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때,
맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수
입력 - 첫 줄에 정수 N(5<=N<=100,000)이 입력된다.
그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다
출력 - 선생님이 볼 수 있는 최대학생수를 출력
*/
import java.util.*;

public class no_2 {
  //내 풀이
  public int solution(int[] arr){
    int answer = 0;
    int max=-1;
    for(int num:arr) {
      if(num>max) {
        answer++;
        max = num;
      }
    }
    return answer;
  }
  
  public static void main(String[] args) {
    no_2 T = new no_2();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(T.solution(arr));
  }
}
