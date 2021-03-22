package practice;

import java.io.*;
import java.util.*;
/*
<Problem> - 소인수분해 11653번
정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
입력: 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
출력: N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. N이 1인 경우 아무것도 출력하지 않는다.
*/
/**
 * My code
 * 
 * @author Bellhyuk
 * @date '21.03.22.
 * 
 * <의사코드>
 * 72를 나눌 수 있는 소수 확인
 * 큰 소수부터 %0될 때까지 나누고 count
 * conut 수 만큼 각 소수 출력
 */

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    if(N==1) System.out.println();
    else if(N==2||N==3) System.out.println(N);
    else if(N==6) {
      System.out.println(2);
      System.out.println(3);
    }
    else {
      int[] num = new int[N+1]; // 소인수 2, 소수X 1, 나머지 0
      for(int i=2;i<=N;i++) {
        if(num[i]==1) continue;
        if(N%i==0) {
          num[i]=2;
          for(int j=i*2;j<N;j+=i) {
            num[j]=1;
          }
        }
      }
      for(int i=2;i<=N;i++) {
        if(num[i]==2) {
          while(N%i==0) {
            System.out.println(i);
            N /= i;
          }
        }
      }
    }
  }
}


/**
 * Best Coding(메모리와 시간이 작은 것을 중심으로)
 * @author kimhim7025
 * 
 * 1. i<=Math.sqrt(n) 대신 i*i<=n을 쓴 점. -> 결과적으로 Math.sqrt는 변수가 제한된다는 문제점이 있음
 * 2. 굳이 소인수를 따로 빼놓고 출력할 필요가 없네.. 작은 수부터 시작해서 나눠 떨어지는 값을 만나면 
 * 나눠떨어지기 전까지 반복
 * 3. StringBuilder를 통해 출력, '\n'을 append하는 것으로 줄바꿈이 되는구나.
 * 
 * 코드도 간단하고 속도는 2배, 메모리는 1/4배인 코드, 배우자!
 * 
 */
public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for(int i = 2; i*i<=n; i++) {
      while(n%i == 0) {
        sb.append(i).append('\n');
        n /= i;
      }
    }
    if(n != 1) {
      sb.append(n);
    }
    System.out.println(sb);
  }
}
