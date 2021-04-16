package Section2_Array;

/*12. 멘토링
선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면,
A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지인지 출력

입력
첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다.
학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.

출력
첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.

//의사코드
 * N: 배열 크기, 반 학생 수
 * M: 반복 횟수, 시험 횟수
 * 멘토-멘티가 되려면 멘토는 멘티보다 모든 테스트에서 등수가 앞서야 한다.
 * 첫번째 Test에서 이중 for문을 통해 경우의 수 확인
 * 나머지 Test Case를 통해 해당 경우가 성립하는지 확인
*/
import java.util.*;
public class no_12 {
  //강사 풀이
  public int solution(int n, int m, int[][] arr) {
    int answer=0;
    //그냥 사람을 번호로 모두 짝지어보기 
    for(int i=1;i<=n;i++) {
      for(int j=1;j<=n;j++) {
        int cnt=0;
        //짝이 조건에 부합하는지 확인
        for(int k=0; k<m; k++) {
          int pi=0, pj=0;//등수
          for(int s=0; s<n; s++) {
            if(arr[k][s]==i) pi=s;
            if(arr[k][s]==j) pj=s;
          }
          if(pi<pj) cnt++;
        }
        if(cnt==m) answer++;
      }
    }
    return answer;
  }
  
  //내 풀이
  //4중 for문은 좀 너무하지않나.. 그래도 for문을 써야한다면 써야한다는걸 알려주는 건가..  
  /*public int solution(int n, int m, int[][] arr) {
    int answer=0;
    for(int i=0;i<n;i++) {
      int mto= arr[0][i];
      for(int j=i+1;j<n;j++) {
        int mti=arr[0][j];
        for(int k=1;k<m;k++) {
          int mtinum=0, mtonum=0, flag=0;
          for(int q=0;q<n;q++) {
            if(arr[k][q]==mto) {
              mtonum=q;
              flag++;
            }
            if(arr[k][q]==mti) {
              mtinum=q;
              flag++;
            }
            if(flag==2) break;
          }
          if(mtonum>=mtinum) break;
          if(k==m-1) answer++;
        }
      }
    }
    return answer;
  }*/
  
  public static void main(String[] args) {
    no_12 T = new no_12();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] arr = new int[m][n];
    for(int i=0; i<m; i++) {
      for(int j=0; j<n; j++) {
        arr[i][j]=sc.nextInt();
      }
    }
    System.out.println(T.solution(n, m, arr));
  }
}
