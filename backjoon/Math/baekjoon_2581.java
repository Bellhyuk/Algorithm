package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
<Problem> - 소수 2581번
자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성

예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중
소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.

입력: 첫 줄에 자연수 M, 두번째 줄에 자연수 N, (10000이하 자연수, M<=N)

출력: 첫째 줄 소수의 합, 둘째 줄 가장 작은 소수, 없으면 -1
*/
/**
 * My code
 * 
 * @author Bellhyuk
 * @date '21.03.22.
 * 
 * <의사코드>
 * 소수 -> 소수의 갯수를 구할 때는 소수의 성질+루트, 소수의 값을 구할 때는 에라토스테네스의 체 필요
 * 소수는 n의 배수가 아니다 -> 입력받은 수보다 작은 수 둘로 나누어 떨어지면 소수가 아니다.
 * 
 */

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());// 작은 수
    int N = Integer.parseInt(br.readLine());// 큰 수

    int[] arr = new int[N + 1];// 소수 체크용, 전부 0으로 초기화된 상태
    arr[1]=1;//1은 소수X
    //소수 찾기
    for (int i=2; i<=Math.sqrt(N); i++) { // 루트 N까지 확인
      if (arr[i]==1) continue;
      for (int j=2*i; j<=N; j+=i) { //N 값까지 나오는 것만 받자
        arr[j]=1; //소수는 0, 나머지는 1
      }
    }
   
    int min=0, sum=0, flag=0;
    
    //작은 값 찾기
    for(int i=M;i<arr.length;i++) {
      if(arr[i]==0) {
        min = i;
        break;
      }
    }
    //합 찾기
    for(int i=M;i<arr.length;i++) {
      if(arr[i]==0) {
        sum += i;
        flag++;
      } 
    }
    
    if(flag>0) {
      System.out.println(sum);
      System.out.println(min);
    }else System.out.println(-1);
  }
}

/**
 * Best Coding(메모리와 시간이 작은 것을 중심으로)
 * @author 
 * 좋은 코드들이 check에 boolean을 썼다는 점만 차이나 별도로 적지 않았다.
 * 
 */
/*
 * public class Main { public static void main(String[] args) throws IOException{ 
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *
 *  }
 * }
 */
