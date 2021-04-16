package Section2_Array;

/*11. 임시반장 정하기
 * 그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서
 * 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
 * 
 * 입력
 * 첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
 * 둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를
 * 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
 * 주어지는 정수는 모두 1 이상 9 이하의 정수이다.
 * 
 * 출력
 * 첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
 * 단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
 * 
 * <의사코드>
 * 5학년까지 제한, O(n^2) 시간복잡도
*/
//어렵다 11번
import java.util.*;
public class no_11 {
  //강의 풀이
  public int solution(int n, int[][] arr) {
    int answer=0, max=Integer.MIN_VALUE;
    //기준 학생번호
    for(int i=1; i<=n; i++) {
      int cnt=0;
      //같은 반을 했던 학생 번호
      for(int j=1;j<=n;j++) {
        //학년
        for(int k=1; k<=5; k++) {
          if(arr[i][k]==arr[j][k]) {
            cnt++;
            break;
          }
        }
      }
      if(cnt>max) {
        max=cnt;
        answer=i;
      }
    }
    return answer;
  }
  
  public static void main(String[] args) {
    no_11 T = new no_11();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n+1][6];
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=5; j++) {
        arr[i][j]=sc.nextInt();
      }
    }
    System.out.println(T.solution(n, arr));
  }
  
  //내 풀이
  //하 문제를 똑바로 읽자..
  /*public int solution(int n, int[][] arr) {
    int answer=0;
    int[] stu= new int[n];
    boolean[] ch = new boolean[n];
    //학생 한명을 기준으로 돌리자
    //i번 학생일 때
    for(int i=0;i<n;i++) {
      Arrays.fill(ch, false);
      //i학년일 때
      for(int j=0;j<5;j++) {
        int num = arr[i][j];
        //나머지 번호 학생과 비교
        for(int k=0;k<n;k++) {
          if(!ch[k] && k!=i && num==arr[k][j]) {
            stu[i]++;
            ch[k]=true;
          }
        }
      }
    }
    int max=stu[0];
    for(int i=1;i<n;i++) {
      if(max<stu[i]) {
        max=stu[i];
        answer=i;
      }
    }
    return answer+1;
  }
  
  public static void main(String[] args) {
    no_11 T = new no_11();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][5];
    for(int i=0; i<n; i++) {
      for(int j=0; j<5; j++) {
        arr[i][j]=sc.nextInt();
      }
    }
    System.out.println(T.solution(n, arr));
  }*/
}
