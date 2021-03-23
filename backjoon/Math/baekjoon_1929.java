package practice;

import java.io.*;
import java.util.*;
/*
<Problem> - 소수 구하기 1929번
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
입력: 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)
출력: 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
*/
/**
 * My code
 * 
 * @author Bellhyuk
 * @date '21.03.23.
 * 
 * <의사코드>
 * 에라토스테네스 체 & 소수의 성질 복습
 */

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int[] arr = new int[N+1]; //소수 0, 소수가 아니면 1
    //소수 아닌 것 체크, 1은 별도 체크
    arr[1]=1;
    for(int i=2; i*i<=N; i++) {
      if(arr[i]==1) continue;
      for(int j=i*2;j<=N;j+=i) {
        arr[j]=1;
      }
    }
    //출력
    for(int i=M; i<=N; i++) {
      if(arr[i]==0) System.out.println(i);
    }
  }
}
/**
 * Best Coding(메모리와 시간이 작은 것을 중심으로)
 * @author rlawjdwo555
 * 
 * 1. int 배열보다 boolean 배열을 사용한 점
 * 2. System.out.println()으로 매번 출력하는 것이 아니라 StringBuidler로 한번에 출력한 것
 * 3. 소수의 성질 2(루트 N개까지 확인해도 소수를 확인할 수 있다)를 쓰지 않는 대신 for문을 하나 덜 쓴 것
 *    -> 다만 이건 시간복잡도에 큰 영향을 주지 않는다.
 * 
 * 전체적으로 보았을 때 2번의 영향이 제일 큰 것같다.(입출력에 시간이 많이 걸리는데 매번 출력해대니..)
 * 
 */
public class Main {
  public static void main(String[] args) throws Exception {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      
      String nm[] = input.readLine().split(" ");       
      int n = Integer.parseInt(nm[0]);//m이 n보다 큰 수
      int m = Integer.parseInt(nm[1]);
      
      boolean prime[] = new boolean[m+1];
      
      for(int i=2; i<=m; i++) {
        if(prime[i]) continue;
        
        if(i >= n) sb.append(i+"\n");
        
        for(int j=i+i; j<=m; j+=i) {
          prime[j] = true;
        }
      }
      
      System.out.println(sb);
  }
}
