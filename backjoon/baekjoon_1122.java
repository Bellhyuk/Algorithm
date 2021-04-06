import java.io.*;
/*
<Problem> - 뒤집기 1122번
홍준이는 A개의 0과 B개의 1을 가지고 있다.
이 게임의 목표는 모두 1로 만드는 것이다. 각 턴은 정확하게 K개의 숫자를 뒤집는 것(0->1, 1->0)
매번 수의 값이나, 이전에 뒤집은 적이 있는지 없는지에 상관없이 아무 K개의 숫자를 고를 수 있다.
게임에서 이기기 위한 뒤집는 횟수의 최솟값을 출력하는 프로그램을 작성
만약 불가능하면 -1을 출력한다.

입력 - 첫째 줄에 A B K가 주어진다. 모든 수는 100,000보다 작거나 같은 자연수 또는 0이다.
출력 - 첫째 줄에 문제의 정답을 출력한다.
*/
/**
 * My code
 * @author Bellhyuk
 * @date '21.04.06.
 * 
 * <의사코드>
 * 풀이 참고함
 * K개의 비트를 N번 뒤집었을때 모든 비트가 1이 되었다고 가정
 * O[i] = 처음에 0이었던 i번째 비트가 뒤집힌 횟수 (1 <= i <= A)
 * E[i] = 처음에 1이었던 i번째 비트가 뒤집힌 횟수 (1 <= i <= B)
 * 라고 정의 해보면, 모든 비트가 1이 될려면 다음과 같은 필요 조건이 붙습니다.
 * 1) O[i] <= N, O[i] = 1 mod 2 -> A
 * 2) E[i] <= N, E[i] = 0 mod 2 -> B
 * 3) O[1] + ... + O[A] + E[1] + ... + E[B] = K * N
 * 
 * A가 0개이고 B가 0이 아닐 경우, N=0
 * A가 0개이고 B가 0개일 경우, N=-1
 * K가 0개일 경우, N=-1
 * A가 홀수이고 K가 짝수일 경우, N=-1
 * 그리고 1)2)3) 조건 확인을 통해 N 구하기
 * 
 */

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int A=Integer.parseInt(input[0]);
    int B=Integer.parseInt(input[1]);
    int K=Integer.parseInt(input[2]);
    int N;//answer
    if(K==0 || (A%2==1 && K%2==0)) System.out.println(-1);
    if(A==0) System.out.println(0);
    else {
      long max=0, min=A, sum1=0, sum2=0, flag=0;
      for(N=1; N<=100000; N++) {
        if(N%2==1) sum1=N*A;//조건 1)
        else sum2=N*B;//조건 2)
        max = sum1+sum2; //1로 만들기 위한 최대 수
        long tmp = K*N; //조건 3)
        if(tmp>=min && tmp<=max) {
          if((max-tmp)%2==0) {
            System.out.println(N);
            flag=1;
            break;
          }
        }
      }
      if(flag==0) System.out.println(-1);
    }
  }
}
