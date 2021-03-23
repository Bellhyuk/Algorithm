package practice;

import java.io.*;
import java.util.*;
/*
<Problem> - 골드바흐의 추측 9020번
<골드바흐 추측>
2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다.
이러한 수를 골드바흐 수. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다. 

2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오. 
만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고 짝수 n이 주어진다.

출력
각 테스트 케이스에 대해서 주어진 n의 골드바흐 파티션을 출력한다. 출력하는 소수는 작은 것부터 먼저 출력하며, 공백으로 구분
*/
/**
 * My code
 * 
 * @author Bellhyuk
 * @date '21.03.23.
 * 
 * <의사코드>
 * 2보다 큰 짝수 n
 * 일단 소수를 뽑은 배열 생성
 * 가장 작은 소수 a 출력 + 출력 소수보다 크거나 같은 소수 b 하나씩 더해보며 값 비교
 * a+b>n이면 종료 후 그 다음으로 작은 소수로 반복
 * 출력하는 소수가 작은 것부터 출력이니 이진 탐색보다는 이게 나을듯하다.
 * 
 * 문제를 잘못봤다.. 출력하는 소수 파티션이 여러 개면 차이가 작은 것부터 출력..
 * 그러면..n을 받고 n을 2로 나눈 값과 가장 가까운 소수 두개 
 */

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int test = Integer.parseInt(br.readLine());
    //소수 배열
    boolean[] arr = new boolean[10001];
    for(int i=2; i<=10000; i++) {
      if(arr[i]) continue;
      for(int j=i*2;j<=10000; j+=i) {
        arr[j]=true;
      }
    }
    //탐색
    while(test-->0) {
      int n = Integer.parseInt(br.readLine())/2;
      int a=0, b=0, flag=0;
      if(!arr[n]) {
        a=n; b=n;
      }else {
        for(int i=n; i<=n*2; i++) {
          if(!arr[i]) {
            a=i;
            for(int j=n; j>=2; j--){
              if(!arr[j]) {
                b=j;
                if(a+b==n*2) {
                  flag=1;
                  break;
                }
              } 
            }
            if(flag==1) break;
          } 
        }
      }
      System.out.println(b+" "+a);
    }
 }
}
/**
 * Best Coding(메모리와 시간이 작은 것을 중심으로)
 * @author dlwodnsdl
 * 
 * 1. 거의 비슷하게 풀었다만 출력을 일단 한꺼번에 한 것
 * 2. 복잡하게 if문을 엮지않고 prime[j]==0 && prime[N-j]==0을 쓴 것..
 * 
 * 그래도 핵심 알고리즘은 비슷하다는 점에서 뿌듯.
 */
class Main{
  public static void main(String[] args)throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T=Integer.parseInt(br.readLine().trim());
    int[] prime=new int[10000];
    prime[0]=1;
    prime[1]=1;
    for(int i=2;i<10000;i++){
      if(prime[i]==0){
        for(int j=2;i*j<10000;j++){
          prime[i*j]=1;
        }
      }
    }
    for(int i=0;i<T;i++){
      int N=Integer.parseInt(br.readLine().trim());
      for(int j=N/2;;j--){
        if(prime[j]==0&&prime[N-j]==0){
          bw.write(j+" "+(N-j)+"\n");
          break;
        }         
      }
    }
    bw.close();
    
  }
}
