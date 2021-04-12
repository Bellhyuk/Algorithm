package Section2_Array;

/*3. 가위 바위 보
총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다.
비길 경우에는 D를 출력합니다.
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보
두 사람의 각 회의 가위, 바위, 보 정보가 주어지면
각 회를 누가 이겼는지 출력하는 프로그램을 작성
입력
첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
출력
각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력
// 1>3, 3>2, 2>1
*/
import java.util.*;

public class no_3 {
  //내 풀이
  public List<String> solution(int n, int[] arrA, int[] arrB){
    List<String> answer = new ArrayList<String>();
    for(int i=0; i<n; i++) {
      if(arrA[i]==arrB[i]) answer.add("D");
      else if((arrA[i]==3 && arrB[i]==2)||(arrA[i]==2 && arrB[i]==1)||(arrA[i]==1 && arrB[i]==3)) answer.add("A");
      else answer.add("B");
    }
    return answer;
  }
  
  public static void main(String[] args) {
    no_3 T = new no_3();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arrA = new int[n];
    int[] arrB = new int[n];
    for(int i=0; i<n; i++) {
      arrA[i] = sc.nextInt();
    }
    for(int i=0; i<n; i++) {
      arrB[i] = sc.nextInt();
    }
    for(String s:T.solution(n, arrA, arrB)) {
      System.out.println(s);
    }
  }
}
