package Section2_Array;

/*4. 피보나치 수열
1) 피보나키 수열을 출력한다.
피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
2) 입력은 피보나치 수열의 총 항의 수 이다.
만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다
입력
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
출력
줄에 피보나치 수열을 출력합니다.
그냥 앞에꺼 두 개 더해서 출력해주면 되는거자너..
*/
import java.util.*;

public class no_4 {
  //배열을 쓰지않고 푸는 경우
  public void solution(int n) {
    int a=1, b=1, c;
    System.out.println(a+" "+b+" ");
    for(int i=2; i<n; i++) {
      c=a+b;
      System.out.println(c+" ");
      a=b;
      b=c;
    }
  }
  
  public static void main(String[] args) {
    no_4 T = new no_4();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    T.solution(n);
  }
  //내 풀이
  /*public List<Integer> solution(int n){
    List<Integer> answer = new ArrayList<>();
    int[] arr = new int[n];
    arr[0]=1; arr[1]=1;
    for(int i=0; i<n; i++) {
      if(i<2) answer.add(arr[i]);
      else {
        arr[i] = arr[i-1] + arr[i-2];
        answer.add(arr[i]);
      }
    }
    return answer;
  }
  
  public static void main(String[] args) {
    no_4 T = new no_4();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int s:T.solution(n)) {
      System.out.print(s+" ");
    }
  }*/
}
