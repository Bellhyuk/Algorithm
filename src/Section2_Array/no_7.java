package Section2_Array;

/*7. 점수계산
 * 처음 맞는 문제는 1점
 * 연속으로 맞는 경우, 연속 횟수에 비례하여 점수 2번연속-2점, 3번연속-3점
 * 틀린 문제는 0점
 * 총 점수를 계산하는 프로그램을 작성
 * 
 * 입력
 * 첫째 줄에 문제의 개수 N (1 ≤ N ≤ 100)이 주어진다.
 * 둘째 줄에는 N개 문제의 채점 결과를 나타내는 0 혹은 1이 빈 칸을 사이에 두고 주어진다
 * 출력
 * 첫째 줄에 입력에서 주어진 채점 결과에 대하여 가산점을 고려한 총 점수를 출력한다
 * 
 *의사코드
 *그냥 전역변수, 지역변수 따로 두고 계산하면 될듯
*/
import java.util.*;

public class no_7 {
  public int solution(int loop, int[] arr) {
    int sum=0;
    int cnt=0;
    for(int i=0; i<loop; i++) {
      if(arr[i]==1) cnt++;
      else cnt=0;
      sum += cnt;
    }
    return sum;
  }
  
  public static void main(String[] args) {
    no_7 T = new no_7();
    Scanner sc = new Scanner(System.in);
    int loop = sc.nextInt();
    int[] arr = new int[loop];
    for(int i=0; i<loop; i++) {
      arr[i]=sc.nextInt();
    }
    System.out.println(T.solution(loop, arr));
  }
}
