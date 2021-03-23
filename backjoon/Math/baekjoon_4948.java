package practice;

import java.io.*;
import java.util.*;
/*
<Problem> - 베르트랑 공준 4948번
<베르트랑 공준>
임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다

예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다.
(11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)

자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오. 

입력
여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다. 
입력의 마지막에는 0이 주어진다.

출력
각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
*/
/**
 * My code
 * 
 * @author Bellhyuk
 * @date '21.03.23.
 * 
 * <의사코드>
 * n부터 2n까지의 소수 갯수 확인
 * for문으로 값을 받고 StringBuilder에 쌓는 것 반복
 * StringBuilder로 쌓아놓은다음에 한꺼번에 출력
 * 
 * n을 받고 소수 찾고 하는 것을 반복하는 것보다 테스트 케이스가 만다면
 * 그냥 끝까지 찾고 보는게 맞지 않을까?
 * 입력 제한 n은 최대 123456
 */

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int MAX = 123456;
    //소수 탐색
    boolean[] arr = new boolean[2*MAX+1]; //기본값 false(소수), true(소수가 아님)
    arr[1] = true;
    for(int i=2; i*i<=2*MAX; i++) {
      if(arr[i]==true) continue;
      for(int j=i*2; j<=2*MAX; j+=i) {
        arr[j]=true;
      }
    }
    //출력
    while(true) {
      int n = Integer.parseInt(br.readLine());
      if(n==0) break;
      int count=0;
      for(int i=n+1;i<=2*n;i++) {
        if(arr[i]==false) count++;
      }
      sb.append(count).append('\n');
    }
    System.out.println(sb);
 }
}
/**
 * Best Coding(메모리와 시간이 작은 것을 중심으로)
 * @author godgod3260
 * 
 * 알고리즘의 단순함만 따진다면 내가 작성한 코드가 더 좋을지 모른다.
 * 하지만 소수 배열, 소수 갯수 배열을 따로 생성하여
 * 이진탐색을 통해 input보다 큰 소수 번호, input*2보다 큰 소수 번호를 뽑아 냄으로써
 * 전체 갯수를 구하는 방법은 신선하여 참고해볼만 하다고 생각한다.
 * 
 */
public class Main {
  static final int MAX = 123457 * 2;
  static boolean isPrime[] = new boolean[MAX];
  static int prime[] = new int[21790]; //배열의 크기는 MAX의 제곱근

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int size = setPrime();//소수 탐색 후 전체 소수 갯수 할당
    while (true) {
      int input = Integer.parseInt(br.readLine());
      if (input == 0) {
        break;
      }
      int idx1 = binarySearch(input, size);//이진 탐색을 통해 전체 소수 갯수 중 input보다 큰 소수의 번호 출력
      int idx2 = binarySearch(input * 2, size);//마찬가지
      if (prime[idx2] == input * 2) {//값이 같으면 하나 앞에 값부터 처리
        idx2++;
      } else if (prime[idx1] == input) {
        idx1++;
      }
      sb.append((idx2 - idx1));//input ~ input*2 내에 있는 값의 갯수 출력
      sb.append('\n');
    }
    System.out.println(sb.toString());
  }

  //소수만 모아 놓은 prime 배열의 값과 input 값을 비교해서 input 값보다 큰 소수 중 가장 가까운 소수 번호 출력
  public static int binarySearch(int num, int size) {
    int start = 1;
    int end = size - 1;
    while (start <= end) {
      int center = (start + end) / 2;
      if (prime[center] >= num) {
        end = center - 1;
      } else {
        start = center + 1;
      }
    }
    return start;
  }
  //소수 탐색
  public static int setPrime() {
    int idx = 1;
    for (int i = 2; i < MAX; i++) {
      if (!isPrime[i]) {
        prime[idx++] = i;
        for (int j = i; j < MAX; j += i) {
          isPrime[j] = true;
        }
      }
    }
    return idx;
  }
}
