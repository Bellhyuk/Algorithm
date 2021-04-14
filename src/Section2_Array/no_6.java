package Section2_Array;

/*6. 뒤집은 소수
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후
 * 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다.
 * 단 910를 뒤집으면 19로 숫자화 해야 한다. 첫 자리부터의 연속된 0은 무시한다.
 * 
 * 입력
 * 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
 * 각 자연수의 크기는 100,000를 넘지 않는다.
 * 출력
 * 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.

의사코드
첫 줄 -> 반복 횟수
두번째 줄 -> 각 수를 받고 뒤집고 소수인지 확인

소수 확인에는 여러 방법이 있겠으나 조건이 10만개이므로 에라토스테네스 체로 구한 배열을 활용
*/
import java.util.*;

public class no_6 {
  public boolean isPrime(int num) {
    if(num==1) return false;
    else{
      for(int i=2;i<num;i++) {
        if(num%i==0) return false;
      }
      return true;
    }
  }
  
  public ArrayList<Integer> solution(int n, int[] arr){
    ArrayList<Integer> answer = new ArrayList<>();
    //뒤집기 유형
    for(int i=0;i<n;i++) {
      int tmp = arr[i];
      int res=0;
      while(tmp>0) {
        int t = tmp%10;
        res = res*10 + t;
        tmp /= 10;
      }
      if(isPrime(res)) answer.add(res);
    }
    return answer;
  }
  
  public static void main(String[] args) {
    no_6 T = new no_6();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i]=sc.nextInt();
    }
    for(int x:T.solution(n, arr)) {
      System.out.print(x+" ");
    }
  }
//내풀이
/*  public int solution(String num) {
    String[] arr = num.split("");
    int[] ch = new int[100001];
    String answer="";
    int ans=0;
    int len = arr.length;
    
    //체크용 배열 형성
    ch[0]=1; ch[1]=1;
    for(int i=2; i*i<=100000; i++) {
      if(ch[i]==1) continue;
      for(int j=i*2; j<=100000; j+=i) ch[j]=1;
    }
    //수 뒤집기
    for(int i=len-1; i>=0; i--) {
      answer += arr[i];
    }
    ans=Integer.parseInt(answer);
    if(ch[ans]==0) return ans;
    else return -1;
  }
  
  public static void main(String[] args) {
    no_6 T = new no_6();
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int n = sc.nextInt();
    while(n-->0) {
      String num = sc.next();
      if(T.solution(num)==-1) continue;
      else sb.append(T.solution(num)).append(" ");
    }
    System.out.println(sb.toString());
  }*/
}
