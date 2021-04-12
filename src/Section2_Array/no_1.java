package Section2_Array;

/*1. 큰 수 출력
N개의 정수를 입력받아,
자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
입력 - 첫 줄에 입력 갯수 자연수 N, 두번째 줄에 N개의 정수
출력 - 해당 값 한 줄
*/
import java.util.*;

public class no_1 {
  //강사 풀이
  public List<Integer> solution(int n, int[] arr){
    List<Integer> answer = new ArrayList<>();
    answer.add(arr[0]);
    for(int i=1;i<n;i++) {
      if(arr[i]>arr[i-1]) answer.add(arr[i]);
    }
    return answer;
  }
  
  public static void main(String[] args) {
    no_1 T = new no_1();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++) {
      arr[i]=sc.nextInt();
    }
    for(int x:T.solution(n,arr)) {
      System.out.print(x+" ");
    }
  }
  
  //내 풀이
  /*public String solution(int n, String str) {
    String answer ="";
    String[] arr=str.split(" ");
    int max=-1;
    for(int i=0; i<n; i++) {
      if(max<Integer.parseInt(arr[i])) {
        answer += arr[i]+" ";
      }
      max = Integer.parseInt(arr[i]);
    }
    return answer;
  }
  public static void main(String[] args) {
    no_1 T = new no_1();
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String str = sc.nextLine();
    System.out.println(T.solution(n, str));
  }*/
}
